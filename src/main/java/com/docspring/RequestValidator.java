package com.docspring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Checks a request against API v2's request schemas (request_schemas.json, the schemas the API validates requests
 * with) before it's sent, and says what the API would say about it. api_clients/validator_conformance checks that it
 * agrees with the API.
 */
public final class RequestValidator {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static final JsonNodeFactory NODES = JsonNodeFactory.instance;
  private static final Map<String, String> TYPE_NAMES = new HashMap<>();
  static {
    TYPE_NAMES.put("string", "a string");
    TYPE_NAMES.put("integer", "an integer");
    TYPE_NAMES.put("number", "a number");
    TYPE_NAMES.put("boolean", "true or false");
    TYPE_NAMES.put("object", "an object");
    TYPE_NAMES.put("array", "an array");
    TYPE_NAMES.put("null", "null");
  }
  // What a multipart body's file field holds when the API checks it
  private static final String FILE_PLACEHOLDER = "(file)";
  // A date and time as the API reads it (Ruby's DateTime.rfc3339, then json_schemer's checks)
  private static final Pattern DATE_TIME = Pattern.compile(
      "\\A[ \\t\\n\\x0B\\f\\r]*(-?\\d{4})-(\\d{2})-(\\d{2})[Tt \\t\\n\\x0B\\f\\r](\\d{2}):(\\d{2}):(\\d{2})(?:\\.\\d+)?"
          + "(?:[Zz]|([+-])(\\d{2}):(\\d{2}))\\z");
  // An absolute URI as the API reads it (RFC 3986, as Ruby's URI parser has it), a little looser for IP addresses
  // Lookaheads check the escapes, so only character classes repeat: Java and PHP recurse on each repetition of a group
  private static final String SEGMENT = "[%!$&-.0-9:;=@A-Z_a-z~/]";
  private static final Pattern URI = Pattern.compile(
      "\\A(?![^?#]*%(?![0-9A-Fa-f]{2}))[A-Za-z][+\\-.0-9A-Za-z]*:"
          + "(?://(?:[%!$&-.0-9:;=A-Z_a-z~]*@)?"
          + "(?:\\[(?:[0-9A-Fa-f:.]+|[vV][0-9A-Fa-f]+\\.[!$&-.0-9:;=A-Z_a-z~]+)\\]|[%!$&-.0-9;=A-Z_a-z~]*)"
          + "(?::[0-9]*)?(?:/" + SEGMENT + "*)?"
          + "|/(?:(?!/)" + SEGMENT + "+)?"
          + "|(?!/)" + SEGMENT + "+"
          + "|)"
          + "(?:\\?[^#]*)?"
          + "(?:#(?![^#]*%(?![0-9A-Fa-f]{2}))[%!$&-.0-9:;=@A-Z_a-z~/?]*)?\\z");
  private static final Pattern WHITESPACE = Pattern.compile("[ \\t\\n\\x0B\\f\\r]");
  private static final Pattern INTEGER_STRING = Pattern.compile("\\A-?[0-9]+\\z");
  private static final Pattern NUMBER_STRING = Pattern.compile("\\A-?[0-9]+(?:\\.[0-9]+)?\\z");
  // A pattern Java can't compile isn't checked
  private static final Pattern UNCHECKED = Pattern.compile("");
  private static final Map<String, Pattern> PATTERNS = new ConcurrentHashMap<>();
  private static volatile JsonNode schemas;

  private RequestValidator() {}

  /**
   * Throws a ValidationException when the API would reject a request to an operation (createSubmission) with a 422.
   * ApiClient calls this before sending each request, unless its validateRequests setting is off.
   */
  public static void validateRequest(String operationId, List<Pair> queryParams, Object body, Map<String, Object> formParams, ApiClient apiClient) {
    ObjectNode query = NODES.objectNode();
    if (queryParams != null) {
      for (Pair pair : queryParams) {
        if (!query.has(pair.getName())) query.put(pair.getName(), pair.getValue());
      }
    }
    JsonNode requestBody = null;
    if (formParams != null && !formParams.isEmpty()) {
      ObjectNode values = NODES.objectNode();
      for (Map.Entry<String, Object> param : formParams.entrySet()) {
        Object value = param.getValue();
        if (value == null) continue;
        values.put(param.getKey(), value instanceof File ? FILE_PLACEHOLDER : apiClient.parameterToString(value));
      }
      requestBody = values;
    } else if (body != null) {
      // The JSON the request sends, read the way the API reads it
      try {
        requestBody = MAPPER.readTree(apiClient.getJSON().getMapper().writeValueAsString(body));
      } catch (IOException e) {
        throw new IllegalArgumentException("Can't serialize the request body: " + e.getMessage(), e);
      }
    }
    List<ErrorDetail> details = errors(operationId, query, requestBody);
    if (!details.isEmpty()) throw new ValidationException(details);
  }

