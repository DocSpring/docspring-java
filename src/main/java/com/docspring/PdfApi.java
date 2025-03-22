package com.docspring;

import com.docspring.ApiException;
import com.docspring.ApiClient;
import com.docspring.ApiResponse;
import com.docspring.Configuration;
import com.docspring.Pair;

import javax.ws.rs.core.GenericType;

import com.docspring.AddFieldsData;
import com.docspring.BatchGeneratePdfs201Response;
import java.math.BigDecimal;
import com.docspring.CombinePdfsData;
import com.docspring.CombinedSubmission;
import com.docspring.CombinedSubmissionData;
import com.docspring.CopyTemplateOptions;
import com.docspring.CreateCombinedSubmissionResponse;
import com.docspring.CreateCustomFileData;
import com.docspring.CreateCustomFileResponse;
import com.docspring.CreateFolderData;
import com.docspring.CreateHtmlSubmissionData;
import com.docspring.CreateHtmlTemplate;
import com.docspring.CreatePdfSubmissionData;
import com.docspring.CreatePdfTemplate;
import com.docspring.CreateSubmissionDataRequestEventRequest;
import com.docspring.CreateSubmissionDataRequestEventResponse;
import com.docspring.CreateSubmissionDataRequestResponse;
import com.docspring.CreateSubmissionDataRequestTokenResponse;
import com.docspring.CreateSubmissionResponse;
import com.docspring.ErrorResponse;
import java.io.File;
import com.docspring.Folder;
import com.docspring.JsonSchema;
import com.docspring.ListSubmissionsResponse;
import com.docspring.MoveFolderData;
import com.docspring.MoveTemplateData;
import com.docspring.MultipleErrorsResponse;
import com.docspring.PublishVersionData;
import com.docspring.RenameFolderData;
import com.docspring.RestoreVersionData;
import com.docspring.Submission;
import com.docspring.SubmissionBatchData;
import com.docspring.SubmissionBatchWithSubmissions;
import com.docspring.SubmissionDataRequestShow;
import com.docspring.SubmissionPreview;
import com.docspring.SuccessErrorResponse;
import com.docspring.SuccessMultipleErrorsResponse;
import com.docspring.Template;
import com.docspring.TemplateAddFieldsResponse;
import com.docspring.TemplateDeleteResponse;
import com.docspring.TemplatePreview;
import com.docspring.TemplatePublishVersionResponse;
import com.docspring.UpdateHtmlTemplate;
import com.docspring.UpdateSubmissionDataRequestData;
import com.docspring.UploadPresignResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class PdfApi {
  private ApiClient apiClient;

  public PdfApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PdfApi(ApiClient apiClient) {
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
   * 
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
   */
  public TemplateAddFieldsResponse addFieldsToTemplate(String templateId, AddFieldsData data) throws ApiException {
    return addFieldsToTemplateWithHttpInfo(templateId, data).getData();
  }

  /**
   * Add new fields to a Template
   * 
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
   */
  public ApiResponse<TemplateAddFieldsResponse> addFieldsToTemplateWithHttpInfo(String templateId, AddFieldsData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.addFieldsToTemplate", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generates multiple PDFs
   * 
   * @param data  (required)
   * @param wait Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return BatchGeneratePdfs201Response
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submissions created </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> some PDFs with invalid data </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> array of arrays </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
     </table>
   */
  public BatchGeneratePdfs201Response batchGeneratePdfs(SubmissionBatchData data, Boolean wait) throws ApiException {
    return batchGeneratePdfsWithHttpInfo(data, wait).getData();
  }

  /**
   * Generates multiple PDFs
   * 
   * @param data  (required)
   * @param wait Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;BatchGeneratePdfs201Response&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submissions created </td><td>  -  </td></tr>
       <tr><td> 200 </td><td> some PDFs with invalid data </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> array of arrays </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchGeneratePdfs201Response> batchGeneratePdfsWithHttpInfo(SubmissionBatchData data, Boolean wait) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.batchGeneratePdfs", "/submissions/batches", "POST", localVarQueryParams, data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Merge submission PDFs, template PDFs, or custom files
   * 
   * @param data  (required)
   * @return CreateCombinedSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public CreateCombinedSubmissionResponse combinePdfs(CombinePdfsData data) throws ApiException {
    return combinePdfsWithHttpInfo(data).getData();
  }

  /**
   * Merge submission PDFs, template PDFs, or custom files
   * 
   * @param data  (required)
   * @return ApiResponse&lt;CreateCombinedSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CreateCombinedSubmissionResponse> combinePdfsWithHttpInfo(CombinePdfsData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling combinePdfs");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateCombinedSubmissionResponse> localVarReturnType = new GenericType<CreateCombinedSubmissionResponse>() {};
    return apiClient.invokeAPI("PdfApi.combinePdfs", "/combined_submissions?v=2", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Merge generated PDFs together
   * 
   * @param data  (required)
   * @param wait Wait for combined submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return CreateCombinedSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public CreateCombinedSubmissionResponse combineSubmissions(CombinedSubmissionData data, Boolean wait) throws ApiException {
    return combineSubmissionsWithHttpInfo(data, wait).getData();
  }

  /**
   * Merge generated PDFs together
   * 
   * @param data  (required)
   * @param wait Wait for combined submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;CreateCombinedSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> combined submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> invalid JSON </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CreateCombinedSubmissionResponse> combineSubmissionsWithHttpInfo(CombinedSubmissionData data, Boolean wait) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling combineSubmissions");
    }

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateCombinedSubmissionResponse> localVarReturnType = new GenericType<CreateCombinedSubmissionResponse>() {};
    return apiClient.invokeAPI("PdfApi.combineSubmissions", "/combined_submissions", "POST", localVarQueryParams, data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Copy a Template
   * 
   * @param templateId  (required)
   * @param options  (optional)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> copy template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview copyTemplate(String templateId, CopyTemplateOptions options) throws ApiException {
    return copyTemplateWithHttpInfo(templateId, options).getData();
  }

  /**
   * Copy a Template
   * 
   * @param templateId  (required)
   * @param options  (optional)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> copy template success </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> folder not found </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> copyTemplateWithHttpInfo(String templateId, CopyTemplateOptions options) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.copyTemplate", localVarPath, "POST", new ArrayList<>(), options,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new custom file from a cached presign upload
   * 
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
   */
  public CreateCustomFileResponse createCustomFileFromUpload(CreateCustomFileData data) throws ApiException {
    return createCustomFileFromUploadWithHttpInfo(data).getData();
  }

  /**
   * Create a new custom file from a cached presign upload
   * 
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
   */
  public ApiResponse<CreateCustomFileResponse> createCustomFileFromUploadWithHttpInfo(CreateCustomFileData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createCustomFileFromUpload");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateCustomFileResponse> localVarReturnType = new GenericType<CreateCustomFileResponse>() {};
    return apiClient.invokeAPI("PdfApi.createCustomFileFromUpload", "/custom_files", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Creates a new event for emailing a signee a request for signature
   * 
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
   */
  public CreateSubmissionDataRequestEventResponse createDataRequestEvent(String dataRequestId, CreateSubmissionDataRequestEventRequest event) throws ApiException {
    return createDataRequestEventWithHttpInfo(dataRequestId, event).getData();
  }

  /**
   * Creates a new event for emailing a signee a request for signature
   * 
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
   */
  public ApiResponse<CreateSubmissionDataRequestEventResponse> createDataRequestEventWithHttpInfo(String dataRequestId, CreateSubmissionDataRequestEventRequest event) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.createDataRequestEvent", localVarPath, "POST", new ArrayList<>(), event,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Creates a new data request token for form authentication
   * 
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
   */
  public CreateSubmissionDataRequestTokenResponse createDataRequestToken(String dataRequestId, String type) throws ApiException {
    return createDataRequestTokenWithHttpInfo(dataRequestId, type).getData();
  }

  /**
   * Creates a new data request token for form authentication
   * 
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
   */
  public ApiResponse<CreateSubmissionDataRequestTokenResponse> createDataRequestTokenWithHttpInfo(String dataRequestId, String type) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.createDataRequestToken", localVarPath, "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a folder
   * 
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
  public Folder createFolder(CreateFolderData data) throws ApiException {
    return createFolderWithHttpInfo(data).getData();
  }

  /**
   * Create a folder
   * 
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
  public ApiResponse<Folder> createFolderWithHttpInfo(CreateFolderData data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createFolder");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<Folder> localVarReturnType = new GenericType<Folder>() {};
    return apiClient.invokeAPI("PdfApi.createFolder", "/folders/", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new HTML template
   * 
   * @param data  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a created template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview createHTMLTemplate(CreateHtmlTemplate data) throws ApiException {
    return createHTMLTemplateWithHttpInfo(data).getData();
  }

  /**
   * Create a new HTML template
   * 
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a created template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createHTMLTemplateWithHttpInfo(CreateHtmlTemplate data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createHTMLTemplate");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("PdfApi.createHTMLTemplate", "/templates?endpoint_description=html", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new PDF template with a form POST file upload
   * 
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
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview createPDFTemplate(File templateDocument, String templateName, Boolean wait, String templateDescription, String templateParentFolderId) throws ApiException {
    return createPDFTemplateWithHttpInfo(templateDocument, templateName, wait, templateDescription, templateParentFolderId).getData();
  }

  /**
   * Create a new PDF template with a form POST file upload
   * 
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
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createPDFTemplateWithHttpInfo(File templateDocument, String templateName, Boolean wait, String templateDescription, String templateParentFolderId) throws ApiException {
    // Check required parameters
    if (templateDocument == null) {
      throw new ApiException(400, "Missing the required parameter 'templateDocument' when calling createPDFTemplate");
    }
    if (templateName == null) {
      throw new ApiException(400, "Missing the required parameter 'templateName' when calling createPDFTemplate");
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
    return apiClient.invokeAPI("PdfApi.createPDFTemplate", "/templates", "POST", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create a new PDF template from a cached presign upload
   * 
   * @param data  (required)
   * @return TemplatePreview
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public TemplatePreview createPDFTemplateFromUpload(CreatePdfTemplate data) throws ApiException {
    return createPDFTemplateFromUploadWithHttpInfo(data).getData();
  }

  /**
   * Create a new PDF template from a cached presign upload
   * 
   * @param data  (required)
   * @return ApiResponse&lt;TemplatePreview&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> returns a pending template </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TemplatePreview> createPDFTemplateFromUploadWithHttpInfo(CreatePdfTemplate data) throws ApiException {
    // Check required parameters
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling createPDFTemplateFromUpload");
    }

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<TemplatePreview> localVarReturnType = new GenericType<TemplatePreview>() {};
    return apiClient.invokeAPI("PdfApi.createPDFTemplateFromUpload", "/templates?endpoint_description=cached_upload", "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a folder
   * 
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
  public Folder deleteFolder(String folderId) throws ApiException {
    return deleteFolderWithHttpInfo(folderId).getData();
  }

  /**
   * Delete a folder
   * 
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
  public ApiResponse<Folder> deleteFolderWithHttpInfo(String folderId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.deleteFolder", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete a template
   * 
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
  public TemplateDeleteResponse deleteTemplate(String templateId, String version) throws ApiException {
    return deleteTemplateWithHttpInfo(templateId, version).getData();
  }

  /**
   * Delete a template
   * 
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
  public ApiResponse<TemplateDeleteResponse> deleteTemplateWithHttpInfo(String templateId, String version) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.deleteTemplate", localVarPath, "DELETE", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Expire a combined submission
   * 
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
   */
  public CombinedSubmission expireCombinedSubmission(String combinedSubmissionId) throws ApiException {
    return expireCombinedSubmissionWithHttpInfo(combinedSubmissionId).getData();
  }

  /**
   * Expire a combined submission
   * 
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
   */
  public ApiResponse<CombinedSubmission> expireCombinedSubmissionWithHttpInfo(String combinedSubmissionId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.expireCombinedSubmission", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Expire a PDF submission
   * 
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
  public SubmissionPreview expireSubmission(String submissionId) throws ApiException {
    return expireSubmissionWithHttpInfo(submissionId).getData();
  }

  /**
   * Expire a PDF submission
   * 
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
  public ApiResponse<SubmissionPreview> expireSubmissionWithHttpInfo(String submissionId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.expireSubmission", localVarPath, "DELETE", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generates a new PDF
   * 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return CreateSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public CreateSubmissionResponse generatePdf(String templateId, CreatePdfSubmissionData submission, Boolean wait) throws ApiException {
    return generatePdfWithHttpInfo(templateId, submission, wait).getData();
  }

  /**
   * Generates a new PDF
   * 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;CreateSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
       <tr><td> 422 </td><td> invalid request </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CreateSubmissionResponse> generatePdfWithHttpInfo(String templateId, CreatePdfSubmissionData submission, Boolean wait) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.generatePdf", localVarPath, "POST", localVarQueryParams, submission,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generates a new PDF for an HTML template
   * 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return CreateSubmissionResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
     </table>
   */
  public CreateSubmissionResponse generatePdfForHtmlTemplate(String templateId, CreateHtmlSubmissionData submission, Boolean wait) throws ApiException {
    return generatePdfForHtmlTemplateWithHttpInfo(templateId, submission, wait).getData();
  }

  /**
   * Generates a new PDF for an HTML template
   * 
   * @param templateId  (required)
   * @param submission  (required)
   * @param wait Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) (optional, default to true)
   * @return ApiResponse&lt;CreateSubmissionResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 201 </td><td> submission created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CreateSubmissionResponse> generatePdfForHtmlTemplateWithHttpInfo(String templateId, CreateHtmlSubmissionData submission, Boolean wait) throws ApiException {
    // Check required parameters
    if (templateId == null) {
      throw new ApiException(400, "Missing the required parameter 'templateId' when calling generatePdfForHtmlTemplate");
    }
    if (submission == null) {
      throw new ApiException(400, "Missing the required parameter 'submission' when calling generatePdfForHtmlTemplate");
    }

    // Path parameters
    String localVarPath = "/templates/{template_id}/submissions?endpoint_description=html_templates"
            .replaceAll("\\{template_id}", apiClient.escapeString(templateId.toString()));

    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "wait", wait)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType("application/json");
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<CreateSubmissionResponse> localVarReturnType = new GenericType<CreateSubmissionResponse>() {};
    return apiClient.invokeAPI("PdfApi.generatePdfForHtmlTemplate", localVarPath, "POST", localVarQueryParams, submission,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Generated a preview PDF for partially completed data requests
   * 
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
  public SuccessErrorResponse generatePreview(String submissionId) throws ApiException {
    return generatePreviewWithHttpInfo(submissionId).getData();
  }

  /**
   * Generated a preview PDF for partially completed data requests
   * 
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
  public ApiResponse<SuccessErrorResponse> generatePreviewWithHttpInfo(String submissionId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.generatePreview", localVarPath, "POST", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a combined submission (merged PDFs)
   * 
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
   */
  public CombinedSubmission getCombinedSubmission(String combinedSubmissionId) throws ApiException {
    return getCombinedSubmissionWithHttpInfo(combinedSubmissionId).getData();
  }

  /**
   * Check the status of a combined submission (merged PDFs)
   * 
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
   */
  public ApiResponse<CombinedSubmission> getCombinedSubmissionWithHttpInfo(String combinedSubmissionId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getCombinedSubmission", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Look up a submission data request
   * 
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
  public SubmissionDataRequestShow getDataRequest(String dataRequestId) throws ApiException {
    return getDataRequestWithHttpInfo(dataRequestId).getData();
  }

  /**
   * Look up a submission data request
   * 
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
  public ApiResponse<SubmissionDataRequestShow> getDataRequestWithHttpInfo(String dataRequestId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getDataRequest", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Fetch the full attributes for a PDF template
   * 
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
  public Template getFullTemplate(String templateId) throws ApiException {
    return getFullTemplateWithHttpInfo(templateId).getData();
  }

  /**
   * Fetch the full attributes for a PDF template
   * 
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
  public ApiResponse<Template> getFullTemplateWithHttpInfo(String templateId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getFullTemplate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a presigned URL so that you can upload a file to our AWS S3 bucket
   * 
   * @return UploadPresignResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presign URL generated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public UploadPresignResponse getPresignUrl() throws ApiException {
    return getPresignUrlWithHttpInfo().getData();
  }

  /**
   * Get a presigned URL so that you can upload a file to our AWS S3 bucket
   * 
   * @return ApiResponse&lt;UploadPresignResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> presign URL generated </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<UploadPresignResponse> getPresignUrlWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<UploadPresignResponse> localVarReturnType = new GenericType<UploadPresignResponse>() {};
    return apiClient.invokeAPI("PdfApi.getPresignUrl", "/uploads/presign", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a PDF
   * 
   * @param submissionId  (required)
   * @param includeData  (optional)
   * @return Submission
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public Submission getSubmission(String submissionId, Boolean includeData) throws ApiException {
    return getSubmissionWithHttpInfo(submissionId, includeData).getData();
  }

  /**
   * Check the status of a PDF
   * 
   * @param submissionId  (required)
   * @param includeData  (optional)
   * @return ApiResponse&lt;Submission&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> processed submission found </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> submission not found </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Submission> getSubmissionWithHttpInfo(String submissionId, Boolean includeData) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getSubmission", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of a submission batch job
   * 
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
  public SubmissionBatchWithSubmissions getSubmissionBatch(String submissionBatchId, Boolean includeSubmissions) throws ApiException {
    return getSubmissionBatchWithHttpInfo(submissionBatchId, includeSubmissions).getData();
  }

  /**
   * Check the status of a submission batch job
   * 
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
  public ApiResponse<SubmissionBatchWithSubmissions> getSubmissionBatchWithHttpInfo(String submissionBatchId, Boolean includeSubmissions) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getSubmissionBatch", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Check the status of an uploaded template
   * 
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
  public TemplatePreview getTemplate(String templateId) throws ApiException {
    return getTemplateWithHttpInfo(templateId).getData();
  }

  /**
   * Check the status of an uploaded template
   * 
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
  public ApiResponse<TemplatePreview> getTemplateWithHttpInfo(String templateId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getTemplate", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Fetch the JSON schema for a template
   * 
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
  public JsonSchema getTemplateSchema(String templateId) throws ApiException {
    return getTemplateSchemaWithHttpInfo(templateId).getData();
  }

  /**
   * Fetch the JSON schema for a template
   * 
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
  public ApiResponse<JsonSchema> getTemplateSchemaWithHttpInfo(String templateId) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.getTemplateSchema", localVarPath, "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all combined submissions
   * 
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
   */
  public List<CombinedSubmission> listCombinedSubmissions(Integer page, Integer perPage) throws ApiException {
    return listCombinedSubmissionsWithHttpInfo(page, perPage).getData();
  }

  /**
   * Get a list of all combined submissions
   * 
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
   */
  public ApiResponse<List<CombinedSubmission>> listCombinedSubmissionsWithHttpInfo(Integer page, Integer perPage) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "page", page)
    );
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "per_page", perPage));

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<CombinedSubmission>> localVarReturnType = new GenericType<List<CombinedSubmission>>() {};
    return apiClient.invokeAPI("PdfApi.listCombinedSubmissions", "/combined_submissions", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all folders
   * 
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
  public List<Folder> listFolders(String parentFolderId) throws ApiException {
    return listFoldersWithHttpInfo(parentFolderId).getData();
  }

  /**
   * Get a list of all folders
   * 
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
  public ApiResponse<List<Folder>> listFoldersWithHttpInfo(String parentFolderId) throws ApiException {
    // Query parameters
    List<Pair> localVarQueryParams = new ArrayList<>(
            apiClient.parameterToPairs("", "parent_folder_id", parentFolderId)
    );

    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<List<Folder>> localVarReturnType = new GenericType<List<Folder>>() {};
    return apiClient.invokeAPI("PdfApi.listFolders", "/folders/", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List all submissions
   * 
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
  public ListSubmissionsResponse listSubmissions(String cursor, BigDecimal limit, String createdAfter, String createdBefore, String type, Boolean includeData) throws ApiException {
    return listSubmissionsWithHttpInfo(cursor, limit, createdAfter, createdBefore, type, includeData).getData();
  }

  /**
   * List all submissions
   * 
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
  public ApiResponse<ListSubmissionsResponse> listSubmissionsWithHttpInfo(String cursor, BigDecimal limit, String createdAfter, String createdBefore, String type, Boolean includeData) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.listSubmissions", "/submissions", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * List all submissions for a given template
   * 
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
  public ListSubmissionsResponse listTemplateSubmissions(String templateId, String cursor, BigDecimal limit, String createdAfter, String createdBefore, String type, Boolean includeData) throws ApiException {
    return listTemplateSubmissionsWithHttpInfo(templateId, cursor, limit, createdAfter, createdBefore, type, includeData).getData();
  }

  /**
   * List all submissions for a given template
   * 
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
  public ApiResponse<ListSubmissionsResponse> listTemplateSubmissionsWithHttpInfo(String templateId, String cursor, BigDecimal limit, String createdAfter, String createdBefore, String type, Boolean includeData) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.listTemplateSubmissions", localVarPath, "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get a list of all templates
   * 
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
  public List<TemplatePreview> listTemplates(String query, String parentFolderId, Integer page, Integer perPage) throws ApiException {
    return listTemplatesWithHttpInfo(query, parentFolderId, page, perPage).getData();
  }

  /**
   * Get a list of all templates
   * 
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
  public ApiResponse<List<TemplatePreview>> listTemplatesWithHttpInfo(String query, String parentFolderId, Integer page, Integer perPage) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.listTemplates", "/templates", "GET", localVarQueryParams, null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move a folder
   * 
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
  public Folder moveFolderToFolder(String folderId, MoveFolderData data) throws ApiException {
    return moveFolderToFolderWithHttpInfo(folderId, data).getData();
  }

  /**
   * Move a folder
   * 
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
  public ApiResponse<Folder> moveFolderToFolderWithHttpInfo(String folderId, MoveFolderData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.moveFolderToFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Move Template to folder
   * 
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
  public TemplatePreview moveTemplateToFolder(String templateId, MoveTemplateData data) throws ApiException {
    return moveTemplateToFolderWithHttpInfo(templateId, data).getData();
  }

  /**
   * Move Template to folder
   * 
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
  public ApiResponse<TemplatePreview> moveTemplateToFolderWithHttpInfo(String templateId, MoveTemplateData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.moveTemplateToFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Publish a template version
   * 
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
  public TemplatePublishVersionResponse publishTemplateVersion(String templateId, PublishVersionData data) throws ApiException {
    return publishTemplateVersionWithHttpInfo(templateId, data).getData();
  }

  /**
   * Publish a template version
   * 
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
  public ApiResponse<TemplatePublishVersionResponse> publishTemplateVersionWithHttpInfo(String templateId, PublishVersionData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.publishTemplateVersion", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Rename a folder
   * 
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
  public Folder renameFolder(String folderId, RenameFolderData data) throws ApiException {
    return renameFolderWithHttpInfo(folderId, data).getData();
  }

  /**
   * Rename a folder
   * 
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
  public ApiResponse<Folder> renameFolderWithHttpInfo(String folderId, RenameFolderData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.renameFolder", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Restore a template version
   * 
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
  public SuccessErrorResponse restoreTemplateVersion(String templateId, RestoreVersionData data) throws ApiException {
    return restoreTemplateVersionWithHttpInfo(templateId, data).getData();
  }

  /**
   * Restore a template version
   * 
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
  public ApiResponse<SuccessErrorResponse> restoreTemplateVersionWithHttpInfo(String templateId, RestoreVersionData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.restoreTemplateVersion", localVarPath, "POST", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Test Authentication
   * 
   * @return SuccessErrorResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public SuccessErrorResponse testAuthentication() throws ApiException {
    return testAuthenticationWithHttpInfo().getData();
  }

  /**
   * Test Authentication
   * 
   * @return ApiResponse&lt;SuccessErrorResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> authentication succeeded </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> authentication failed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessErrorResponse> testAuthenticationWithHttpInfo() throws ApiException {
    String localVarAccept = apiClient.selectHeaderAccept("application/json");
    String localVarContentType = apiClient.selectHeaderContentType();
    String[] localVarAuthNames = new String[] {"api_token_basic"};
    GenericType<SuccessErrorResponse> localVarReturnType = new GenericType<SuccessErrorResponse>() {};
    return apiClient.invokeAPI("PdfApi.testAuthentication", "/authentication", "GET", new ArrayList<>(), null,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a submission data request
   * 
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
   */
  public CreateSubmissionDataRequestResponse updateDataRequest(String dataRequestId, UpdateSubmissionDataRequestData data) throws ApiException {
    return updateDataRequestWithHttpInfo(dataRequestId, data).getData();
  }

  /**
   * Update a submission data request
   * 
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
   */
  public ApiResponse<CreateSubmissionDataRequestResponse> updateDataRequestWithHttpInfo(String dataRequestId, UpdateSubmissionDataRequestData data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.updateDataRequest", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update a Template
   * 
   * @param templateId  (required)
   * @param data  (required)
   * @return SuccessMultipleErrorsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> update template success </td><td>  -  </td></tr>
     </table>
   */
  public SuccessMultipleErrorsResponse updateTemplate(String templateId, UpdateHtmlTemplate data) throws ApiException {
    return updateTemplateWithHttpInfo(templateId, data).getData();
  }

  /**
   * Update a Template
   * 
   * @param templateId  (required)
   * @param data  (required)
   * @return ApiResponse&lt;SuccessMultipleErrorsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> update template success </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SuccessMultipleErrorsResponse> updateTemplateWithHttpInfo(String templateId, UpdateHtmlTemplate data) throws ApiException {
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
    return apiClient.invokeAPI("PdfApi.updateTemplate", localVarPath, "PUT", new ArrayList<>(), data,
                               new LinkedHashMap<>(), new LinkedHashMap<>(), new LinkedHashMap<>(), localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
