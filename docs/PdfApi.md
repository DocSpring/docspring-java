# PdfApi

All URIs are relative to *https://api.docspring.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFieldsToTemplate**](PdfApi.md#addFieldsToTemplate) | **PUT** templates/{template_id}/add_fields | Add new fields to a Template
[**batchGeneratePdfV1**](PdfApi.md#batchGeneratePdfV1) | **POST** templates/{template_id}/submissions/batch | Generates multiple PDFs
[**batchGeneratePdfs**](PdfApi.md#batchGeneratePdfs) | **POST** submissions/batches | Generates multiple PDFs
[**combinePdfs**](PdfApi.md#combinePdfs) | **POST** combined_submissions?v&#x3D;2 | Merge submission PDFs, template PDFs, or custom files
[**combineSubmissions**](PdfApi.md#combineSubmissions) | **POST** combined_submissions | Merge generated PDFs together
[**createCustomFileFromUpload**](PdfApi.md#createCustomFileFromUpload) | **POST** custom_files | Create a new custom file from a cached presign upload
[**createDataRequestToken**](PdfApi.md#createDataRequestToken) | **POST** data_requests/{data_request_id}/tokens | Creates a new data request token for form authentication
[**createFolder**](PdfApi.md#createFolder) | **POST** folders/ | Create a folder
[**createHTMLTemplate**](PdfApi.md#createHTMLTemplate) | **POST** templates?desc&#x3D;html | Create a new HTML template
[**createPDFTemplate**](PdfApi.md#createPDFTemplate) | **POST** templates | Create a new PDF template with a form POST file upload
[**createPDFTemplateFromUpload**](PdfApi.md#createPDFTemplateFromUpload) | **POST** templates?desc&#x3D;cached_upload | Create a new PDF template from a cached presign upload
[**deleteFolder**](PdfApi.md#deleteFolder) | **DELETE** folders/{folder_id} | Delete a folder
[**expireCombinedSubmission**](PdfApi.md#expireCombinedSubmission) | **DELETE** combined_submissions/{combined_submission_id} | Expire a combined submission
[**expireSubmission**](PdfApi.md#expireSubmission) | **DELETE** submissions/{submission_id} | Expire a PDF submission
[**generatePDF**](PdfApi.md#generatePDF) | **POST** templates/{template_id}/submissions | Generates a new PDF
[**getCombinedSubmission**](PdfApi.md#getCombinedSubmission) | **GET** combined_submissions/{combined_submission_id} | Check the status of a combined submission (merged PDFs)
[**getDataRequest**](PdfApi.md#getDataRequest) | **GET** data_requests/{data_request_id} | Look up a submission data request
[**getPresignUrl**](PdfApi.md#getPresignUrl) | **GET** uploads/presign | Get a presigned URL so that you can upload a file to our AWS S3 bucket
[**getSubmission**](PdfApi.md#getSubmission) | **GET** submissions/{submission_id} | Check the status of a PDF
[**getSubmissionBatch**](PdfApi.md#getSubmissionBatch) | **GET** submissions/batches/{submission_batch_id} | Check the status of a submission batch job
[**getTemplate**](PdfApi.md#getTemplate) | **GET** templates/{template_id} | Get a single template
[**getTemplateSchema**](PdfApi.md#getTemplateSchema) | **GET** templates/{template_id}/schema | Fetch the JSON schema for a template
[**listFolders**](PdfApi.md#listFolders) | **GET** folders/ | Get a list of all folders
[**listTemplates**](PdfApi.md#listTemplates) | **GET** templates | Get a list of all templates
[**moveFolderToFolder**](PdfApi.md#moveFolderToFolder) | **POST** folders/{folder_id}/move | Move a folder
[**moveTemplateToFolder**](PdfApi.md#moveTemplateToFolder) | **POST** templates/{template_id}/move | Move Template to folder
[**renameFolder**](PdfApi.md#renameFolder) | **POST** folders/{folder_id}/rename | Rename a folder
[**testAuthentication**](PdfApi.md#testAuthentication) | **GET** authentication | Test Authentication
[**updateDataRequest**](PdfApi.md#updateDataRequest) | **PUT** data_requests/{data_request_id} | Update a submission data request
[**updateTemplate**](PdfApi.md#updateTemplate) | **PUT** templates/{template_id} | Update a Template


<a name="addFieldsToTemplate"></a>
# **addFieldsToTemplate**
> AddFieldsTemplateResponse addFieldsToTemplate(templateId, addFieldsData)

Add new fields to a Template

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000002; // String | 
AddFieldsData addFieldsData = new AddFieldsData(); // AddFieldsData | 
try {
    AddFieldsTemplateResponse result = apiInstance.addFieldsToTemplate(templateId, addFieldsData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#addFieldsToTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |
 **addFieldsData** | [**AddFieldsData**](AddFieldsData.md)|  |

### Return type

[**AddFieldsTemplateResponse**](AddFieldsTemplateResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="batchGeneratePdfV1"></a>
# **batchGeneratePdfV1**
> List&lt;CreateSubmissionResponse&gt; batchGeneratePdfV1(templateId, requestBody)

Generates multiple PDFs

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000001; // String | 
List<Object> requestBody = Arrays.asList(new List()); // List<Object> | 
try {
    List<CreateSubmissionResponse> result = apiInstance.batchGeneratePdfV1(templateId, requestBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#batchGeneratePdfV1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |
 **requestBody** | [**List&lt;Object&gt;**](List.md)|  |

### Return type

[**List&lt;CreateSubmissionResponse&gt;**](CreateSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="batchGeneratePdfs"></a>
# **batchGeneratePdfs**
> CreateSubmissionBatchResponse batchGeneratePdfs(submissionBatchData)

Generates multiple PDFs

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
SubmissionBatchData submissionBatchData = new SubmissionBatchData(); // SubmissionBatchData | 
try {
    CreateSubmissionBatchResponse result = apiInstance.batchGeneratePdfs(submissionBatchData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#batchGeneratePdfs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submissionBatchData** | [**SubmissionBatchData**](SubmissionBatchData.md)|  |

### Return type

[**CreateSubmissionBatchResponse**](CreateSubmissionBatchResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="combinePdfs"></a>
# **combinePdfs**
> CreateCombinedSubmissionResponse combinePdfs(combinePdfsData)

Merge submission PDFs, template PDFs, or custom files

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CombinePdfsData combinePdfsData = new CombinePdfsData(); // CombinePdfsData | 
try {
    CreateCombinedSubmissionResponse result = apiInstance.combinePdfs(combinePdfsData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#combinePdfs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **combinePdfsData** | [**CombinePdfsData**](CombinePdfsData.md)|  |

### Return type

[**CreateCombinedSubmissionResponse**](CreateCombinedSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="combineSubmissions"></a>
# **combineSubmissions**
> CreateCombinedSubmissionResponse combineSubmissions(combinedSubmissionData)

Merge generated PDFs together

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CombinedSubmissionData combinedSubmissionData = new CombinedSubmissionData(); // CombinedSubmissionData | 
try {
    CreateCombinedSubmissionResponse result = apiInstance.combineSubmissions(combinedSubmissionData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#combineSubmissions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **combinedSubmissionData** | [**CombinedSubmissionData**](CombinedSubmissionData.md)|  |

### Return type

[**CreateCombinedSubmissionResponse**](CreateCombinedSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCustomFileFromUpload"></a>
# **createCustomFileFromUpload**
> CreateCustomFileResponse createCustomFileFromUpload(createCustomFileData)

Create a new custom file from a cached presign upload

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CreateCustomFileData createCustomFileData = new CreateCustomFileData(); // CreateCustomFileData | 
try {
    CreateCustomFileResponse result = apiInstance.createCustomFileFromUpload(createCustomFileData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createCustomFileFromUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCustomFileData** | [**CreateCustomFileData**](CreateCustomFileData.md)|  |

### Return type

[**CreateCustomFileResponse**](CreateCustomFileResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createDataRequestToken"></a>
# **createDataRequestToken**
> CreateSubmissionDataRequestTokenResponse createDataRequestToken(dataRequestId)

Creates a new data request token for form authentication

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String dataRequestId = drq_000000000000000001; // String | 
try {
    CreateSubmissionDataRequestTokenResponse result = apiInstance.createDataRequestToken(dataRequestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createDataRequestToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dataRequestId** | **String**|  |

### Return type

[**CreateSubmissionDataRequestTokenResponse**](CreateSubmissionDataRequestTokenResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createFolder"></a>
# **createFolder**
> Folder createFolder(createFolderData)

Create a folder

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CreateFolderData createFolderData = new CreateFolderData(); // CreateFolderData | 
try {
    Folder result = apiInstance.createFolder(createFolderData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createFolderData** | [**CreateFolderData**](CreateFolderData.md)|  |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createHTMLTemplate"></a>
# **createHTMLTemplate**
> PendingTemplate createHTMLTemplate(createHtmlTemplateData)

Create a new HTML template

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CreateHtmlTemplateData createHtmlTemplateData = new CreateHtmlTemplateData(); // CreateHtmlTemplateData | 
try {
    PendingTemplate result = apiInstance.createHTMLTemplate(createHtmlTemplateData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createHTMLTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createHtmlTemplateData** | [**CreateHtmlTemplateData**](CreateHtmlTemplateData.md)|  |

### Return type

[**PendingTemplate**](PendingTemplate.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPDFTemplate"></a>
# **createPDFTemplate**
> PendingTemplate createPDFTemplate(templateDocument, templateName, templateParentFolderId)

Create a new PDF template with a form POST file upload

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
File templateDocument = new File("null"); // File | 
String templateName = "null"; // String | 
String templateParentFolderId = "null"; // String | 
try {
    PendingTemplate result = apiInstance.createPDFTemplate(templateDocument, templateName, templateParentFolderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createPDFTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateDocument** | **File**|  | [default to null]
 **templateName** | **String**|  | [default to null]
 **templateParentFolderId** | **String**|  | [optional] [default to null]

### Return type

[**PendingTemplate**](PendingTemplate.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="createPDFTemplateFromUpload"></a>
# **createPDFTemplateFromUpload**
> PendingTemplate createPDFTemplateFromUpload(createTemplateFromUploadData)

Create a new PDF template from a cached presign upload

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
CreateTemplateFromUploadData createTemplateFromUploadData = new CreateTemplateFromUploadData(); // CreateTemplateFromUploadData | 
try {
    PendingTemplate result = apiInstance.createPDFTemplateFromUpload(createTemplateFromUploadData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#createPDFTemplateFromUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createTemplateFromUploadData** | [**CreateTemplateFromUploadData**](CreateTemplateFromUploadData.md)|  |

### Return type

[**PendingTemplate**](PendingTemplate.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFolder"></a>
# **deleteFolder**
> Folder deleteFolder(folderId)

Delete a folder

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String folderId = fld_000000000000000001; // String | 
try {
    Folder result = apiInstance.deleteFolder(folderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#deleteFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **folderId** | **String**|  |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="expireCombinedSubmission"></a>
# **expireCombinedSubmission**
> CombinedSubmission expireCombinedSubmission(combinedSubmissionId)

Expire a combined submission

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String combinedSubmissionId = com_000000000000000001; // String | 
try {
    CombinedSubmission result = apiInstance.expireCombinedSubmission(combinedSubmissionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#expireCombinedSubmission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **combinedSubmissionId** | **String**|  |

### Return type

[**CombinedSubmission**](CombinedSubmission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="expireSubmission"></a>
# **expireSubmission**
> Submission expireSubmission(submissionId)

Expire a PDF submission

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String submissionId = sub_000000000000000001; // String | 
try {
    Submission result = apiInstance.expireSubmission(submissionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#expireSubmission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submissionId** | **String**|  |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="generatePDF"></a>
# **generatePDF**
> CreateSubmissionResponse generatePDF(templateId, submissionData)

Generates a new PDF

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000001; // String | 
SubmissionData submissionData = new SubmissionData(); // SubmissionData | 
try {
    CreateSubmissionResponse result = apiInstance.generatePDF(templateId, submissionData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#generatePDF");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |
 **submissionData** | [**SubmissionData**](SubmissionData.md)|  |

### Return type

[**CreateSubmissionResponse**](CreateSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCombinedSubmission"></a>
# **getCombinedSubmission**
> CombinedSubmission getCombinedSubmission(combinedSubmissionId)

Check the status of a combined submission (merged PDFs)

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String combinedSubmissionId = com_000000000000000001; // String | 
try {
    CombinedSubmission result = apiInstance.getCombinedSubmission(combinedSubmissionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getCombinedSubmission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **combinedSubmissionId** | **String**|  |

### Return type

[**CombinedSubmission**](CombinedSubmission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDataRequest"></a>
# **getDataRequest**
> SubmissionDataRequest getDataRequest(dataRequestId)

Look up a submission data request

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String dataRequestId = drq_000000000000000001; // String | 
try {
    SubmissionDataRequest result = apiInstance.getDataRequest(dataRequestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getDataRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dataRequestId** | **String**|  |

### Return type

[**SubmissionDataRequest**](SubmissionDataRequest.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPresignUrl"></a>
# **getPresignUrl**
> Map&lt;String, Object&gt; getPresignUrl()

Get a presigned URL so that you can upload a file to our AWS S3 bucket

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
try {
    Map<String, Object> result = apiInstance.getPresignUrl();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getPresignUrl");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Map&lt;String, Object&gt;**

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSubmission"></a>
# **getSubmission**
> Submission getSubmission(submissionId, includeData)

Check the status of a PDF

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String submissionId = sub_000000000000000001; // String | 
Boolean includeData = true; // Boolean | 
try {
    Submission result = apiInstance.getSubmission(submissionId, includeData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getSubmission");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submissionId** | **String**|  |
 **includeData** | **Boolean**|  | [optional]

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSubmissionBatch"></a>
# **getSubmissionBatch**
> SubmissionBatch getSubmissionBatch(submissionBatchId, includeSubmissions)

Check the status of a submission batch job

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String submissionBatchId = sbb_000000000000000001; // String | 
Boolean includeSubmissions = true; // Boolean | 
try {
    SubmissionBatch result = apiInstance.getSubmissionBatch(submissionBatchId, includeSubmissions);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getSubmissionBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submissionBatchId** | **String**|  |
 **includeSubmissions** | **Boolean**|  | [optional]

### Return type

[**SubmissionBatch**](SubmissionBatch.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTemplate"></a>
# **getTemplate**
> Template getTemplate(templateId)

Get a single template

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000011; // String | 
try {
    Template result = apiInstance.getTemplate(templateId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTemplateSchema"></a>
# **getTemplateSchema**
> Map&lt;String, Object&gt; getTemplateSchema(templateId)

Fetch the JSON schema for a template

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000001; // String | 
try {
    Map<String, Object> result = apiInstance.getTemplateSchema(templateId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#getTemplateSchema");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |

### Return type

**Map&lt;String, Object&gt;**

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listFolders"></a>
# **listFolders**
> List&lt;Folder&gt; listFolders(parentFolderId)

Get a list of all folders

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String parentFolderId = fld_000000000000000002; // String | Filter By Folder Id
try {
    List<Folder> result = apiInstance.listFolders(parentFolderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#listFolders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentFolderId** | **String**| Filter By Folder Id | [optional]

### Return type

[**List&lt;Folder&gt;**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listTemplates"></a>
# **listTemplates**
> List&lt;Template&gt; listTemplates(query, parentFolderId, page, perPage)

Get a list of all templates

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String query = 2; // String | Search By Name
String parentFolderId = fld_000000000000000001; // String | Filter By Folder Id
Integer page = 2; // Integer | Default: 1
Integer perPage = 1; // Integer | Default: 50
try {
    List<Template> result = apiInstance.listTemplates(query, parentFolderId, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#listTemplates");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| Search By Name | [optional]
 **parentFolderId** | **String**| Filter By Folder Id | [optional]
 **page** | **Integer**| Default: 1 | [optional]
 **perPage** | **Integer**| Default: 50 | [optional]

### Return type

[**List&lt;Template&gt;**](Template.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="moveFolderToFolder"></a>
# **moveFolderToFolder**
> Folder moveFolderToFolder(folderId, moveFolderData)

Move a folder

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String folderId = fld_000000000000000001; // String | 
MoveFolderData moveFolderData = new MoveFolderData(); // MoveFolderData | 
try {
    Folder result = apiInstance.moveFolderToFolder(folderId, moveFolderData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#moveFolderToFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **folderId** | **String**|  |
 **moveFolderData** | [**MoveFolderData**](MoveFolderData.md)|  |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="moveTemplateToFolder"></a>
# **moveTemplateToFolder**
> Template moveTemplateToFolder(templateId, moveTemplateData)

Move Template to folder

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000001; // String | 
MoveTemplateData moveTemplateData = new MoveTemplateData(); // MoveTemplateData | 
try {
    Template result = apiInstance.moveTemplateToFolder(templateId, moveTemplateData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#moveTemplateToFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |
 **moveTemplateData** | [**MoveTemplateData**](MoveTemplateData.md)|  |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="renameFolder"></a>
# **renameFolder**
> renameFolder(folderId, renameFolderData)

Rename a folder

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String folderId = fld_000000000000000001; // String | 
RenameFolderData renameFolderData = new RenameFolderData(); // RenameFolderData | 
try {
    apiInstance.renameFolder(folderId, renameFolderData);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#renameFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **folderId** | **String**|  |
 **renameFolderData** | [**RenameFolderData**](RenameFolderData.md)|  |

### Return type

null (empty response body)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="testAuthentication"></a>
# **testAuthentication**
> AuthenticationSuccessResponse testAuthentication()

Test Authentication

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
try {
    AuthenticationSuccessResponse result = apiInstance.testAuthentication();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#testAuthentication");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AuthenticationSuccessResponse**](AuthenticationSuccessResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateDataRequest"></a>
# **updateDataRequest**
> UpdateDataRequestResponse updateDataRequest(dataRequestId, updateSubmissionDataRequestData)

Update a submission data request

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String dataRequestId = drq_000000000000000001; // String | 
UpdateSubmissionDataRequestData updateSubmissionDataRequestData = new UpdateSubmissionDataRequestData(); // UpdateSubmissionDataRequestData | 
try {
    UpdateDataRequestResponse result = apiInstance.updateDataRequest(dataRequestId, updateSubmissionDataRequestData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#updateDataRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dataRequestId** | **String**|  |
 **updateSubmissionDataRequestData** | [**UpdateSubmissionDataRequestData**](UpdateSubmissionDataRequestData.md)|  |

### Return type

[**UpdateDataRequestResponse**](UpdateDataRequestResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTemplate"></a>
# **updateTemplate**
> UpdateTemplateResponse updateTemplate(templateId, updateTemplateData)

Update a Template

### Example
```java
// Import classes:
//import com.docspring.ApiClient;
//import com.docspring.ApiException;
//import com.docspring.Configuration;
//import com.docspring.auth.*;
//import com.docspring.PdfApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: api_token_basic
HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
api_token_basic.setUsername("YOUR USERNAME");
api_token_basic.setPassword("YOUR PASSWORD");

PdfApi apiInstance = new PdfApi();
String templateId = tpl_000000000000000003; // String | 
UpdateTemplateData updateTemplateData = new UpdateTemplateData(); // UpdateTemplateData | 
try {
    UpdateTemplateResponse result = apiInstance.updateTemplate(templateId, updateTemplateData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PdfApi#updateTemplate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **templateId** | **String**|  |
 **updateTemplateData** | [**UpdateTemplateData**](UpdateTemplateData.md)|  |

### Return type

[**UpdateTemplateResponse**](UpdateTemplateResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