  /** The details for a request to an operation (createSubmission) */
  public static List<ErrorDetail> errors(String operationId, JsonNode query, JsonNode body) {
    JsonNode entry = requestSchemas().path("operations").path(operationId);
    List<ErrorDetail> details = new ArrayList<>();
    if (entry.isMissingNode()) return details;

    JsonNode params = entry.get("query");
    if (params != null && query != null && query.size() > 0) {
      ObjectNode schema = NODES.objectNode();
      schema.put("type", "object");
      ObjectNode properties = schema.putObject("properties");
      ArrayNode required = schema.putArray("required");
      for (Map.Entry<String, JsonNode> param : params.properties()) {
        properties.set(param.getKey(), param.getValue().get("schema"));
        if (param.getValue().path("required").asBoolean(false)) required.add(param.getKey());
      }
      schema.put("additionalProperties", false);
      details.addAll(validateParams(schema, query, "query"));
    }
    JsonNode bodyEntry = entry.get("body");
    if (bodyEntry != null && body != null && !body.isNull()) {
      JsonNode schema = bodyEntry.get("schema");
      if ("multipart/form-data".equals(bodyEntry.path("mediaType").asText())) {
        details.addAll(validateParams(schema, body, "body"));
      } else {
        details.addAll(validate(schema, body, "body"));
      }
    }
    return details;
  }

  /** The details for data checked against a schema at a location (body or query) */
  public static List<ErrorDetail> validate(JsonNode schema, JsonNode data, String location) {
    List<ErrorDetail> details = new ArrayList<>();
    check(schema, data, "", location, details);
    return details;
  }

  private static JsonNode requestSchemas() {
    if (schemas == null) {
      synchronized (RequestValidator.class) {
        if (schemas == null) {
          try (InputStream stream = RequestValidator.class.getResourceAsStream("request_schemas.json")) {
            if (stream == null) throw new IllegalStateException("com/docspring/request_schemas.json is missing from the SDK");
            schemas = MAPPER.readTree(stream);
          } catch (IOException e) {
            throw new IllegalStateException("Can't read com/docspring/request_schemas.json: " + e.getMessage(), e);
          }
        }
      }
    }
    return schemas;
  }

  // Query and multipart params arrive as strings, which the API converts where the schema types them
  private static List<ErrorDetail> validateParams(JsonNode schema, JsonNode data, String location) {
    JsonNode properties = schema.path("properties");
    ObjectNode converted = NODES.objectNode();
    for (Map.Entry<String, JsonNode> field : data.properties()) {
      converted.set(field.getKey(), convertParam(field.getValue(), properties.get(field.getKey())));
    }
    return validate(schema, converted, location);
  }

  private static JsonNode convertParam(JsonNode value, JsonNode schema) {
    if (schema == null || !schema.isObject()) return value;
    List<String> types = typesOf(schema);
    if (value.isArray() && types.contains("array")) {
      ArrayNode converted = NODES.arrayNode();
      for (JsonNode item : value) converted.add(convertParam(item, schema.get("items")));
      return converted;
    }
    if (!value.isTextual()) return value;
    String text = value.asText();
    if (types.contains("integer") && INTEGER_STRING.matcher(text).find()) return NODES.numberNode(new BigInteger(text));
    if (types.contains("number") && NUMBER_STRING.matcher(text).find()) {
      return text.contains(".") ? NODES.numberNode(Double.parseDouble(text)) : NODES.numberNode(new BigInteger(text));
    }
    if (types.contains("boolean") && (text.equals("true") || text.equals("false"))) return NODES.booleanNode(text.equals("true"));
    return value;
  }

