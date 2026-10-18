package com.docspring;

import com.docspring.ApiException;
import com.docspring.ApiClient;
import com.docspring.ApiResponse;
import com.docspring.Configuration;
import com.docspring.Pair;

import javax.ws.rs.core.GenericType;

import com.docspring.AddFieldsData;
import com.docspring.BatchGeneratePdfs201Response;
import com.docspring.CombinePdfsData;
import com.docspring.CombinedSubmission;
import com.docspring.CopyTemplateOptions;
import com.docspring.CreateCombinedSubmissionResponse;
import com.docspring.CreateCustomFileData;
import com.docspring.CreateCustomFileResponse;
import com.docspring.CreateFolderData;
import com.docspring.CreateHtmlTemplate;
import com.docspring.CreatePdfSubmissionData;
import com.docspring.CreatePdfTemplate;
import com.docspring.CreateSubmissionDataRequestEventRequest;
import com.docspring.CreateSubmissionDataRequestEventResponse;
import com.docspring.CreateSubmissionDataRequestResponse;
import com.docspring.CreateSubmissionDataRequestTokenResponse;
import com.docspring.CreateSubmissionResponse;
import com.docspring.CreateWebhookData;
import com.docspring.ErrorOrMultipleErrorsResponse;
import com.docspring.ErrorResponse;
import java.io.File;
import com.docspring.Folder;
import com.docspring.ForbiddenErrorResponse;
import com.docspring.JsonSchema;
import com.docspring.ListSubmissionsResponse;
import com.docspring.MoveFolderData;
import com.docspring.MoveTemplateData;
import com.docspring.MultipleErrorsResponse;
import com.docspring.PublishVersionData;
import com.docspring.RenameFolderData;
import com.docspring.RestoreVersionData;
import com.docspring.Submission;
import com.docspring.Submission422Response;
import com.docspring.SubmissionBatchData;
import com.docspring.SubmissionBatchWithSubmissions;
import com.docspring.SubmissionDataRequestShow;
import com.docspring.SubmissionPreview;
import com.docspring.SuccessErrorResponse;
import com.docspring.SuccessMultipleErrorsResponse;
import com.docspring.Template;
import com.docspring.TemplateAddFieldsResponse;
import com.docspring.TemplateDeleteResponse;
import com.docspring.TemplateModelCodeResponse;
import com.docspring.TemplatePreview;
import com.docspring.TemplatePublishVersionResponse;
import com.docspring.UpdateHtmlTemplate;
import com.docspring.UpdatePdfTemplate;
import com.docspring.UpdateSubmissionDataRequestData;
import com.docspring.UpdateWebhookData;
import com.docspring.UploadPresignResponse;
import com.docspring.Webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.16.0-DOCSPRING")
public class Client {
  private ApiClient apiClient;

  private static final String DEFAULT_BASE_PATH = "https://sync.api.docspring.com/api/v1";

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
    String tokenId = apiTokenId != null ? apiTokenId : System.getenv("DOCSPRING_TOKEN_ID");
    String tokenSecret = apiTokenSecret != null ? apiTokenSecret : System.getenv("DOCSPRING_TOKEN_SECRET");
    com.docspring.auth.HttpBasicAuth auth =
        (com.docspring.auth.HttpBasicAuth) apiClient.getAuthentication("api_token_basic");
    // Credentials set on the ApiClient beforehand win
    if (tokenId != null && tokenSecret != null && auth.getUsername() == null && auth.getPassword() == null) {
      apiClient.setUsername(tokenId);
      apiClient.setPassword(tokenSecret);
    }

