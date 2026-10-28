package com.docspring;

import com.docspring.ApiException;
import com.docspring.ApiClient;
import com.docspring.ApiResponse;
import com.docspring.Configuration;
import com.docspring.Pair;

import javax.ws.rs.core.GenericType;

import com.docspring.AddTemplateFieldsRequest;
import com.docspring.AiFieldNamingLanguage;
import com.docspring.AuthenticationCheck;
import com.docspring.CombinedPdf;
import com.docspring.CombinedPdfList;
import com.docspring.CopyTemplateRequest;
import com.docspring.CreateCombinedPdfRequest;
import com.docspring.CreateCustomFileFromUploadRequest;
import com.docspring.CreateFolderRequest;
import com.docspring.CreateSignatureRequestEventRequest;
import com.docspring.CreateSignatureRequestTokenRequest;
import com.docspring.CreateSubmissionBatchRequest;
import com.docspring.CreateSubmissionRequest;
import com.docspring.CreateTemplatePreviewRequest;
import com.docspring.CreateTemplateRequest;
import com.docspring.CreateWebhookRequest;
import com.docspring.CustomFile;
import com.docspring.CustomFileList;
import com.docspring.ErrorResponse;
import com.docspring.FieldSetupLogic;
import com.docspring.FieldSetupNaming;
import com.docspring.FieldSetupSource;
import java.io.File;
import com.docspring.Folder;
import com.docspring.FolderList;
import com.docspring.GenerateSubmissionFilesRequest;
import com.docspring.ModelCodeLanguage;
import com.docspring.MoveFolderRequest;
import com.docspring.MoveTemplateRequest;
import java.time.OffsetDateTime;
import com.docspring.PublishTemplateVersionRequest;
import com.docspring.RemoveTemplateFieldsRequest;
import com.docspring.RenameFolderRequest;
import com.docspring.ReorderTemplateFieldsRequest;
import com.docspring.RestoreTemplateVersionRequest;
import com.docspring.SignatureRequest;
import com.docspring.SignatureRequestEvent;
import com.docspring.SignatureRequestToken;
import com.docspring.Submission;
import com.docspring.SubmissionBatch;
import com.docspring.SubmissionList;
import com.docspring.SubmissionState;
import com.docspring.SubmissionValidation;
import com.docspring.Template;
import com.docspring.TemplateDiff;
import com.docspring.TemplateFields;
import com.docspring.TemplateModelCode;
import com.docspring.TemplatePageImages;
import com.docspring.TemplatePreview;
import com.docspring.TemplateSummaryList;
import com.docspring.TemplateVersion;
import com.docspring.UpdateSignatureRequestRequest;
import com.docspring.UpdateTemplateDocumentRequest;
import com.docspring.UpdateTemplateFieldsRequest;
import com.docspring.UpdateTemplateRequest;
import com.docspring.UpdateWebhookRequest;
import com.docspring.UploadPresign;
import com.docspring.ValidateSubmissionRequest;
import com.docspring.Webhook;
import com.docspring.WebhookEventType;
import com.docspring.WebhookList;
import com.docspring.WebhookMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.26.0-DOCSPRING")
public class Client {
  private ApiClient apiClient;

  private static final String DEFAULT_BASE_PATH = "https://sync.api.docspring.com/api/v2";

  /**
   * Creates a client that uses the shared default ApiClient. Credentials and a host that haven't been set on it are
   * read from the DOCSPRING_TOKEN_ID, DOCSPRING_TOKEN_SECRET, DOCSPRING_HOST and DOCSPRING_REGION environment
   * variables.
   */
  public Client() {
    this(Configuration.getDefaultApiClient());
    configure(null, null, null, null);
  }

  /**
   * Creates a client with its own ApiClient. The host comes from DOCSPRING_HOST or DOCSPRING_REGION (US by default).
   *
   * @param apiTokenId API token ID (falls back to DOCSPRING_TOKEN_ID when null)
   * @param apiTokenSecret API token secret (falls back to DOCSPRING_TOKEN_SECRET when null)
   */
  public Client(String apiTokenId, String apiTokenSecret) {
    this(apiTokenId, apiTokenSecret, null, null);
  }

  /**
   * Creates a client with its own ApiClient.
   *
   * @param apiTokenId API token ID (falls back to DOCSPRING_TOKEN_ID when null)
   * @param apiTokenSecret API token secret (falls back to DOCSPRING_TOKEN_SECRET when null)
   * @param host API host, e.g. "sync.api-eu.docspring.com" (falls back to DOCSPRING_HOST when null)
   * @param region "US" or "EU", used when there is no host (falls back to DOCSPRING_REGION when null)
   */
  public Client(String apiTokenId, String apiTokenSecret, String host, String region) {
    this(new ApiClient());
    configure(apiTokenId, apiTokenSecret, host, region);
  }

  private void configure(String apiTokenId, String apiTokenSecret, String host, String region) {
    // Use the credentials passed in, or the environment variables. An empty string counts as not set.
    String tokenId = firstNonEmpty(apiTokenId, System.getenv("DOCSPRING_TOKEN_ID"));
    String tokenSecret = firstNonEmpty(apiTokenSecret, System.getenv("DOCSPRING_TOKEN_SECRET"));
    com.docspring.auth.HttpBasicAuth auth =
        (com.docspring.auth.HttpBasicAuth) apiClient.getAuthentication("api_token_basic");
    // Credentials set on the ApiClient beforehand win. Without credentials the client is still created, and the API's
    // 401 response says what's missing.
    if (tokenId != null && auth.getUsername() == null) {
      apiClient.setUsername(tokenId);
    }
    if (tokenSecret != null && auth.getPassword() == null) {
      apiClient.setPassword(tokenSecret);
    }

    String baseUrl = resolveBaseUrl(host, region);
    // A base path set on the ApiClient beforehand wins
    if (baseUrl != null && DEFAULT_BASE_PATH.equals(apiClient.getBasePath())) {
      apiClient.setBasePath(baseUrl);
    }
  }

  private static String firstNonEmpty(String value, String fallback) {
    if (value != null && !value.isEmpty()) {
      return value;
    }
    return fallback != null && !fallback.isEmpty() ? fallback : null;
  }

  private static String resolveBaseUrl(String host, String region) {
    String resolvedHost = host != null ? host : System.getenv("DOCSPRING_HOST");
    if (resolvedHost == null || resolvedHost.trim().isEmpty()) {
      String resolvedRegion = region != null ? region : System.getenv("DOCSPRING_REGION");
      if (resolvedRegion == null || resolvedRegion.trim().isEmpty()) {
        return null;
      }
      switch (resolvedRegion.trim().toUpperCase(java.util.Locale.ROOT)) {
        case "US":
          resolvedHost = "sync.api.docspring.com";
          break;
        case "EU":
          resolvedHost = "sync.api-eu.docspring.com";
          break;
        default:
          throw new IllegalArgumentException(resolvedRegion + " is not a valid region. Valid regions: US, EU");
      }
    }

    String url = resolvedHost.trim();
    if (!url.matches("(?i)^https?://.*")) {
      url = "https://" + url;
    }
    url = url.replaceAll("/+$", "");
    // Any API version's path (such as /api/v1 from a 3.x setup) becomes /api/v2
    return url.replaceAll("(?i)/api/v\\d+$", "") + "/api/v2";
  }

  public Client(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API client
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API client
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add fields to a template
   * Adds fields to a template&#39;s draft and returns all of its fields. Publish a version for submissions of published versions to have them. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to add to the template&#39;s draft. (required)
   * @return TemplateFields
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> fields added </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid fields </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Add fields to a template Documentation</a>
   */
  public TemplateFields addTemplateFields(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull AddTemplateFieldsRequest body) throws ApiException {
    return addTemplateFieldsWithHttpInfo(templateId, body).getData();
  }

  /**
   * Add fields to a template
   * Adds fields to a template&#39;s draft and returns all of its fields. Publish a version for submissions of published versions to have them. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to add to the template&#39;s draft. (required)
   * @return ApiResponse&lt;TemplateFields&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> fields added </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid fields </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Add fields to a template Documentation</a>
   */
  public ApiResponse<TemplateFields> addTemplateFieldsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull AddTemplateFieldsRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling addTemplateFields");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling addTemplateFields");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/fields"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateFields> localVarReturnType = new GenericType<TemplateFields>() {};
    return apiClient.invokeAPI("Client.addTemplateFields", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Copy a template
   * Copies a template (its draft, or a published version) into a new template.
   * @param templateId The template&#39;s ID. (required)
   * @param body Settings for the copy. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> template copied </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid copy </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template copyTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable CopyTemplateRequest body) throws ApiException {
    return copyTemplateWithHttpInfo(templateId, body).getData();
  }

  /**
   * Copy a template
   * Copies a template (its draft, or a published version) into a new template.
   * @param templateId The template&#39;s ID. (required)
   * @param body Settings for the copy. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> template copied </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid copy </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> copyTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable CopyTemplateRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling copyTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/copy"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.copyTemplate", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Combine PDFs
   * Merges PDFs into one: submissions, other combined PDFs, templates, custom files (POST /custom_files) and PDFs from URLs, in the order of &#x60;source_pdfs&#x60;. The PDF is generated in the background: on sync.api hosts the request waits for it (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /combined_pdfs/{combined_pdf_id} until &#x60;state&#x60; isn&#39;t &#x60;pending&#x60;.  A template source merges the template&#39;s processed PDF by default: the PDF submissions are filled in on, decrypted and with its form fields removed. Pass &#x60;processed: false&#x60; to merge the PDF as it was uploaded. 
   * @param body The PDFs to merge, and the combined PDF&#39;s settings. (required)
   * @param wait Wait until the PDF has been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another combined PDF. Send a new key with each new combined PDF, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return CombinedPdf
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined PDF created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid source PDFs </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> not allowed </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s combined_pdf_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public CombinedPdf createCombinedPdf(@javax.annotation.Nonnull CreateCombinedPdfRequest body, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    return createCombinedPdfWithHttpInfo(body, wait, idempotencyKey).getData();
  }

  /**
   * Combine PDFs
   * Merges PDFs into one: submissions, other combined PDFs, templates, custom files (POST /custom_files) and PDFs from URLs, in the order of &#x60;source_pdfs&#x60;. The PDF is generated in the background: on sync.api hosts the request waits for it (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /combined_pdfs/{combined_pdf_id} until &#x60;state&#x60; isn&#39;t &#x60;pending&#x60;.  A template source merges the template&#39;s processed PDF by default: the PDF submissions are filled in on, decrypted and with its form fields removed. Pass &#x60;processed: false&#x60; to merge the PDF as it was uploaded. 
   * @param body The PDFs to merge, and the combined PDF&#39;s settings. (required)
   * @param wait Wait until the PDF has been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another combined PDF. Send a new key with each new combined PDF, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return ApiResponse&lt;CombinedPdf&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined PDF created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid source PDFs </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> not allowed </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s combined_pdf_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CombinedPdf> createCombinedPdfWithHttpInfo(@javax.annotation.Nonnull CreateCombinedPdfRequest body, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createCombinedPdf");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    // Header parameters
    Map<String, String> localVarHeaderParams = new LinkedHashMap<>();
    if (idempotencyKey != null) {
      localVarHeaderParams.put("Idempotency-Key", apiClient.parameterToString(idempotencyKey));
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedPdf> localVarReturnType = new GenericType<CombinedPdf>() {};
    return apiClient.invokeAPI("Client.createCombinedPdf", "/combined_pdfs", "POST", localVarQueryParams, body,
                               localVarHeaderParams, new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a custom file from an upload
   * Creates a custom file from a PDF you uploaded, so you can merge it with other PDFs. Upload the file with the presigned upload (GET /uploads/presign) first, then pass its &#x60;fields.key&#x60; as &#x60;cache_id&#x60;. 
   * @param body The uploaded file to create the custom file from. (required)
   * @return CustomFile
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> custom file created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid custom file </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn how to merge custom files with other PDFs
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Create a custom file from an upload Documentation</a>
   */
  public CustomFile createCustomFileFromUpload(@javax.annotation.Nonnull CreateCustomFileFromUploadRequest body) throws ApiException {
    return createCustomFileFromUploadWithHttpInfo(body).getData();
  }

