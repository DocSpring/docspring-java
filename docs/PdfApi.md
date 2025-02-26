# PdfApi

All URIs are relative to *https://sync.api.docspring.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addFieldsToTemplate**](PdfApi.md#addFieldsToTemplate) | **PUT** /templates/{template_id}/add_fields | Add new fields to a Template |
| [**batchGeneratePdfs**](PdfApi.md#batchGeneratePdfs) | **POST** /submissions/batches | Generates multiple PDFs |
| [**combinePdfs**](PdfApi.md#combinePdfs) | **POST** /combined_submissions?v&#x3D;2 | Merge submission PDFs, template PDFs, or custom files |
| [**combineSubmissions**](PdfApi.md#combineSubmissions) | **POST** /combined_submissions | Merge generated PDFs together |
| [**copyTemplate**](PdfApi.md#copyTemplate) | **POST** /templates/{template_id}/copy | Copy a Template |
| [**createCustomFileFromUpload**](PdfApi.md#createCustomFileFromUpload) | **POST** /custom_files | Create a new custom file from a cached presign upload |
| [**createDataRequestEvent**](PdfApi.md#createDataRequestEvent) | **POST** /data_requests/{data_request_id}/events | Creates a new event for emailing a signee a request for signature |
| [**createDataRequestToken**](PdfApi.md#createDataRequestToken) | **POST** /data_requests/{data_request_id}/tokens | Creates a new data request token for form authentication |
| [**createFolder**](PdfApi.md#createFolder) | **POST** /folders/ | Create a folder |
| [**createHTMLTemplate**](PdfApi.md#createHTMLTemplate) | **POST** /templates?endpoint_description&#x3D;html | Create a new HTML template |
| [**createPDFTemplate**](PdfApi.md#createPDFTemplate) | **POST** /templates | Create a new PDF template with a form POST file upload |
| [**createPDFTemplateFromUpload**](PdfApi.md#createPDFTemplateFromUpload) | **POST** /templates?endpoint_description&#x3D;cached_upload | Create a new PDF template from a cached presign upload |
| [**deleteFolder**](PdfApi.md#deleteFolder) | **DELETE** /folders/{folder_id} | Delete a folder |
| [**deleteTemplate**](PdfApi.md#deleteTemplate) | **DELETE** /templates/{template_id} | Delete a template |
| [**expireCombinedSubmission**](PdfApi.md#expireCombinedSubmission) | **DELETE** /combined_submissions/{combined_submission_id} | Expire a combined submission |
| [**expireSubmission**](PdfApi.md#expireSubmission) | **DELETE** /submissions/{submission_id} | Expire a PDF submission |
| [**generatePdf**](PdfApi.md#generatePdf) | **POST** /templates/{template_id}/submissions | Generates a new PDF |
| [**generatePdfForHtmlTemplate**](PdfApi.md#generatePdfForHtmlTemplate) | **POST** /templates/{template_id}/submissions?endpoint_description&#x3D;html_templates | Generates a new PDF for an HTML template |
| [**generatePreview**](PdfApi.md#generatePreview) | **POST** /submissions/{submission_id}/generate_preview | Generated a preview PDF for partially completed data requests |
| [**getCombinedSubmission**](PdfApi.md#getCombinedSubmission) | **GET** /combined_submissions/{combined_submission_id} | Check the status of a combined submission (merged PDFs) |
| [**getDataRequest**](PdfApi.md#getDataRequest) | **GET** /data_requests/{data_request_id} | Look up a submission data request |
| [**getFullTemplate**](PdfApi.md#getFullTemplate) | **GET** /templates/{template_id}?full&#x3D;true | Fetch the full template attributes |
| [**getPresignUrl**](PdfApi.md#getPresignUrl) | **GET** /uploads/presign | Get a presigned URL so that you can upload a file to our AWS S3 bucket |
| [**getSubmission**](PdfApi.md#getSubmission) | **GET** /submissions/{submission_id} | Check the status of a PDF |
| [**getSubmissionBatch**](PdfApi.md#getSubmissionBatch) | **GET** /submissions/batches/{submission_batch_id} | Check the status of a submission batch job |
| [**getTemplate**](PdfApi.md#getTemplate) | **GET** /templates/{template_id} | Check the status of an uploaded template |
| [**getTemplateSchema**](PdfApi.md#getTemplateSchema) | **GET** /templates/{template_id}/schema | Fetch the JSON schema for a template |
| [**listCombinedSubmissions**](PdfApi.md#listCombinedSubmissions) | **GET** /combined_submissions | Get a list of all combined submissions |
| [**listFolders**](PdfApi.md#listFolders) | **GET** /folders/ | Get a list of all folders |
| [**listSubmissions**](PdfApi.md#listSubmissions) | **GET** /submissions | List all submissions |
| [**listTemplateSubmissions**](PdfApi.md#listTemplateSubmissions) | **GET** /templates/{template_id}/submissions | List all submissions for a given template |
| [**listTemplates**](PdfApi.md#listTemplates) | **GET** /templates | Get a list of all templates |
| [**moveFolderToFolder**](PdfApi.md#moveFolderToFolder) | **POST** /folders/{folder_id}/move | Move a folder |
| [**moveTemplateToFolder**](PdfApi.md#moveTemplateToFolder) | **POST** /templates/{template_id}/move | Move Template to folder |
| [**renameFolder**](PdfApi.md#renameFolder) | **POST** /folders/{folder_id}/rename | Rename a folder |
| [**testAuthentication**](PdfApi.md#testAuthentication) | **GET** /authentication | Test Authentication |
| [**updateDataRequest**](PdfApi.md#updateDataRequest) | **PUT** /data_requests/{data_request_id} | Update a submission data request |
| [**updateTemplate**](PdfApi.md#updateTemplate) | **PUT** /templates/{template_id} | Update a Template |



## addFieldsToTemplate

> TemplateAddFieldsResponse addFieldsToTemplate(templateId, data)

Add new fields to a Template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | 
        AddFieldsData data = new AddFieldsData(); // AddFieldsData | 
        try {
            TemplateAddFieldsResponse result = apiInstance.addFieldsToTemplate(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#addFieldsToTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **data** | [**AddFieldsData**](AddFieldsData.md)|  | |

### Return type

[**TemplateAddFieldsResponse**](TemplateAddFieldsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | add fields success |  -  |
| **422** | add fields error |  -  |


## batchGeneratePdfs

> BatchGeneratePdfs201Response batchGeneratePdfs(data, wait)

Generates multiple PDFs

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        SubmissionBatchData data = new SubmissionBatchData(); // SubmissionBatchData | 
        Boolean wait = true; // Boolean | Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            BatchGeneratePdfs201Response result = apiInstance.batchGeneratePdfs(data, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#batchGeneratePdfs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**SubmissionBatchData**](SubmissionBatchData.md)|  | |
| **wait** | **Boolean**| Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) | [optional] [default to true] |

### Return type

[**BatchGeneratePdfs201Response**](BatchGeneratePdfs201Response.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | submissions created |  -  |
| **200** | some PDFs with invalid data |  -  |
| **401** | authentication failed |  -  |
| **422** | array of arrays |  -  |
| **400** | invalid JSON |  -  |


## combinePdfs

> CreateCombinedSubmissionResponse combinePdfs(data)

Merge submission PDFs, template PDFs, or custom files

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CombinePdfsData data = new CombinePdfsData(); // CombinePdfsData | 
        try {
            CreateCombinedSubmissionResponse result = apiInstance.combinePdfs(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#combinePdfs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CombinePdfsData**](CombinePdfsData.md)|  | |

### Return type

[**CreateCombinedSubmissionResponse**](CreateCombinedSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | combined submission created |  -  |
| **422** | invalid request |  -  |
| **400** | invalid JSON |  -  |
| **401** | authentication failed |  -  |


## combineSubmissions

> CreateCombinedSubmissionResponse combineSubmissions(data, wait)

Merge generated PDFs together

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CombinedSubmissionData data = new CombinedSubmissionData(); // CombinedSubmissionData | 
        Boolean wait = true; // Boolean | Wait for combined submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            CreateCombinedSubmissionResponse result = apiInstance.combineSubmissions(data, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#combineSubmissions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CombinedSubmissionData**](CombinedSubmissionData.md)|  | |
| **wait** | **Boolean**| Wait for combined submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) | [optional] [default to true] |

### Return type

[**CreateCombinedSubmissionResponse**](CreateCombinedSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | combined submission created |  -  |
| **422** | invalid request |  -  |
| **400** | invalid JSON |  -  |
| **401** | authentication failed |  -  |


## copyTemplate

> TemplatePreview copyTemplate(templateId, options)

Copy a Template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        CopyTemplateOptions options = new CopyTemplateOptions(); // CopyTemplateOptions | 
        try {
            TemplatePreview result = apiInstance.copyTemplate(templateId, options);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#copyTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **options** | [**CopyTemplateOptions**](CopyTemplateOptions.md)|  | [optional] |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | copy template success |  -  |
| **404** | folder not found |  -  |


## createCustomFileFromUpload

> CreateCustomFileResponse createCustomFileFromUpload(data)

Create a new custom file from a cached presign upload

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CreateCustomFileData data = new CreateCustomFileData(); // CreateCustomFileData | 
        try {
            CreateCustomFileResponse result = apiInstance.createCustomFileFromUpload(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createCustomFileFromUpload");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CreateCustomFileData**](CreateCustomFileData.md)|  | |

### Return type

[**CreateCustomFileResponse**](CreateCustomFileResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | returns the custom file |  -  |
| **401** | authentication failed |  -  |


## createDataRequestEvent

> CreateSubmissionDataRequestEventResponse createDataRequestEvent(dataRequestId, event)

Creates a new event for emailing a signee a request for signature

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        CreateSubmissionDataRequestEventRequest event = new CreateSubmissionDataRequestEventRequest(); // CreateSubmissionDataRequestEventRequest | 
        try {
            CreateSubmissionDataRequestEventResponse result = apiInstance.createDataRequestEvent(dataRequestId, event);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createDataRequestEvent");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dataRequestId** | **String**|  | |
| **event** | [**CreateSubmissionDataRequestEventRequest**](CreateSubmissionDataRequestEventRequest.md)|  | |

### Return type

[**CreateSubmissionDataRequestEventResponse**](CreateSubmissionDataRequestEventResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | event created |  -  |
| **401** | authentication failed |  -  |
| **422** | message recipient must not be blank |  -  |


## createDataRequestToken

> CreateSubmissionDataRequestTokenResponse createDataRequestToken(dataRequestId, type)

Creates a new data request token for form authentication

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        String type = "api"; // String | 
        try {
            CreateSubmissionDataRequestTokenResponse result = apiInstance.createDataRequestToken(dataRequestId, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createDataRequestToken");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dataRequestId** | **String**|  | |
| **type** | **String**|  | [optional] [enum: api, email] |

### Return type

[**CreateSubmissionDataRequestTokenResponse**](CreateSubmissionDataRequestTokenResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | token created |  -  |
| **401** | authentication failed |  -  |
| **422** | invalid request |  -  |


## createFolder

> Folder createFolder(data)

Create a folder

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CreateFolderData data = new CreateFolderData(); // CreateFolderData | 
        try {
            Folder result = apiInstance.createFolder(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createFolder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CreateFolderData**](CreateFolderData.md)|  | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **422** | name already exist |  -  |
| **404** | parent folder doesn&#39;t exist |  -  |
| **200** | folder created inside another folder |  -  |
| **401** | authentication failed |  -  |


## createHTMLTemplate

> TemplatePreview createHTMLTemplate(data)

Create a new HTML template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CreateHtmlTemplate data = new CreateHtmlTemplate(); // CreateHtmlTemplate | 
        try {
            TemplatePreview result = apiInstance.createHTMLTemplate(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createHTMLTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CreateHtmlTemplate**](CreateHtmlTemplate.md)|  | |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | returns a created template |  -  |
| **401** | authentication failed |  -  |


## createPDFTemplate

> TemplatePreview createPDFTemplate(templateDocument, templateName, wait, templateDescription, templateParentFolderId)

Create a new PDF template with a form POST file upload

### Example

```java
import java.io.File;
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        File templateDocument = new File("/path/to/file"); // File | 
        String templateName = "templateName_example"; // String | 
        Boolean wait = true; // Boolean | Wait for template document to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        String templateDescription = "templateDescription_example"; // String | 
        String templateParentFolderId = "templateParentFolderId_example"; // String | 
        try {
            TemplatePreview result = apiInstance.createPDFTemplate(templateDocument, templateName, wait, templateDescription, templateParentFolderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createPDFTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateDocument** | **File**|  | |
| **templateName** | **String**|  | |
| **wait** | **Boolean**| Wait for template document to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) | [optional] [default to true] |
| **templateDescription** | **String**|  | [optional] |
| **templateParentFolderId** | **String**|  | [optional] |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | returns a pending template |  -  |
| **401** | authentication failed |  -  |


## createPDFTemplateFromUpload

> TemplatePreview createPDFTemplateFromUpload(data)

Create a new PDF template from a cached presign upload

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        CreatePdfTemplate data = new CreatePdfTemplate(); // CreatePdfTemplate | 
        try {
            TemplatePreview result = apiInstance.createPDFTemplateFromUpload(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#createPDFTemplateFromUpload");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **data** | [**CreatePdfTemplate**](CreatePdfTemplate.md)|  | |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | returns a pending template |  -  |
| **401** | authentication failed |  -  |


## deleteFolder

> Folder deleteFolder(folderId)

Delete a folder

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        try {
            Folder result = apiInstance.deleteFolder(folderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#deleteFolder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **folderId** | **String**|  | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | folder doesn&#39;t exist |  -  |
| **422** | folder has contents |  -  |
| **200** | folder is empty |  -  |
| **401** | authentication failed |  -  |


## deleteTemplate

> SuccessMultipleErrorsResponse deleteTemplate(templateId)

Delete a template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            SuccessMultipleErrorsResponse result = apiInstance.deleteTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#deleteTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |

### Return type

[**SuccessMultipleErrorsResponse**](SuccessMultipleErrorsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template deleted |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## expireCombinedSubmission

> CombinedSubmission expireCombinedSubmission(combinedSubmissionId)

Expire a combined submission

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String combinedSubmissionId = "com_1234567890abcdef01"; // String | 
        try {
            CombinedSubmission result = apiInstance.expireCombinedSubmission(combinedSubmissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#expireCombinedSubmission");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **combinedSubmissionId** | **String**|  | |

### Return type

[**CombinedSubmission**](CombinedSubmission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | submission was expired |  -  |
| **404** | combined submission not found |  -  |
| **403** | test API token used |  -  |
| **401** | authentication failed |  -  |


## expireSubmission

> SubmissionPreview expireSubmission(submissionId)

Expire a PDF submission

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        try {
            SubmissionPreview result = apiInstance.expireSubmission(submissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#expireSubmission");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **submissionId** | **String**|  | |

### Return type

[**SubmissionPreview**](SubmissionPreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | submission was expired |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |
| **403** | test API token used |  -  |


## generatePdf

> CreateSubmissionResponse generatePdf(templateId, submission, wait)

Generates a new PDF

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        CreatePdfSubmissionData submission = new CreatePdfSubmissionData(); // CreatePdfSubmissionData | 
        Boolean wait = true; // Boolean | Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            CreateSubmissionResponse result = apiInstance.generatePdf(templateId, submission, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#generatePdf");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **submission** | [**CreatePdfSubmissionData**](CreatePdfSubmissionData.md)|  | |
| **wait** | **Boolean**| Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) | [optional] [default to true] |

### Return type

[**CreateSubmissionResponse**](CreateSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | submission created |  -  |
| **422** | invalid request |  -  |
| **401** | authentication failed |  -  |


## generatePdfForHtmlTemplate

> CreateSubmissionResponse generatePdfForHtmlTemplate(templateId, submission, wait)

Generates a new PDF for an HTML template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_HTML567890abcdef01"; // String | 
        CreateHtmlSubmissionData submission = new CreateHtmlSubmissionData(); // CreateHtmlSubmissionData | 
        Boolean wait = true; // Boolean | Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            CreateSubmissionResponse result = apiInstance.generatePdfForHtmlTemplate(templateId, submission, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#generatePdfForHtmlTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **submission** | [**CreateHtmlSubmissionData**](CreateHtmlSubmissionData.md)|  | |
| **wait** | **Boolean**| Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain) | [optional] [default to true] |

### Return type

[**CreateSubmissionResponse**](CreateSubmissionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | submission created |  -  |


## generatePreview

> SuccessErrorResponse generatePreview(submissionId)

Generated a preview PDF for partially completed data requests

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        try {
            SuccessErrorResponse result = apiInstance.generatePreview(submissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#generatePreview");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **submissionId** | **String**|  | |

### Return type

[**SuccessErrorResponse**](SuccessErrorResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | preview was successfully requested |  -  |
| **404** | submission not found |  -  |
| **422** | error requesting preview |  -  |


## getCombinedSubmission

> CombinedSubmission getCombinedSubmission(combinedSubmissionId)

Check the status of a combined submission (merged PDFs)

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String combinedSubmissionId = "com_1234567890abcdef01"; // String | 
        try {
            CombinedSubmission result = apiInstance.getCombinedSubmission(combinedSubmissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getCombinedSubmission");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **combinedSubmissionId** | **String**|  | |

### Return type

[**CombinedSubmission**](CombinedSubmission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | processed combined submission found |  -  |
| **404** | combined submission not found |  -  |
| **401** | authentication failed |  -  |


## getDataRequest

> SubmissionDataRequestShow getDataRequest(dataRequestId)

Look up a submission data request

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        try {
            SubmissionDataRequestShow result = apiInstance.getDataRequest(dataRequestId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getDataRequest");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dataRequestId** | **String**|  | |

### Return type

[**SubmissionDataRequestShow**](SubmissionDataRequestShow.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | completed submission data request found |  -  |
| **404** | submission data request not found |  -  |
| **401** | authentication failed |  -  |


## getFullTemplate

> Template getFullTemplate(templateId)

Fetch the full template attributes

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            Template result = apiInstance.getFullTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getFullTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template found |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## getPresignUrl

> UploadPresignResponse getPresignUrl()

Get a presigned URL so that you can upload a file to our AWS S3 bucket

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        try {
            UploadPresignResponse result = apiInstance.getPresignUrl();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getPresignUrl");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**UploadPresignResponse**](UploadPresignResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | presign URL generated |  -  |
| **401** | authentication failed |  -  |


## getSubmission

> Submission getSubmission(submissionId, includeData)

Check the status of a PDF

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            Submission result = apiInstance.getSubmission(submissionId, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getSubmission");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **submissionId** | **String**|  | |
| **includeData** | **Boolean**|  | [optional] |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | processed submission found |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |


## getSubmissionBatch

> SubmissionBatchWithSubmissions getSubmissionBatch(submissionBatchId, includeSubmissions)

Check the status of a submission batch job

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String submissionBatchId = "sbb_1234567890abcdef01"; // String | 
        Boolean includeSubmissions = true; // Boolean | 
        try {
            SubmissionBatchWithSubmissions result = apiInstance.getSubmissionBatch(submissionBatchId, includeSubmissions);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getSubmissionBatch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **submissionBatchId** | **String**|  | |
| **includeSubmissions** | **Boolean**|  | [optional] |

### Return type

[**SubmissionBatchWithSubmissions**](SubmissionBatchWithSubmissions.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | processed submission batch found |  -  |
| **404** | submission batch not found |  -  |
| **401** | authentication failed |  -  |


## getTemplate

> TemplatePreview getTemplate(templateId)

Check the status of an uploaded template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            TemplatePreview result = apiInstance.getTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template found |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## getTemplateSchema

> JsonSchema getTemplateSchema(templateId)

Fetch the JSON schema for a template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            JsonSchema result = apiInstance.getTemplateSchema(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#getTemplateSchema");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |

### Return type

[**JsonSchema**](JsonSchema.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template found |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## listCombinedSubmissions

> List&lt;CombinedSubmission&gt; listCombinedSubmissions(page, perPage)

Get a list of all combined submissions

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        Integer page = 2; // Integer | Default: 1
        Integer perPage = 1; // Integer | Default: 50
        try {
            List<CombinedSubmission> result = apiInstance.listCombinedSubmissions(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#listCombinedSubmissions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| Default: 1 | [optional] |
| **perPage** | **Integer**| Default: 50 | [optional] |

### Return type

[**List&lt;CombinedSubmission&gt;**](CombinedSubmission.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enumerate all combined submissions |  -  |
| **401** | authentication failed |  -  |


## listFolders

> List&lt;Folder&gt; listFolders(parentFolderId)

Get a list of all folders

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String parentFolderId = "fld_1234567890abcdef02"; // String | Filter By Folder Id
        try {
            List<Folder> result = apiInstance.listFolders(parentFolderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#listFolders");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **parentFolderId** | **String**| Filter By Folder Id | [optional] |

### Return type

[**List&lt;Folder&gt;**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enumerate all folders |  -  |
| **401** | authentication failed |  -  |


## listSubmissions

> ListSubmissionsResponse listSubmissions(cursor, limit, createdAfter, createdBefore, type, includeData)

List all submissions

### Example

```java
import java.math.BigDecimal;
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String cursor = "sub_1234567890abcdef12"; // String | 
        BigDecimal limit = new BigDecimal("3"); // BigDecimal | 
        String createdAfter = "2019-01-01T09:00:00-05:00"; // String | 
        String createdBefore = "2020-01-01T09:00:00.000+0200"; // String | 
        String type = "test"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            ListSubmissionsResponse result = apiInstance.listSubmissions(cursor, limit, createdAfter, createdBefore, type, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#listSubmissions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cursor** | **String**|  | [optional] |
| **limit** | **BigDecimal**|  | [optional] |
| **createdAfter** | **String**|  | [optional] |
| **createdBefore** | **String**|  | [optional] |
| **type** | **String**|  | [optional] |
| **includeData** | **Boolean**|  | [optional] |

### Return type

[**ListSubmissionsResponse**](ListSubmissionsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listing submissions |  -  |
| **422** | invalid type |  -  |
| **401** | authentication failed |  -  |


## listTemplateSubmissions

> ListSubmissionsResponse listTemplateSubmissions(templateId, cursor, limit, createdAfter, createdBefore, type, includeData)

List all submissions for a given template

### Example

```java
import java.math.BigDecimal;
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | 
        String cursor = "cursor_example"; // String | 
        BigDecimal limit = new BigDecimal(78); // BigDecimal | 
        String createdAfter = "createdAfter_example"; // String | 
        String createdBefore = "createdBefore_example"; // String | 
        String type = "type_example"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            ListSubmissionsResponse result = apiInstance.listTemplateSubmissions(templateId, cursor, limit, createdAfter, createdBefore, type, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#listTemplateSubmissions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **cursor** | **String**|  | [optional] |
| **limit** | **BigDecimal**|  | [optional] |
| **createdAfter** | **String**|  | [optional] |
| **createdBefore** | **String**|  | [optional] |
| **type** | **String**|  | [optional] |
| **includeData** | **Boolean**|  | [optional] |

### Return type

[**ListSubmissionsResponse**](ListSubmissionsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | listing submissions |  -  |
| **404** | invalid template id |  -  |


## listTemplates

> List&lt;TemplatePreview&gt; listTemplates(query, parentFolderId, page, perPage)

Get a list of all templates

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String query = "2"; // String | Search By Name
        String parentFolderId = "fld_1234567890abcdef01"; // String | Filter By Folder Id
        Integer page = 2; // Integer | Default: 1
        Integer perPage = 1; // Integer | Default: 50
        try {
            List<TemplatePreview> result = apiInstance.listTemplates(query, parentFolderId, page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#listTemplates");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **query** | **String**| Search By Name | [optional] |
| **parentFolderId** | **String**| Filter By Folder Id | [optional] |
| **page** | **Integer**| Default: 1 | [optional] |
| **perPage** | **Integer**| Default: 50 | [optional] |

### Return type

[**List&lt;TemplatePreview&gt;**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | enumerate all templates |  -  |
| **404** | filter templates by invalid folder id |  -  |
| **401** | authentication failed |  -  |


## moveFolderToFolder

> Folder moveFolderToFolder(folderId, data)

Move a folder

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        MoveFolderData data = new MoveFolderData(); // MoveFolderData | 
        try {
            Folder result = apiInstance.moveFolderToFolder(folderId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#moveFolderToFolder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **folderId** | **String**|  | |
| **data** | [**MoveFolderData**](MoveFolderData.md)|  | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **404** | parent folder doesn&#39;t exist |  -  |
| **200** | move to root folder |  -  |
| **401** | authentication failed |  -  |


## moveTemplateToFolder

> TemplatePreview moveTemplateToFolder(templateId, data)

Move Template to folder

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        MoveTemplateData data = new MoveTemplateData(); // MoveTemplateData | 
        try {
            TemplatePreview result = apiInstance.moveTemplateToFolder(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#moveTemplateToFolder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **data** | [**MoveTemplateData**](MoveTemplateData.md)|  | |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | move template success |  -  |
| **404** | folder not found |  -  |


## renameFolder

> Folder renameFolder(folderId, data)

Rename a folder

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        RenameFolderData data = new RenameFolderData(); // RenameFolderData | 
        try {
            Folder result = apiInstance.renameFolder(folderId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#renameFolder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **folderId** | **String**|  | |
| **data** | [**RenameFolderData**](RenameFolderData.md)|  | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **422** | name already exist |  -  |
| **404** | folder doesn&#39;t belong to me |  -  |
| **200** | successful rename |  -  |
| **401** | authentication failed |  -  |


## testAuthentication

> SuccessErrorResponse testAuthentication()

Test Authentication

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        try {
            SuccessErrorResponse result = apiInstance.testAuthentication();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#testAuthentication");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**SuccessErrorResponse**](SuccessErrorResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | authentication succeeded |  -  |
| **401** | authentication failed |  -  |


## updateDataRequest

> CreateSubmissionDataRequestResponse updateDataRequest(dataRequestId, data)

Update a submission data request

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        UpdateSubmissionDataRequestData data = new UpdateSubmissionDataRequestData(); // UpdateSubmissionDataRequestData | 
        try {
            CreateSubmissionDataRequestResponse result = apiInstance.updateDataRequest(dataRequestId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#updateDataRequest");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dataRequestId** | **String**|  | |
| **data** | [**UpdateSubmissionDataRequestData**](UpdateSubmissionDataRequestData.md)|  | |

### Return type

[**CreateSubmissionDataRequestResponse**](CreateSubmissionDataRequestResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | submission data request updated |  -  |
| **422** | invalid request |  -  |
| **404** | submission data request not found |  -  |
| **401** | authentication failed |  -  |


## updateTemplate

> SuccessMultipleErrorsResponse updateTemplate(templateId, data)

Update a Template

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.PdfApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        PdfApi apiInstance = new PdfApi(defaultClient);
        String templateId = "tpl_1234567890abcdef03"; // String | 
        UpdateHtmlTemplate data = new UpdateHtmlTemplate(); // UpdateHtmlTemplate | 
        try {
            SuccessMultipleErrorsResponse result = apiInstance.updateTemplate(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PdfApi#updateTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **templateId** | **String**|  | |
| **data** | [**UpdateHtmlTemplate**](UpdateHtmlTemplate.md)|  | |

### Return type

[**SuccessMultipleErrorsResponse**](SuccessMultipleErrorsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | update template success |  -  |