    String baseUrl = resolveBaseUrl(host, region);
    // A base path set on the ApiClient beforehand wins
    if (baseUrl != null && DEFAULT_BASE_PATH.equals(apiClient.getBasePath())) {
      apiClient.setBasePath(baseUrl);
    }
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
    if (!url.matches("(?i).*/api/v1$")) {
      url = url + "/api/v1";
    }
    return url;
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
   * Add new fields to a Template
   * Adds fields to a PDF template. Configure field types, positions, defaults, and formatting options. 
   * @param templateId  (required)
   * @param data  (required)
   * @return TemplateAddFieldsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> add fields success </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> add fields error </td><td>  -  </td></tr>
     </table>
   * View the field schema to see all available properties and types
   * @see <a href="https://docspring.com/docs/reference/field-schema/">Add new fields to a Template Documentation</a>
   */
  public TemplateAddFieldsResponse addFieldsToTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull AddFieldsData data) throws ApiException {
    return addFieldsToTemplateWithHttpInfo(templateId, data).getData();
  }

  /**
   * Add new fields to a Template
   * Adds fields to a PDF template. Configure field types, positions, defaults, and formatting options. 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;TemplateAddFieldsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> add fields success </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> add fields error </td><td>  -  </td></tr>
     </table>
   * View the field schema to see all available properties and types
   * @see <a href="https://docspring.com/docs/reference/field-schema/">Add new fields to a Template Documentation</a>
   */
  public ApiResponse<TemplateAddFieldsResponse> addFieldsToTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull AddFieldsData data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling addFieldsToTemplate");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling addFieldsToTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/add_fields"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateAddFieldsResponse> localVarReturnType = new GenericType<TemplateAddFieldsResponse>() {};
    return apiClient.invokeAPI("Client.addFieldsToTemplate", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate multiple PDFs
   * Generates up to 50 PDFs in a single request. Each submission can use a different template and data. Supports both synchronous (wait for all PDFs) and asynchronous processing. More efficient than individual requests when creating multiple PDFs.  Live PDFs use credits. If any live submission is waiting for credits, the API returns 402 and the others are still processed: check each submission&#39;s &#x60;state&#x60;. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).  See also: - [Batch Generate PDFs](https://docspring.com/docs/api-guide/generate-pdfs/batch-generate-pdfs/) - Request format, responses, and limits 
   * @param data  (required)
   * @param wait Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return BatchGeneratePdfs201Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> account suspended </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> submissions created </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> some PDFs with invalid data </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> array of arrays </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
     </table>
   * Learn more about generating multiple PDFs in batches
   * @see <a href="https://docspring.com/docs/api-guide/generate-pdfs/batch-generate-pdfs/">Generate multiple PDFs Documentation</a>
   */
  public BatchGeneratePdfs201Response batchGeneratePdfs(@javax.annotation.Nonnull SubmissionBatchData data, @javax.annotation.Nullable Boolean wait) throws ApiException {
    return batchGeneratePdfsWithHttpInfo(data, wait).getData();
  }

  /**
   * Generate multiple PDFs
   * Generates up to 50 PDFs in a single request. Each submission can use a different template and data. Supports both synchronous (wait for all PDFs) and asynchronous processing. More efficient than individual requests when creating multiple PDFs.  Live PDFs use credits. If any live submission is waiting for credits, the API returns 402 and the others are still processed: check each submission&#39;s &#x60;state&#x60;. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).  See also: - [Batch Generate PDFs](https://docspring.com/docs/api-guide/generate-pdfs/batch-generate-pdfs/) - Request format, responses, and limits 
   * @param data  (required)
   * @param wait Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;BatchGeneratePdfs201Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> account suspended </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> submissions created </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> some PDFs with invalid data </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> array of arrays </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
     </table>
   * Learn more about generating multiple PDFs in batches
   * @see <a href="https://docspring.com/docs/api-guide/generate-pdfs/batch-generate-pdfs/">Generate multiple PDFs Documentation</a>
   */
  public ApiResponse<BatchGeneratePdfs201Response> batchGeneratePdfsWithHttpInfo(@javax.annotation.Nonnull SubmissionBatchData data, @javax.annotation.Nullable Boolean wait) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling batchGeneratePdfs");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<BatchGeneratePdfs201Response> localVarReturnType = new GenericType<BatchGeneratePdfs201Response>() {};
    return apiClient.invokeAPI("Client.batchGeneratePdfs", "/submissions/batches", "POST", localVarQueryParams, data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Merge submission PDFs, template PDFs, or custom files
   * Combines multiple PDFs from various sources into a single PDF file. Supports merging submission PDFs, template PDFs, custom files, other merged PDFs, and PDFs from URLs. Merges the PDFs in the order provided.  Combining uses credits (4 per source PDF, plus 4 per unit of the combined PDF), even with a test API token or watermarked source PDFs. If your balance can&#39;t cover it, the API returns 402 and the combined submission waits in the &#x60;insufficient_credits&#x60; state until you add credits. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/). 
   * @param data  (required)
   * @return CreateCombinedSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used to delete custom files </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Merge submission PDFs, template PDFs, or custom files Documentation</a>
   */
  public CreateCombinedSubmissionResponse combinePdfs(@javax.annotation.Nonnull CombinePdfsData data) throws ApiException {
    return combinePdfsWithHttpInfo(data).getData();
  }

  /**
   * Merge submission PDFs, template PDFs, or custom files
   * Combines multiple PDFs from various sources into a single PDF file. Supports merging submission PDFs, template PDFs, custom files, other merged PDFs, and PDFs from URLs. Merges the PDFs in the order provided.  Combining uses credits (4 per source PDF, plus 4 per unit of the combined PDF), even with a test API token or watermarked source PDFs. If your balance can&#39;t cover it, the API returns 402 and the combined submission waits in the &#x60;insufficient_credits&#x60; state until you add credits. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/). 
   * @param data  (required)
   * @return ApiResponse&lt;CreateCombinedSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used to delete custom files </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Merge submission PDFs, template PDFs, or custom files Documentation</a>
   */
  public ApiResponse<CreateCombinedSubmissionResponse> combinePdfsWithHttpInfo(@javax.annotation.Nonnull CombinePdfsData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling combinePdfs");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateCombinedSubmissionResponse> localVarReturnType = new GenericType<CreateCombinedSubmissionResponse>() {};
    return apiClient.invokeAPI("Client.combinePdfs", "/combined_submissions", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Copy a template
   * Creates a copy of an existing template with all its fields and configuration. Optionally specify a new name and target folder. The copied template starts as a new draft that can be modified independently of the original. 
   * @param templateId  (required)
   * @param options  (optional)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> copy template success </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview copyTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable CopyTemplateOptions options) throws ApiException {
    return copyTemplateWithHttpInfo(templateId, options).getData();
  }

  /**
   * Copy a template
   * Creates a copy of an existing template with all its fields and configuration. Optionally specify a new name and target folder. The copied template starts as a new draft that can be modified independently of the original. 
   * @param templateId  (required)
   * @param options  (optional)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> copy template success </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> copyTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable CopyTemplateOptions options) throws ApiException {
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
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.copyTemplate", localVarPath, "POST", new ArrayList<>(), options,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new custom file from a cached S3 upload
   * The Custom Files API endpoint allows you to upload PDFs to DocSpring and then merge them with other PDFs. First upload your file using the presigned URL endpoint, then use the returned cache_id to create the custom file. 
   * @param data  (required)
   * @return CreateCustomFileResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns the custom file </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to merge custom files with other PDFs
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Create a new custom file from a cached S3 upload Documentation</a>
   */
  public CreateCustomFileResponse createCustomFileFromUpload(@javax.annotation.Nonnull CreateCustomFileData data) throws ApiException {
    return createCustomFileFromUploadWithHttpInfo(data).getData();
  }

  /**
   * Create a new custom file from a cached S3 upload
   * The Custom Files API endpoint allows you to upload PDFs to DocSpring and then merge them with other PDFs. First upload your file using the presigned URL endpoint, then use the returned cache_id to create the custom file. 
   * @param data  (required)
   * @return ApiResponse&lt;CreateCustomFileResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns the custom file </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to merge custom files with other PDFs
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Create a new custom file from a cached S3 upload Documentation</a>
   */
  public ApiResponse<CreateCustomFileResponse> createCustomFileFromUploadWithHttpInfo(@javax.annotation.Nonnull CreateCustomFileData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createCustomFileFromUpload");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateCustomFileResponse> localVarReturnType = new GenericType<CreateCustomFileResponse>() {};
    return apiClient.invokeAPI("Client.createCustomFileFromUpload", "/custom_files", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new event for emailing a signee a request for signature
   * Records user notification events for data requests. Use this to create an audit trail showing when and how users were notified about data request forms. Supports email, SMS, and other notification types. Records the notification time for compliance tracking.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - User notification workflow 
   * @param dataRequestId  (required)
   * @param event  (required)
   * @return CreateSubmissionDataRequestEventResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> event created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> message recipient must not be blank </td><td>  -  </td></tr>
     </table>
   * Track user notification events for audit trail logging
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#2-notify-the-user">Create a new event for emailing a signee a request for signature Documentation</a>
   */
  public CreateSubmissionDataRequestEventResponse createDataRequestEvent(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nonnull CreateSubmissionDataRequestEventRequest event) throws ApiException {
    return createDataRequestEventWithHttpInfo(dataRequestId, event).getData();
  }

  /**
   * Create a new event for emailing a signee a request for signature
   * Records user notification events for data requests. Use this to create an audit trail showing when and how users were notified about data request forms. Supports email, SMS, and other notification types. Records the notification time for compliance tracking.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - User notification workflow 
   * @param dataRequestId  (required)
   * @param event  (required)
   * @return ApiResponse&lt;CreateSubmissionDataRequestEventResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> event created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> message recipient must not be blank </td><td>  -  </td></tr>
     </table>
   * Track user notification events for audit trail logging
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#2-notify-the-user">Create a new event for emailing a signee a request for signature Documentation</a>
   */
  public ApiResponse<CreateSubmissionDataRequestEventResponse> createDataRequestEventWithHttpInfo(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nonnull CreateSubmissionDataRequestEventRequest event) throws ApiException {
    // Check required parameters
    if (dataRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'dataRequestId' when calling createDataRequestEvent");
    }
    if (event == null) {
      throw new ApiException(400, "Missing the required parameter 'event' when calling createDataRequestEvent");
    }

    // Path parameters
    String localVarPath = "/data_requests/{data_request_id}/events"
            .replaceAll("\\{data_request_id}", apiClient.escapeString(dataRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateSubmissionDataRequestEventResponse> localVarReturnType = new GenericType<CreateSubmissionDataRequestEventResponse>() {};
    return apiClient.invokeAPI("Client.createDataRequestEvent", localVarPath, "POST", new ArrayList<>(), event,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new data request token for form authentication
   * Creates an authentication token for accessing a data request form. Returns a token and a pre-authenticated URL for the data request form. The token remains valid until the data request is completed.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) 
   * @param dataRequestId  (required)
   * @param type  (optional)
   * @return CreateSubmissionDataRequestTokenResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> token created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
     </table>
   * Generate authentication tokens for embedded data requests
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#3-request-an-authentication-token">Create a new data request token for form authentication Documentation</a>
   */
  public CreateSubmissionDataRequestTokenResponse createDataRequestToken(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nullable String type) throws ApiException {
    return createDataRequestTokenWithHttpInfo(dataRequestId, type).getData();
  }

  /**
   * Create a new data request token for form authentication
   * Creates an authentication token for accessing a data request form. Returns a token and a pre-authenticated URL for the data request form. The token remains valid until the data request is completed.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) 
   * @param dataRequestId  (required)
   * @param type  (optional)
   * @return ApiResponse&lt;CreateSubmissionDataRequestTokenResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> token created </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
     </table>
   * Generate authentication tokens for embedded data requests
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#3-request-an-authentication-token">Create a new data request token for form authentication Documentation</a>
   */
  public ApiResponse<CreateSubmissionDataRequestTokenResponse> createDataRequestTokenWithHttpInfo(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nullable String type) throws ApiException {
    // Check required parameters
    if (dataRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'dataRequestId' when calling createDataRequestToken");
    }

    // Path parameters
    String localVarPath = "/data_requests/{data_request_id}/tokens"
            .replaceAll("\\{data_request_id}", apiClient.escapeString(dataRequestId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "type", type)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateSubmissionDataRequestTokenResponse> localVarReturnType = new GenericType<CreateSubmissionDataRequestTokenResponse>() {};
    return apiClient.invokeAPI("Client.createDataRequestToken", localVarPath, "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a folder
   * Creates a new folder for organizing templates. Folders can be nested within other folders by providing a &#x60;parent_folder_id&#x60;. Folder names must be unique within the same parent. 
   * @param data  (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 422 </td><td> name already exist </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> parent folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> folder created inside another folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Folder createFolder(@javax.annotation.Nonnull CreateFolderData data) throws ApiException {
    return createFolderWithHttpInfo(data).getData();
  }

  /**
   * Create a folder
   * Creates a new folder for organizing templates. Folders can be nested within other folders by providing a &#x60;parent_folder_id&#x60;. Folder names must be unique within the same parent. 
   * @param data  (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 422 </td><td> name already exist </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> parent folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> folder created inside another folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Folder> createFolderWithHttpInfo(@javax.annotation.Nonnull CreateFolderData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createFolder");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.createFolder", "/folders/", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new HTML template
   * Creates a new HTML template using HTML, CSS/SCSS, and Liquid templating. Allows complete control over PDF layout and styling. Supports headers, footers, and dynamic content using Liquid syntax for field values, conditions, loops, and filters. 
   * @param data  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a created template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn more about HTML/SCSS templates and Liquid templating
   * @see <a href="https://docspring.com/docs/html-templates/overview/">Create a new HTML template Documentation</a>
   */
  public TemplatePreview createHtmlTemplate(@javax.annotation.Nonnull CreateHtmlTemplate data) throws ApiException {
    return createHtmlTemplateWithHttpInfo(data).getData();
  }

  /**
   * Create a new HTML template
   * Creates a new HTML template using HTML, CSS/SCSS, and Liquid templating. Allows complete control over PDF layout and styling. Supports headers, footers, and dynamic content using Liquid syntax for field values, conditions, loops, and filters. 
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a created template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn more about HTML/SCSS templates and Liquid templating
   * @see <a href="https://docspring.com/docs/html-templates/overview/">Create a new HTML template Documentation</a>
   */
  public ApiResponse<TemplatePreview> createHtmlTemplateWithHttpInfo(@javax.annotation.Nonnull CreateHtmlTemplate data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createHtmlTemplate");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.createHtmlTemplate", "/templates?endpoint_variant=create_html_template", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new PDF template with a form POST file upload
   * Creates a new PDF template by uploading a PDF file. The uploaded PDF becomes the foundation for your template, and you can then add fillable fields using the template editor. Use the wait parameter to control whether the request waits for document processing to complete. 
   * @param templateDocument  (required)
   * @param templateName  (required)
   * @param wait Wait for template document to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @param templateDescription  (optional)
   * @param templateParentFolderId  (optional)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview createPdfTemplate(@javax.annotation.Nonnull File templateDocument, @javax.annotation.Nonnull String templateName, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String templateDescription, @javax.annotation.Nullable String templateParentFolderId) throws ApiException {
    return createPdfTemplateWithHttpInfo(templateDocument, templateName, wait, templateDescription, templateParentFolderId).getData();
  }

  /**
   * Create a new PDF template with a form POST file upload
   * Creates a new PDF template by uploading a PDF file. The uploaded PDF becomes the foundation for your template, and you can then add fillable fields using the template editor. Use the wait parameter to control whether the request waits for document processing to complete. 
   * @param templateDocument  (required)
   * @param templateName  (required)
   * @param wait Wait for template document to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @param templateDescription  (optional)
   * @param templateParentFolderId  (optional)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createPdfTemplateWithHttpInfo(@javax.annotation.Nonnull File templateDocument, @javax.annotation.Nonnull String templateName, @javax.annotation.Nullable Boolean wait, @javax.annotation.Nullable String templateDescription, @javax.annotation.Nullable String templateParentFolderId) throws ApiException {
    // Check required parameters
    if (templateDocument == null) {
      throw new ApiException(400, "Missing the required parameter 'templateDocument' when calling createPdfTemplate");
    }
    if (templateName == null) {
      throw new ApiException(400, "Missing the required parameter 'templateName' when calling createPdfTemplate");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("template[document]", templateDocument);
    localVarFormParams.put("template[name]", templateName);
    if (templateDescription != null) {
      localVarFormParams.put("template[description]", templateDescription);
    }
    if (templateParentFolderId != null) {
      localVarFormParams.put("template[parent_folder_id]", templateParentFolderId);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.createPdfTemplate", "/templates", "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new PDF template from a cached S3 file upload
   * Creates a new PDF template from a file previously uploaded to S3 using a presigned URL. This two-step process allows for more reliable large file uploads by first uploading the file to S3, then creating the template using the cached upload ID. 
   * @param data  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview createPdfTemplateFromUpload(@javax.annotation.Nonnull CreatePdfTemplate data) throws ApiException {
    return createPdfTemplateFromUploadWithHttpInfo(data).getData();
  }

  /**
   * Create a new PDF template from a cached S3 file upload
   * Creates a new PDF template from a file previously uploaded to S3 using a presigned URL. This two-step process allows for more reliable large file uploads by first uploading the file to S3, then creating the template using the cached upload ID. 
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> the plan&#39;s template limit is reached </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createPdfTemplateFromUploadWithHttpInfo(@javax.annotation.Nonnull CreatePdfTemplate data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createPdfTemplateFromUpload");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.createPdfTemplateFromUpload", "/templates?endpoint_variant=create_template_from_cached_upload", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a webhook
   * Creates a webhook that delivers a POST request to your endpoint whenever a subscribed event occurs. Optionally scope the webhook to specific API tokens, templates, or folders. 
   * @param data  (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> webhook created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Webhook createWebhook(@javax.annotation.Nonnull CreateWebhookData data) throws ApiException {
    return createWebhookWithHttpInfo(data).getData();
  }

  /**
   * Create a webhook
   * Creates a webhook that delivers a POST request to your endpoint whenever a subscribed event occurs. Optionally scope the webhook to specific API tokens, templates, or folders. 
   * @param data  (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> webhook created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid parameters </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> createWebhookWithHttpInfo(@javax.annotation.Nonnull CreateWebhookData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createWebhook");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.createWebhook", "/webhooks", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a folder
   * Deletes an empty folder. The folder must not contain any templates or subfolders. Move or delete all contents before attempting to delete the folder. 
   * @param folderId  (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> folder has contents </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> folder is empty </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Folder deleteFolder(@javax.annotation.Nonnull String folderId) throws ApiException {
    return deleteFolderWithHttpInfo(folderId).getData();
  }

  /**
   * Delete a folder
   * Deletes an empty folder. The folder must not contain any templates or subfolders. Move or delete all contents before attempting to delete the folder. 
   * @param folderId  (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> folder has contents </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> folder is empty </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
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
   * Deletes a template or a specific template version. When no version is specified, deletes the entire template including all versions. When a version is specified, deletes only that version while preserving others. Returns remaining version information. 
   * @param templateId  (required)
   * @param version  (optional)
   * @return TemplateDeleteResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template version deleted successfully </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplateDeleteResponse deleteTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
    return deleteTemplateWithHttpInfo(templateId, version).getData();
  }

  /**
   * Delete a template
   * Deletes a template or a specific template version. When no version is specified, deletes the entire template including all versions. When a version is specified, deletes only that version while preserving others. Returns remaining version information. 
   * @param templateId  (required)
   * @param version  (optional)
   * @return ApiResponse&lt;TemplateDeleteResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template version deleted successfully </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplateDeleteResponse> deleteTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String version) throws ApiException {
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
    GenericType<TemplateDeleteResponse> localVarReturnType = new GenericType<TemplateDeleteResponse>() {};
    return apiClient.invokeAPI("Client.deleteTemplate", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a webhook
   * Permanently deletes a webhook so it stops receiving events, and returns the deleted webhook.
   * @param webhookId  (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Webhook deleteWebhook(@javax.annotation.Nonnull String webhookId) throws ApiException {
    return deleteWebhookWithHttpInfo(webhookId).getData();
  }

  /**
   * Delete a webhook
   * Permanently deletes a webhook so it stops receiving events, and returns the deleted webhook.
   * @param webhookId  (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook deleted </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
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
   * Expire a combined submission
   * Expiring a combined submission deletes the PDF from our system. This is useful for invalidating sensitive documents. 
   * @param combinedSubmissionId  (required)
   * @return CombinedSubmission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission was expired </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined submission not found </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Expire a combined submission Documentation</a>
   */
  public CombinedSubmission expireCombinedSubmission(@javax.annotation.Nonnull String combinedSubmissionId) throws ApiException {
    return expireCombinedSubmissionWithHttpInfo(combinedSubmissionId).getData();
  }

  /**
   * Expire a combined submission
   * Expiring a combined submission deletes the PDF from our system. This is useful for invalidating sensitive documents. 
   * @param combinedSubmissionId  (required)
   * @return ApiResponse&lt;CombinedSubmission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission was expired </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined submission not found </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Expire a combined submission Documentation</a>
   */
  public ApiResponse<CombinedSubmission> expireCombinedSubmissionWithHttpInfo(@javax.annotation.Nonnull String combinedSubmissionId) throws ApiException {
    // Check required parameters
    if (combinedSubmissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'combinedSubmissionId' when calling expireCombinedSubmission");
    }

    // Path parameters
    String localVarPath = "/combined_submissions/{combined_submission_id}"
            .replaceAll("\\{combined_submission_id}", apiClient.escapeString(combinedSubmissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedSubmission> localVarReturnType = new GenericType<CombinedSubmission>() {};
    return apiClient.invokeAPI("Client.expireCombinedSubmission", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Expire a PDF submission
   * Expiring a PDF submission deletes the PDF and removes the data from our database. This is useful for invalidating sensitive documents after they&#39;ve been downloaded. You can also [configure a data retention policy for your submissions](https://docspring.com/docs/template-editor/settings/#expire-submissions) so that they automatically expire. 
   * @param submissionId  (required)
   * @return SubmissionPreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission was expired </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used </td><td>  -  </td></tr>
     </table>
   */
  public SubmissionPreview expireSubmission(@javax.annotation.Nonnull String submissionId) throws ApiException {
    return expireSubmissionWithHttpInfo(submissionId).getData();
  }

  /**
   * Expire a PDF submission
   * Expiring a PDF submission deletes the PDF and removes the data from our database. This is useful for invalidating sensitive documents after they&#39;ve been downloaded. You can also [configure a data retention policy for your submissions](https://docspring.com/docs/template-editor/settings/#expire-submissions) so that they automatically expire. 
   * @param submissionId  (required)
   * @return ApiResponse&lt;SubmissionPreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission was expired </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> test API token used </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionPreview> expireSubmissionWithHttpInfo(@javax.annotation.Nonnull String submissionId) throws ApiException {
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
    GenericType<SubmissionPreview> localVarReturnType = new GenericType<SubmissionPreview>() {};
    return apiClient.invokeAPI("Client.expireSubmission", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate a PDF
   * Creates a PDF submission by filling in a template with data. Supports both synchronous (default) and asynchronous processing. Add the &#x60;wait&#x3D;false&#x60; query parameter to return immediately.  Live PDFs use credits; test PDFs (&#x60;test: true&#x60;) are free and watermarked. If your balance can&#39;t cover a live PDF, the API returns 402 and the submission waits in the &#x60;insufficient_credits&#x60; state until you add credits. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).  See also: - [Customize the PDF Title and Filename](https://docspring.com/docs/api-guide/generate-pdfs/customize-pdf-title-and-filename/) - Set custom metadata - [Handling Truncated Text](https://docspring.com/docs/api-guide/generate-pdfs/handle-truncated-text/) - Handle text that doesn&#39;t fit in fields 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return CreateSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> live data requests need Starter or higher </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to generating PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/generate-pdfs/generate-pdfs-via-api/">Generate a PDF Documentation</a>
   */
  public CreateSubmissionResponse generatePdf(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreatePdfSubmissionData submission, @javax.annotation.Nullable Boolean wait) throws ApiException {
    return generatePdfWithHttpInfo(templateId, submission, wait).getData();
  }

  /**
   * Generate a PDF
   * Creates a PDF submission by filling in a template with data. Supports both synchronous (default) and asynchronous processing. Add the &#x60;wait&#x3D;false&#x60; query parameter to return immediately.  Live PDFs use credits; test PDFs (&#x60;test: true&#x60;) are free and watermarked. If your balance can&#39;t cover a live PDF, the API returns 402 and the submission waits in the &#x60;insufficient_credits&#x60; state until you add credits. See [Credits &amp; Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).  See also: - [Customize the PDF Title and Filename](https://docspring.com/docs/api-guide/generate-pdfs/customize-pdf-title-and-filename/) - Set custom metadata - [Handling Truncated Text](https://docspring.com/docs/api-guide/generate-pdfs/handle-truncated-text/) - Handle text that doesn&#39;t fit in fields 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;CreateSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 402 </td><td> insufficient credits </td><td>  -  </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> live data requests need Starter or higher </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to generating PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/generate-pdfs/generate-pdfs-via-api/">Generate a PDF Documentation</a>
   */
  public ApiResponse<CreateSubmissionResponse> generatePdfWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull CreatePdfSubmissionData submission, @javax.annotation.Nullable Boolean wait) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling generatePdf");
    }
    if (submission == null) {
      throw new ApiException(400, "Missing the required parameter 'submission' when calling generatePdf");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateSubmissionResponse> localVarReturnType = new GenericType<CreateSubmissionResponse>() {};
    return apiClient.invokeAPI("Client.generatePdf", localVarPath, "POST", localVarQueryParams, submission,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate a preview PDF for partially completed data requests
   * Generates a preview PDF for a submission with partially completed data requests. Useful for showing users what the final document will look like before all signatures or data have been collected. The preview includes any data collected so far. 
   * @param submissionId  (required)
   * @return SuccessErrorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview was successfully requested </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> error requesting preview </td><td>  -  </td></tr>
     </table>
   */
  public SuccessErrorResponse generatePreview(@javax.annotation.Nonnull String submissionId) throws ApiException {
    return generatePreviewWithHttpInfo(submissionId).getData();
  }

  /**
   * Generate a preview PDF for partially completed data requests
   * Generates a preview PDF for a submission with partially completed data requests. Useful for showing users what the final document will look like before all signatures or data have been collected. The preview includes any data collected so far. 
   * @param submissionId  (required)
   * @return ApiResponse&lt;SuccessErrorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> preview was successfully requested </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> error requesting preview </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessErrorResponse> generatePreviewWithHttpInfo(@javax.annotation.Nonnull String submissionId) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling generatePreview");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}/generate_preview"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessErrorResponse> localVarReturnType = new GenericType<SuccessErrorResponse>() {};
    return apiClient.invokeAPI("Client.generatePreview", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a combined submission (merged PDFs)
   * Retrieves the details and status of a combined submission. Returns processing state, download URL (if processed), metadata, and information about any integrated actions (e.g., S3 uploads).  &#x60;insufficient_credits&#x60; means the combined submission is waiting for credits and is processed once you add them. If it&#39;s still waiting after 30 days, it moves to &#x60;error&#x60;. 
   * @param combinedSubmissionId  (required)
   * @return CombinedSubmission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed combined submission found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Check the status of a combined submission (merged PDFs) Documentation</a>
   */
  public CombinedSubmission getCombinedSubmission(@javax.annotation.Nonnull String combinedSubmissionId) throws ApiException {
    return getCombinedSubmissionWithHttpInfo(combinedSubmissionId).getData();
  }

  /**
   * Check the status of a combined submission (merged PDFs)
   * Retrieves the details and status of a combined submission. Returns processing state, download URL (if processed), metadata, and information about any integrated actions (e.g., S3 uploads).  &#x60;insufficient_credits&#x60; means the combined submission is waiting for credits and is processed once you add them. If it&#39;s still waiting after 30 days, it moves to &#x60;error&#x60;. 
   * @param combinedSubmissionId  (required)
   * @return ApiResponse&lt;CombinedSubmission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed combined submission found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> combined submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Check the status of a combined submission (merged PDFs) Documentation</a>
   */
  public ApiResponse<CombinedSubmission> getCombinedSubmissionWithHttpInfo(@javax.annotation.Nonnull String combinedSubmissionId) throws ApiException {
    // Check required parameters
    if (combinedSubmissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'combinedSubmissionId' when calling getCombinedSubmission");
    }

    // Path parameters
    String localVarPath = "/combined_submissions/{combined_submission_id}"
            .replaceAll("\\{combined_submission_id}", apiClient.escapeString(combinedSubmissionId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CombinedSubmission> localVarReturnType = new GenericType<CombinedSubmission>() {};
    return apiClient.invokeAPI("Client.getCombinedSubmission", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Look up a submission data request
   * Retrieves the details and status of a data request. Returns information about the request state (pending, viewed, completed), authentication details, and metadata. Includes audit information like IP address, browseruser agent, and timestamps.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - Complete guide to data request workflow 
   * @param dataRequestId  (required)
   * @return SubmissionDataRequestShow
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> completed submission data request found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission data request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SubmissionDataRequestShow getDataRequest(@javax.annotation.Nonnull String dataRequestId) throws ApiException {
    return getDataRequestWithHttpInfo(dataRequestId).getData();
  }

  /**
   * Look up a submission data request
   * Retrieves the details and status of a data request. Returns information about the request state (pending, viewed, completed), authentication details, and metadata. Includes audit information like IP address, browseruser agent, and timestamps.  See also: - [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - Complete guide to data request workflow 
   * @param dataRequestId  (required)
   * @return ApiResponse&lt;SubmissionDataRequestShow&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> completed submission data request found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission data request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionDataRequestShow> getDataRequestWithHttpInfo(@javax.annotation.Nonnull String dataRequestId) throws ApiException {
    // Check required parameters
    if (dataRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'dataRequestId' when calling getDataRequest");
    }

    // Path parameters
    String localVarPath = "/data_requests/{data_request_id}"
            .replaceAll("\\{data_request_id}", apiClient.escapeString(dataRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionDataRequestShow> localVarReturnType = new GenericType<SubmissionDataRequestShow>() {};
    return apiClient.invokeAPI("Client.getDataRequest", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Fetch the full attributes for a PDF template
   * Retrieves complete template information including fields, defaults, settings, and HTML/SCSS content. Use this to get all template data needed for automated updates or analysis. Returns more detailed information than the basic &#x60;getTemplate&#x60; endpoint. 
   * @param templateId  (required)
   * @return Template
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Template getFullTemplate(@javax.annotation.Nonnull String templateId) throws ApiException {
    return getFullTemplateWithHttpInfo(templateId).getData();
  }

  /**
   * Fetch the full attributes for a PDF template
   * Retrieves complete template information including fields, defaults, settings, and HTML/SCSS content. Use this to get all template data needed for automated updates or analysis. Returns more detailed information than the basic &#x60;getTemplate&#x60; endpoint. 
   * @param templateId  (required)
   * @return ApiResponse&lt;Template&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Template> getFullTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getFullTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}?full=true"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Template> localVarReturnType = new GenericType<Template>() {};
    return apiClient.invokeAPI("Client.getFullTemplate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a presigned S3 URL for direct file upload
   * Returns a presigned S3 URL for uploading files directly to our S3 bucket. Use this endpoint to upload large files before creating templates or custom files. S3 will respond with a JSON object that you can include in your DocSpring API request.  Uploaded files can be used to: - [Create templates](https://docspring.com/docs/api/#tag/templates/post/templates?endpoint_variant&#x3D;create_template_from_cached_upload) - [Update templates](https://docspring.com/docs/api/#tag/templates/put/templates/{template_id}?endpoint_variant&#x3D;update_template_pdf_with_cached_upload) - [Create custom files](https://docspring.com/docs/api/#tag/custom-files/post/custom_files) and then [merge them with other PDFs](https://docspring.com/docs/api/#tag/combine-pdfs/post/combined_submissions) 
   * @return UploadPresignResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presign URL generated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn about uploading custom files for PDF combining
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a presigned S3 URL for direct file upload Documentation</a>
   */
  public UploadPresignResponse getPresignUrl() throws ApiException {
    return getPresignUrlWithHttpInfo().getData();
  }

  /**
   * Get a presigned S3 URL for direct file upload
   * Returns a presigned S3 URL for uploading files directly to our S3 bucket. Use this endpoint to upload large files before creating templates or custom files. S3 will respond with a JSON object that you can include in your DocSpring API request.  Uploaded files can be used to: - [Create templates](https://docspring.com/docs/api/#tag/templates/post/templates?endpoint_variant&#x3D;create_template_from_cached_upload) - [Update templates](https://docspring.com/docs/api/#tag/templates/put/templates/{template_id}?endpoint_variant&#x3D;update_template_pdf_with_cached_upload) - [Create custom files](https://docspring.com/docs/api/#tag/custom-files/post/custom_files) and then [merge them with other PDFs](https://docspring.com/docs/api/#tag/combine-pdfs/post/combined_submissions) 
   * @return ApiResponse&lt;UploadPresignResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presign URL generated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn about uploading custom files for PDF combining
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a presigned S3 URL for direct file upload Documentation</a>
   */
  public ApiResponse<UploadPresignResponse> getPresignUrlWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<UploadPresignResponse> localVarReturnType = new GenericType<UploadPresignResponse>() {};
    return apiClient.invokeAPI("Client.getPresignUrl", "/uploads/presign", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a PDF
   * Retrieves the details and status of a PDF submission. Returns processing state, download URL (if processed), metadata, submission data (optional), and information about any integrated actions. Use this to poll for completion when using asynchronous processing.  &#x60;insufficient_credits&#x60; means the submission is waiting for credits and is processed once you add them. If it&#39;s still waiting after 30 days, it moves to &#x60;error&#x60;. 
   * @param submissionId  (required)
   * @param includeData  (optional)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission found with data </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Submission getSubmission(@javax.annotation.Nonnull String submissionId, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    return getSubmissionWithHttpInfo(submissionId, includeData).getData();
  }

  /**
   * Check the status of a PDF
   * Retrieves the details and status of a PDF submission. Returns processing state, download URL (if processed), metadata, submission data (optional), and information about any integrated actions. Use this to poll for completion when using asynchronous processing.  &#x60;insufficient_credits&#x60; means the submission is waiting for credits and is processed once you add them. If it&#39;s still waiting after 30 days, it moves to &#x60;error&#x60;. 
   * @param submissionId  (required)
   * @param includeData  (optional)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission found with data </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Submission> getSubmissionWithHttpInfo(@javax.annotation.Nonnull String submissionId, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    // Check required parameters
    if (submissionId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionId' when calling getSubmission");
    }

    // Path parameters
    String localVarPath = "/submissions/{submission_id}"
            .replaceAll("\\{submission_id}", apiClient.escapeString(submissionId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "include_data", includeData)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Submission> localVarReturnType = new GenericType<Submission>() {};
    return apiClient.invokeAPI("Client.getSubmission", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a submission batch job
   * Retrieves the status and results of a batch PDF generation job. Returns processing state, completion statistics, and optionally includes all individual submission details. Use this to poll for completion when using asynchronous batch processing.  Submissions waiting for credits are in the &#x60;insufficient_credits&#x60; state and count as pending, so the batch stays &#x60;pending&#x60; until you add credits or they stop waiting after 30 days. 
   * @param submissionBatchId  (required)
   * @param includeSubmissions  (optional)
   * @return SubmissionBatchWithSubmissions
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission batch found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission batch not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SubmissionBatchWithSubmissions getSubmissionBatch(@javax.annotation.Nonnull String submissionBatchId, @javax.annotation.Nullable Boolean includeSubmissions) throws ApiException {
    return getSubmissionBatchWithHttpInfo(submissionBatchId, includeSubmissions).getData();
  }

  /**
   * Check the status of a submission batch job
   * Retrieves the status and results of a batch PDF generation job. Returns processing state, completion statistics, and optionally includes all individual submission details. Use this to poll for completion when using asynchronous batch processing.  Submissions waiting for credits are in the &#x60;insufficient_credits&#x60; state and count as pending, so the batch stays &#x60;pending&#x60; until you add credits or they stop waiting after 30 days. 
   * @param submissionBatchId  (required)
   * @param includeSubmissions  (optional)
   * @return ApiResponse&lt;SubmissionBatchWithSubmissions&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission batch found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission batch not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubmissionBatchWithSubmissions> getSubmissionBatchWithHttpInfo(@javax.annotation.Nonnull String submissionBatchId, @javax.annotation.Nullable Boolean includeSubmissions) throws ApiException {
    // Check required parameters
    if (submissionBatchId == null) {
      throw new ApiException(400, "Missing the required parameter 'submissionBatchId' when calling getSubmissionBatch");
    }

    // Path parameters
    String localVarPath = "/submissions/batches/{submission_batch_id}"
            .replaceAll("\\{submission_batch_id}", apiClient.escapeString(submissionBatchId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "include_submissions", includeSubmissions)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SubmissionBatchWithSubmissions> localVarReturnType = new GenericType<SubmissionBatchWithSubmissions>() {};
    return apiClient.invokeAPI("Client.getSubmissionBatch", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of an uploaded template
   * Retrieves information about a template including processing status and document URL. Use this to check if template is ready to view in the template editor or generate PDFs. 
   * @param templateId  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview getTemplate(@javax.annotation.Nonnull String templateId) throws ApiException {
    return getTemplateWithHttpInfo(templateId).getData();
  }

  /**
   * Check the status of an uploaded template
   * Retrieves information about a template including processing status and document URL. Use this to check if template is ready to view in the template editor or generate PDFs. 
   * @param templateId  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> getTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.getTemplate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generate typed model code for a template
   * Generates typed model code for a template&#39;s submission data from its JSON schema, in TypeScript, JavaScript, Ruby, Python, PHP, Java, C#, Elixir or Go. Build your submission data with the generated types so your app catches mistakes before it calls the API.  &#x60;root_type_name&#x60; is the type that describes the whole submission data object, qualified with its namespace or package where there is one. Java returns every class in &#x60;code&#x60;, each under a &#x60;// ClassName.java&#x60; comment: split them into one file per class.  A template with no named fields returns 422, since there are no types to generate.  See also: - [Generate Model Code](https://docspring.com/docs/template-editor/generate-model-code/) - Use the generated types 
   * @param templateId  (required)
   * @param lang The language to generate code for (required)
   * @return TemplateModelCodeResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> model code generated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown language </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to use the generated model code
   * @see <a href="https://docspring.com/docs/template-editor/generate-model-code/">Generate typed model code for a template Documentation</a>
   */
  public TemplateModelCodeResponse getTemplateModelCode(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull String lang) throws ApiException {
    return getTemplateModelCodeWithHttpInfo(templateId, lang).getData();
  }

  /**
   * Generate typed model code for a template
   * Generates typed model code for a template&#39;s submission data from its JSON schema, in TypeScript, JavaScript, Ruby, Python, PHP, Java, C#, Elixir or Go. Build your submission data with the generated types so your app catches mistakes before it calls the API.  &#x60;root_type_name&#x60; is the type that describes the whole submission data object, qualified with its namespace or package where there is one. Java returns every class in &#x60;code&#x60;, each under a &#x60;// ClassName.java&#x60; comment: split them into one file per class.  A template with no named fields returns 422, since there are no types to generate.  See also: - [Generate Model Code](https://docspring.com/docs/template-editor/generate-model-code/) - Use the generated types 
   * @param templateId  (required)
   * @param lang The language to generate code for (required)
   * @return ApiResponse&lt;TemplateModelCodeResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> model code generated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> unknown language </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to use the generated model code
   * @see <a href="https://docspring.com/docs/template-editor/generate-model-code/">Generate typed model code for a template Documentation</a>
   */
  public ApiResponse<TemplateModelCodeResponse> getTemplateModelCodeWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull String lang) throws ApiException {
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
            apiClient.parameterToPairs("", "lang", lang)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplateModelCodeResponse> localVarReturnType = new GenericType<TemplateModelCodeResponse>() {};
    return apiClient.invokeAPI("Client.getTemplateModelCode", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Fetch the JSON schema for a template
   * Retrieves the JSON Schema definition for a template&#39;s fields. Use this to validate data before submitting it for PDF generation, or to build dynamic forms that match the template&#39;s field structure and validation requirements.  See also: - [Generate PDFs Guide](https://docspring.com/docs/api-guide/generate-pdfs/generate-pdfs-via-api/) - Use schema to validate submission data 
   * @param templateId  (required)
   * @return JsonSchema
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public JsonSchema getTemplateSchema(@javax.annotation.Nonnull String templateId) throws ApiException {
    return getTemplateSchemaWithHttpInfo(templateId).getData();
  }

  /**
   * Fetch the JSON schema for a template
   * Retrieves the JSON Schema definition for a template&#39;s fields. Use this to validate data before submitting it for PDF generation, or to build dynamic forms that match the template&#39;s field structure and validation requirements.  See also: - [Generate PDFs Guide](https://docspring.com/docs/api-guide/generate-pdfs/generate-pdfs-via-api/) - Use schema to validate submission data 
   * @param templateId  (required)
   * @return ApiResponse&lt;JsonSchema&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> template found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<JsonSchema> getTemplateSchemaWithHttpInfo(@javax.annotation.Nonnull String templateId) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling getTemplateSchema");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/schema"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<JsonSchema> localVarReturnType = new GenericType<JsonSchema>() {};
    return apiClient.invokeAPI("Client.getTemplateSchema", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a webhook
   * Retrieves a single webhook by its ID.
   * @param webhookId  (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Webhook getWebhook(@javax.annotation.Nonnull String webhookId) throws ApiException {
    return getWebhookWithHttpInfo(webhookId).getData();
  }

  /**
   * Get a webhook
   * Retrieves a single webhook by its ID.
   * @param webhookId  (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
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
   * Get a list of all combined submissions
   * Returns a paginated list of combined submissions (merged PDFs) for your account. Includes processing status, expiration details, and download URLs for processed PDFs. 
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @return List&lt;CombinedSubmission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all combined submissions </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a list of all combined submissions Documentation</a>
   */
  public List<CombinedSubmission> listCombinedSubmissions(@javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage) throws ApiException {
    return listCombinedSubmissionsWithHttpInfo(page, perPage).getData();
  }

  /**
   * Get a list of all combined submissions
   * Returns a paginated list of combined submissions (merged PDFs) for your account. Includes processing status, expiration details, and download URLs for processed PDFs. 
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @return ApiResponse&lt;List&lt;CombinedSubmission&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all combined submissions </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Complete guide to combining PDFs with DocSpring
   * @see <a href="https://docspring.com/docs/api-guide/combine-pdfs/">Get a list of all combined submissions Documentation</a>
   */
  public ApiResponse<List<CombinedSubmission>> listCombinedSubmissionsWithHttpInfo(@javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "page", page)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "per_page", perPage));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<CombinedSubmission>> localVarReturnType = new GenericType<List<CombinedSubmission>>() {};
    return apiClient.invokeAPI("Client.listCombinedSubmissions", "/combined_submissions", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all folders
   * Returns a list of folders in your account. Can be filtered by parent folder ID to retrieve subfolders. Folders help organize templates and maintain a hierarchical structure. 
   * @param parentFolderId Filter By Folder Id (optional)
   * @return List&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all folders </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public List<Folder> listFolders(@javax.annotation.Nullable String parentFolderId) throws ApiException {
    return listFoldersWithHttpInfo(parentFolderId).getData();
  }

  /**
   * Get a list of all folders
   * Returns a list of folders in your account. Can be filtered by parent folder ID to retrieve subfolders. Folders help organize templates and maintain a hierarchical structure. 
   * @param parentFolderId Filter By Folder Id (optional)
   * @return ApiResponse&lt;List&lt;Folder&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all folders </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Folder>> listFoldersWithHttpInfo(@javax.annotation.Nullable String parentFolderId) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "parent_folder_id", parentFolderId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<Folder>> localVarReturnType = new GenericType<List<Folder>>() {};
    return apiClient.invokeAPI("Client.listFolders", "/folders/", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List all submissions
   * Returns a paginated list of all PDF submissions across all templates in your account. Can be filtered by date range and submission type (test/live). Supports cursor-based pagination and optionally includes submission data for each result. 
   * @param cursor  (optional)
   * @param limit  (optional)
   * @param createdAfter  (optional)
   * @param createdBefore  (optional)
   * @param type  (optional)
   * @param includeData  (optional)
   * @return ListSubmissionsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> listing submissions </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ListSubmissionsResponse listSubmissions(@javax.annotation.Nullable String cursor, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String createdAfter, @javax.annotation.Nullable String createdBefore, @javax.annotation.Nullable String type, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    return listSubmissionsWithHttpInfo(cursor, limit, createdAfter, createdBefore, type, includeData).getData();
  }

  /**
   * List all submissions
   * Returns a paginated list of all PDF submissions across all templates in your account. Can be filtered by date range and submission type (test/live). Supports cursor-based pagination and optionally includes submission data for each result. 
   * @param cursor  (optional)
   * @param limit  (optional)
   * @param createdAfter  (optional)
   * @param createdBefore  (optional)
   * @param type  (optional)
   * @param includeData  (optional)
   * @return ApiResponse&lt;ListSubmissionsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> listing submissions </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ListSubmissionsResponse> listSubmissionsWithHttpInfo(@javax.annotation.Nullable String cursor, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String createdAfter, @javax.annotation.Nullable String createdBefore, @javax.annotation.Nullable String type, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "cursor", cursor)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_after", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_before", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "type", type));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_data", includeData));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<ListSubmissionsResponse> localVarReturnType = new GenericType<ListSubmissionsResponse>() {};
    return apiClient.invokeAPI("Client.listSubmissions", "/submissions", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List all submissions for a given template
   * Returns a paginated list of all submissions for a specific template. Can be filtered by date range, submission type (test/live), and optionally include submission data. Supports cursor-based pagination for efficient retrieval of large result sets. 
   * @param templateId  (required)
   * @param cursor  (optional)
   * @param limit  (optional)
   * @param createdAfter  (optional)
   * @param createdBefore  (optional)
   * @param type  (optional)
   * @param includeData  (optional)
   * @return ListSubmissionsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> listing submissions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> invalid template id </td><td>  -  </td></tr>
     </table>
   */
  public ListSubmissionsResponse listTemplateSubmissions(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String createdAfter, @javax.annotation.Nullable String createdBefore, @javax.annotation.Nullable String type, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    return listTemplateSubmissionsWithHttpInfo(templateId, cursor, limit, createdAfter, createdBefore, type, includeData).getData();
  }

  /**
   * List all submissions for a given template
   * Returns a paginated list of all submissions for a specific template. Can be filtered by date range, submission type (test/live), and optionally include submission data. Supports cursor-based pagination for efficient retrieval of large result sets. 
   * @param templateId  (required)
   * @param cursor  (optional)
   * @param limit  (optional)
   * @param createdAfter  (optional)
   * @param createdBefore  (optional)
   * @param type  (optional)
   * @param includeData  (optional)
   * @return ApiResponse&lt;ListSubmissionsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> listing submissions </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> invalid template id </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ListSubmissionsResponse> listTemplateSubmissionsWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nullable String cursor, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String createdAfter, @javax.annotation.Nullable String createdBefore, @javax.annotation.Nullable String type, @javax.annotation.Nullable Boolean includeData) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling listTemplateSubmissions");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "cursor", cursor)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_after", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "created_before", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "type", type));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "include_data", includeData));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<ListSubmissionsResponse> localVarReturnType = new GenericType<ListSubmissionsResponse>() {};
    return apiClient.invokeAPI("Client.listTemplateSubmissions", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all templates
   * Retrieves a list of your templates with search, filtering, and pagination options. Returns basic template information including ID, name, type (PDF or HTML), and folder location. Supports text search by name and filtering by parent folder. 
   * @param query Search By Name (optional)
   * @param parentFolderId Filter By Folder Id (optional)
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @return List&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all templates </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> filter templates by invalid folder id </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public List<TemplatePreview> listTemplates(@javax.annotation.Nullable String query, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage) throws ApiException {
    return listTemplatesWithHttpInfo(query, parentFolderId, page, perPage).getData();
  }

  /**
   * Get a list of all templates
   * Retrieves a list of your templates with search, filtering, and pagination options. Returns basic template information including ID, name, type (PDF or HTML), and folder location. Supports text search by name and filtering by parent folder. 
   * @param query Search By Name (optional)
   * @param parentFolderId Filter By Folder Id (optional)
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @return ApiResponse&lt;List&lt;TemplatePreview&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> enumerate all templates </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> filter templates by invalid folder id </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<TemplatePreview>> listTemplatesWithHttpInfo(@javax.annotation.Nullable String query, @javax.annotation.Nullable String parentFolderId, @javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "query", query)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parent_folder_id", parentFolderId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "per_page", perPage));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<TemplatePreview>> localVarReturnType = new GenericType<List<TemplatePreview>>() {};
    return apiClient.invokeAPI("Client.listTemplates", "/templates", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all webhooks
   * Returns a list of the webhooks configured for your account. Supports pagination and filtering by event type, mode, and the API token, template, or folder a webhook is scoped to. 
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @param eventType Filter by a subscribed event type (optional)
   * @param mode Filter by mode (test or live) (optional)
   * @param templateId Filter by a scoped template ID (optional)
   * @param folderId Filter by a scoped folder ID (optional)
   * @param apiTokenId Filter by a scoped API token ID (optional)
   * @return List&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> filter webhooks by scope and event type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public List<Webhook> listWebhooks(@javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage, @javax.annotation.Nullable String eventType, @javax.annotation.Nullable String mode, @javax.annotation.Nullable String templateId, @javax.annotation.Nullable String folderId, @javax.annotation.Nullable String apiTokenId) throws ApiException {
    return listWebhooksWithHttpInfo(page, perPage, eventType, mode, templateId, folderId, apiTokenId).getData();
  }

  /**
   * Get a list of all webhooks
   * Returns a list of the webhooks configured for your account. Supports pagination and filtering by event type, mode, and the API token, template, or folder a webhook is scoped to. 
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @param eventType Filter by a subscribed event type (optional)
   * @param mode Filter by mode (test or live) (optional)
   * @param templateId Filter by a scoped template ID (optional)
   * @param folderId Filter by a scoped folder ID (optional)
   * @param apiTokenId Filter by a scoped API token ID (optional)
   * @return ApiResponse&lt;List&lt;Webhook&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> filter webhooks by scope and event type </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<Webhook>> listWebhooksWithHttpInfo(@javax.annotation.Nullable Integer page, @javax.annotation.Nullable Integer perPage, @javax.annotation.Nullable String eventType, @javax.annotation.Nullable String mode, @javax.annotation.Nullable String templateId, @javax.annotation.Nullable String folderId, @javax.annotation.Nullable String apiTokenId) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "page", page)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "per_page", perPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "event_type", eventType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "mode", mode));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "template_id", templateId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "folder_id", folderId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "api_token_id", apiTokenId));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<Webhook>> localVarReturnType = new GenericType<List<Webhook>>() {};
    return apiClient.invokeAPI("Client.listWebhooks", "/webhooks", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move a folder
   * Moves a folder to a new parent folder or to the root level. All templates and subfolders within the folder are moved together. Cannot move a folder into one of its own subfolders. 
   * @param folderId  (required)
   * @param data  (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> parent folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> move to root folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Folder moveFolderToFolder(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull MoveFolderData data) throws ApiException {
    return moveFolderToFolderWithHttpInfo(folderId, data).getData();
  }

  /**
   * Move a folder
   * Moves a folder to a new parent folder or to the root level. All templates and subfolders within the folder are moved together. Cannot move a folder into one of its own subfolders. 
   * @param folderId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 404 </td><td> parent folder doesn&#39;t exist </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> move to root folder </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Folder> moveFolderToFolderWithHttpInfo(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull MoveFolderData data) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling moveFolderToFolder");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling moveFolderToFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}/move"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.moveFolderToFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move Template to folder
   * Moves a template to a different folder or to the root level. Use this to organize templates within your folders. Provide a folder ID to move to a specific folder, or &#x60;null&#x60; to move to the root level. 
   * @param templateId  (required)
   * @param data  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> move template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview moveTemplateToFolder(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull MoveTemplateData data) throws ApiException {
    return moveTemplateToFolderWithHttpInfo(templateId, data).getData();
  }

  /**
   * Move Template to folder
   * Moves a template to a different folder or to the root level. Use this to organize templates within your folders. Provide a folder ID to move to a specific folder, or &#x60;null&#x60; to move to the root level. 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> move template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> moveTemplateToFolderWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull MoveTemplateData data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling moveTemplateToFolder");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling moveTemplateToFolder");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/move"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("Client.moveTemplateToFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Publish a template version
   * Publishes the current draft version of a template and creates a new immutable version with semantic versioning (major.minor.patch). 
   * @param templateId  (required)
   * @param data  (required)
   * @return TemplatePublishVersionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version published successfully </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version type </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePublishVersionResponse publishTemplateVersion(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull PublishVersionData data) throws ApiException {
    return publishTemplateVersionWithHttpInfo(templateId, data).getData();
  }

  /**
   * Publish a template version
   * Publishes the current draft version of a template and creates a new immutable version with semantic versioning (major.minor.patch). 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePublishVersionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version published successfully </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid version type </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePublishVersionResponse> publishTemplateVersionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull PublishVersionData data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling publishTemplateVersion");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling publishTemplateVersion");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/publish_version"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePublishVersionResponse> localVarReturnType = new GenericType<TemplatePublishVersionResponse>() {};
    return apiClient.invokeAPI("Client.publishTemplateVersion", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename a folder
   * Renames an existing folder. The new name must be unique within the same parent folder. This operation only changes the folder name, not its location or contents. 
   * @param folderId  (required)
   * @param data  (required)
   * @return Folder
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 422 </td><td> name already exist </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder doesn&#39;t belong to me </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> successful rename </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Folder renameFolder(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull RenameFolderData data) throws ApiException {
    return renameFolderWithHttpInfo(folderId, data).getData();
  }

  /**
   * Rename a folder
   * Renames an existing folder. The new name must be unique within the same parent folder. This operation only changes the folder name, not its location or contents. 
   * @param folderId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;Folder&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 422 </td><td> name already exist </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder doesn&#39;t belong to me </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> successful rename </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Folder> renameFolderWithHttpInfo(@javax.annotation.Nonnull String folderId, @javax.annotation.Nonnull RenameFolderData data) throws ApiException {
    // Check required parameters
    if (folderId == null) {
      throw new ApiException(400, "Missing the required parameter 'folderId' when calling renameFolder");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling renameFolder");
    }

    // Path parameters
    String localVarPath = "/folders/{folder_id}/rename"
            .replaceAll("\\{folder_id}", apiClient.escapeString(folderId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("Client.renameFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Restore a template version
   * Restores your template to a previously published version, copying that version&#39;s content and configuration to the current draft. Use this to revert changes or recover from an unwanted modification. 
   * @param templateId  (required)
   * @param data  (required)
   * @return SuccessErrorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version restored successfully </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> draft version not allowed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template version not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SuccessErrorResponse restoreTemplateVersion(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RestoreVersionData data) throws ApiException {
    return restoreTemplateVersionWithHttpInfo(templateId, data).getData();
  }

  /**
   * Restore a template version
   * Restores your template to a previously published version, copying that version&#39;s content and configuration to the current draft. Use this to revert changes or recover from an unwanted modification. 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;SuccessErrorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> version restored successfully </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> draft version not allowed </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> template version not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessErrorResponse> restoreTemplateVersionWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull RestoreVersionData data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling restoreTemplateVersion");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling restoreTemplateVersion");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/restore_version"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessErrorResponse> localVarReturnType = new GenericType<SuccessErrorResponse>() {};
    return apiClient.invokeAPI("Client.restoreTemplateVersion", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test authentication
   * Checks whether your API token is valid by making an authenticated request. Returns a success response if authentication passes. This endpoint is useful for verifying credentials during setup or troubleshooting issues. 
   * @return SuccessErrorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to authenticate with the DocSpring API
   * @see <a href="https://docspring.com/docs/api-guide/authentication/">Test authentication Documentation</a>
   */
  public SuccessErrorResponse testAuthentication() throws ApiException {
    return testAuthenticationWithHttpInfo().getData();
  }

  /**
   * Test authentication
   * Checks whether your API token is valid by making an authenticated request. Returns a success response if authentication passes. This endpoint is useful for verifying credentials during setup or troubleshooting issues. 
   * @return ApiResponse&lt;SuccessErrorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Learn how to authenticate with the DocSpring API
   * @see <a href="https://docspring.com/docs/api-guide/authentication/">Test authentication Documentation</a>
   */
  public ApiResponse<SuccessErrorResponse> testAuthenticationWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessErrorResponse> localVarReturnType = new GenericType<SuccessErrorResponse>() {};
    return apiClient.invokeAPI("Client.testAuthentication", "/authentication", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a submission data request
   * Updates authentication details for a data request. Use this when a user logs in to record their authentication method, provider, session information, and hashed identifiers. Updates metadata and tracks authentication state changes for auditing and compliance. 
   * @param dataRequestId  (required)
   * @param data  (required)
   * @return CreateSubmissionDataRequestResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission data request updated </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission data request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Update authentication details after user sign-in
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#4-update-authentication-details">Update a submission data request Documentation</a>
   */
  public CreateSubmissionDataRequestResponse updateDataRequest(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nonnull UpdateSubmissionDataRequestData data) throws ApiException {
    return updateDataRequestWithHttpInfo(dataRequestId, data).getData();
  }

  /**
   * Update a submission data request
   * Updates authentication details for a data request. Use this when a user logs in to record their authentication method, provider, session information, and hashed identifiers. Updates metadata and tracks authentication state changes for auditing and compliance. 
   * @param dataRequestId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;CreateSubmissionDataRequestResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> submission data request updated </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission data request not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   * Update authentication details after user sign-in
   * @see <a href="https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/#4-update-authentication-details">Update a submission data request Documentation</a>
   */
  public ApiResponse<CreateSubmissionDataRequestResponse> updateDataRequestWithHttpInfo(@javax.annotation.Nonnull String dataRequestId, @javax.annotation.Nonnull UpdateSubmissionDataRequestData data) throws ApiException {
    // Check required parameters
    if (dataRequestId == null) {
      throw new ApiException(400, "Missing the required parameter 'dataRequestId' when calling updateDataRequest");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling updateDataRequest");
    }

    // Path parameters
    String localVarPath = "/data_requests/{data_request_id}"
            .replaceAll("\\{data_request_id}", apiClient.escapeString(dataRequestId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateSubmissionDataRequestResponse> localVarReturnType = new GenericType<CreateSubmissionDataRequestResponse>() {};
    return apiClient.invokeAPI("Client.updateDataRequest", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a Template
   * Updates template content and properties. For HTML templates, you can modify the HTML, SCSS, headers, footers, name, and description. Changes are applied to your draft template and do not affect published template versions. The exception is &#x60;parent_folder_id&#x60;: moving the template to another folder moves its published versions too. 
   * @param templateId  (required)
   * @param data  (required)
   * @return SuccessMultipleErrorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> update template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public SuccessMultipleErrorsResponse updateTemplate(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateHtmlTemplate data) throws ApiException {
    return updateTemplateWithHttpInfo(templateId, data).getData();
  }

  /**
   * Update a Template
   * Updates template content and properties. For HTML templates, you can modify the HTML, SCSS, headers, footers, name, and description. Changes are applied to your draft template and do not affect published template versions. The exception is &#x60;parent_folder_id&#x60;: moving the template to another folder moves its published versions too. 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;SuccessMultipleErrorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> update template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessMultipleErrorsResponse> updateTemplateWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdateHtmlTemplate data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplate");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling updateTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessMultipleErrorsResponse> localVarReturnType = new GenericType<SuccessMultipleErrorsResponse>() {};
    return apiClient.invokeAPI("Client.updateTemplate", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a template&#39;s document with a form POST file upload
   * Upload a new PDF file to update a PDF template&#39;s document. This replaces the template&#39;s PDF while preserving all of the existing fields. If you upload a PDF with fewer pages than the current document, any fields on the removed pages will be deleted. 
   * @param templateId  (required)
   * @param templateDocument  (required)
   * @param templateName  (optional)
   * @return SuccessMultipleErrorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> returns a template with updated document </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SuccessMultipleErrorsResponse updateTemplateDocument(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull File templateDocument, @javax.annotation.Nullable String templateName) throws ApiException {
    return updateTemplateDocumentWithHttpInfo(templateId, templateDocument, templateName).getData();
  }

  /**
   * Update a template&#39;s document with a form POST file upload
   * Upload a new PDF file to update a PDF template&#39;s document. This replaces the template&#39;s PDF while preserving all of the existing fields. If you upload a PDF with fewer pages than the current document, any fields on the removed pages will be deleted. 
   * @param templateId  (required)
   * @param templateDocument  (required)
   * @param templateName  (optional)
   * @return ApiResponse&lt;SuccessMultipleErrorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> returns a template with updated document </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessMultipleErrorsResponse> updateTemplateDocumentWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull File templateDocument, @javax.annotation.Nullable String templateName) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplateDocument");
    }
    if (templateDocument == null) {
      throw new ApiException(400, "Missing the required parameter 'templateDocument' when calling updateTemplateDocument");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}?endpoint_variant=update_template_pdf_with_form_post"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Form parameters
    Map<String, Object> localVarFormParams = new LinkedHashMap<>();
    localVarFormParams.put("template[document]", templateDocument);
    if (templateName != null) {
      localVarFormParams.put("template[name]", templateName);
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("multipart/form-data");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessMultipleErrorsResponse> localVarReturnType = new GenericType<SuccessMultipleErrorsResponse>() {};
    return apiClient.invokeAPI("Client.updateTemplateDocument", localVarPath, "PUT", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a template&#39;s document with a cached S3 file upload
   * Updates a PDF template&#39;s document using a cached file upload. This is a three-step process: First, request a presigned URL to upload your PDF file to our S3 bucket. Then, use that URL to upload your PDF file. Finally, submit the ID of the uploaded file to replace the template&#39;s document. 
   * @param templateId  (required)
   * @param data  (required)
   * @return SuccessMultipleErrorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> returns a template with updated document </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SuccessMultipleErrorsResponse updateTemplateDocumentFromUpload(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdatePdfTemplate data) throws ApiException {
    return updateTemplateDocumentFromUploadWithHttpInfo(templateId, data).getData();
  }

  /**
   * Update a template&#39;s document with a cached S3 file upload
   * Updates a PDF template&#39;s document using a cached file upload. This is a three-step process: First, request a presigned URL to upload your PDF file to our S3 bucket. Then, use that URL to upload your PDF file. Finally, submit the ID of the uploaded file to replace the template&#39;s document. 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;SuccessMultipleErrorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> returns a template with updated document </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessMultipleErrorsResponse> updateTemplateDocumentFromUploadWithHttpInfo(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull UpdatePdfTemplate data) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling updateTemplateDocumentFromUpload");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling updateTemplateDocumentFromUpload");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}?endpoint_variant=update_template_pdf_with_cached_upload"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessMultipleErrorsResponse> localVarReturnType = new GenericType<SuccessMultipleErrorsResponse>() {};
    return apiClient.invokeAPI("Client.updateTemplateDocumentFromUpload", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a webhook
   * Updates the configuration of an existing webhook.
   * @param webhookId  (required)
   * @param data  (required)
   * @return Webhook
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Webhook updateWebhook(@javax.annotation.Nonnull String webhookId, @javax.annotation.Nonnull UpdateWebhookData data) throws ApiException {
    return updateWebhookWithHttpInfo(webhookId, data).getData();
  }

  /**
   * Update a webhook
   * Updates the configuration of an existing webhook.
   * @param webhookId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;Webhook&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> webhook updated </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> webhook not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Webhook> updateWebhookWithHttpInfo(@javax.annotation.Nonnull String webhookId, @javax.annotation.Nonnull UpdateWebhookData data) throws ApiException {
    // Check required parameters
    if (webhookId == null) {
      throw new ApiException(400, "Missing the required parameter 'webhookId' when calling updateWebhook");
    }
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling updateWebhook");
    }

    // Path parameters
    String localVarPath = "/webhooks/{webhook_id}"
            .replaceAll("\\{webhook_id}", apiClient.escapeString(webhookId.toString()));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Webhook> localVarReturnType = new GenericType<Webhook>() {};
    return apiClient.invokeAPI("Client.updateWebhook", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
