/*
 * DocSpring API
 * DocSpring provides an API that helps you fill out and sign PDF templates.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.docspring;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.docspring.JSON;


/**
 * JsonSchema
 */
@JsonPropertyOrder({
  JsonSchema.JSON_PROPERTY_$_SCHEMA,
  JsonSchema.JSON_PROPERTY_ID,
  JsonSchema.JSON_PROPERTY_TITLE,
  JsonSchema.JSON_PROPERTY_DESCRIPTION,
  JsonSchema.JSON_PROPERTY_DEFINITIONS,
  JsonSchema.JSON_PROPERTY_TYPE,
  JsonSchema.JSON_PROPERTY_PROPERTIES,
  JsonSchema.JSON_PROPERTY_ADDITIONAL_PROPERTIES,
  JsonSchema.JSON_PROPERTY_REQUIRED
})
@JsonTypeName("json_schema")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class JsonSchema {
  public static final String JSON_PROPERTY_$_SCHEMA = "$schema";
  @javax.annotation.Nullable
  private URI $schema;

  public static final String JSON_PROPERTY_ID = "id";
  @javax.annotation.Nullable
  private String id;

  public static final String JSON_PROPERTY_TITLE = "title";
  @javax.annotation.Nullable
  private String title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @javax.annotation.Nullable
  private String description;

  public static final String JSON_PROPERTY_DEFINITIONS = "definitions";
  @javax.annotation.Nullable
  private Object definitions;

  public static final String JSON_PROPERTY_TYPE = "type";
  @javax.annotation.Nullable
  private String type;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  @javax.annotation.Nullable
  private Object properties;

  public static final String JSON_PROPERTY_ADDITIONAL_PROPERTIES = "additionalProperties";
  @javax.annotation.Nullable
  private Boolean additionalProperties;

  public static final String JSON_PROPERTY_REQUIRED = "required";
  @javax.annotation.Nullable
  private List<String> required = new ArrayList<>();

  public JsonSchema() { 
  }

  public JsonSchema $schema(@javax.annotation.Nullable URI $schema) {
    this.$schema = $schema;
    return this;
  }

  /**
   * Get $schema
   * @return $schema
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_$_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI get$Schema() {
    return $schema;
  }


  @JsonProperty(JSON_PROPERTY_$_SCHEMA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set$Schema(@javax.annotation.Nullable URI $schema) {
    this.$schema = $schema;
  }


  public JsonSchema id(@javax.annotation.Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(@javax.annotation.Nullable String id) {
    this.id = id;
  }


  public JsonSchema title(@javax.annotation.Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(@javax.annotation.Nullable String title) {
    this.title = title;
  }


  public JsonSchema description(@javax.annotation.Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(@javax.annotation.Nullable String description) {
    this.description = description;
  }


  public JsonSchema definitions(@javax.annotation.Nullable Object definitions) {
    this.definitions = definitions;
    return this;
  }

  /**
   * Get definitions
   * @return definitions
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getDefinitions() {
    return definitions;
  }


  @JsonProperty(JSON_PROPERTY_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDefinitions(@javax.annotation.Nullable Object definitions) {
    this.definitions = definitions;
  }


  public JsonSchema type(@javax.annotation.Nullable String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(@javax.annotation.Nullable String type) {
    this.type = type;
  }


  public JsonSchema properties(@javax.annotation.Nullable Object properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getProperties() {
    return properties;
  }


  @JsonProperty(JSON_PROPERTY_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProperties(@javax.annotation.Nullable Object properties) {
    this.properties = properties;
  }


  public JsonSchema additionalProperties(@javax.annotation.Nullable Boolean additionalProperties) {
    this.additionalProperties = additionalProperties;
    return this;
  }

  /**
   * Get additionalProperties
   * @return additionalProperties
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdditionalProperties() {
    return additionalProperties;
  }


  @JsonProperty(JSON_PROPERTY_ADDITIONAL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalProperties(@javax.annotation.Nullable Boolean additionalProperties) {
    this.additionalProperties = additionalProperties;
  }


  public JsonSchema required(@javax.annotation.Nullable List<String> required) {
    this.required = required;
    return this;
  }

  public JsonSchema addRequiredItem(String requiredItem) {
    if (this.required == null) {
      this.required = new ArrayList<>();
    }
    this.required.add(requiredItem);
    return this;
  }

  /**
   * Get required
   * @return required
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getRequired() {
    return required;
  }


  @JsonProperty(JSON_PROPERTY_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequired(@javax.annotation.Nullable List<String> required) {
    this.required = required;
  }


  /**
   * Return true if this json_schema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonSchema jsonSchema = (JsonSchema) o;
    return Objects.equals(this.$schema, jsonSchema.$schema) &&
        Objects.equals(this.id, jsonSchema.id) &&
        Objects.equals(this.title, jsonSchema.title) &&
        Objects.equals(this.description, jsonSchema.description) &&
        Objects.equals(this.definitions, jsonSchema.definitions) &&
        Objects.equals(this.type, jsonSchema.type) &&
        Objects.equals(this.properties, jsonSchema.properties) &&
        Objects.equals(this.additionalProperties, jsonSchema.additionalProperties) &&
        Objects.equals(this.required, jsonSchema.required);
  }

  @Override
  public int hashCode() {
    return Objects.hash($schema, id, title, description, definitions, type, properties, additionalProperties, required);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonSchema {\n");
    sb.append("    $schema: ").append(toIndentedString($schema)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    definitions: ").append(toIndentedString(definitions)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