  private static List<String> typesOf(JsonNode schema) {
    JsonNode type = schema.get("type");
    List<String> types = new ArrayList<>();
    if (type == null) return types;
    if (type.isArray()) {
      for (JsonNode name : type) types.add(name.asText());
    } else {
      types.add(type.asText());
    }
    return types;
  }

  private static JsonNode resolve(JsonNode schema) {
    JsonNode resolved = schema;
    while (resolved != null && resolved.isObject() && resolved.has("$ref")) {
      String name = resolved.get("$ref").asText().replace("#/components/schemas/", "");
      resolved = requestSchemas().path("components").path("schemas").get(name);
    }
    return resolved;
  }

  private static void check(JsonNode rawSchema, JsonNode data, String pointer, String location, List<ErrorDetail> details) {
    JsonNode schema = resolve(rawSchema);
    if (schema == null || !schema.isObject()) return;
    if (schema.has("discriminator")) {
      checkUnion(schema.get("discriminator"), data, pointer, location, details);
      return;
    }

    if (schema.has("type")) {
      boolean matches = false;
      for (String type : typesOf(schema)) matches = matches || isType(data, type);
      if (!matches) {
        String message = pointer.isEmpty() && location.equals("body") ? "must be a JSON object" : typeMessage(typesOf(schema));
        details.add(detail(location, pointer, "type", message));
      }
    }
    JsonNode values = schema.get("enum");
    if (values != null) {
      boolean found = false;
      List<String> shown = new ArrayList<>();
      for (JsonNode value : values) {
        found = found || jsonEqual(value, data);
        shown.add(toJson(value));
      }
      if (!found) details.add(detail(location, pointer, "enum", "must be one of: " + String.join(", ", shown)));
    }
    if (schema.has("const") && !jsonEqual(schema.get("const"), data)) {
      details.add(detail(location, pointer, "const", "must be " + toJson(schema.get("const"))));
    }

    if (data.isTextual()) {
      checkString(schema, data.asText(), pointer, location, details);
    } else if (data.isNumber()) {
      checkNumber(schema, data, pointer, location, details);
    } else if (data.isArray()) {
      checkArray(schema, data, pointer, location, details);
    } else if (data.isObject()) {
      checkObject(schema, data, pointer, location, details);
    }
  }

  // A union (oneOf with a discriminator): the discriminator property's value picks the variant, and only that one is
  // checked, as the API does. The mapping is [value, $ref] pairs, in the order the API lists them.
  private static void checkUnion(JsonNode discriminator, JsonNode data, String pointer, String location, List<ErrorDetail> details) {
    if (!data.isObject()) {
      details.add(detail(location, pointer, "type", "must be " + TYPE_NAMES.get("object")));
      return;
    }

    String name = discriminator.path("propertyName").asText();
    String child = pointer + "/" + escape(name);
    if (!data.has(name)) {
      details.add(detail(location, child, "required", "is required"));
      return;
    }

    JsonNode value = data.get(name);
    List<String> shown = new ArrayList<>();
    for (JsonNode pair : discriminator.path("mapping")) {
      if (value.isTextual() && pair.get(0).asText().equals(value.asText())) {
        ObjectNode ref = NODES.objectNode();
        ref.set("$ref", pair.get(1));
        check(ref, data, pointer, location, details);
        return;
      }
      shown.add(toJson(pair.get(0)));
    }
    details.add(detail(location, child, "enum", "must be one of: " + String.join(", ", shown)));
  }

