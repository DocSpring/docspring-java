package com.docspring;

import com.docspring.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.docspring.AddFieldsData;
import com.docspring.AddFieldsTemplateResponse;
import com.docspring.AuthenticationError;
import com.docspring.AuthenticationSuccessResponse;
import com.docspring.CombinePdfsData;
import com.docspring.CombinedSubmission;
import com.docspring.CombinedSubmissionData;
import com.docspring.CreateCombinedSubmissionResponse;
import com.docspring.CreateCustomFileData;
import com.docspring.CreateCustomFileResponse;
import com.docspring.CreateFolderData;
import com.docspring.CreateHtmlTemplateData;
import com.docspring.CreateSubmissionBatchResponse;
import com.docspring.CreateSubmissionDataRequestTokenResponse;
import com.docspring.CreateSubmissionResponse;
import com.docspring.CreateTemplateFromUploadData;
import com.docspring.Error;
import java.io.File;
import com.docspring.Folder;
import com.docspring.InvalidRequest;
import com.docspring.MoveFolderData;
import com.docspring.MoveTemplateData;
import com.docspring.PendingTemplate;
import com.docspring.RenameFolderData;
import com.docspring.Submission;
import com.docspring.SubmissionBatch;
import com.docspring.SubmissionBatchData;
import com.docspring.SubmissionData;
import com.docspring.SubmissionDataRequest;
import com.docspring.Template;
import com.docspring.UpdateDataRequestResponse;
import com.docspring.UpdateSubmissionDataRequestData;
import com.docspring.UpdateTemplateData;
import com.docspring.UpdateTemplateResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PdfApi {
  /**
   * Add new fields to a Template
   * 
   * @param templateId  (required)
   * @param addFieldsData  (required)
   * @return Call&lt;AddFieldsTemplateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("templates/{template_id}/add_fields")
  Call<AddFieldsTemplateResponse> addFieldsToTemplate(
    @retrofit2.http.Path("template_id") String templateId, @retrofit2.http.Body AddFieldsData addFieldsData
  );

  /**
   * Generates multiple PDFs
   * 
   * @param templateId  (required)
   * @param requestBody  (required)
   * @return Call&lt;List&lt;CreateSubmissionResponse&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("templates/{template_id}/submissions/batch")
  Call<List<CreateSubmissionResponse>> batchGeneratePdfV1(
    @retrofit2.http.Path("template_id") String templateId, @retrofit2.http.Body List<Object> requestBody
  );

  /**
   * Generates multiple PDFs
   * 
   * @param submissionBatchData  (required)
   * @return Call&lt;CreateSubmissionBatchResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("submissions/batches")
  Call<CreateSubmissionBatchResponse> batchGeneratePdfs(
    @retrofit2.http.Body SubmissionBatchData submissionBatchData
  );

  /**
   * Merge submission PDFs, template PDFs, or custom files
   * 
   * @param combinePdfsData  (required)
   * @return Call&lt;CreateCombinedSubmissionResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("combined_submissions?v=2")
  Call<CreateCombinedSubmissionResponse> combinePdfs(
    @retrofit2.http.Body CombinePdfsData combinePdfsData
  );

  /**
   * Merge generated PDFs together
   * 
   * @param combinedSubmissionData  (required)
   * @return Call&lt;CreateCombinedSubmissionResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("combined_submissions")
  Call<CreateCombinedSubmissionResponse> combineSubmissions(
    @retrofit2.http.Body CombinedSubmissionData combinedSubmissionData
  );

  /**
   * Create a new custom file from a cached presign upload
   * 
   * @param createCustomFileData  (required)
   * @return Call&lt;CreateCustomFileResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("custom_files")
  Call<CreateCustomFileResponse> createCustomFileFromUpload(
    @retrofit2.http.Body CreateCustomFileData createCustomFileData
  );

  /**
   * Creates a new data request token for form authentication
   * 
   * @param dataRequestId  (required)
   * @return Call&lt;CreateSubmissionDataRequestTokenResponse&gt;
   */
  @POST("data_requests/{data_request_id}/tokens")
  Call<CreateSubmissionDataRequestTokenResponse> createDataRequestToken(
    @retrofit2.http.Path("data_request_id") String dataRequestId
  );

  /**
   * Create a folder
   * 
   * @param createFolderData  (required)
   * @return Call&lt;Folder&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("folders/")
  Call<Folder> createFolder(
    @retrofit2.http.Body CreateFolderData createFolderData
  );

  /**
   * Create a new HTML template
   * 
   * @param createHtmlTemplateData  (required)
   * @return Call&lt;PendingTemplate&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("templates?desc=html")
  Call<PendingTemplate> createHTMLTemplate(
    @retrofit2.http.Body CreateHtmlTemplateData createHtmlTemplateData
  );

  /**
   * Create a new PDF template with a form POST file upload
   * 
   * @param templateDocument  (required)
   * @param templateName  (required)
   * @param templateParentFolderId  (optional, default to null)
   * @return Call&lt;PendingTemplate&gt;
   */
  @retrofit2.http.Multipart
  @POST("templates")
  Call<PendingTemplate> createPDFTemplate(
    @retrofit2.http.Part("template[document]") MultipartBody.Part templateDocument, @retrofit2.http.Part("template[name]") String templateName, @retrofit2.http.Part("template[parent_folder_id]") String templateParentFolderId
  );

  /**
   * Create a new PDF template from a cached presign upload
   * 
   * @param createTemplateFromUploadData  (required)
   * @return Call&lt;PendingTemplate&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("templates?desc=cached_upload")
  Call<PendingTemplate> createPDFTemplateFromUpload(
    @retrofit2.http.Body CreateTemplateFromUploadData createTemplateFromUploadData
  );

  /**
   * Delete a folder
   * 
   * @param folderId  (required)
   * @return Call&lt;Folder&gt;
   */
  @DELETE("folders/{folder_id}")
  Call<Folder> deleteFolder(
    @retrofit2.http.Path("folder_id") String folderId
  );

  /**
   * Expire a combined submission
   * 
   * @param combinedSubmissionId  (required)
   * @return Call&lt;CombinedSubmission&gt;
   */
  @DELETE("combined_submissions/{combined_submission_id}")
  Call<CombinedSubmission> expireCombinedSubmission(
    @retrofit2.http.Path("combined_submission_id") String combinedSubmissionId
  );

  /**
   * Expire a PDF submission
   * 
   * @param submissionId  (required)
   * @return Call&lt;Submission&gt;
   */
  @DELETE("submissions/{submission_id}")
  Call<Submission> expireSubmission(
    @retrofit2.http.Path("submission_id") String submissionId
  );

  /**
   * Generates a new PDF
   * 
   * @param templateId  (required)
   * @param submissionData  (required)
   * @return Call&lt;CreateSubmissionResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("templates/{template_id}/submissions")
  Call<CreateSubmissionResponse> generatePDF(
    @retrofit2.http.Path("template_id") String templateId, @retrofit2.http.Body SubmissionData submissionData
  );

  /**
   * Check the status of a combined submission (merged PDFs)
   * 
   * @param combinedSubmissionId  (required)
   * @return Call&lt;CombinedSubmission&gt;
   */
  @GET("combined_submissions/{combined_submission_id}")
  Call<CombinedSubmission> getCombinedSubmission(
    @retrofit2.http.Path("combined_submission_id") String combinedSubmissionId
  );

  /**
   * Look up a submission data request
   * 
   * @param dataRequestId  (required)
   * @return Call&lt;SubmissionDataRequest&gt;
   */
  @GET("data_requests/{data_request_id}")
  Call<SubmissionDataRequest> getDataRequest(
    @retrofit2.http.Path("data_request_id") String dataRequestId
  );

  /**
   * Get a presigned URL so that you can upload a file to our AWS S3 bucket
   * 
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("uploads/presign")
  Call<Map<String, Object>> getPresignUrl();
    

  /**
   * Check the status of a PDF
   * 
   * @param submissionId  (required)
   * @param includeData  (optional)
   * @return Call&lt;Submission&gt;
   */
  @GET("submissions/{submission_id}")
  Call<Submission> getSubmission(
    @retrofit2.http.Path("submission_id") String submissionId, @retrofit2.http.Query("include_data") Boolean includeData
  );

  /**
   * Check the status of a submission batch job
   * 
   * @param submissionBatchId  (required)
   * @param includeSubmissions  (optional)
   * @return Call&lt;SubmissionBatch&gt;
   */
  @GET("submissions/batches/{submission_batch_id}")
  Call<SubmissionBatch> getSubmissionBatch(
    @retrofit2.http.Path("submission_batch_id") String submissionBatchId, @retrofit2.http.Query("include_submissions") Boolean includeSubmissions
  );

  /**
   * Get a single template
   * 
   * @param templateId  (required)
   * @return Call&lt;Template&gt;
   */
  @GET("templates/{template_id}")
  Call<Template> getTemplate(
    @retrofit2.http.Path("template_id") String templateId
  );

  /**
   * Fetch the JSON schema for a template
   * 
   * @param templateId  (required)
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("templates/{template_id}/schema")
  Call<Map<String, Object>> getTemplateSchema(
    @retrofit2.http.Path("template_id") String templateId
  );

  /**
   * Get a list of all folders
   * 
   * @param parentFolderId Filter By Folder Id (optional)
   * @return Call&lt;List&lt;Folder&gt;&gt;
   */
  @GET("folders/")
  Call<List<Folder>> listFolders(
    @retrofit2.http.Query("parent_folder_id") String parentFolderId
  );

  /**
   * Get a list of all templates
   * 
   * @param query Search By Name (optional)
   * @param parentFolderId Filter By Folder Id (optional)
   * @param page Default: 1 (optional)
   * @param perPage Default: 50 (optional)
   * @return Call&lt;List&lt;Template&gt;&gt;
   */
  @GET("templates")
  Call<List<Template>> listTemplates(
    @retrofit2.http.Query("query") String query, @retrofit2.http.Query("parent_folder_id") String parentFolderId, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("per_page") Integer perPage
  );

  /**
   * Move a folder
   * 
   * @param folderId  (required)
   * @param moveFolderData  (required)
   * @return Call&lt;Folder&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("folders/{folder_id}/move")
  Call<Folder> moveFolderToFolder(
    @retrofit2.http.Path("folder_id") String folderId, @retrofit2.http.Body MoveFolderData moveFolderData
  );

  /**
   * Move Template to folder
   * 
   * @param templateId  (required)
   * @param moveTemplateData  (required)
   * @return Call&lt;Template&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("templates/{template_id}/move")
  Call<Template> moveTemplateToFolder(
    @retrofit2.http.Path("template_id") String templateId, @retrofit2.http.Body MoveTemplateData moveTemplateData
  );

  /**
   * Rename a folder
   * 
   * @param folderId  (required)
   * @param renameFolderData  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("folders/{folder_id}/rename")
  Call<Void> renameFolder(
    @retrofit2.http.Path("folder_id") String folderId, @retrofit2.http.Body RenameFolderData renameFolderData
  );

  /**
   * Test Authentication
   * 
   * @return Call&lt;AuthenticationSuccessResponse&gt;
   */
  @GET("authentication")
  Call<AuthenticationSuccessResponse> testAuthentication();
    

  /**
   * Update a submission data request
   * 
   * @param dataRequestId  (required)
   * @param updateSubmissionDataRequestData  (required)
   * @return Call&lt;UpdateDataRequestResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("data_requests/{data_request_id}")
  Call<UpdateDataRequestResponse> updateDataRequest(
    @retrofit2.http.Path("data_request_id") String dataRequestId, @retrofit2.http.Body UpdateSubmissionDataRequestData updateSubmissionDataRequestData
  );

  /**
   * Update a Template
   * 
   * @param templateId  (required)
   * @param updateTemplateData  (required)
   * @return Call&lt;UpdateTemplateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("templates/{template_id}")
  Call<UpdateTemplateResponse> updateTemplate(
    @retrofit2.http.Path("template_id") String templateId, @retrofit2.http.Body UpdateTemplateData updateTemplateData
  );

}