  /**
   * Create a custom file from an upload
   * Creates a custom file from a PDF you uploaded, so you can merge it with other PDFs. Upload the file with the presigned upload (GET /uploads/presign) first, then pass its &#x60;fields.key&#x60; as &#x60;cache_id&#x60;. 
   * @param body The uploaded file to create the custom file from. (required)
   * @return ApiResponse&lt;CustomFile&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> custom file created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid custom file </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn how to merge custom files with other PDFs
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Create a custom file from an upload Documentation</a>
   */
  public ApiResponse<CustomFile> createCustomFileFromUploadWithHttpInfo(@javax.annotation.Nonnull CreateCustomFileFromUploadRequest body) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createCustomFileFromUpload");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CustomFile> localVarReturnType = new GenericType<CustomFile>() {};
    return apiClient.invokeAPI("Client.createCustomFileFromUpload", "/custom_files", "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a folder
   * Creates a folder for organizing templates. Pass &#x60;parent_folder_id&#x60; to create it inside another folder. Folder names are unique within their parent folder. 
   * @param body The folder to create. (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> folder created inside another folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Folder createFolder(@javax.annotation.Nonnull CreateFolderRequest body) throws ApiException {
    return createFolderWithHttpInfo(body).getData();
  }

  /**
   * Create a folder
   * Creates a folder for organizing templates. Pass &#x60;parent_folder_id&#x60; to create it inside another folder. Folder names are unique within their parent folder. 
   * @param body The folder to create. (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> folder created inside another folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Folder> createFolderWithHttpInfo(@javax.annotation.Nonnull CreateFolderRequest body) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createFolder");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.createFolder", "/folders", "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Record a signature request event
   * Records something that happened outside DocSpring in the signature request&#39;s audit trail: you sent the request to the person (&#x60;send_request&#x60;). The audit trail shows it as reported by your account. A finished (completed, declined or expired) signature request&#39;s audit trail takes no more events, and a test API token can&#39;t record one for a live signature request. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The event to record. (required)
   * @return SignatureRequestEvent
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> event recorded </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token on a live signature request </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request finished </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid event </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SignatureRequestEvent createSignatureRequestEvent(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nonnull CreateSignatureRequestEventRequest body) throws ApiException {
    return createSignatureRequestEventWithHttpInfo(signatureRequestId, body).getData();
  }

  /**
   * Record a signature request event
   * Records something that happened outside DocSpring in the signature request&#39;s audit trail: you sent the request to the person (&#x60;send_request&#x60;). The audit trail shows it as reported by your account. A finished (completed, declined or expired) signature request&#39;s audit trail takes no more events, and a test API token can&#39;t record one for a live signature request. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The event to record. (required)
   * @return ApiResponse&lt;SignatureRequestEvent&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> event recorded </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token on a live signature request </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request finished </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid event </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SignatureRequestEvent> createSignatureRequestEventWithHttpInfo(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nonnull CreateSignatureRequestEventRequest body) throws ApiException {
    // Check required parameters
    if (signatureRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'signatureRequestId' when calling createSignatureRequestEvent");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createSignatureRequestEvent");
    }

    // Path parameters
    String localVarPath = "/signature_requests/{signature_request_id}/events"
            .replaceAll("\\{signature_request_id}", apiClient.escapeString(signatureRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SignatureRequestEvent> localVarReturnType = new GenericType<SignatureRequestEvent>() {};
    return apiClient.invokeAPI("Client.createSignatureRequestEvent", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a signature request token
   * Creates a token that opens the signature request without signing in, in a form embedded in your app or from a link you send. The response is the only time the token&#39;s secret is returned. The link works for 24 hours, or 7 days for an &#x60;email&#x60; token, and a signing page that opened in time keeps working for 7 more days. A test API token can&#39;t create a token for a live signature request. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The kind of link to make. Send no body for an &#x60;api&#x60; token. (optional)
   * @return SignatureRequestToken
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> token created </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token on a live signature request </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request finished </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid token request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SignatureRequestToken createSignatureRequestToken(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nullable CreateSignatureRequestTokenRequest body) throws ApiException {
    return createSignatureRequestTokenWithHttpInfo(signatureRequestId, body).getData();
  }

  /**
   * Create a signature request token
   * Creates a token that opens the signature request without signing in, in a form embedded in your app or from a link you send. The response is the only time the token&#39;s secret is returned. The link works for 24 hours, or 7 days for an &#x60;email&#x60; token, and a signing page that opened in time keeps working for 7 more days. A test API token can&#39;t create a token for a live signature request. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The kind of link to make. Send no body for an &#x60;api&#x60; token. (optional)
   * @return ApiResponse&lt;SignatureRequestToken&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> token created </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token on a live signature request </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request finished </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid token request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SignatureRequestToken> createSignatureRequestTokenWithHttpInfo(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nullable CreateSignatureRequestTokenRequest body) throws ApiException {
    // Check required parameters
    if (signatureRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'signatureRequestId' when calling createSignatureRequestToken");
    }

    // Path parameters
    String localVarPath = "/signature_requests/{signature_request_id}/tokens"
            .replaceAll("\\{signature_request_id}", apiClient.escapeString(signatureRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SignatureRequestToken> localVarReturnType = new GenericType<SignatureRequestToken>() {};
    return apiClient.invokeAPI("Client.createSignatureRequestToken", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate a PDF
   * Creates a submission: fills in a template with your data and generates a PDF. The PDF is generated in the background: on sync.api hosts the request waits for it (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/{submission_id} until &#x60;state&#x60; isn&#39;t &#x60;pending&#x60;.  Data that doesn&#39;t match the template&#39;s fields returns a 422 with an &#x60;invalid_data&#x60; error. The submission is still saved, with its errors, so you can find it in DocSpring: the error&#39;s &#x60;submission_id&#x60; is its ID. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The submission&#39;s data and settings. (required)
   * @param version The template version to use: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published). (optional)
   * @param wait Wait until the files have been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another submission. Send a new key with each new submission, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid data </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the account is suspended </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Submission createSubmission(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreateSubmissionRequest body, @javax.annotation.Nullable String version, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    return createSubmissionWithHttpInfo(templateId, body, version, wait, idempotencyKey).getData();
  }

  /**
   * Generate a PDF
   * Creates a submission: fills in a template with your data and generates a PDF. The PDF is generated in the background: on sync.api hosts the request waits for it (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/{submission_id} until &#x60;state&#x60; isn&#39;t &#x60;pending&#x60;.  Data that doesn&#39;t match the template&#39;s fields returns a 422 with an &#x60;invalid_data&#x60; error. The submission is still saved, with its errors, so you can find it in DocSpring: the error&#39;s &#x60;submission_id&#x60; is its ID. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The submission&#39;s data and settings. (required)
   * @param version The template version to use: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published). (optional)
   * @param wait Wait until the files have been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another submission. Send a new key with each new submission, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid data </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the account is suspended </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Submission> createSubmissionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreateSubmissionRequest body, @javax.annotation.Nullable String version, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling createSubmission");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createSubmission");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "wait", wait));

    // Header parameters
    Map<String, String> localVarHeaderParams = new LinkedHashMap<>();
    if (idempotencyKey != null) {
      localVarHeaderParams.put("Idempotency-Key", apiClient.parameterToString(idempotencyKey));
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.createSubmission", localVarPath, "POST", localVarQueryParams, body,
                               localVarHeaderParams, new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate PDFs in a batch
   * Creates up to 50 submissions in one request, from one template or several. The PDFs are only generated when every submission is valid. On sync.api hosts the request waits until every PDF has been generated (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/batches/{submission_batch_id} until &#x60;processed_at&#x60; is set.  When any submission is invalid, nothing is generated and the request returns a 422. Submissions whose data doesn&#39;t match their template&#39;s fields are still saved with their errors (an &#x60;invalid_data&#x60; error, with each one&#39;s &#x60;submission_id&#x60; in its details), so you can find them in DocSpring. The other submissions aren&#39;t saved. 
   * @param body The submissions to create, and the settings they share. (required)
   * @param wait Wait until every PDF in the batch has been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another batch. Send a new key with each new batch, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return SubmissionBatch
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> batch created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid data </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> account suspended </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_batch_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public SubmissionBatch createSubmissionBatch(@javax.annotation.Nonnull CreateSubmissionBatchRequest body, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    return createSubmissionBatchWithHttpInfo(body, wait, idempotencyKey).getData();
  }

  /**
   * Generate PDFs in a batch
   * Creates up to 50 submissions in one request, from one template or several. The PDFs are only generated when every submission is valid. On sync.api hosts the request waits until every PDF has been generated (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/batches/{submission_batch_id} until &#x60;processed_at&#x60; is set.  When any submission is invalid, nothing is generated and the request returns a 422. Submissions whose data doesn&#39;t match their template&#39;s fields are still saved with their errors (an &#x60;invalid_data&#x60; error, with each one&#39;s &#x60;submission_id&#x60; in its details), so you can find them in DocSpring. The other submissions aren&#39;t saved. 
   * @param body The submissions to create, and the settings they share. (required)
   * @param wait Wait until every PDF in the batch has been generated before responding. Default true on sync.api hosts. (optional)
   * @param idempotencyKey A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request&#39;s response (and an &#x60;Idempotent-Replayed: true&#x60; header) instead of creating another batch. Send a new key with each new batch, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 &#x60;idempotency_key_reused&#x60;. A 409 &#x60;idempotency_key_in_use&#x60; means the first request is still being processed: send the request again in a few seconds. (optional)
   * @return ApiResponse&lt;SubmissionBatch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> batch created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid data </td><td>  -  </td></tr>
       <tr><td> 402 </td><td> not enough credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> account suspended </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> a request with the same Idempotency-Key is still being processed </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_batch_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionBatch> createSubmissionBatchWithHttpInfo(@javax.annotation.Nonnull CreateSubmissionBatchRequest body, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String idempotencyKey) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createSubmissionBatch");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    // Header parameters
    Map<String, String> localVarHeaderParams = new LinkedHashMap<>();
    if (idempotencyKey != null) {
      localVarHeaderParams.put("Idempotency-Key", apiClient.parameterToString(idempotencyKey));
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionBatch> localVarReturnType = new GenericType<SubmissionBatch>() {};
    return apiClient.invokeAPI("Client.createSubmissionBatch", "/submissions/batches", "POST", localVarQueryParams, body,
                               localVarHeaderParams, new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a template
   * Creates an HTML template, or a PDF template from a PDF you uploaded with the presigned upload (GET /uploads/presign): pass its &#x60;fields.key&#x60; as &#x60;cache_id&#x60;. To send the PDF with the request instead, use POST /templates/upload.  A PDF template is ready to generate PDFs once DocSpring has processed its PDF (&#x60;ready&#x60; is true). On sync.api hosts the request waits for that unless you pass &#x60;wait&#x3D;false&#x60;. 
   * @param body The template to create. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> HTML template created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Template createTemplate(@javax.annotation.Nonnull CreateTemplateRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    return createTemplateWithHttpInfo(body, wait).getData();
  }

  /**
   * Create a template
   * Creates an HTML template, or a PDF template from a PDF you uploaded with the presigned upload (GET /uploads/presign): pass its &#x60;fields.key&#x60; as &#x60;cache_id&#x60;. To send the PDF with the request instead, use POST /templates/upload.  A PDF template is ready to generate PDFs once DocSpring has processed its PDF (&#x60;ready&#x60; is true). On sync.api hosts the request waits for that unless you pass &#x60;wait&#x3D;false&#x60;. 
   * @param body The template to create. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> HTML template created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Template> createTemplateWithHttpInfo(@javax.annotation.Nonnull CreateTemplateRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createTemplate");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.createTemplate", "/templates", "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Preview a template with data
   * Makes PNG images of a template&#39;s pages filled in with the data you send (not a PDF), so you can check how an HTML or PDF template prints with your data before you publish a version or send live data. It renders the template&#39;s draft, or the published &#x60;version&#x60; you ask for. A preview makes no submission and uses no credits, and its pages are watermarked like a test submission&#39;s PDF. It&#39;s &#x60;pending&#x60; while it renders: get it with GET /templates/{template_id}/previews/{preview_id} until it&#39;s &#x60;processed&#x60;, with an image of each page, or &#x60;error&#x60;. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The data to render the template with. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> preview created </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> no data </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public TemplatePreview createTemplatePreview(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreateTemplatePreviewRequest body, @javax.annotation.Nullable String version) throws ApiException {
    return createTemplatePreviewWithHttpInfo(templateId, body, version).getData();
  }

  /**
   * Preview a template with data
   * Makes PNG images of a template&#39;s pages filled in with the data you send (not a PDF), so you can check how an HTML or PDF template prints with your data before you publish a version or send live data. It renders the template&#39;s draft, or the published &#x60;version&#x60; you ask for. A preview makes no submission and uses no credits, and its pages are watermarked like a test submission&#39;s PDF. It&#39;s &#x60;pending&#x60; while it renders: get it with GET /templates/{template_id}/previews/{preview_id} until it&#39;s &#x60;processed&#x60;, with an image of each page, or &#x60;error&#x60;. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The data to render the template with. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> preview created </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> no data </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createTemplatePreviewWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreateTemplatePreviewRequest body, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling createTemplatePreview");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createTemplatePreview");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/previews"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.createTemplatePreview", localVarPath, "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a webhook
   * Creates a webhook that sends a POST request to your endpoint whenever a subscribed event happens. Scope it to API tokens, templates or folders to receive only their events. 
   * @param body The webhook to create. (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> webhook created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid webhook </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Webhook createWebhook(@javax.annotation.Nonnull CreateWebhookRequest body) throws ApiException {
    return createWebhookWithHttpInfo(body).getData();
  }

  /**
   * Create a webhook
   * Creates a webhook that sends a POST request to your endpoint whenever a subscribed event happens. Scope it to API tokens, templates or folders to receive only their events. 
   * @param body The webhook to create. (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> webhook created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid webhook </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> createWebhookWithHttpInfo(@javax.annotation.Nonnull CreateWebhookRequest body) throws ApiException {
    // Check required parameters
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling createWebhook");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.createWebhook", "/webhooks", "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a custom file
   * Deletes a custom file and returns it. Use a live API token: test tokens can&#39;t delete custom files. 
   * @param customFileId The custom file&#39;s ID. (required)
   * @return CustomFile
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom file deleted </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> custom file not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CustomFile deleteCustomFile(@javax.annotation.Nonnull String customFileId) throws ApiException {
    return deleteCustomFileWithHttpInfo(customFileId).getData();
  }

  /**
   * Delete a custom file
   * Deletes a custom file and returns it. Use a live API token: test tokens can&#39;t delete custom files. 
   * @param customFileId The custom file&#39;s ID. (required)
   * @return ApiResponse&lt;CustomFile&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom file deleted </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> custom file not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CustomFile> deleteCustomFileWithHttpInfo(@javax.annotation.Nonnull String customFileId) throws ApiException {
    // Check required parameters
    if (customFileId == null) {
      throw new ApiException(400, "Missing the required parameter 'customFileId' when calling deleteCustomFile");
    }

    // Path parameters
    String localVarPath = "/custom_files/{custom_file_id}"
            .replaceAll("\\{custom_file_id}", apiClient.escapeString(customFileId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CustomFile> localVarReturnType = new GenericType<CustomFile>() {};
    return apiClient.invokeAPI("Client.deleteCustomFile", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a folder
   * Deletes an empty folder and returns it. A folder that still has templates or folders in it can&#39;t be deleted. 
   * @param folderId The folder&#39;s ID. (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder deleted </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> folder is not empty </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Folder deleteFolder(@javax.annotation.Nonnull String folderId) throws ApiException {
    return deleteFolderWithHttpInfo(folderId).getData();
  }

  /**
   * Delete a folder
   * Deletes an empty folder and returns it. A folder that still has templates or folders in it can&#39;t be deleted. 
   * @param folderId The folder&#39;s ID. (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder deleted </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> folder is not empty </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Folder> deleteFolderWithHttpInfo(@javax.annotation.Nonnull String folderId) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling deleteFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.deleteFolder", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a template
   * Deletes a template&#39;s draft and all of its published versions, or one published version (&#x60;version&#x60;). Returns the template as it was before it was deleted. 
   * @param templateId The template&#39;s ID. (required)
   * @param version Delete only this published version (&#x60;1.2.0&#x60;) or the draft (&#x60;draft&#x60;, when no version has been published). Without it, the draft and every published version are deleted. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template deleted </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template deleteTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return deleteTemplateWithHttpInfo(templateId, version).getData();
  }

  /**
   * Delete a template
   * Deletes a template&#39;s draft and all of its published versions, or one published version (&#x60;version&#x60;). Returns the template as it was before it was deleted. 
   * @param templateId The template&#39;s ID. (required)
   * @param version Delete only this published version (&#x60;1.2.0&#x60;) or the draft (&#x60;draft&#x60;, when no version has been published). Without it, the draft and every published version are deleted. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template deleted </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> deleteTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling deleteTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.deleteTemplate", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a webhook
   * Deletes a webhook so it stops receiving events, and returns it.
   * @param webhookId The webhook&#39;s ID. (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Webhook deleteWebhook(@javax.annotation.Nonnull String webhookId) throws ApiException {
    return deleteWebhookWithHttpInfo(webhookId).getData();
  }

  /**
   * Delete a webhook
   * Deletes a webhook so it stops receiving events, and returns it.
   * @param webhookId The webhook&#39;s ID. (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> deleteWebhookWithHttpInfo(@javax.annotation.Nonnull String webhookId) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling deleteWebhook");
    }

    // Path parameters
    String localVarPath = "/webhooks/{webhook_id}"
            .replaceAll("\\{webhook_id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.deleteWebhook", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Expire a combined PDF
   * Deletes a combined PDF&#39;s PDF and returns the expired combined PDF.
   * @param combinedPdfId The combined PDF&#39;s ID. (required)
   * @return CombinedPdf
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDF expired </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined PDF not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CombinedPdf expireCombinedPdf(@javax.annotation.Nonnull String combinedPdfId) throws ApiException {
    return expireCombinedPdfWithHttpInfo(combinedPdfId).getData();
  }

  /**
   * Expire a combined PDF
   * Deletes a combined PDF&#39;s PDF and returns the expired combined PDF.
   * @param combinedPdfId The combined PDF&#39;s ID. (required)
   * @return ApiResponse&lt;CombinedPdf&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDF expired </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined PDF not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CombinedPdf> expireCombinedPdfWithHttpInfo(@javax.annotation.Nonnull String combinedPdfId) throws ApiException {
    // Check required parameters
    if (combinedPdfId == null) {
      throw new ApiException(400, "Missing the required parameter 'combinedPdfId' when calling expireCombinedPdf");
    }

    // Path parameters
    String localVarPath = "/combined_pdfs/{combined_pdf_id}"
            .replaceAll("\\{combined_pdf_id}", apiClient.escapeString(combinedPdfId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedPdf> localVarReturnType = new GenericType<CombinedPdf>() {};
    return apiClient.invokeAPI("Client.expireCombinedPdf", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Expire a submission
   * Deletes a submission&#39;s data and PDF now, and returns the expired submission.
   * @param submissionId The submission&#39;s ID. (required)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission expired </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Submission expireSubmission(@javax.annotation.Nonnull String submissionId) throws ApiException {
    return expireSubmissionWithHttpInfo(submissionId).getData();
  }

  /**
   * Expire a submission
   * Deletes a submission&#39;s data and PDF now, and returns the expired submission.
   * @param submissionId The submission&#39;s ID. (required)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission expired </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Submission> expireSubmissionWithHttpInfo(@javax.annotation.Nonnull String submissionId) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling expireSubmission");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.expireSubmission", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate more files
   * Adds formats to a processed submission&#39;s files, in the background: &#x60;png&#x60;, a PNG image of each page of the PDF (up to 100 pages). To make them with the submission, add them to &#x60;output_formats&#x60; when you create it.  Each new file is listed in &#x60;files&#x60; while it&#39;s made: on sync.api hosts the request waits for them (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/{submission_id} until none of their &#x60;state&#x60; is &#x60;pending&#x60;. A file that couldn&#39;t be made has the state &#x60;error&#x60; and an &#x60;error_message&#x60;, and the submission stays processed. Asking for a format the submission already has (or is making) changes nothing. 
   * @param submissionId The submission&#39;s ID. (required)
   * @param body The formats to make. (required)
   * @param wait Wait until the files have been generated before responding. Default true on sync.api hosts. (optional)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> images of the pages requested </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> files not possible </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Submission generateSubmissionFiles(@javax.annotation.Nonnull String submissionId, @javax.annotation.Nonnull GenerateSubmissionFilesRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    return generateSubmissionFilesWithHttpInfo(submissionId, body, wait).getData();
  }

  /**
   * Generate more files
   * Adds formats to a processed submission&#39;s files, in the background: &#x60;png&#x60;, a PNG image of each page of the PDF (up to 100 pages). To make them with the submission, add them to &#x60;output_formats&#x60; when you create it.  Each new file is listed in &#x60;files&#x60; while it&#39;s made: on sync.api hosts the request waits for them (unless you pass &#x60;wait&#x3D;false&#x60;), otherwise poll GET /submissions/{submission_id} until none of their &#x60;state&#x60; is &#x60;pending&#x60;. A file that couldn&#39;t be made has the state &#x60;error&#x60; and an &#x60;error_message&#x60;, and the submission stays processed. Asking for a format the submission already has (or is making) changes nothing. 
   * @param submissionId The submission&#39;s ID. (required)
   * @param body The formats to make. (required)
   * @param wait Wait until the files have been generated before responding. Default true on sync.api hosts. (optional)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> images of the pages requested </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> files not possible </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s submission_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Submission> generateSubmissionFilesWithHttpInfo(@javax.annotation.Nonnull String submissionId, @javax.annotation.Nonnull GenerateSubmissionFilesRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling generateSubmissionFiles");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling generateSubmissionFiles");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}/generate_files"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.generateSubmissionFiles", localVarPath, "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate a preview PDF
   * Generates a preview of a submission&#39;s PDF in the background, such as for a submission still waiting for its signature requests. It&#39;s in &#x60;files.preview&#x60; once &#x60;preview_generated_at&#x60; changes. 
   * @param submissionId The submission&#39;s ID. (required)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview requested </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> preview not possible </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Submission generateSubmissionPreview(@javax.annotation.Nonnull String submissionId) throws ApiException {
    return generateSubmissionPreviewWithHttpInfo(submissionId).getData();
  }

  /**
   * Generate a preview PDF
   * Generates a preview of a submission&#39;s PDF in the background, such as for a submission still waiting for its signature requests. It&#39;s in &#x60;files.preview&#x60; once &#x60;preview_generated_at&#x60; changes. 
   * @param submissionId The submission&#39;s ID. (required)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview requested </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> preview not possible </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Submission> generateSubmissionPreviewWithHttpInfo(@javax.annotation.Nonnull String submissionId) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling generateSubmissionPreview");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}/generate_preview"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.generateSubmissionPreview", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a combined PDF
   * Returns a combined PDF, with a temporary link to download it once it has been generated.
   * @param combinedPdfId The combined PDF&#39;s ID. (required)
   * @return CombinedPdf
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDF </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined PDF not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CombinedPdf getCombinedPdf(@javax.annotation.Nonnull String combinedPdfId) throws ApiException {
    return getCombinedPdfWithHttpInfo(combinedPdfId).getData();
  }

  /**
   * Get a combined PDF
   * Returns a combined PDF, with a temporary link to download it once it has been generated.
   * @param combinedPdfId The combined PDF&#39;s ID. (required)
   * @return ApiResponse&lt;CombinedPdf&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDF </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined PDF not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CombinedPdf> getCombinedPdfWithHttpInfo(@javax.annotation.Nonnull String combinedPdfId) throws ApiException {
    // Check required parameters
    if (combinedPdfId == null) {
      throw new ApiException(400, "Missing the required parameter 'combinedPdfId' when calling getCombinedPdf");
    }

    // Path parameters
    String localVarPath = "/combined_pdfs/{combined_pdf_id}"
            .replaceAll("\\{combined_pdf_id}", apiClient.escapeString(combinedPdfId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedPdf> localVarReturnType = new GenericType<CombinedPdf>() {};
    return apiClient.invokeAPI("Client.getCombinedPdf", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a custom file
   * Returns a custom file, with a temporary URL to download it.
   * @param customFileId The custom file&#39;s ID. (required)
   * @return CustomFile
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom file found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> custom file not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CustomFile getCustomFile(@javax.annotation.Nonnull String customFileId) throws ApiException {
    return getCustomFileWithHttpInfo(customFileId).getData();
  }

  /**
   * Get a custom file
   * Returns a custom file, with a temporary URL to download it.
   * @param customFileId The custom file&#39;s ID. (required)
   * @return ApiResponse&lt;CustomFile&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom file found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> custom file not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CustomFile> getCustomFileWithHttpInfo(@javax.annotation.Nonnull String customFileId) throws ApiException {
    // Check required parameters
    if (customFileId == null) {
      throw new ApiException(400, "Missing the required parameter 'customFileId' when calling getCustomFile");
    }

    // Path parameters
    String localVarPath = "/custom_files/{custom_file_id}"
            .replaceAll("\\{custom_file_id}", apiClient.escapeString(customFileId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CustomFile> localVarReturnType = new GenericType<CustomFile>() {};
    return apiClient.invokeAPI("Client.getCustomFile", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a folder
   * Returns a folder.
   * @param folderId The folder&#39;s ID. (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Folder getFolder(@javax.annotation.Nonnull String folderId) throws ApiException {
    return getFolderWithHttpInfo(folderId).getData();
  }

  /**
   * Get a folder
   * Returns a folder.
   * @param folderId The folder&#39;s ID. (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Folder> getFolderWithHttpInfo(@javax.annotation.Nonnull String folderId) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling getFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.getFolder", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a presigned URL to upload a file
   * Returns a presigned S3 form for uploading a file directly to DocSpring, for files too large to send in a request body. POST the &#x60;fields&#x60; and the file (as &#x60;file&#x60;) to &#x60;url&#x60; as multipart/form-data, then pass &#x60;fields.key&#x60; as the &#x60;cache_id&#x60; when you create a custom file. 
   * @return UploadPresign
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presigned URL created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn about uploading custom files for PDF combining
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a presigned URL to upload a file Documentation</a>
   */
  public UploadPresign getPresignUrl() throws ApiException {
    return getPresignUrlWithHttpInfo().getData();
  }

  /**
   * Get a presigned URL to upload a file
   * Returns a presigned S3 form for uploading a file directly to DocSpring, for files too large to send in a request body. POST the &#x60;fields&#x60; and the file (as &#x60;file&#x60;) to &#x60;url&#x60; as multipart/form-data, then pass &#x60;fields.key&#x60; as the &#x60;cache_id&#x60; when you create a custom file. 
   * @return ApiResponse&lt;UploadPresign&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presigned URL created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn about uploading custom files for PDF combining
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a presigned URL to upload a file Documentation</a>
   */
  public ApiResponse<UploadPresign> getPresignUrlWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<UploadPresign> localVarReturnType = new GenericType<UploadPresign>() {};
    return apiClient.invokeAPI("Client.getPresignUrl", "/uploads/presign", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a signature request
   * Returns a signature request, with the values the person has entered so far.
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @return SignatureRequest
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> signature request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SignatureRequest getSignatureRequest(@javax.annotation.Nonnull String signatureRequestId) throws ApiException {
    return getSignatureRequestWithHttpInfo(signatureRequestId).getData();
  }

  /**
   * Get a signature request
   * Returns a signature request, with the values the person has entered so far.
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @return ApiResponse&lt;SignatureRequest&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> signature request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SignatureRequest> getSignatureRequestWithHttpInfo(@javax.annotation.Nonnull String signatureRequestId) throws ApiException {
    // Check required parameters
    if (signatureRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'signatureRequestId' when calling getSignatureRequest");
    }

    // Path parameters
    String localVarPath = "/signature_requests/{signature_request_id}"
            .replaceAll("\\{signature_request_id}", apiClient.escapeString(signatureRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SignatureRequest> localVarReturnType = new GenericType<SignatureRequest>() {};
    return apiClient.invokeAPI("Client.getSignatureRequest", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a submission
   * Returns a submission, with its data and links to download its PDF.
   * @param submissionId The submission&#39;s ID. (required)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Submission getSubmission(@javax.annotation.Nonnull String submissionId) throws ApiException {
    return getSubmissionWithHttpInfo(submissionId).getData();
  }

  /**
   * Get a submission
   * Returns a submission, with its data and links to download its PDF.
   * @param submissionId The submission&#39;s ID. (required)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Submission> getSubmissionWithHttpInfo(@javax.annotation.Nonnull String submissionId) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling getSubmission");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.getSubmission", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a batch
   * Returns a batch with its submissions. The batch has finished once &#x60;processed_at&#x60; is set: its &#x60;state&#x60; is &#x60;processed&#x60; when every PDF was generated, or &#x60;error&#x60; when any submission failed. 
   * @param submissionBatchId The batch&#39;s ID. (required)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @return SubmissionBatch
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> batch </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> batch not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SubmissionBatch getSubmissionBatch(@javax.annotation.Nonnull String submissionBatchId, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    return getSubmissionBatchWithHttpInfo(submissionBatchId, includeData).getData();
  }

  /**
   * Get a batch
   * Returns a batch with its submissions. The batch has finished once &#x60;processed_at&#x60; is set: its &#x60;state&#x60; is &#x60;processed&#x60; when every PDF was generated, or &#x60;error&#x60; when any submission failed. 
   * @param submissionBatchId The batch&#39;s ID. (required)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @return ApiResponse&lt;SubmissionBatch&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> batch </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> batch not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionBatch> getSubmissionBatchWithHttpInfo(@javax.annotation.Nonnull String submissionBatchId, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    // Check required parameters
    if (submissionBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionBatchId' when calling getSubmissionBatch");
    }

    // Path parameters
    String localVarPath = "/submissions/batches/{submission_batch_id}"
            .replaceAll("\\{submission_batch_id}", apiClient.escapeString(submissionBatchId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "include_data", includeData)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionBatch> localVarReturnType = new GenericType<SubmissionBatch>() {};
    return apiClient.invokeAPI("Client.getSubmissionBatch", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a template
   * Returns a template: its draft, or one of its published versions.
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template getTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return getTemplateWithHttpInfo(templateId, version).getData();
  }

  /**
   * Get a template
   * Returns a template: its draft, or one of its published versions.
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> getTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.getTemplate", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Compare a version of a template with the one before it
   * Returns what changed in the template&#39;s draft since its latest published version (or in a published version since the one before it): fields added, removed, changed and moved, the settings that changed, and whether the document was replaced. Check it before you publish a version. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return TemplateDiff
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> the draft&#39;s changes since the latest published version </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Compare a version of a template with the one before it Documentation</a>
   */
  public TemplateDiff getTemplateDiff(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return getTemplateDiffWithHttpInfo(templateId, version).getData();
  }

  /**
   * Compare a version of a template with the one before it
   * Returns what changed in the template&#39;s draft since its latest published version (or in a published version since the one before it): fields added, removed, changed and moved, the settings that changed, and whether the document was replaced. Check it before you publish a version. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return ApiResponse&lt;TemplateDiff&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> the draft&#39;s changes since the latest published version </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Compare a version of a template with the one before it Documentation</a>
   */
  public ApiResponse<TemplateDiff> getTemplateDiffWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplateDiff");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/diff"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateDiff> localVarReturnType = new GenericType<TemplateDiff>() {};
    return apiClient.invokeAPI("Client.getTemplateDiff", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate typed code for a template&#39;s submission data
   * Generates types for a template&#39;s submission data in TypeScript, JavaScript, Ruby, Python, PHP, Java, C#, Elixir or Go, so your app catches mistakes before it calls the API. &#x60;root_type_name&#x60; is the type of the whole &#x60;data&#x60; object, and &#x60;just_types&#x3D;true&#x60; leaves out the code that converts JSON to and from the types. Java returns every class in &#x60;code&#x60;, each under a &#x60;// ClassName.java&#x60; comment. A template with no named fields returns 422. 
   * @param templateId The template&#39;s ID. (required)
   * @param lang The language to generate the code in. (required)
   * @param version The template version: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published), the version a submission uses by default. (optional)
   * @param justTypes Return only the types (interfaces, classes or structs), without the code that converts JSON to and from them. Default false. JavaScript has no types and PHP no types-only code, so theirs is the same either way. (optional)
   * @return TemplateModelCode
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> model code </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown language </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public TemplateModelCode getTemplateModelCode(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ModelCodeLanguage lang, @javax.annotation.Nullable String version, @javax.annotation.Nullable Boolean justTypes) throws ApiException {
    return getTemplateModelCodeWithHttpInfo(templateId, lang, version, justTypes).getData();
  }

  /**
   * Generate typed code for a template&#39;s submission data
   * Generates types for a template&#39;s submission data in TypeScript, JavaScript, Ruby, Python, PHP, Java, C#, Elixir or Go, so your app catches mistakes before it calls the API. &#x60;root_type_name&#x60; is the type of the whole &#x60;data&#x60; object, and &#x60;just_types&#x3D;true&#x60; leaves out the code that converts JSON to and from the types. Java returns every class in &#x60;code&#x60;, each under a &#x60;// ClassName.java&#x60; comment. A template with no named fields returns 422. 
   * @param templateId The template&#39;s ID. (required)
   * @param lang The language to generate the code in. (required)
   * @param version The template version: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published), the version a submission uses by default. (optional)
   * @param justTypes Return only the types (interfaces, classes or structs), without the code that converts JSON to and from them. Default false. JavaScript has no types and PHP no types-only code, so theirs is the same either way. (optional)
   * @return ApiResponse&lt;TemplateModelCode&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> model code </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown language </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<TemplateModelCode> getTemplateModelCodeWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ModelCodeLanguage lang, @javax.annotation.Nullable String version, @javax.annotation.Nullable Boolean justTypes) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplateModelCode");
    }
    if (lang == null) {
      throw new ApiException(400, "Missing the required parameter 'lang' when calling getTemplateModelCode");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/model_code"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lang", lang));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "just_types", justTypes));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateModelCode> localVarReturnType = new GenericType<TemplateModelCode>() {};
    return apiClient.invokeAPI("Client.getTemplateModelCode", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get images of a template&#39;s pages
   * Returns a JPEG image of each page of a PDF template&#39;s PDF, with temporary links to download them: the draft&#39;s PDF, or a published version&#39;s. Use them to see the pages that fields are placed on. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return TemplatePageImages
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> page images </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> no page images </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Get images of a template&#39;s pages Documentation</a>
   */
  public TemplatePageImages getTemplatePageImages(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return getTemplatePageImagesWithHttpInfo(templateId, version).getData();
  }

  /**
   * Get images of a template&#39;s pages
   * Returns a JPEG image of each page of a PDF template&#39;s PDF, with temporary links to download them: the draft&#39;s PDF, or a published version&#39;s. Use them to see the pages that fields are placed on. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return ApiResponse&lt;TemplatePageImages&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> page images </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> no page images </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Get images of a template&#39;s pages Documentation</a>
   */
  public ApiResponse<TemplatePageImages> getTemplatePageImagesWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplatePageImages");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/page_images"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePageImages> localVarReturnType = new GenericType<TemplatePageImages>() {};
    return apiClient.invokeAPI("Client.getTemplatePageImages", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a template preview
   * Returns a preview made with POST /templates/{template_id}/previews. Once it&#39;s &#x60;processed&#x60;, &#x60;pages&#x60; has a PNG image of each page with a temporary link to download it: a preview has no PDF. Previews are deleted an hour after they&#39;re created. 
   * @param templateId The template&#39;s ID. (required)
   * @param previewId The preview&#39;s ID. (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> preview not found </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public TemplatePreview getTemplatePreview(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull String previewId) throws ApiException {
    return getTemplatePreviewWithHttpInfo(templateId, previewId).getData();
  }

  /**
   * Get a template preview
   * Returns a preview made with POST /templates/{template_id}/previews. Once it&#39;s &#x60;processed&#x60;, &#x60;pages&#x60; has a PNG image of each page with a temporary link to download it: a preview has no PDF. Previews are deleted an hour after they&#39;re created. 
   * @param templateId The template&#39;s ID. (required)
   * @param previewId The preview&#39;s ID. (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> preview not found </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> getTemplatePreviewWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull String previewId) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplatePreview");
    }
    if (previewId == null) {
      throw new ApiException(400, "Missing the required parameter 'previewId' when calling getTemplatePreview");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/previews/{preview_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()))
            .replaceAll("\\{preview_id}", apiClient.escapeString(previewId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.getTemplatePreview", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get the JSON Schema of a template&#39;s submission data
   * Returns the JSON Schema that a submission&#39;s &#x60;data&#x60; must match. Use it to check data before you create submissions, or to build a form for the template&#39;s fields. 
   * @param templateId The template&#39;s ID. (required)
   * @param version The template version: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published), the version a submission uses by default. (optional)
   * @return Map&lt;String, Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template schema </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Map<String, Object> getTemplateSchema(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return getTemplateSchemaWithHttpInfo(templateId, version).getData();
  }

  /**
   * Get the JSON Schema of a template&#39;s submission data
   * Returns the JSON Schema that a submission&#39;s &#x60;data&#x60; must match. Use it to check data before you create submissions, or to build a form for the template&#39;s fields. 
   * @param templateId The template&#39;s ID. (required)
   * @param version The template version: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published), the version a submission uses by default. (optional)
   * @return ApiResponse&lt;Map&lt;String, Object&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template schema </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, Object>> getTemplateSchemaWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplateSchema");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/schema"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Map<String, Object>> localVarReturnType = new GenericType<Map<String, Object>>() {};
    return apiClient.invokeAPI("Client.getTemplateSchema", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a webhook
   * Returns a webhook.
   * @param webhookId The webhook&#39;s ID. (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Webhook getWebhook(@javax.annotation.Nonnull String webhookId) throws ApiException {
    return getWebhookWithHttpInfo(webhookId).getData();
  }

  /**
   * Get a webhook
   * Returns a webhook.
   * @param webhookId The webhook&#39;s ID. (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> getWebhookWithHttpInfo(@javax.annotation.Nonnull String webhookId) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling getWebhook");
    }

    // Path parameters
    String localVarPath = "/webhooks/{webhook_id}"
            .replaceAll("\\{webhook_id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.getWebhook", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List combined PDFs
   * Returns the combined PDFs in your account, newest first, one page at a time.
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return CombinedPdfList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDFs </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CombinedPdfList listCombinedPdfs(@javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    return listCombinedPdfsWithHttpInfo(limit, cursor).getData();
  }

  /**
   * List combined PDFs
   * Returns the combined PDFs in your account, newest first, one page at a time.
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return ApiResponse&lt;CombinedPdfList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> combined PDFs </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CombinedPdfList> listCombinedPdfsWithHttpInfo(@javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "limit", limit)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedPdfList> localVarReturnType = new GenericType<CombinedPdfList>() {};
    return apiClient.invokeAPI("Client.listCombinedPdfs", "/combined_pdfs", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List custom files
   * Returns the custom files in your account, newest first, one page at a time.
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return CustomFileList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom files </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public CustomFileList listCustomFiles(@javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    return listCustomFilesWithHttpInfo(limit, cursor).getData();
  }

  /**
   * List custom files
   * Returns the custom files in your account, newest first, one page at a time.
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return ApiResponse&lt;CustomFileList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> custom files </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<CustomFileList> listCustomFilesWithHttpInfo(@javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "limit", limit)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CustomFileList> localVarReturnType = new GenericType<CustomFileList>() {};
    return apiClient.invokeAPI("Client.listCustomFiles", "/custom_files", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List folders
   * Returns the folders in your account, newest first, one page at a time. Pass &#x60;parent_folder_id&#x60; to list the folders in one folder. 
   * @param parentFolderId Only list the folders in this folder. Without it, the list has every folder, at any depth. (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return FolderList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folders in a folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public FolderList listFolders(@javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    return listFoldersWithHttpInfo(parentFolderId, limit, cursor).getData();
  }

  /**
   * List folders
   * Returns the folders in your account, newest first, one page at a time. Pass &#x60;parent_folder_id&#x60; to list the folders in one folder. 
   * @param parentFolderId Only list the folders in this folder. Without it, the list has every folder, at any depth. (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return ApiResponse&lt;FolderList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folders in a folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<FolderList> listFoldersWithHttpInfo(@javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "parent_folder_id", parentFolderId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<FolderList> localVarReturnType = new GenericType<FolderList>() {};
    return apiClient.invokeAPI("Client.listFolders", "/folders", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List submissions
   * Returns the submissions in your account, newest first, one page at a time. Each one is a summary: its &#x60;data&#x60; is null unless you pass &#x60;include_data&#x3D;true&#x60;, and its &#x60;files&#x60; are empty unless you pass &#x60;include_files&#x3D;true&#x60;. Get a submission by its ID for its signature requests, uploads and page images. 
   * @param templateId Only list this template&#39;s submissions. (optional)
   * @param test Only list test submissions (true) or live submissions (false). (optional)
   * @param createdAfter Only list submissions created after this time (RFC 3339, such as &#x60;2025-01-31T09:00:00Z&#x60;). (optional)
   * @param createdBefore Only list submissions created before this time. (optional)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @param state Only list submissions in this state (one state per request). The ones that failed are &#x60;invalid_data&#x60;, &#x60;error&#x60;, &#x60;syntax_error&#x60;, &#x60;image_download_failed&#x60; and &#x60;image_processing_failed&#x60;, and one still &#x60;pending&#x60; an hour after it was created is stuck. (optional)
   * @param includeFiles Include each submission&#39;s generated files and their download links (&#x60;files&#x60;, empty without it), without the page images&#39; links. (optional)
   * @return SubmissionList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submissions </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SubmissionList listSubmissions(@javax.annotation.Nullable String templateId, @javax.annotation.Nullable Boolean test, @javax.annotation.Nullable OffsetDateTime createdAfter, @javax.annotation.Nullable OffsetDateTime createdBefore, @javax.annotation.Nullable Boolean includeData, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable SubmissionState state, @javax.annotation.Nullable Boolean includeFiles) throws ApiException {
    return listSubmissionsWithHttpInfo(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles).getData();
  }

  /**
   * List submissions
   * Returns the submissions in your account, newest first, one page at a time. Each one is a summary: its &#x60;data&#x60; is null unless you pass &#x60;include_data&#x3D;true&#x60;, and its &#x60;files&#x60; are empty unless you pass &#x60;include_files&#x3D;true&#x60;. Get a submission by its ID for its signature requests, uploads and page images. 
   * @param templateId Only list this template&#39;s submissions. (optional)
   * @param test Only list test submissions (true) or live submissions (false). (optional)
   * @param createdAfter Only list submissions created after this time (RFC 3339, such as &#x60;2025-01-31T09:00:00Z&#x60;). (optional)
   * @param createdBefore Only list submissions created before this time. (optional)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @param state Only list submissions in this state (one state per request). The ones that failed are &#x60;invalid_data&#x60;, &#x60;error&#x60;, &#x60;syntax_error&#x60;, &#x60;image_download_failed&#x60; and &#x60;image_processing_failed&#x60;, and one still &#x60;pending&#x60; an hour after it was created is stuck. (optional)
   * @param includeFiles Include each submission&#39;s generated files and their download links (&#x60;files&#x60;, empty without it), without the page images&#39; links. (optional)
   * @return ApiResponse&lt;SubmissionList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submissions </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionList> listSubmissionsWithHttpInfo(@javax.annotation.Nullable String templateId, @javax.annotation.Nullable Boolean test, @javax.annotation.Nullable OffsetDateTime createdAfter, @javax.annotation.Nullable OffsetDateTime createdBefore, @javax.annotation.Nullable Boolean includeData, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable SubmissionState state, @javax.annotation.Nullable Boolean includeFiles) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "template_id", templateId)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "test", test));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_after", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_before", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_data", includeData));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "state", state));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_files", includeFiles));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionList> localVarReturnType = new GenericType<SubmissionList>() {};
    return apiClient.invokeAPI("Client.listSubmissions", "/submissions", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List a template&#39;s fields
   * Returns a template&#39;s fields with all of their settings, page by page: the draft&#39;s fields, or a published version&#39;s. A PDF template&#39;s fields are placed on its pages: GET /templates/{template_id}/page_images has images of the pages. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return TemplateFields
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">List a template&#39;s fields Documentation</a>
   */
  public TemplateFields listTemplateFields(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return listTemplateFieldsWithHttpInfo(templateId, version).getData();
  }

  /**
   * List a template&#39;s fields
   * Returns a template&#39;s fields with all of their settings, page by page: the draft&#39;s fields, or a published version&#39;s. A PDF template&#39;s fields are placed on its pages: GET /templates/{template_id}/page_images has images of the pages. 
   * @param templateId The template&#39;s ID. (required)
   * @param version A published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;draft&#x60;. (optional)
   * @return ApiResponse&lt;TemplateFields&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> the template&#39;s PDF hasn&#39;t been processed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">List a template&#39;s fields Documentation</a>
   */
  public ApiResponse<TemplateFields> listTemplateFieldsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling listTemplateFields");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/fields"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateFields> localVarReturnType = new GenericType<TemplateFields>() {};
    return apiClient.invokeAPI("Client.listTemplateFields", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List a template&#39;s submissions
   * Returns a template&#39;s submissions (from every version of the template), newest first.
   * @param templateId The template&#39;s ID. (required)
   * @param test Only list test submissions (true) or live submissions (false). (optional)
   * @param createdAfter Only list submissions created after this time (RFC 3339, such as &#x60;2025-01-31T09:00:00Z&#x60;). (optional)
   * @param createdBefore Only list submissions created before this time. (optional)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @param state Only list submissions in this state (one state per request). The ones that failed are &#x60;invalid_data&#x60;, &#x60;error&#x60;, &#x60;syntax_error&#x60;, &#x60;image_download_failed&#x60; and &#x60;image_processing_failed&#x60;, and one still &#x60;pending&#x60; an hour after it was created is stuck. (optional)
   * @param includeFiles Include each submission&#39;s generated files and their download links (&#x60;files&#x60;, empty without it), without the page images&#39; links. (optional)
   * @return SubmissionList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template&#39;s submissions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SubmissionList listTemplateSubmissions(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable Boolean test, @javax.annotation.Nullable OffsetDateTime createdAfter, @javax.annotation.Nullable OffsetDateTime createdBefore, @javax.annotation.Nullable Boolean includeData, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable SubmissionState state, @javax.annotation.Nullable Boolean includeFiles) throws ApiException {
    return listTemplateSubmissionsWithHttpInfo(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles).getData();
  }

  /**
   * List a template&#39;s submissions
   * Returns a template&#39;s submissions (from every version of the template), newest first.
   * @param templateId The template&#39;s ID. (required)
   * @param test Only list test submissions (true) or live submissions (false). (optional)
   * @param createdAfter Only list submissions created after this time (RFC 3339, such as &#x60;2025-01-31T09:00:00Z&#x60;). (optional)
   * @param createdBefore Only list submissions created before this time. (optional)
   * @param includeData Include each submission&#39;s &#x60;data&#x60; (null without it). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @param state Only list submissions in this state (one state per request). The ones that failed are &#x60;invalid_data&#x60;, &#x60;error&#x60;, &#x60;syntax_error&#x60;, &#x60;image_download_failed&#x60; and &#x60;image_processing_failed&#x60;, and one still &#x60;pending&#x60; an hour after it was created is stuck. (optional)
   * @param includeFiles Include each submission&#39;s generated files and their download links (&#x60;files&#x60;, empty without it), without the page images&#39; links. (optional)
   * @return ApiResponse&lt;SubmissionList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template&#39;s submissions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionList> listTemplateSubmissionsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable Boolean test, @javax.annotation.Nullable OffsetDateTime createdAfter, @javax.annotation.Nullable OffsetDateTime createdBefore, @javax.annotation.Nullable Boolean includeData, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable SubmissionState state, @javax.annotation.Nullable Boolean includeFiles) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling listTemplateSubmissions");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "test", test)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_after", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_before", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_data", includeData));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "state", state));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_files", includeFiles));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionList> localVarReturnType = new GenericType<SubmissionList>() {};
    return apiClient.invokeAPI("Client.listTemplateSubmissions", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List templates
   * Returns the templates in your account (their drafts), newest first, one page at a time. Each one is a summary: get a template by its ID for its settings, its PDF in full, its HTML, defaults and published versions. 
   * @param query Only list templates whose name contains this text (ignoring case). (optional)
   * @param parentFolderId Only list the templates in this folder (not in its subfolders). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return TemplateSummaryList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> templates </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public TemplateSummaryList listTemplates(@javax.annotation.Nullable String query, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    return listTemplatesWithHttpInfo(query, parentFolderId, limit, cursor).getData();
  }

  /**
   * List templates
   * Returns the templates in your account (their drafts), newest first, one page at a time. Each one is a summary: get a template by its ID for its settings, its PDF in full, its HTML, defaults and published versions. 
   * @param query Only list templates whose name contains this text (ignoring case). (optional)
   * @param parentFolderId Only list the templates in this folder (not in its subfolders). (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return ApiResponse&lt;TemplateSummaryList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> templates </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid query parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<TemplateSummaryList> listTemplatesWithHttpInfo(@javax.annotation.Nullable String query, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent_folder_id", parentFolderId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateSummaryList> localVarReturnType = new GenericType<TemplateSummaryList>() {};
    return apiClient.invokeAPI("Client.listTemplates", "/templates", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List webhooks
   * Returns the webhooks in your account, newest first, one page at a time. Filter them by event type, mode, or the API token, template or folder they&#39;re scoped to. 
   * @param eventType Only list webhooks that subscribe to this event. (optional)
   * @param mode Only list webhooks set to this mode. (optional)
   * @param templateId Only list webhooks scoped to this template. (optional)
   * @param folderId Only list webhooks scoped to this folder. (optional)
   * @param apiTokenId Only list webhooks scoped to this API token. (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return WebhookList
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhooks for a template and event </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown event type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public WebhookList listWebhooks(@javax.annotation.Nullable WebhookEventType eventType, @javax.annotation.Nullable WebhookMode mode, @javax.annotation.Nullable String templateId, @javax.annotation.Nullable String folderId, @javax.annotation.Nullable String apiTokenId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    return listWebhooksWithHttpInfo(eventType, mode, templateId, folderId, apiTokenId, limit, cursor).getData();
  }

  /**
   * List webhooks
   * Returns the webhooks in your account, newest first, one page at a time. Filter them by event type, mode, or the API token, template or folder they&#39;re scoped to. 
   * @param eventType Only list webhooks that subscribe to this event. (optional)
   * @param mode Only list webhooks set to this mode. (optional)
   * @param templateId Only list webhooks scoped to this template. (optional)
   * @param folderId Only list webhooks scoped to this folder. (optional)
   * @param apiTokenId Only list webhooks scoped to this API token. (optional)
   * @param limit How many items to return (1-100, default 50). (optional, default to 50)
   * @param cursor The previous page&#39;s &#x60;next_cursor&#x60;, to get the next page. It&#39;s the ID of that page&#39;s last item, so get the next page before you delete or change the items on this one. (optional)
   * @return ApiResponse&lt;WebhookList&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhooks for a template and event </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown event type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<WebhookList> listWebhooksWithHttpInfo(@javax.annotation.Nullable WebhookEventType eventType, @javax.annotation.Nullable WebhookMode mode, @javax.annotation.Nullable String templateId, @javax.annotation.Nullable String folderId, @javax.annotation.Nullable String apiTokenId, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String cursor) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "event_type", eventType)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "mode", mode));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "template_id", templateId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "folder_id", folderId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_token_id", apiTokenId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursor", cursor));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<WebhookList> localVarReturnType = new GenericType<WebhookList>() {};
    return apiClient.invokeAPI("Client.listWebhooks", "/webhooks", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move a folder
   * Moves a folder into another folder, or to the root with &#x60;parent_folder_id: null&#x60;. Its templates and folders move with it. A folder can&#39;t move into itself or one of its own folders. 
   * @param folderId The folder&#39;s ID. (required)
   * @param body Where to move the folder. (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder moved into another folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid move </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Folder moveFolder(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull MoveFolderRequest body) throws ApiException {
    return moveFolderWithHttpInfo(folderId, body).getData();
  }

  /**
   * Move a folder
   * Moves a folder into another folder, or to the root with &#x60;parent_folder_id: null&#x60;. Its templates and folders move with it. A folder can&#39;t move into itself or one of its own folders. 
   * @param folderId The folder&#39;s ID. (required)
   * @param body Where to move the folder. (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder moved into another folder </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid move </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Folder> moveFolderWithHttpInfo(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull MoveFolderRequest body) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling moveFolder");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling moveFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}/move"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.moveFolder", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move a template to a folder
   * Moves a template and all of its published versions to a folder, or to the root (&#x60;null&#x60;).
   * @param templateId The template&#39;s ID. (required)
   * @param body Where to move the template. (required)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template moved </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid move </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template moveTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull MoveTemplateRequest body) throws ApiException {
    return moveTemplateWithHttpInfo(templateId, body).getData();
  }

  /**
   * Move a template to a folder
   * Moves a template and all of its published versions to a folder, or to the root (&#x60;null&#x60;).
   * @param templateId The template&#39;s ID. (required)
   * @param body Where to move the template. (required)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template moved </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid move </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> moveTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull MoveTemplateRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling moveTemplate");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling moveTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/move"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.moveTemplate", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Publish a template version
   * Publishes the template&#39;s draft as a new version that doesn&#39;t change. &#x60;version_type&#x60; says which part of the latest version number goes up. While the template&#39;s PDF is downloading or being processed, or DocSpring is setting up its fields, it returns a 409 that says so. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The version to publish. (required)
   * @return TemplateVersion
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> version published </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version type </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> no changes to publish </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public TemplateVersion publishTemplateVersion(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull PublishTemplateVersionRequest body) throws ApiException {
    return publishTemplateVersionWithHttpInfo(templateId, body).getData();
  }

  /**
   * Publish a template version
   * Publishes the template&#39;s draft as a new version that doesn&#39;t change. &#x60;version_type&#x60; says which part of the latest version number goes up. While the template&#39;s PDF is downloading or being processed, or DocSpring is setting up its fields, it returns a 409 that says so. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The version to publish. (required)
   * @return ApiResponse&lt;TemplateVersion&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> version published </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version type </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> no changes to publish </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<TemplateVersion> publishTemplateVersionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull PublishTemplateVersionRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling publishTemplateVersion");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling publishTemplateVersion");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/publish_version"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateVersion> localVarReturnType = new GenericType<TemplateVersion>() {};
    return apiClient.invokeAPI("Client.publishTemplateVersion", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Remove fields from a template
   * Removes fields from a template&#39;s draft and returns the fields that are left. Conditional logic that used only the removed fields is removed too. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to remove from the template&#39;s draft. (required)
   * @return TemplateFields
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields removed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> a field the template does not have </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Remove fields from a template Documentation</a>
   */
  public TemplateFields removeTemplateFields(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RemoveTemplateFieldsRequest body) throws ApiException {
    return removeTemplateFieldsWithHttpInfo(templateId, body).getData();
  }

  /**
   * Remove fields from a template
   * Removes fields from a template&#39;s draft and returns the fields that are left. Conditional logic that used only the removed fields is removed too. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to remove from the template&#39;s draft. (required)
   * @return ApiResponse&lt;TemplateFields&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields removed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> a field the template does not have </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Remove fields from a template Documentation</a>
   */
  public ApiResponse<TemplateFields> removeTemplateFieldsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RemoveTemplateFieldsRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling removeTemplateFields");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling removeTemplateFields");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/fields/remove"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateFields> localVarReturnType = new GenericType<TemplateFields>() {};
    return apiClient.invokeAPI("Client.removeTemplateFields", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename a folder
   * Renames a folder. The name must be unique within its parent folder. 
   * @param folderId The folder&#39;s ID. (required)
   * @param body The folder&#39;s new name. (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder renamed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> name already exists </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Folder renameFolder(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull RenameFolderRequest body) throws ApiException {
    return renameFolderWithHttpInfo(folderId, body).getData();
  }

  /**
   * Rename a folder
   * Renames a folder. The name must be unique within its parent folder. 
   * @param folderId The folder&#39;s ID. (required)
   * @param body The folder&#39;s new name. (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> folder renamed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> name already exists </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Folder> renameFolderWithHttpInfo(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull RenameFolderRequest body) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling renameFolder");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling renameFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}/rename"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.renameFolder", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Reorder a template&#39;s fields
   * Changes the order of the fields in a template&#39;s draft and returns them in their new order. Send every field&#39;s ID: each field stays on its page, and a page&#39;s fields are printed in this order, so a later field prints over an earlier one where they overlap. Their values are in this order in the template&#39;s data schema and forms. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The new order of the fields in the template&#39;s draft. (required)
   * @return TemplateFields
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields reordered </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> a field missing from the order </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Reorder a template&#39;s fields Documentation</a>
   */
  public TemplateFields reorderTemplateFields(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ReorderTemplateFieldsRequest body) throws ApiException {
    return reorderTemplateFieldsWithHttpInfo(templateId, body).getData();
  }

  /**
   * Reorder a template&#39;s fields
   * Changes the order of the fields in a template&#39;s draft and returns them in their new order. Send every field&#39;s ID: each field stays on its page, and a page&#39;s fields are printed in this order, so a later field prints over an earlier one where they overlap. Their values are in this order in the template&#39;s data schema and forms. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The new order of the fields in the template&#39;s draft. (required)
   * @return ApiResponse&lt;TemplateFields&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields reordered </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> a field missing from the order </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Reorder a template&#39;s fields Documentation</a>
   */
  public ApiResponse<TemplateFields> reorderTemplateFieldsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ReorderTemplateFieldsRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling reorderTemplateFields");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling reorderTemplateFields");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/fields/reorder"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateFields> localVarReturnType = new GenericType<TemplateFields>() {};
    return apiClient.invokeAPI("Client.reorderTemplateFields", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Restore a template version
   * Replaces the template&#39;s draft with a copy of one of its published versions.
   * @param templateId The template&#39;s ID. (required)
   * @param body The version to restore. (required)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version restored </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown version </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template restoreTemplateVersion(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RestoreTemplateVersionRequest body) throws ApiException {
    return restoreTemplateVersionWithHttpInfo(templateId, body).getData();
  }

  /**
   * Restore a template version
   * Replaces the template&#39;s draft with a copy of one of its published versions.
   * @param templateId The template&#39;s ID. (required)
   * @param body The version to restore. (required)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version restored </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown version </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> restoreTemplateVersionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RestoreTemplateVersionRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling restoreTemplateVersion");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling restoreTemplateVersion");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/restore_version"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.restoreTemplateVersion", localVarPath, "POST", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test authentication
   * Checks whether your API token is valid by making an authenticated request. This endpoint is useful for verifying credentials during setup or troubleshooting issues. 
   * @return AuthenticationCheck
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn how to authenticate with the DocSpring API
   * @see <a href="https://docspring.com/docs/api-guide/authentication/">Test authentication Documentation</a>
   */
  public AuthenticationCheck testAuthentication() throws ApiException {
    return testAuthenticationWithHttpInfo().getData();
  }

  /**
   * Test authentication
   * Checks whether your API token is valid by making an authenticated request. This endpoint is useful for verifying credentials during setup or troubleshooting issues. 
   * @return ApiResponse&lt;AuthenticationCheck&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Learn how to authenticate with the DocSpring API
   * @see <a href="https://docspring.com/docs/api-guide/authentication/">Test authentication Documentation</a>
   */
  public ApiResponse<AuthenticationCheck> testAuthenticationWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<AuthenticationCheck> localVarReturnType = new GenericType<AuthenticationCheck>() {};
    return apiClient.invokeAPI("Client.testAuthentication", "/authentication", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a signature request
   * Changes a pending signature request&#39;s metadata, or how your app authenticated the person (for the audit trail). Once the person has opened it, only its metadata can be changed, and a completed or declined signature request can&#39;t be changed. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return SignatureRequest
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> signature request updated </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request completed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SignatureRequest updateSignatureRequest(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nonnull UpdateSignatureRequestRequest body) throws ApiException {
    return updateSignatureRequestWithHttpInfo(signatureRequestId, body).getData();
  }

  /**
   * Update a signature request
   * Changes a pending signature request&#39;s metadata, or how your app authenticated the person (for the audit trail). Once the person has opened it, only its metadata can be changed, and a completed or declined signature request can&#39;t be changed. 
   * @param signatureRequestId The signature request&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return ApiResponse&lt;SignatureRequest&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> signature request updated </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> signature request completed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> signature request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SignatureRequest> updateSignatureRequestWithHttpInfo(@javax.annotation.Nonnull String signatureRequestId, @javax.annotation.Nonnull UpdateSignatureRequestRequest body) throws ApiException {
    // Check required parameters
    if (signatureRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'signatureRequestId' when calling updateSignatureRequest");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateSignatureRequest");
    }

    // Path parameters
    String localVarPath = "/signature_requests/{signature_request_id}"
            .replaceAll("\\{signature_request_id}", apiClient.escapeString(signatureRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SignatureRequest> localVarReturnType = new GenericType<SignatureRequest>() {};
    return apiClient.invokeAPI("Client.updateSignatureRequest", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a template
   * Changes a template&#39;s draft. Properties left out keep their values. &#x60;defaults&#x60; and &#x60;html_engine_options&#x60; replace the whole object, and &#x60;field_groups&#x60; changes only the groups it lists. Setting &#x60;parent_folder_id&#x60; moves the template and all of its published versions. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template updated </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid field group changes </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Template updateTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateRequest body) throws ApiException {
    return updateTemplateWithHttpInfo(templateId, body).getData();
  }

  /**
   * Update a template
   * Changes a template&#39;s draft. Properties left out keep their values. &#x60;defaults&#x60; and &#x60;html_engine_options&#x60; replace the whole object, and &#x60;field_groups&#x60; changes only the groups it lists. Setting &#x60;parent_folder_id&#x60; moves the template and all of its published versions. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template updated </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid field group changes </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Template> updateTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplate");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.updateTemplate", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Replace a template&#39;s PDF
   * Replaces a PDF template&#39;s PDF with one you uploaded with the presigned upload (GET /uploads/presign) (&#x60;cache_id&#x60;), a link to download it from (&#x60;document_url&#x60;), or the file in base64 (&#x60;document_base64&#x60;). The fields stay where they are, unless &#x60;reimport_fields&#x60; replaces them with the new PDF&#39;s fillable fields. To send the PDF as &#x60;multipart/form-data&#x60; instead, use PUT /templates/{template_id}/document/upload. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The new PDF, as one of &#x60;cache_id&#x60;, &#x60;document_url&#x60; and &#x60;document_base64&#x60;. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF replaced </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked, so its fields can&#39;t be re-imported </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> no document, or more than one </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Template updateTemplateDocument(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateDocumentRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    return updateTemplateDocumentWithHttpInfo(templateId, body, wait).getData();
  }

  /**
   * Replace a template&#39;s PDF
   * Replaces a PDF template&#39;s PDF with one you uploaded with the presigned upload (GET /uploads/presign) (&#x60;cache_id&#x60;), a link to download it from (&#x60;document_url&#x60;), or the file in base64 (&#x60;document_base64&#x60;). The fields stay where they are, unless &#x60;reimport_fields&#x60; replaces them with the new PDF&#39;s fillable fields. To send the PDF as &#x60;multipart/form-data&#x60; instead, use PUT /templates/{template_id}/document/upload. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The new PDF, as one of &#x60;cache_id&#x60;, &#x60;document_url&#x60; and &#x60;document_base64&#x60;. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF replaced </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> template is locked, so its fields can&#39;t be re-imported </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> no document, or more than one </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Template> updateTemplateDocumentWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateDocumentRequest body, @javax.annotation.Nullable Boolean wait) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplateDocument");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateTemplateDocument");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/document"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.updateTemplateDocument", localVarPath, "PUT", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a template&#39;s fields
   * Changes fields of a template&#39;s draft and returns all of its fields. Settings left out keep their values. A shared setting (&#x60;type&#x60;, &#x60;required&#x60;, &#x60;default&#x60;, ...) changes for every field with the same name. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to change in the template&#39;s draft. (required)
   * @return TemplateFields
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields updated </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid changes </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Update a template&#39;s fields Documentation</a>
   */
  public TemplateFields updateTemplateFields(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateFieldsRequest body) throws ApiException {
    return updateTemplateFieldsWithHttpInfo(templateId, body).getData();
  }

  /**
   * Update a template&#39;s fields
   * Changes fields of a template&#39;s draft and returns all of its fields. Settings left out keep their values. A shared setting (&#x60;type&#x60;, &#x60;required&#x60;, &#x60;default&#x60;, ...) changes for every field with the same name. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The fields to change in the template&#39;s draft. (required)
   * @return ApiResponse&lt;TemplateFields&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> fields updated </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid changes </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   * Create a PDF template and add fields with the API
   * @see <a href="https://docspring.com/docs/api-guide/create-pdf-templates/">Update a template&#39;s fields Documentation</a>
   */
  public ApiResponse<TemplateFields> updateTemplateFieldsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateTemplateFieldsRequest body) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplateFields");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateTemplateFields");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/fields"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateFields> localVarReturnType = new GenericType<TemplateFields>() {};
    return apiClient.invokeAPI("Client.updateTemplateFields", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a webhook
   * Updates a webhook. Only the properties you send change.
   * @param webhookId The webhook&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid webhook </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public Webhook updateWebhook(@javax.annotation.Nonnull String webhookId, @javax.annotation.Nonnull UpdateWebhookRequest body) throws ApiException {
    return updateWebhookWithHttpInfo(webhookId, body).getData();
  }

  /**
   * Update a webhook
   * Updates a webhook. Only the properties you send change.
   * @param webhookId The webhook&#39;s ID. (required)
   * @param body The settings to change. Properties left out keep their values. (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid webhook </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> updateWebhookWithHttpInfo(@javax.annotation.Nonnull String webhookId, @javax.annotation.Nonnull UpdateWebhookRequest body) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling updateWebhook");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateWebhook");
    }

    // Path parameters
    String localVarPath = "/webhooks/{webhook_id}"
            .replaceAll("\\{webhook_id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.updateWebhook", localVarPath, "PUT", new ArrayList<>(), body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a PDF template from an uploaded PDF
   * Creates a PDF template from a PDF sent with the request (&#x60;multipart/form-data&#x60;). For large files, upload the PDF with the presigned upload (GET /uploads/presign) and create the template with POST /templates. 
   * @param document The PDF. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @param name The template&#39;s name. (optional)
   * @param description The template&#39;s description. (optional)
   * @param parentFolderId The folder to put the template in. Left out, it&#39;s created at the root. (optional)
   * @param aiFieldNamingLanguage The language AI field setup names fields in: &#x60;auto&#x60; uses the form&#39;s language when it&#39;s written in the Latin alphabet without accents, and English otherwise; &#x60;english&#x60; always uses English; &#x60;form_language&#x60; uses the form&#39;s language and script. Default: your account&#39;s template settings. (optional)
   * @param detectFields Set up the PDF&#39;s fields as DocSpring&#39;s \\\&quot;Automatically detect fields\\\&quot; upload option does: import or detect the fields, name them with AI, and set up conditional logic. &#x60;field_source&#x60;, &#x60;field_naming&#x60; and &#x60;field_logic&#x60; choose how. Default false. &#x60;document.page_processing_statuses&#x60; and &#x60;document.field_logic_status&#x60; show how it&#39;s going, and &#x60;document.state&#x60; becomes &#x60;processed&#x60; once every page&#39;s fields are set up. (optional)
   * @param fieldSource With &#x60;detect_fields&#x60;, where the fields come from. &#x60;auto&#x60; (the default) imports the form fields of a fillable PDF and detects the fields of a PDF without them; &#x60;pdf_detection&#x60; detects the fields from the page layout, even on a fillable PDF; &#x60;pdf_form_fields&#x60; only imports the PDF&#39;s form fields. (optional)
   * @param fieldNaming With &#x60;detect_fields&#x60;, how the fields are named. &#x60;ai&#x60; (the default) names them and sets their types and settings with AI; &#x60;preserve&#x60; keeps the names of the PDF&#39;s form fields, and AI only names the fields it detected. &#x60;preserve&#x60; needs &#x60;field_source&#x60; &#x60;auto&#x60; or &#x60;pdf_form_fields&#x60;. (optional)
   * @param fieldLogic With &#x60;detect_fields&#x60;, whether AI reads the whole form once the fields are named and sets up conditional logic and required fields (&#x60;ai&#x60;) or not (&#x60;none&#x60;). Default: your account&#39;s template settings. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> PDF template created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid upload </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Template uploadTemplate(@javax.annotation.Nonnull File document, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String name, @javax.annotation.Nullable String description, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable AiFieldNamingLanguage aiFieldNamingLanguage, @javax.annotation.Nullable Boolean detectFields, @javax.annotation.Nullable FieldSetupSource fieldSource, @javax.annotation.Nullable FieldSetupNaming fieldNaming, @javax.annotation.Nullable FieldSetupLogic fieldLogic) throws ApiException {
    return uploadTemplateWithHttpInfo(document, wait, name, description, parentFolderId, aiFieldNamingLanguage, detectFields, fieldSource, fieldNaming, fieldLogic).getData();
  }

  /**
   * Create a PDF template from an uploaded PDF
   * Creates a PDF template from a PDF sent with the request (&#x60;multipart/form-data&#x60;). For large files, upload the PDF with the presigned upload (GET /uploads/presign) and create the template with POST /templates. 
   * @param document The PDF. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @param name The template&#39;s name. (optional)
   * @param description The template&#39;s description. (optional)
   * @param parentFolderId The folder to put the template in. Left out, it&#39;s created at the root. (optional)
   * @param aiFieldNamingLanguage The language AI field setup names fields in: &#x60;auto&#x60; uses the form&#39;s language when it&#39;s written in the Latin alphabet without accents, and English otherwise; &#x60;english&#x60; always uses English; &#x60;form_language&#x60; uses the form&#39;s language and script. Default: your account&#39;s template settings. (optional)
   * @param detectFields Set up the PDF&#39;s fields as DocSpring&#39;s \\\&quot;Automatically detect fields\\\&quot; upload option does: import or detect the fields, name them with AI, and set up conditional logic. &#x60;field_source&#x60;, &#x60;field_naming&#x60; and &#x60;field_logic&#x60; choose how. Default false. &#x60;document.page_processing_statuses&#x60; and &#x60;document.field_logic_status&#x60; show how it&#39;s going, and &#x60;document.state&#x60; becomes &#x60;processed&#x60; once every page&#39;s fields are set up. (optional)
   * @param fieldSource With &#x60;detect_fields&#x60;, where the fields come from. &#x60;auto&#x60; (the default) imports the form fields of a fillable PDF and detects the fields of a PDF without them; &#x60;pdf_detection&#x60; detects the fields from the page layout, even on a fillable PDF; &#x60;pdf_form_fields&#x60; only imports the PDF&#39;s form fields. (optional)
   * @param fieldNaming With &#x60;detect_fields&#x60;, how the fields are named. &#x60;ai&#x60; (the default) names them and sets their types and settings with AI; &#x60;preserve&#x60; keeps the names of the PDF&#39;s form fields, and AI only names the fields it detected. &#x60;preserve&#x60; needs &#x60;field_source&#x60; &#x60;auto&#x60; or &#x60;pdf_form_fields&#x60;. (optional)
   * @param fieldLogic With &#x60;detect_fields&#x60;, whether AI reads the whole form once the fields are named and sets up conditional logic and required fields (&#x60;ai&#x60;) or not (&#x60;none&#x60;). Default: your account&#39;s template settings. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> PDF template created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid upload </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Template> uploadTemplateWithHttpInfo(@javax.annotation.Nonnull File document, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String name, @javax.annotation.Nullable String description, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable AiFieldNamingLanguage aiFieldNamingLanguage, @javax.annotation.Nullable Boolean detectFields, @javax.annotation.Nullable FieldSetupSource fieldSource, @javax.annotation.Nullable FieldSetupNaming fieldNaming, @javax.annotation.Nullable FieldSetupLogic fieldLogic) throws ApiException {
    // Check required parameters
    if (document == null) {
      throw new ApiException(400, "Missing the required parameter 'document' when calling uploadTemplate");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("document", document);
    if (name != null) {
      localVarFormParams.put("name", name);
    }
    if (description != null) {
      localVarFormParams.put("description", description);
    }
    if (parentFolderId != null) {
      localVarFormParams.put("parent_folder_id", parentFolderId);
    }
    if (aiFieldNamingLanguage != null) {
      localVarFormParams.put("ai_field_naming_language", aiFieldNamingLanguage);
    }
    if (detectFields != null) {
      localVarFormParams.put("detect_fields", detectFields);
    }
    if (fieldSource != null) {
      localVarFormParams.put("field_source", fieldSource);
    }
    if (fieldNaming != null) {
      localVarFormParams.put("field_naming", fieldNaming);
    }
    if (fieldLogic != null) {
      localVarFormParams.put("field_logic", fieldLogic);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.uploadTemplate", "/templates/upload", "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Replace a template&#39;s PDF with an uploaded PDF
   * Replaces a PDF template&#39;s PDF with one sent with the request (&#x60;multipart/form-data&#x60;). The fields stay where they are, unless &#x60;reimport_fields&#x60; replaces them with the new PDF&#39;s fillable fields. 
   * @param templateId The template&#39;s ID. (required)
   * @param document The new PDF. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @param reimportFields Replace all of the template&#39;s fields with the fillable fields in the new PDF, once DocSpring has processed it (&#x60;document.field_reimport_state&#x60;). As on a first upload, the default typeface, font size, bold and color are taken from the PDF&#39;s fields; the template&#39;s other settings are kept. If the PDF has no fillable fields, the template keeps its fields. A locked template can&#39;t re-import its fields. (optional)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF replaced </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> not a PDF template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public Template uploadTemplateDocument(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull File document, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable Boolean reimportFields) throws ApiException {
    return uploadTemplateDocumentWithHttpInfo(templateId, document, wait, reimportFields).getData();
  }

  /**
   * Replace a template&#39;s PDF with an uploaded PDF
   * Replaces a PDF template&#39;s PDF with one sent with the request (&#x60;multipart/form-data&#x60;). The fields stay where they are, unless &#x60;reimport_fields&#x60; replaces them with the new PDF&#39;s fillable fields. 
   * @param templateId The template&#39;s ID. (required)
   * @param document The new PDF. (required)
   * @param wait Wait until the PDF has been processed, and a &#x60;document_url&#x60; downloaded, before responding. Default true on sync.api hosts. (optional)
   * @param reimportFields Replace all of the template&#39;s fields with the fillable fields in the new PDF, once DocSpring has processed it (&#x60;document.field_reimport_state&#x60;). As on a first upload, the default typeface, font size, bold and color are taken from the PDF&#39;s fields; the template&#39;s other settings are kept. If the PDF has no fillable fields, the template keeps its fields. A locked template can&#39;t re-import its fields. (optional)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> PDF replaced </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> not a PDF template </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
       <tr><td> 504 </td><td> On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error&#39;s template_id instead of sending the request again. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Template> uploadTemplateDocumentWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull File document, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable Boolean reimportFields) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling uploadTemplateDocument");
    }
    if (document == null) {
      throw new ApiException(400, "Missing the required parameter 'document' when calling uploadTemplateDocument");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/document/upload"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("document", document);
    if (reimportFields != null) {
      localVarFormParams.put("reimport_fields", reimportFields);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.uploadTemplateDocument", localVarPath, "PUT", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check a submission without creating it
   * Checks a submission as creating it would (its data against the template&#39;s fields, its settings and signature requests) without saving it, generating anything or using credits. It doesn&#39;t check your account&#39;s credits. The response says whether the submission is valid, and if not, has the error that creating it would return. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The submission&#39;s data and settings. (required)
   * @param version The template version to use: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published). (optional)
   * @return SubmissionValidation
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> valid submission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public SubmissionValidation validateSubmission(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ValidateSubmissionRequest body, @javax.annotation.Nullable String version) throws ApiException {
    return validateSubmissionWithHttpInfo(templateId, body, version).getData();
  }

  /**
   * Check a submission without creating it
   * Checks a submission as creating it would (its data against the template&#39;s fields, its settings and signature requests) without saving it, generating anything or using credits. It doesn&#39;t check your account&#39;s credits. The response says whether the submission is valid, and if not, has the error that creating it would return. 
   * @param templateId The template&#39;s ID. (required)
   * @param body The submission&#39;s data and settings. (required)
   * @param version The template version to use: a published version (&#x60;1.2.0&#x60;, or &#x60;1&#x60; for the latest 1.x.x), &#x60;latest&#x60; or &#x60;draft&#x60;. Default &#x60;latest&#x60; (the draft when no version has been published). (optional)
   * @return ApiResponse&lt;SubmissionValidation&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> valid submission </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 429 </td><td> Too many requests: wait the number of seconds in the Retry-After header, then send the request again. </td><td>  * Retry-After - Seconds until you can send the request again. <br>  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionValidation> validateSubmissionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull ValidateSubmissionRequest body, @javax.annotation.Nullable String version) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling validateSubmission");
    }
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling validateSubmission");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions/validate"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "version", version)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionValidation> localVarReturnType = new GenericType<SubmissionValidation>() {};
    return apiClient.invokeAPI("Client.validateSubmission", localVarPath, "POST", localVarQueryParams, body,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