  private static void checkString(JsonNode schema, String data, String pointer, String location, List<ErrorDetail> details) {
    int length = data.codePointCount(0, data.length());
    JsonNode minLength = schema.get("minLength");
    if (minLength != null && length < minLength.asDouble()) {
      String message = atLeast(minLength, "must be at least " + count(minLength, "character"));
      details.add(detail(location, pointer, "minLength", message));
    }
    JsonNode maxLength = schema.get("maxLength");
    if (maxLength != null && length > maxLength.asDouble()) {
      details.add(detail(location, pointer, "maxLength", "must be at most " + count(maxLength, "character")));
    }
    JsonNode source = schema.get("pattern");
    if (source != null) {
      Pattern compiled = pattern(source.asText());
      if (compiled != UNCHECKED && !compiled.matcher(data).find()) {
        JsonNode custom = schema.get("x-pattern-message");
        String message = custom != null ? custom.asText() : "must match the pattern " + source.asText();
        details.add(detail(location, pointer, "pattern", message));
      }
    }
    JsonNode format = schema.get("format");
    if (format != null && !format(format.asText(), data)) {
      JsonNode custom = requestSchemas().path("formatMessages").get(format.asText());
      String message = custom != null ? custom.asText() : "must be a valid " + format.asText();
      details.add(detail(location, pointer, "format", message));
    }
  }

  private static void checkNumber(JsonNode schema, JsonNode data, String pointer, String location, List<ErrorDetail> details) {
    JsonNode limit = schema.get("minimum");
    if (limit != null && compare(data, limit) < 0) {
      details.add(detail(location, pointer, "minimum", "must be at least " + number(limit)));
    }
    limit = schema.get("maximum");
    if (limit != null && compare(data, limit) > 0) {
      details.add(detail(location, pointer, "maximum", "must be at most " + number(limit)));
    }
    limit = schema.get("exclusiveMinimum");
    if (limit != null && compare(data, limit) <= 0) {
      details.add(detail(location, pointer, "exclusiveMinimum", "must be greater than " + number(limit)));
    }
    limit = schema.get("exclusiveMaximum");
    if (limit != null && compare(data, limit) >= 0) {
      details.add(detail(location, pointer, "exclusiveMaximum", "must be less than " + number(limit)));
    }
  }

  private static void checkArray(JsonNode schema, JsonNode data, String pointer, String location, List<ErrorDetail> details) {
    JsonNode minItems = schema.get("minItems");
    if (minItems != null && data.size() < minItems.asDouble()) {
      String message = atLeast(minItems, "must have at least " + count(minItems, "item"));
      details.add(detail(location, pointer, "minItems", message));
    }
    JsonNode maxItems = schema.get("maxItems");
    if (maxItems != null && data.size() > maxItems.asDouble()) {
      details.add(detail(location, pointer, "maxItems", "must have at most " + count(maxItems, "item")));
    }
    if (schema.path("uniqueItems").asBoolean(false) && !unique(data)) {
      JsonNode duplicate = firstDuplicate(data);
      String message = duplicate != null ? "has " + toJson(duplicate) + " more than once" : "can't contain the same item twice";
      details.add(detail(location, pointer, "uniqueItems", message));
    }
    JsonNode items = schema.get("items");
    if (items != null) {
      for (int index = 0; index < data.size(); index++) {
        check(items, data.get(index), pointer + "/" + index, location, details);
      }
    }
  }

  private static void checkObject(JsonNode schema, JsonNode data, String pointer, String location, List<ErrorDetail> details) {
    JsonNode required = schema.get("required");
    if (required != null) {
      for (JsonNode name : required) {
        if (!data.has(name.asText())) {
          details.add(detail(location, pointer + "/" + escape(name.asText()), "required", "is required"));
        }
      }
    }

    JsonNode properties = schema.path("properties");
    JsonNode additional = schema.get("additionalProperties");
    for (Map.Entry<String, JsonNode> field : data.properties()) {
      String name = field.getKey();
      String child = pointer + "/" + escape(name);
      if (properties.has(name)) {
        check(properties.get(name), field.getValue(), child, location, details);
      } else if (additional != null && additional.isBoolean() && !additional.asBoolean()) {
        details.add(unknownProperty(schema, name, child, location));
      } else if (additional != null && additional.isObject()) {
        check(additional, field.getValue(), child, location, details);
      }
    }
  }

  private static ErrorDetail unknownProperty(JsonNode schema, String name, String pointer, String location) {
    JsonNode notAllowed = schema.path("x-not-allowed-properties").get(name);
    if (notAllowed != null) return detail(location, pointer, "not_allowed", notAllowed.asText());

    String noun = location.equals("query") ? "query parameter" : "property";
    JsonNode custom = schema.get("x-unknown-property-message");
    String message = custom != null ? custom.asText() : "isn't a documented " + noun;
    String snake = underscore(name);
    if (!snake.equals(name) && schema.path("properties").has(snake)) {
      String plural = custom != null ? "settings" : noun.equals("property") ? "properties" : "query parameters";
      message += ". API v2 names " + plural + " in snake_case: '" + snake + "'";
    }
    return detail(location, pointer, "unknown_property", message);
  }

