# Client

All URIs are relative to *https://sync.api.docspring.com/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addFieldsToTemplate**](Client.md#addFieldsToTemplate) | **PUT** /templates/{template_id}/add_fields | Add new fields to a Template |
| [**batchGeneratePdfs**](Client.md#batchGeneratePdfs) | **POST** /submissions/batches | Generate multiple PDFs |
| [**combinePdfs**](Client.md#combinePdfs) | **POST** /combined_submissions | Merge submission PDFs, template PDFs, or custom files |
| [**copyTemplate**](Client.md#copyTemplate) | **POST** /templates/{template_id}/copy | Copy a template |
| [**createCustomFileFromUpload**](Client.md#createCustomFileFromUpload) | **POST** /custom_files | Create a new custom file from a cached S3 upload |
| [**createDataRequestEvent**](Client.md#createDataRequestEvent) | **POST** /data_requests/{data_request_id}/events | Create a new event for emailing a signee a request for signature |
| [**createDataRequestToken**](Client.md#createDataRequestToken) | **POST** /data_requests/{data_request_id}/tokens | Create a new data request token for form authentication |
| [**createFolder**](Client.md#createFolder) | **POST** /folders/ | Create a folder |
| [**createHtmlTemplate**](Client.md#createHtmlTemplate) | **POST** /templates?endpoint_variant&#x3D;create_html_template | Create a new HTML template |
| [**createPdfTemplate**](Client.md#createPdfTemplate) | **POST** /templates | Create a new PDF template with a form POST file upload |
| [**createPdfTemplateFromUpload**](Client.md#createPdfTemplateFromUpload) | **POST** /templates?endpoint_variant&#x3D;create_template_from_cached_upload | Create a new PDF template from a cached S3 file upload |
| [**createWebhook**](Client.md#createWebhook) | **POST** /webhooks | Create a webhook |
| [**deleteFolder**](Client.md#deleteFolder) | **DELETE** /folders/{folder_id} | Delete a folder |
| [**deleteTemplate**](Client.md#deleteTemplate) | **DELETE** /templates/{template_id} | Delete a template |
| [**deleteWebhook**](Client.md#deleteWebhook) | **DELETE** /webhooks/{webhook_id} | Delete a webhook |
| [**expireCombinedSubmission**](Client.md#expireCombinedSubmission) | **DELETE** /combined_submissions/{combined_submission_id} | Expire a combined submission |
| [**expireSubmission**](Client.md#expireSubmission) | **DELETE** /submissions/{submission_id} | Expire a PDF submission |
| [**generatePdf**](Client.md#generatePdf) | **POST** /templates/{template_id}/submissions | Generate a PDF |
| [**generatePreview**](Client.md#generatePreview) | **POST** /submissions/{submission_id}/generate_preview | Generate a preview PDF for partially completed data requests |
| [**getCombinedSubmission**](Client.md#getCombinedSubmission) | **GET** /combined_submissions/{combined_submission_id} | Check the status of a combined submission (merged PDFs) |
| [**getDataRequest**](Client.md#getDataRequest) | **GET** /data_requests/{data_request_id} | Look up a submission data request |
| [**getFullTemplate**](Client.md#getFullTemplate) | **GET** /templates/{template_id}?full&#x3D;true | Fetch the full attributes for a PDF template |
| [**getPresignUrl**](Client.md#getPresignUrl) | **GET** /uploads/presign | Get a presigned S3 URL for direct file upload |
| [**getSubmission**](Client.md#getSubmission) | **GET** /submissions/{submission_id} | Check the status of a PDF |
| [**getSubmissionBatch**](Client.md#getSubmissionBatch) | **GET** /submissions/batches/{submission_batch_id} | Check the status of a submission batch job |
| [**getTemplate**](Client.md#getTemplate) | **GET** /templates/{template_id} | Check the status of an uploaded template |
| [**getTemplateModelCode**](Client.md#getTemplateModelCode) | **GET** /templates/{template_id}/model_code | Generate typed model code for a template |
| [**getTemplateSchema**](Client.md#getTemplateSchema) | **GET** /templates/{template_id}/schema | Fetch the JSON schema for a template |
| [**getWebhook**](Client.md#getWebhook) | **GET** /webhooks/{webhook_id} | Get a webhook |
| [**listCombinedSubmissions**](Client.md#listCombinedSubmissions) | **GET** /combined_submissions | Get a list of all combined submissions |
| [**listFolders**](Client.md#listFolders) | **GET** /folders/ | Get a list of all folders |
| [**listSubmissions**](Client.md#listSubmissions) | **GET** /submissions | List all submissions |
| [**listTemplateSubmissions**](Client.md#listTemplateSubmissions) | **GET** /templates/{template_id}/submissions | List all submissions for a given template |
| [**listTemplates**](Client.md#listTemplates) | **GET** /templates | Get a list of all templates |
| [**listWebhooks**](Client.md#listWebhooks) | **GET** /webhooks | Get a list of all webhooks |
| [**moveFolderToFolder**](Client.md#moveFolderToFolder) | **POST** /folders/{folder_id}/move | Move a folder |
| [**moveTemplateToFolder**](Client.md#moveTemplateToFolder) | **POST** /templates/{template_id}/move | Move Template to folder |
| [**publishTemplateVersion**](Client.md#publishTemplateVersion) | **POST** /templates/{template_id}/publish_version | Publish a template version |
| [**renameFolder**](Client.md#renameFolder) | **POST** /folders/{folder_id}/rename | Rename a folder |
| [**restoreTemplateVersion**](Client.md#restoreTemplateVersion) | **POST** /templates/{template_id}/restore_version | Restore a template version |
| [**testAuthentication**](Client.md#testAuthentication) | **GET** /authentication | Test authentication |
| [**updateDataRequest**](Client.md#updateDataRequest) | **PUT** /data_requests/{data_request_id} | Update a submission data request |
| [**updateTemplate**](Client.md#updateTemplate) | **PUT** /templates/{template_id} | Update a Template |
| [**updateTemplateDocument**](Client.md#updateTemplateDocument) | **PUT** /templates/{template_id}?endpoint_variant&#x3D;update_template_pdf_with_form_post | Update a template&#39;s document with a form POST file upload |
| [**updateTemplateDocumentFromUpload**](Client.md#updateTemplateDocumentFromUpload) | **PUT** /templates/{template_id}?endpoint_variant&#x3D;update_template_pdf_with_cached_upload | Update a template&#39;s document with a cached S3 file upload |
| [**updateWebhook**](Client.md#updateWebhook) | **PUT** /webhooks/{webhook_id} | Update a webhook |



## addFieldsToTemplate

> TemplateAddFieldsResponse addFieldsToTemplate(templateId, data)

Add new fields to a Template

Adds fields to a PDF template. Configure field types, positions,
defaults, and formatting options.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | 
        AddFieldsData data = new AddFieldsData(); // AddFieldsData | 
        try {
            TemplateAddFieldsResponse result = apiInstance.addFieldsToTemplate(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#addFieldsToTemplate");
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

Generate multiple PDFs

Generates up to 50 PDFs in a single request. Each submission can use a different template
and data. Supports both synchronous (wait for all PDFs) and asynchronous processing. More
efficient than individual requests when creating multiple PDFs.

Live PDFs use credits. If any live submission is waiting for credits, the API returns 402 and the
others are still processed: check each submission's `state`. See
[Credits & Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).

See also:
- [Batch Generate PDFs](https://docspring.com/docs/api-guide/generate-pdfs/batch-generate-pdfs/) - Request format, responses, and limits


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        SubmissionBatchData data = new SubmissionBatchData(); // SubmissionBatchData | 
        Boolean wait = true; // Boolean | Wait for submission batch to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            BatchGeneratePdfs201Response result = apiInstance.batchGeneratePdfs(data, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#batchGeneratePdfs");
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
| **402** | insufficient credits |  -  |
| **403** | account suspended |  -  |
| **201** | submissions created |  -  |
| **200** | some PDFs with invalid data |  -  |
| **401** | authentication failed |  -  |
| **422** | array of arrays |  -  |
| **400** | invalid JSON |  -  |


## combinePdfs

> CreateCombinedSubmissionResponse combinePdfs(data)

Merge submission PDFs, template PDFs, or custom files

Combines multiple PDFs from various sources into a single PDF file. Supports merging
submission PDFs, template PDFs, custom files, other merged PDFs,
and PDFs from URLs. Merges the PDFs in the order provided.

Combining uses credits (4 per source PDF, plus 4 per unit of the combined PDF), even with a test API
token or watermarked source PDFs. If your balance can't cover it, the API returns 402 and the combined
submission waits in the `insufficient_credits` state until you add credits. See
[Credits & Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CombinePdfsData data = new CombinePdfsData(); // CombinePdfsData | 
        try {
            CreateCombinedSubmissionResponse result = apiInstance.combinePdfs(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#combinePdfs");
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
| **402** | insufficient credits |  -  |
| **403** | test API token used to delete custom files |  -  |
| **201** | combined submission created |  -  |
| **422** | invalid request |  -  |
| **400** | invalid JSON |  -  |
| **401** | authentication failed |  -  |


## copyTemplate

> TemplatePreview copyTemplate(templateId, options)

Copy a template

Creates a copy of an existing template with all its fields and configuration.
Optionally specify a new name and target folder. The copied template starts as a new
draft that can be modified independently of the original.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        CopyTemplateOptions options = new CopyTemplateOptions(); // CopyTemplateOptions | 
        try {
            TemplatePreview result = apiInstance.copyTemplate(templateId, options);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#copyTemplate");
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
| **403** | the plan&#39;s template limit is reached |  -  |
| **404** | folder not found |  -  |


## createCustomFileFromUpload

> CreateCustomFileResponse createCustomFileFromUpload(data)

Create a new custom file from a cached S3 upload

The Custom Files API endpoint allows you to upload PDFs to DocSpring and then
merge them with other PDFs. First upload your file using the presigned URL endpoint,
then use the returned cache_id to create the custom file.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateCustomFileData data = new CreateCustomFileData(); // CreateCustomFileData | 
        try {
            CreateCustomFileResponse result = apiInstance.createCustomFileFromUpload(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createCustomFileFromUpload");
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

Create a new event for emailing a signee a request for signature

Records user notification events for data requests. Use this to create an audit trail
showing when and how users were notified about data request forms. Supports email, SMS,
and other notification types. Records the notification time for compliance tracking.

See also:
- [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - User notification workflow


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        CreateSubmissionDataRequestEventRequest event = new CreateSubmissionDataRequestEventRequest(); // CreateSubmissionDataRequestEventRequest | 
        try {
            CreateSubmissionDataRequestEventResponse result = apiInstance.createDataRequestEvent(dataRequestId, event);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createDataRequestEvent");
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

Create a new data request token for form authentication

Creates an authentication token for accessing a data request form. Returns a token
and a pre-authenticated URL for the data request form. The token remains valid until
the data request is completed.

See also:
- [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/)


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        String type = "api"; // String | 
        try {
            CreateSubmissionDataRequestTokenResponse result = apiInstance.createDataRequestToken(dataRequestId, type);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createDataRequestToken");
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

Creates a new folder for organizing templates. Folders can be nested within other folders
by providing a `parent_folder_id`. Folder names must be unique within the same parent.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateFolderData data = new CreateFolderData(); // CreateFolderData | 
        try {
            Folder result = apiInstance.createFolder(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createFolder");
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


## createHtmlTemplate

> TemplatePreview createHtmlTemplate(data)

Create a new HTML template

Creates a new HTML template using HTML, CSS/SCSS, and Liquid templating. Allows complete
control over PDF layout and styling. Supports headers, footers, and dynamic content using
Liquid syntax for field values, conditions, loops, and filters.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateHtmlTemplate data = new CreateHtmlTemplate(); // CreateHtmlTemplate | 
        try {
            TemplatePreview result = apiInstance.createHtmlTemplate(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createHtmlTemplate");
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
| **403** | the plan&#39;s template limit is reached |  -  |
| **401** | authentication failed |  -  |


## createPdfTemplate

> TemplatePreview createPdfTemplate(templateDocument, templateName, wait, templateDescription, templateParentFolderId)

Create a new PDF template with a form POST file upload

Creates a new PDF template by uploading a PDF file. The uploaded PDF becomes the foundation
for your template, and you can then add fillable fields using the template editor. Use the
wait parameter to control whether the request waits for document processing to complete.


### Example

```java
import java.io.File;
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        File templateDocument = new File("/path/to/file"); // File | 
        String templateName = "templateName_example"; // String | 
        Boolean wait = true; // Boolean | Wait for template document to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        String templateDescription = "templateDescription_example"; // String | 
        String templateParentFolderId = "templateParentFolderId_example"; // String | 
        try {
            TemplatePreview result = apiInstance.createPdfTemplate(templateDocument, templateName, wait, templateDescription, templateParentFolderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createPdfTemplate");
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
| **403** | the plan&#39;s template limit is reached |  -  |
| **401** | authentication failed |  -  |


## createPdfTemplateFromUpload

> TemplatePreview createPdfTemplateFromUpload(data)

Create a new PDF template from a cached S3 file upload

Creates a new PDF template from a file previously uploaded to S3 using a presigned URL.
This two-step process allows for more reliable large file uploads by first uploading
the file to S3, then creating the template using the cached upload ID.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreatePdfTemplate data = new CreatePdfTemplate(); // CreatePdfTemplate | 
        try {
            TemplatePreview result = apiInstance.createPdfTemplateFromUpload(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createPdfTemplateFromUpload");
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
| **403** | the plan&#39;s template limit is reached |  -  |


## createWebhook

> Webhook createWebhook(data)

Create a webhook

Creates a webhook that delivers a POST request to your endpoint whenever a subscribed event
occurs. Optionally scope the webhook to specific API tokens, templates, or folders.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateWebhookData data = new CreateWebhookData(); // CreateWebhookData | 
        try {
            Webhook result = apiInstance.createWebhook(data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createWebhook");
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
| **data** | [**CreateWebhookData**](CreateWebhookData.md)|  | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | webhook created |  -  |
| **422** | invalid parameters |  -  |
| **401** | authentication failed |  -  |


## deleteFolder

> Folder deleteFolder(folderId)

Delete a folder

Deletes an empty folder. The folder must not contain any templates or subfolders.
Move or delete all contents before attempting to delete the folder.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        try {
            Folder result = apiInstance.deleteFolder(folderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#deleteFolder");
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

> TemplateDeleteResponse deleteTemplate(templateId, version)

Delete a template

Deletes a template or a specific template version. When no version is specified, deletes
the entire template including all versions. When a version is specified, deletes only
that version while preserving others. Returns remaining version information.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        String version = "0.1.0"; // String | 
        try {
            TemplateDeleteResponse result = apiInstance.deleteTemplate(templateId, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#deleteTemplate");
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
| **version** | **String**|  | [optional] |

### Return type

[**TemplateDeleteResponse**](TemplateDeleteResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template version deleted successfully |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## deleteWebhook

> Webhook deleteWebhook(webhookId)

Delete a webhook

Permanently deletes a webhook so it stops receiving events, and returns the deleted webhook.

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "whk_1234567890abcdef01"; // String | 
        try {
            Webhook result = apiInstance.deleteWebhook(webhookId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#deleteWebhook");
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
| **webhookId** | **String**|  | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook deleted |  -  |
| **404** | webhook not found |  -  |
| **401** | authentication failed |  -  |


## expireCombinedSubmission

> CombinedSubmission expireCombinedSubmission(combinedSubmissionId)

Expire a combined submission

Expiring a combined submission deletes the PDF from our system.
This is useful for invalidating sensitive documents.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String combinedSubmissionId = "com_1234567890abcdef01"; // String | 
        try {
            CombinedSubmission result = apiInstance.expireCombinedSubmission(combinedSubmissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#expireCombinedSubmission");
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

Expiring a PDF submission deletes the PDF and removes the data from our database.
This is useful for invalidating sensitive documents after they've been downloaded.
You can also [configure a data retention policy for your submissions](https://docspring.com/docs/template-editor/settings/#expire-submissions)
so that they automatically expire.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        try {
            SubmissionPreview result = apiInstance.expireSubmission(submissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#expireSubmission");
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

Generate a PDF

Creates a PDF submission by filling in a template with data. Supports both synchronous (default) and
asynchronous processing. Add the `wait=false` query parameter to return immediately.

Live PDFs use credits; test PDFs (`test: true`) are free and watermarked. If your balance can't cover a
live PDF, the API returns 402 and the submission waits in the `insufficient_credits` state until you add
credits. See [Credits & Rate Limits](https://docspring.com/docs/api-guide/credits-and-rate-limits/).

See also:
- [Customize the PDF Title and Filename](https://docspring.com/docs/api-guide/generate-pdfs/customize-pdf-title-and-filename/) - Set custom metadata
- [Handling Truncated Text](https://docspring.com/docs/api-guide/generate-pdfs/handle-truncated-text/) - Handle text that doesn't fit in fields


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        CreatePdfSubmissionData submission = new CreatePdfSubmissionData(); // CreatePdfSubmissionData | 
        Boolean wait = true; // Boolean | Wait for submission to be processed before returning. Set to false to return immediately. Default: true (on sync.* subdomain)
        try {
            CreateSubmissionResponse result = apiInstance.generatePdf(templateId, submission, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#generatePdf");
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
| **402** | insufficient credits |  -  |
| **201** | submission created |  -  |
| **422** | invalid request |  -  |
| **403** | live data requests need Starter or higher |  -  |
| **401** | authentication failed |  -  |


## generatePreview

> SuccessErrorResponse generatePreview(submissionId)

Generate a preview PDF for partially completed data requests

Generates a preview PDF for a submission with partially completed data requests. Useful
for showing users what the final document will look like before all signatures or data
have been collected. The preview includes any data collected so far.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        try {
            SuccessErrorResponse result = apiInstance.generatePreview(submissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#generatePreview");
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

Retrieves the details and status of a combined submission. Returns processing state,
download URL (if processed), metadata, and information about any integrated actions
(e.g., S3 uploads).

`insufficient_credits` means the combined submission is waiting for credits and is processed once you
add them. If it's still waiting after 30 days, it moves to `error`.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String combinedSubmissionId = "com_1234567890abcdef01"; // String | 
        try {
            CombinedSubmission result = apiInstance.getCombinedSubmission(combinedSubmissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getCombinedSubmission");
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

Retrieves the details and status of a data request. Returns information about the request
state (pending, viewed, completed), authentication details, and metadata.
Includes audit information like IP address, browseruser agent, and timestamps.

See also:
- [Embedded Data Requests Guide](https://docspring.com/docs/guides/embedded-forms/embedded-data-requests/) - Complete guide to data request workflow


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        try {
            SubmissionDataRequestShow result = apiInstance.getDataRequest(dataRequestId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getDataRequest");
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

Fetch the full attributes for a PDF template

Retrieves complete template information including fields, defaults, settings, and HTML/SCSS content.
Use this to get all template data needed for automated updates or analysis.
Returns more detailed information than the basic `getTemplate` endpoint.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            Template result = apiInstance.getFullTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getFullTemplate");
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

Get a presigned S3 URL for direct file upload

Returns a presigned S3 URL for uploading files directly to our S3 bucket. Use this
endpoint to upload large files before creating templates or custom files. S3 will
respond with a JSON object that you can include in your DocSpring API request.

Uploaded files can be used to:
- [Create templates](https://docspring.com/docs/api/#tag/templates/post/templates?endpoint_variant=create_template_from_cached_upload)
- [Update templates](https://docspring.com/docs/api/#tag/templates/put/templates/{template_id}?endpoint_variant=update_template_pdf_with_cached_upload)
- [Create custom files](https://docspring.com/docs/api/#tag/custom-files/post/custom_files) and then [merge them with other PDFs](https://docspring.com/docs/api/#tag/combine-pdfs/post/combined_submissions)


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        try {
            UploadPresignResponse result = apiInstance.getPresignUrl();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getPresignUrl");
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

Retrieves the details and status of a PDF submission. Returns processing state, download
URL (if processed), metadata, submission data (optional), and information about any
integrated actions. Use this to poll for completion when using asynchronous processing.

`insufficient_credits` means the submission is waiting for credits and is processed once you add them.
If it's still waiting after 30 days, it moves to `error`.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            Submission result = apiInstance.getSubmission(submissionId, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getSubmission");
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
| **200** | processed submission found with data |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |


## getSubmissionBatch

> SubmissionBatchWithSubmissions getSubmissionBatch(submissionBatchId, includeSubmissions)

Check the status of a submission batch job

Retrieves the status and results of a batch PDF generation job. Returns processing state,
completion statistics, and optionally includes all individual submission details. Use this
to poll for completion when using asynchronous batch processing.

Submissions waiting for credits are in the `insufficient_credits` state and count as pending, so the
batch stays `pending` until you add credits or they stop waiting after 30 days.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionBatchId = "sbb_1234567890abcdef01"; // String | 
        Boolean includeSubmissions = true; // Boolean | 
        try {
            SubmissionBatchWithSubmissions result = apiInstance.getSubmissionBatch(submissionBatchId, includeSubmissions);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getSubmissionBatch");
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

Retrieves information about a template including processing status and document URL.
Use this to check if template is ready to view in the template editor or generate PDFs.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            TemplatePreview result = apiInstance.getTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplate");
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


## getTemplateModelCode

> TemplateModelCodeResponse getTemplateModelCode(templateId, lang)

Generate typed model code for a template

Generates typed model code for a template's submission data from its JSON schema, in
TypeScript, JavaScript, Ruby, Python, PHP, Java, C#, Elixir or Go. Build your submission
data with the generated types so your app catches mistakes before it calls the API.

`root_type_name` is the type that describes the whole submission data object, qualified
with its namespace or package where there is one. Java returns every class in `code`,
each under a `// ClassName.java` comment: split them into one file per class.

A template with no named fields returns 422, since there are no types to generate.

See also:
- [Generate Model Code](https://docspring.com/docs/template-editor/generate-model-code/) - Use the generated types


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        String lang = "typescript"; // String | The language to generate code for
        try {
            TemplateModelCodeResponse result = apiInstance.getTemplateModelCode(templateId, lang);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplateModelCode");
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
| **lang** | **String**| The language to generate code for | [enum: typescript, javascript, ruby, python, php, java, csharp, elixir, go] |

### Return type

[**TemplateModelCodeResponse**](TemplateModelCodeResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | model code generated |  -  |
| **404** | template not found |  -  |
| **422** | unknown language |  -  |
| **401** | authentication failed |  -  |


## getTemplateSchema

> JsonSchema getTemplateSchema(templateId)

Fetch the JSON schema for a template

Retrieves the JSON Schema definition for a template's fields. Use this to validate
data before submitting it for PDF generation, or to build dynamic forms that match
the template's field structure and validation requirements.

See also:
- [Generate PDFs Guide](https://docspring.com/docs/api-guide/generate-pdfs/generate-pdfs-via-api/) - Use schema to validate submission data


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        try {
            JsonSchema result = apiInstance.getTemplateSchema(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplateSchema");
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


## getWebhook

> Webhook getWebhook(webhookId)

Get a webhook

Retrieves a single webhook by its ID.

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "whk_1234567890abcdef01"; // String | 
        try {
            Webhook result = apiInstance.getWebhook(webhookId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getWebhook");
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
| **webhookId** | **String**|  | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook found |  -  |
| **404** | webhook not found |  -  |
| **401** | authentication failed |  -  |


## listCombinedSubmissions

> List&lt;CombinedSubmission&gt; listCombinedSubmissions(page, perPage)

Get a list of all combined submissions

Returns a paginated list of combined submissions (merged PDFs) for your account.
Includes processing status, expiration details, and download URLs for processed PDFs.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        Integer page = 3; // Integer | Default: 1
        Integer perPage = 1; // Integer | Default: 50
        try {
            List<CombinedSubmission> result = apiInstance.listCombinedSubmissions(page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listCombinedSubmissions");
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

Returns a list of folders in your account. Can be filtered by parent folder ID to retrieve
subfolders. Folders help organize templates and maintain a hierarchical structure.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String parentFolderId = "fld_1234567890abcdef02"; // String | Filter By Folder Id
        try {
            List<Folder> result = apiInstance.listFolders(parentFolderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listFolders");
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

Returns a paginated list of all PDF submissions across all templates in your account.
Can be filtered by date range and submission type (test/live). Supports cursor-based
pagination and optionally includes submission data for each result.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String cursor = "sub_1234567890abcdef12"; // String | 
        Integer limit = 3; // Integer | 
        String createdAfter = "2019-01-01T09:00:00-05:00"; // String | 
        String createdBefore = "2020-01-01T09:00:00.000+0200"; // String | 
        String type = "test"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            ListSubmissionsResponse result = apiInstance.listSubmissions(cursor, limit, createdAfter, createdBefore, type, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listSubmissions");
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
| **limit** | **Integer**|  | [optional] |
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

Returns a paginated list of all submissions for a specific template. Can be filtered by
date range, submission type (test/live), and optionally include submission data. Supports
cursor-based pagination for efficient retrieval of large result sets.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | 
        String cursor = "cursor_example"; // String | 
        Integer limit = 56; // Integer | 
        String createdAfter = "createdAfter_example"; // String | 
        String createdBefore = "createdBefore_example"; // String | 
        String type = "type_example"; // String | 
        Boolean includeData = true; // Boolean | 
        try {
            ListSubmissionsResponse result = apiInstance.listTemplateSubmissions(templateId, cursor, limit, createdAfter, createdBefore, type, includeData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listTemplateSubmissions");
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
| **limit** | **Integer**|  | [optional] |
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

Retrieves a list of your templates with search, filtering, and pagination options. Returns
basic template information including ID, name, type (PDF or HTML), and folder location.
Supports text search by name and filtering by parent folder.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String query = "2"; // String | Search By Name
        String parentFolderId = "fld_1234567890abcdef01"; // String | Filter By Folder Id
        Integer page = 2; // Integer | Default: 1
        Integer perPage = 1; // Integer | Default: 50
        try {
            List<TemplatePreview> result = apiInstance.listTemplates(query, parentFolderId, page, perPage);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listTemplates");
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


## listWebhooks

> List&lt;Webhook&gt; listWebhooks(page, perPage, eventType, mode, templateId, folderId, apiTokenId)

Get a list of all webhooks

Returns a list of the webhooks configured for your account. Supports pagination and
filtering by event type, mode, and the API token, template, or folder a webhook is scoped to.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        Integer page = 56; // Integer | Default: 1
        Integer perPage = 56; // Integer | Default: 50
        String eventType = "submission.processed"; // String | Filter by a subscribed event type
        String mode = "live"; // String | Filter by mode (test or live)
        String templateId = "tpl_1234567890abcdef01"; // String | Filter by a scoped template ID
        String folderId = "folderId_example"; // String | Filter by a scoped folder ID
        String apiTokenId = "apiTokenId_example"; // String | Filter by a scoped API token ID
        try {
            List<Webhook> result = apiInstance.listWebhooks(page, perPage, eventType, mode, templateId, folderId, apiTokenId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listWebhooks");
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
| **eventType** | **String**| Filter by a subscribed event type | [optional] |
| **mode** | **String**| Filter by mode (test or live) | [optional] |
| **templateId** | **String**| Filter by a scoped template ID | [optional] |
| **folderId** | **String**| Filter by a scoped folder ID | [optional] |
| **apiTokenId** | **String**| Filter by a scoped API token ID | [optional] |

### Return type

[**List&lt;Webhook&gt;**](Webhook.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | filter webhooks by scope and event type |  -  |
| **401** | authentication failed |  -  |


## moveFolderToFolder

> Folder moveFolderToFolder(folderId, data)

Move a folder

Moves a folder to a new parent folder or to the root level. All templates and subfolders
within the folder are moved together. Cannot move a folder into one of its own subfolders.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        MoveFolderData data = new MoveFolderData(); // MoveFolderData | 
        try {
            Folder result = apiInstance.moveFolderToFolder(folderId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#moveFolderToFolder");
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

Moves a template to a different folder or to the root level. Use this to organize
templates within your folders. Provide a folder ID to move to a specific
folder, or `null` to move to the root level.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        MoveTemplateData data = new MoveTemplateData(); // MoveTemplateData | 
        try {
            TemplatePreview result = apiInstance.moveTemplateToFolder(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#moveTemplateToFolder");
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


## publishTemplateVersion

> TemplatePublishVersionResponse publishTemplateVersion(templateId, data)

Publish a template version

Publishes the current draft version of a template and creates a new immutable version
with semantic versioning (major.minor.patch).


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        PublishVersionData data = new PublishVersionData(); // PublishVersionData | 
        try {
            TemplatePublishVersionResponse result = apiInstance.publishTemplateVersion(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#publishTemplateVersion");
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
| **data** | [**PublishVersionData**](PublishVersionData.md)|  | |

### Return type

[**TemplatePublishVersionResponse**](TemplatePublishVersionResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | version published successfully |  -  |
| **422** | invalid version type |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |


## renameFolder

> Folder renameFolder(folderId, data)

Rename a folder

Renames an existing folder. The new name must be unique within the same parent folder.
This operation only changes the folder name, not its location or contents.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "fld_1234567890abcdef01"; // String | 
        RenameFolderData data = new RenameFolderData(); // RenameFolderData | 
        try {
            Folder result = apiInstance.renameFolder(folderId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#renameFolder");
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


## restoreTemplateVersion

> SuccessErrorResponse restoreTemplateVersion(templateId, data)

Restore a template version

Restores your template to a previously published version, copying that version's content
and configuration to the current draft. Use this to revert changes or recover from
an unwanted modification.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        RestoreVersionData data = new RestoreVersionData(); // RestoreVersionData | 
        try {
            SuccessErrorResponse result = apiInstance.restoreTemplateVersion(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#restoreTemplateVersion");
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
| **data** | [**RestoreVersionData**](RestoreVersionData.md)|  | |

### Return type

[**SuccessErrorResponse**](SuccessErrorResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | version restored successfully |  -  |
| **422** | draft version not allowed |  -  |
| **404** | template version not found |  -  |
| **401** | authentication failed |  -  |


## testAuthentication

> SuccessErrorResponse testAuthentication()

Test authentication

Checks whether your API token is valid by making an authenticated request.
Returns a success response if authentication passes. This endpoint is useful for
verifying credentials during setup or troubleshooting issues.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        try {
            SuccessErrorResponse result = apiInstance.testAuthentication();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#testAuthentication");
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

Updates authentication details for a data request. Use this when a user logs in to record
their authentication method, provider, session information, and hashed identifiers. Updates
metadata and tracks authentication state changes for auditing and compliance.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String dataRequestId = "drq_1234567890abcdef01"; // String | 
        UpdateSubmissionDataRequestData data = new UpdateSubmissionDataRequestData(); // UpdateSubmissionDataRequestData | 
        try {
            CreateSubmissionDataRequestResponse result = apiInstance.updateDataRequest(dataRequestId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateDataRequest");
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

Updates template content and properties. For HTML templates, you can modify the HTML,
SCSS, headers, footers, name, and description. Changes are applied to your draft
template and do not affect published template versions. The exception is
`parent_folder_id`: moving the template to another folder moves its published versions too.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef03"; // String | 
        UpdateHtmlTemplate data = new UpdateHtmlTemplate(); // UpdateHtmlTemplate | 
        try {
            SuccessMultipleErrorsResponse result = apiInstance.updateTemplate(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateTemplate");
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
| **404** | folder not found |  -  |


## updateTemplateDocument

> SuccessMultipleErrorsResponse updateTemplateDocument(templateId, templateDocument, templateName)

Update a template&#39;s document with a form POST file upload

Upload a new PDF file to update a PDF template's document. This replaces the
template's PDF while preserving all of the existing fields. If you upload a PDF with
fewer pages than the current document, any fields on the removed pages will be deleted.


### Example

```java
import java.io.File;
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        File templateDocument = new File("/path/to/file"); // File | 
        String templateName = "templateName_example"; // String | 
        try {
            SuccessMultipleErrorsResponse result = apiInstance.updateTemplateDocument(templateId, templateDocument, templateName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateTemplateDocument");
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
| **templateDocument** | **File**|  | |
| **templateName** | **String**|  | [optional] |

### Return type

[**SuccessMultipleErrorsResponse**](SuccessMultipleErrorsResponse.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | returns a template with updated document |  -  |
| **401** | authentication failed |  -  |


## updateTemplateDocumentFromUpload

> SuccessMultipleErrorsResponse updateTemplateDocumentFromUpload(templateId, data)

Update a template&#39;s document with a cached S3 file upload

Updates a PDF template's document using a cached file upload. This is a three-step process:
First, request a presigned URL to upload your PDF file to our S3 bucket. Then, use that URL to
upload your PDF file. Finally, submit the ID of the uploaded file to replace the template's
document.


### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | 
        UpdatePdfTemplate data = new UpdatePdfTemplate(); // UpdatePdfTemplate | 
        try {
            SuccessMultipleErrorsResponse result = apiInstance.updateTemplateDocumentFromUpload(templateId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateTemplateDocumentFromUpload");
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
| **data** | [**UpdatePdfTemplate**](UpdatePdfTemplate.md)|  | |

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
| **200** | returns a template with updated document |  -  |
| **401** | authentication failed |  -  |


## updateWebhook

> Webhook updateWebhook(webhookId, data)

Update a webhook

Updates the configuration of an existing webhook.

### Example

```java
// Import classes:
import com.docspring.ApiClient;
import com.docspring.ApiException;
import com.docspring.Configuration;
import com.docspring.auth.*;
import com.docspring.model.*;
import com.docspring.Client;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v1");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "whk_1234567890abcdef01"; // String | 
        UpdateWebhookData data = new UpdateWebhookData(); // UpdateWebhookData | 
        try {
            Webhook result = apiInstance.updateWebhook(webhookId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateWebhook");
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
| **webhookId** | **String**|  | |
| **data** | [**UpdateWebhookData**](UpdateWebhookData.md)|  | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#api_token_basic)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook updated |  -  |
| **404** | webhook not found |  -  |
| **401** | authentication failed |  -  |