  private static ErrorDetail detail(String location, String pointer, String code, String message) {
    ErrorDetail detail = new ErrorDetail().code(code).message(message);
    if (!location.equals("query")) return detail.pointer(pointer);

    String parameter = pointer.substring(1).split("/", -1)[0].replace("~1", "/").replace("~0", "~");
    return detail.parameter(parameter);
  }

  private static boolean isType(JsonNode data, String type) {
    switch (type) {
      case "string":
        return data.isTextual();
      case "integer":
        if (data.isIntegralNumber()) return true;
        if (!data.isNumber()) return false;
        double value = data.doubleValue();
        return !Double.isInfinite(value) && !Double.isNaN(value) && value == Math.floor(value);
      case "number":
        return data.isNumber();
      case "boolean":
        return data.isBoolean();
      case "object":
        return data.isObject();
      case "array":
        return data.isArray();
      case "null":
        return data.isNull();
      default:
        return false;
    }
  }

  private static int compare(JsonNode left, JsonNode right) {
    if (left.isIntegralNumber() && right.isIntegralNumber()) return left.bigIntegerValue().compareTo(right.bigIntegerValue());
    return Double.compare(left.doubleValue(), right.doubleValue());
  }

  // Patterns are ECMA-262 regexps, as OpenAPI says: ^ and $ are the start and end of the value, not of a line. The
  // API's patterns only use ^ as the first character and $ as the last (api_clients/scripts/extract_request_schemas).
  private static Pattern pattern(String source) {
    Pattern compiled = PATTERNS.get(source);
    if (compiled == null) {
      String anchored = source.startsWith("^") ? "\\A" + source.substring(1) : source;
      // A $ after an even number of backslashes is the anchor
      if (anchored.endsWith("$")) {
        int backslashes = 0;
        while (backslashes < anchored.length() - 1 && anchored.charAt(anchored.length() - 2 - backslashes) == '\\') backslashes++;
        if (backslashes % 2 == 0) anchored = anchored.substring(0, anchored.length() - 1) + "\\z";
      }
      try {
        compiled = Pattern.compile(anchored);
      } catch (PatternSyntaxException e) {
        compiled = UNCHECKED;
      }
      PATTERNS.put(source, compiled);
    }
    return compiled;
  }

  private static boolean format(String name, String data) {
    if (name.equals("uri")) {
      for (int index = 0; index < data.length(); index++) {
        if (data.charAt(index) > 0x7f) return false;
      }
      return !WHITESPACE.matcher(data).find() && URI.matcher(data).matches();
    }
    if (name.equals("date-time")) return dateTime(data);
    return true;
  }

  private static boolean dateTime(String data) {
    Matcher match = DATE_TIME.matcher(data);
    if (!match.matches()) return false;

    int year = Integer.parseInt(match.group(1));
    int month = Integer.parseInt(match.group(2));
    int day = Integer.parseInt(match.group(3));
    int hour = Integer.parseInt(match.group(4));
    int minute = Integer.parseInt(match.group(5));
    int second = Integer.parseInt(match.group(6));
    if (month < 1 || month > 12 || day < 1 || day > daysInMonth(year, month)) return false;
    if (hour > 23 || minute > 59 || second > 60) return false;

    int offset = 0;
    if (match.group(7) != null) {
      int offsetHours = Integer.parseInt(match.group(8));
      int offsetMinutes = Integer.parseInt(match.group(9));
      if (offsetHours > 23 || offsetMinutes > 59) return false;
      offset = (match.group(7).equals("-") ? -1 : 1) * (offsetHours * 60 + offsetMinutes);
    }
    // A leap second is only at the end of a UTC day
    return second < 60 || Math.floorMod(hour * 60 + minute - offset, 1440) == 1439;
  }

  // Before the Gregorian calendar (1582), the API's dates are Julian: every fourth year is a leap year
  private static int daysInMonth(int year, int month) {
    boolean leap = year % 4 == 0 && (year < 1583 || year % 100 != 0 || year % 400 == 0);
    if (month == 2 && leap) return 29;
    return new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[month - 1];
  }

  private static boolean unique(JsonNode data) {
    for (int index = 0; index < data.size(); index++) {
      for (int other = index + 1; other < data.size(); other++) {
        if (jsonEqual(data.get(index), data.get(other))) return false;
      }
    }
    return true;
  }

  // The first value that's in the list twice, as the API names it
  private static JsonNode firstDuplicate(JsonNode data) {
    Map<String, Integer> counts = new LinkedHashMap<>();
    Map<String, JsonNode> firsts = new HashMap<>();
    for (JsonNode item : data) {
      String key = tallyKey(item);
      Integer seen = counts.get(key);
      counts.put(key, seen == null ? 1 : seen + 1);
      if (!firsts.containsKey(key)) firsts.put(key, item);
    }
    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      if (entry.getValue() > 1) return firsts.get(entry.getKey());
    }
    return null;
  }

  private static String tallyKey(JsonNode value) {
    if (value.isArray()) {
      List<String> parts = new ArrayList<>();
      for (JsonNode item : value) parts.add(tallyKey(item));
      return "[" + String.join(",", parts) + "]";
    }
    if (value.isObject()) {
      Map<String, JsonNode> sorted = new TreeMap<>();
      for (Map.Entry<String, JsonNode> field : value.properties()) {
        sorted.put(field.getKey(), field.getValue());
      }
      List<String> parts = new ArrayList<>();
      for (Map.Entry<String, JsonNode> field : sorted.entrySet()) {
        parts.add(toJson(NODES.textNode(field.getKey())) + ":" + tallyKey(field.getValue()));
      }
      return "{" + String.join(",", parts) + "}";
    }
    return toJson(value);
  }

  // JSON equality: numbers by value, objects regardless of key order
  private static boolean jsonEqual(JsonNode left, JsonNode right) {
    if (left.isNumber() || right.isNumber()) return left.isNumber() && right.isNumber() && compare(left, right) == 0;
    if (left.isArray() && right.isArray()) {
      if (left.size() != right.size()) return false;
      for (int index = 0; index < left.size(); index++) {
        if (!jsonEqual(left.get(index), right.get(index))) return false;
      }
      return true;
    }
    if (left.isObject() && right.isObject()) {
      if (left.size() != right.size()) return false;
      for (Map.Entry<String, JsonNode> field : left.properties()) {
        JsonNode other = right.get(field.getKey());
        if (other == null || !jsonEqual(field.getValue(), other)) return false;
      }
      return true;
    }
    return left.equals(right);
  }

  private static String typeMessage(List<String> types) {
    List<String> names = new ArrayList<>();
    for (String type : types) names.add(TYPE_NAMES.containsKey(type) ? TYPE_NAMES.get(type) : type);
    String connector = " or ";
    for (String name : names) {
      if (names.size() > 1 && name.contains(" or ")) connector = ", or ";
    }
    if (names.size() == 1) return "must be " + names.get(0);
    if (names.size() == 2) return "must be " + String.join(connector, names);
    return "must be " + String.join(", ", names.subList(0, names.size() - 1)) + connector + names.get(names.size() - 1);
  }

  private static String atLeast(JsonNode limit, String message) {
    return limit.asDouble() == 1 ? "can't be empty" : message;
  }

  private static String count(JsonNode number, String noun) {
    return number(number) + " " + (number.asDouble() == 1 ? noun : noun + "s");
  }

  // A number as the schema writes it
  private static String number(JsonNode number) {
    return number.asText();
  }

  private static String toJson(JsonNode value) {
    try {
      return MAPPER.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      return value.toString();
    }
  }

  private static String escape(String token) {
    return token.replace("~", "~0").replace("/", "~1");
  }

  private static String underscore(String name) {
    return name
        .replaceAll("([A-Z\\d]+)([A-Z][a-z])", "$1_$2")
        .replaceAll("([a-z\\d])([A-Z])", "$1_$2")
        .replace("-", "_")
        .toLowerCase(Locale.ROOT);
  }
}
