# Client

All URIs are relative to *https://sync.api.docspring.com/api/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addTemplateFields**](Client.md#addTemplateFields) | **POST** /templates/{template_id}/fields | Add fields to a template |
| [**copyTemplate**](Client.md#copyTemplate) | **POST** /templates/{template_id}/copy | Copy a template |
| [**createCombinedPdf**](Client.md#createCombinedPdf) | **POST** /combined_pdfs | Combine PDFs |
| [**createCustomFileFromUpload**](Client.md#createCustomFileFromUpload) | **POST** /custom_files | Create a custom file from an upload |
| [**createFolder**](Client.md#createFolder) | **POST** /folders | Create a folder |
| [**createSignatureRequestEvent**](Client.md#createSignatureRequestEvent) | **POST** /signature_requests/{signature_request_id}/events | Record a signature request event |
| [**createSignatureRequestToken**](Client.md#createSignatureRequestToken) | **POST** /signature_requests/{signature_request_id}/tokens | Create a signature request token |
| [**createSubmission**](Client.md#createSubmission) | **POST** /templates/{template_id}/submissions | Generate a PDF |
| [**createSubmissionBatch**](Client.md#createSubmissionBatch) | **POST** /submissions/batches | Generate PDFs in a batch |
| [**createTemplate**](Client.md#createTemplate) | **POST** /templates | Create a template |
| [**createTemplatePreview**](Client.md#createTemplatePreview) | **POST** /templates/{template_id}/previews | Preview a template with data |
| [**createWebhook**](Client.md#createWebhook) | **POST** /webhooks | Create a webhook |
| [**deleteCustomFile**](Client.md#deleteCustomFile) | **DELETE** /custom_files/{custom_file_id} | Delete a custom file |
| [**deleteFolder**](Client.md#deleteFolder) | **DELETE** /folders/{folder_id} | Delete a folder |
| [**deleteTemplate**](Client.md#deleteTemplate) | **DELETE** /templates/{template_id} | Delete a template |
| [**deleteWebhook**](Client.md#deleteWebhook) | **DELETE** /webhooks/{webhook_id} | Delete a webhook |
| [**expireCombinedPdf**](Client.md#expireCombinedPdf) | **DELETE** /combined_pdfs/{combined_pdf_id} | Expire a combined PDF |
| [**expireSubmission**](Client.md#expireSubmission) | **DELETE** /submissions/{submission_id} | Expire a submission |
| [**generateSubmissionFiles**](Client.md#generateSubmissionFiles) | **POST** /submissions/{submission_id}/generate_files | Generate more files |
| [**generateSubmissionPreview**](Client.md#generateSubmissionPreview) | **POST** /submissions/{submission_id}/generate_preview | Generate a preview PDF |
| [**getCombinedPdf**](Client.md#getCombinedPdf) | **GET** /combined_pdfs/{combined_pdf_id} | Get a combined PDF |
| [**getCustomFile**](Client.md#getCustomFile) | **GET** /custom_files/{custom_file_id} | Get a custom file |
| [**getFolder**](Client.md#getFolder) | **GET** /folders/{folder_id} | Get a folder |
| [**getPresignUrl**](Client.md#getPresignUrl) | **GET** /uploads/presign | Get a presigned URL to upload a file |
| [**getSignatureRequest**](Client.md#getSignatureRequest) | **GET** /signature_requests/{signature_request_id} | Get a signature request |
| [**getSubmission**](Client.md#getSubmission) | **GET** /submissions/{submission_id} | Get a submission |
| [**getSubmissionBatch**](Client.md#getSubmissionBatch) | **GET** /submissions/batches/{submission_batch_id} | Get a batch |
| [**getTemplate**](Client.md#getTemplate) | **GET** /templates/{template_id} | Get a template |
| [**getTemplateDiff**](Client.md#getTemplateDiff) | **GET** /templates/{template_id}/diff | Compare a version of a template with the one before it |
| [**getTemplateModelCode**](Client.md#getTemplateModelCode) | **GET** /templates/{template_id}/model_code | Generate typed code for a template's submission data |
| [**getTemplatePageImages**](Client.md#getTemplatePageImages) | **GET** /templates/{template_id}/page_images | Get images of a template's pages |
| [**getTemplatePreview**](Client.md#getTemplatePreview) | **GET** /templates/{template_id}/previews/{preview_id} | Get a template preview |
| [**getTemplateSchema**](Client.md#getTemplateSchema) | **GET** /templates/{template_id}/schema | Get the JSON Schema of a template's submission data |
| [**getWebhook**](Client.md#getWebhook) | **GET** /webhooks/{webhook_id} | Get a webhook |
| [**listCombinedPdfs**](Client.md#listCombinedPdfs) | **GET** /combined_pdfs | List combined PDFs |
| [**listCustomFiles**](Client.md#listCustomFiles) | **GET** /custom_files | List custom files |
| [**listFolders**](Client.md#listFolders) | **GET** /folders | List folders |
| [**listSubmissions**](Client.md#listSubmissions) | **GET** /submissions | List submissions |
| [**listTemplateFields**](Client.md#listTemplateFields) | **GET** /templates/{template_id}/fields | List a template's fields |
| [**listTemplateSubmissions**](Client.md#listTemplateSubmissions) | **GET** /templates/{template_id}/submissions | List a template's submissions |
| [**listTemplates**](Client.md#listTemplates) | **GET** /templates | List templates |
| [**listWebhooks**](Client.md#listWebhooks) | **GET** /webhooks | List webhooks |
| [**moveFolder**](Client.md#moveFolder) | **POST** /folders/{folder_id}/move | Move a folder |
| [**moveTemplate**](Client.md#moveTemplate) | **POST** /templates/{template_id}/move | Move a template to a folder |
| [**publishTemplateVersion**](Client.md#publishTemplateVersion) | **POST** /templates/{template_id}/publish_version | Publish a template version |
| [**removeTemplateFields**](Client.md#removeTemplateFields) | **POST** /templates/{template_id}/fields/remove | Remove fields from a template |
| [**renameFolder**](Client.md#renameFolder) | **POST** /folders/{folder_id}/rename | Rename a folder |
| [**reorderTemplateFields**](Client.md#reorderTemplateFields) | **POST** /templates/{template_id}/fields/reorder | Reorder a template's fields |
| [**restoreTemplateVersion**](Client.md#restoreTemplateVersion) | **POST** /templates/{template_id}/restore_version | Restore a template version |
| [**testAuthentication**](Client.md#testAuthentication) | **GET** /authentication | Test authentication |
| [**updateSignatureRequest**](Client.md#updateSignatureRequest) | **PUT** /signature_requests/{signature_request_id} | Update a signature request |
| [**updateTemplate**](Client.md#updateTemplate) | **PUT** /templates/{template_id} | Update a template |
| [**updateTemplateDocument**](Client.md#updateTemplateDocument) | **PUT** /templates/{template_id}/document | Replace a template's document |
| [**updateTemplateFields**](Client.md#updateTemplateFields) | **PUT** /templates/{template_id}/fields | Update a template's fields |
| [**updateWebhook**](Client.md#updateWebhook) | **PUT** /webhooks/{webhook_id} | Update a webhook |
| [**uploadTemplate**](Client.md#uploadTemplate) | **POST** /templates/upload | Create a template from an uploaded PDF or Word document |
| [**uploadTemplateDocument**](Client.md#uploadTemplateDocument) | **PUT** /templates/{template_id}/document/upload | Replace a template's document with an uploaded file |
| [**validateSubmission**](Client.md#validateSubmission) | **POST** /templates/{template_id}/submissions/validate | Check a submission without creating it |



## addTemplateFields

> TemplateFields addTemplateFields(templateId, body)

Add fields to a template

Adds fields to a template's draft and returns all of its fields. Publish a version for submissions of
published versions to have them.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        AddTemplateFieldsRequest body = new AddTemplateFieldsRequest(); // AddTemplateFieldsRequest | The fields to add to the template's draft.
        try {
            TemplateFields result = apiInstance.addTemplateFields(templateId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#addTemplateFields");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**AddTemplateFieldsRequest**](AddTemplateFieldsRequest.md)| The fields to add to the template's draft. | |

### Return type

[**TemplateFields**](TemplateFields.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | fields added |  -  |
| **409** | the template's PDF hasn't been processed |  -  |
| **422** | invalid fields |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## copyTemplate

> Template copyTemplate(templateId, body)

Copy a template

Copies a template (its draft, or a published version) into a new template.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        CopyTemplateRequest body = new CopyTemplateRequest(); // CopyTemplateRequest | Settings for the copy.
        try {
            Template result = apiInstance.copyTemplate(templateId, body);
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**CopyTemplateRequest**](CopyTemplateRequest.md)| Settings for the copy. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | template copied |  -  |
| **422** | invalid copy |  -  |
| **403** | the plan's template limit is reached |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createCombinedPdf

> CombinedPdf createCombinedPdf(body, wait, idempotencyKey)

Combine PDFs

Merges PDFs into one: submissions, other combined PDFs, templates, custom files (POST /custom_files) and
PDFs from URLs, in the order of `source_pdfs`. The PDF is generated in the background: on sync.api hosts the
request waits for it (unless you pass `wait=false`), otherwise poll GET /combined_pdfs/{combined_pdf_id} until
`state` isn't `pending`.

A template source merges the template's processed PDF by default: the PDF submissions are filled in on,
decrypted and with its form fields removed. Pass `processed: false` to merge the PDF as it was uploaded.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateCombinedPdfRequest body = new CreateCombinedPdfRequest(); // CreateCombinedPdfRequest | The PDFs to merge, and the combined PDF's settings.
        Boolean wait = true; // Boolean | Wait until the PDF has been generated before responding. Default true on sync.api hosts.
        String idempotencyKey = "idempotencyKey_example"; // String | A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another combined PDF. Send a new key with each new combined PDF, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds.
        try {
            CombinedPdf result = apiInstance.createCombinedPdf(body, wait, idempotencyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createCombinedPdf");
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
| **body** | [**CreateCombinedPdfRequest**](CreateCombinedPdfRequest.md)| The PDFs to merge, and the combined PDF's settings. | |
| **wait** | **Boolean**| Wait until the PDF has been generated before responding. Default true on sync.api hosts. | [optional] |
| **idempotencyKey** | **String**| A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another combined PDF. Send a new key with each new combined PDF, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds. | [optional] |

### Return type

[**CombinedPdf**](CombinedPdf.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | combined PDF created |  -  |
| **422** | invalid source PDFs |  -  |
| **403** | not allowed |  -  |
| **402** | not enough credits |  -  |
| **409** | a request with the same Idempotency-Key is still being processed |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's combined_pdf_id instead of sending the request again. |  -  |


## createCustomFileFromUpload

> CustomFile createCustomFileFromUpload(body)

Create a custom file from an upload

Creates a custom file from a PDF you uploaded, so you can merge it with other PDFs. Upload the file with the
presigned upload (GET /uploads/presign) first, then pass its `fields.key` as `cache_id`.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateCustomFileFromUploadRequest body = new CreateCustomFileFromUploadRequest(); // CreateCustomFileFromUploadRequest | The uploaded file to create the custom file from.
        try {
            CustomFile result = apiInstance.createCustomFileFromUpload(body);
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
| **body** | [**CreateCustomFileFromUploadRequest**](CreateCustomFileFromUploadRequest.md)| The uploaded file to create the custom file from. | |

### Return type

[**CustomFile**](CustomFile.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | custom file created |  -  |
| **422** | invalid custom file |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createFolder

> Folder createFolder(body)

Create a folder

Creates a folder for organizing templates. Pass `parent_folder_id` to create it inside another folder.
Folder names are unique within their parent folder.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateFolderRequest body = new CreateFolderRequest(); // CreateFolderRequest | The folder to create.
        try {
            Folder result = apiInstance.createFolder(body);
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
| **body** | [**CreateFolderRequest**](CreateFolderRequest.md)| The folder to create. | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | folder created inside another folder |  -  |
| **422** | invalid folder |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createSignatureRequestEvent

> SignatureRequestEvent createSignatureRequestEvent(signatureRequestId, body)

Record a signature request event

Records something that happened outside DocSpring in the signature request's audit trail: you sent the request
to the person (`send_request`). The audit trail shows it as reported by your account. A finished (completed,
declined or expired) signature request's audit trail takes no more events, and a test API token can't record
one for a live signature request.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String signatureRequestId = "srq_1234567890abcdef01"; // String | The signature request's ID.
        CreateSignatureRequestEventRequest body = new CreateSignatureRequestEventRequest(); // CreateSignatureRequestEventRequest | The event to record.
        try {
            SignatureRequestEvent result = apiInstance.createSignatureRequestEvent(signatureRequestId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createSignatureRequestEvent");
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
| **signatureRequestId** | **String**| The signature request's ID. | |
| **body** | [**CreateSignatureRequestEventRequest**](CreateSignatureRequestEventRequest.md)| The event to record. | |

### Return type

[**SignatureRequestEvent**](SignatureRequestEvent.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | event recorded |  -  |
| **403** | test API token on a live signature request |  -  |
| **409** | signature request finished |  -  |
| **422** | invalid event |  -  |
| **404** | signature request not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createSignatureRequestToken

> SignatureRequestToken createSignatureRequestToken(signatureRequestId, body)

Create a signature request token

Creates a token that opens the signature request without signing in, in a form embedded in your app or from a
link you send. The response is the only time the token's secret is returned. The link works for 24 hours, or
7 days for an `email` token, and a signing page that opened in time keeps working for 7 more days. A test API
token can't create a token for a live signature request.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String signatureRequestId = "srq_1234567890abcdef01"; // String | The signature request's ID.
        CreateSignatureRequestTokenRequest body = new CreateSignatureRequestTokenRequest(); // CreateSignatureRequestTokenRequest | The kind of link to make. Send no body for an `api` token.
        try {
            SignatureRequestToken result = apiInstance.createSignatureRequestToken(signatureRequestId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createSignatureRequestToken");
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
| **signatureRequestId** | **String**| The signature request's ID. | |
| **body** | [**CreateSignatureRequestTokenRequest**](CreateSignatureRequestTokenRequest.md)| The kind of link to make. Send no body for an `api` token. | [optional] |

### Return type

[**SignatureRequestToken**](SignatureRequestToken.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | token created |  -  |
| **403** | test API token on a live signature request |  -  |
| **409** | signature request finished |  -  |
| **422** | invalid token request |  -  |
| **404** | signature request not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createSubmission

> Submission createSubmission(templateId, body, version, wait, idempotencyKey)

Generate a PDF

Creates a submission: fills in a template with your data and generates a PDF. The PDF is generated in the
background: on sync.api hosts the request waits for it (unless you pass `wait=false`), otherwise poll GET
/submissions/{submission_id} until `state` isn't `pending`.

Data that doesn't match the template's fields returns a 422 with an `invalid_data` error. The submission
is still saved, with its errors, so you can find it in DocSpring: the error's `submission_id` is its ID.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        CreateSubmissionRequest body = new CreateSubmissionRequest(); // CreateSubmissionRequest | The submission's data and settings.
        String version = "version_example"; // String | The template version to use: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published).
        Boolean wait = true; // Boolean | Wait until the files have been generated before responding. Default true on sync.api hosts.
        String idempotencyKey = "idempotencyKey_example"; // String | A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another submission. Send a new key with each new submission, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds.
        try {
            Submission result = apiInstance.createSubmission(templateId, body, version, wait, idempotencyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createSubmission");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**CreateSubmissionRequest**](CreateSubmissionRequest.md)| The submission's data and settings. | |
| **version** | **String**| The template version to use: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published). | [optional] |
| **wait** | **Boolean**| Wait until the files have been generated before responding. Default true on sync.api hosts. | [optional] |
| **idempotencyKey** | **String**| A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another submission. Send a new key with each new submission, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds. | [optional] |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | submission created |  -  |
| **422** | invalid data |  -  |
| **402** | not enough credits |  -  |
| **403** | the account is suspended |  -  |
| **404** | template not found |  -  |
| **409** | a request with the same Idempotency-Key is still being processed |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's submission_id instead of sending the request again. |  -  |


## createSubmissionBatch

> SubmissionBatch createSubmissionBatch(body, wait, idempotencyKey)

Generate PDFs in a batch

Creates up to 50 submissions in one request, from one template or several. The PDFs are only generated when
every submission is valid. On sync.api hosts the request waits until every PDF has been generated (unless you
pass `wait=false`), otherwise poll GET /submissions/batches/{submission_batch_id} until `processed_at` is set.

When any submission is invalid, nothing is generated and the request returns a 422. Submissions whose data
doesn't match their template's fields are still saved with their errors (an `invalid_data` error, with each
one's `submission_id` in its details), so you can find them in DocSpring. The other submissions aren't saved.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateSubmissionBatchRequest body = new CreateSubmissionBatchRequest(); // CreateSubmissionBatchRequest | The submissions to create, and the settings they share.
        Boolean wait = true; // Boolean | Wait until every file in the batch has been generated before responding. Default true on sync.api hosts.
        String idempotencyKey = "idempotencyKey_example"; // String | A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another batch. Send a new key with each new batch, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds.
        try {
            SubmissionBatch result = apiInstance.createSubmissionBatch(body, wait, idempotencyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createSubmissionBatch");
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
| **body** | [**CreateSubmissionBatchRequest**](CreateSubmissionBatchRequest.md)| The submissions to create, and the settings they share. | |
| **wait** | **Boolean**| Wait until every file in the batch has been generated before responding. Default true on sync.api hosts. | [optional] |
| **idempotencyKey** | **String**| A key of your own, such as a UUID, that makes it safe to send this request again: for 24 hours, DocSpring answers a request with the same key from the same API token with the first request's response (and an `Idempotent-Replayed: true` header) instead of creating another batch. Send a new key with each new batch, and the same key each time you send the same request again, such as after a timeout, a network error or a 5xx. The same key with a different request is a 422 `idempotency_key_reused`. A 409 `idempotency_key_in_use` means the first request is still being processed: send the request again in a few seconds. | [optional] |

### Return type

[**SubmissionBatch**](SubmissionBatch.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | batch created |  -  |
| **422** | invalid data |  -  |
| **402** | not enough credits |  -  |
| **403** | account suspended |  -  |
| **409** | a request with the same Idempotency-Key is still being processed |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's submission_batch_id instead of sending the request again. |  -  |


## createTemplate

> Template createTemplate(body, wait)

Create a template

Creates an HTML template, or a PDF or Word template from a file you uploaded with the presigned upload (GET
/uploads/presign): pass its `fields.key` as `cache_id`. You can send a link to the file (`document_url`) or
the file in base64 (`document_base64`) instead, or send the file with the request with POST
/templates/upload. A Word template is made from a Word document (.docx) or an OpenDocument text file (.odt),
which DocSpring converts to a Word document. It needs its `output_format`: what each submission makes, a Word
document (`docx`), an OpenDocument file (`odt`) or a PDF.

A PDF template is ready to generate PDFs once DocSpring has processed its PDF, a template created from a
`document_url` once its document has been downloaded, and one created from an .odt once it has been converted
(`ready` is true). On sync.api hosts the request waits for that unless you pass `wait=false`.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateTemplateRequest body = new CreateTemplateRequest(); // CreateTemplateRequest | The template to create.
        Boolean wait = true; // Boolean | Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts.
        try {
            Template result = apiInstance.createTemplate(body, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createTemplate");
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
| **body** | [**CreateTemplateRequest**](CreateTemplateRequest.md)| The template to create. | |
| **wait** | **Boolean**| Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | HTML template created |  -  |
| **422** | invalid template |  -  |
| **403** | the plan's template limit is reached |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's template_id instead of sending the request again. |  -  |


## createTemplatePreview

> TemplatePreview createTemplatePreview(templateId, body, version)

Preview a template with data

Makes PNG images of a template's pages filled in with the data you send (not a PDF), so you can check how an
HTML, PDF or Word template prints with your data before you publish a version or send live data. A Word
template's pages are its PDF's, whatever its `output_format`. It renders the template's draft, or the
published `version` you ask for. A preview makes no submission and uses no credits, and its pages are
watermarked like a test submission's PDF. It's `pending` while it renders: get it with GET
/templates/{template_id}/previews/{preview_id} until it's `processed`, with an image of each page, or `error`.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | The template's ID.
        CreateTemplatePreviewRequest body = new CreateTemplatePreviewRequest(); // CreateTemplatePreviewRequest | The data to render the template with.
        String version = "version_example"; // String | A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`.
        try {
            TemplatePreview result = apiInstance.createTemplatePreview(templateId, body, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#createTemplatePreview");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**CreateTemplatePreviewRequest**](CreateTemplatePreviewRequest.md)| The data to render the template with. | |
| **version** | **String**| A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`. | [optional] |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | preview created |  -  |
| **409** | this server can't convert Word documents to PDF |  -  |
| **422** | no data |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## createWebhook

> Webhook createWebhook(body)

Create a webhook

Creates a webhook that sends a POST request to your endpoint whenever a subscribed event happens. Scope it to
API tokens, templates or folders to receive only their events.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        CreateWebhookRequest body = new CreateWebhookRequest(); // CreateWebhookRequest | The webhook to create.
        try {
            Webhook result = apiInstance.createWebhook(body);
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
| **body** | [**CreateWebhookRequest**](CreateWebhookRequest.md)| The webhook to create. | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | webhook created |  -  |
| **422** | invalid webhook |  -  |
| **403** | the plan's integration limit is reached |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## deleteCustomFile

> CustomFile deleteCustomFile(customFileId)

Delete a custom file

Deletes a custom file and returns it. Use a live API token: test tokens can't delete custom files.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String customFileId = "customFileId_example"; // String | The custom file's ID.
        try {
            CustomFile result = apiInstance.deleteCustomFile(customFileId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#deleteCustomFile");
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
| **customFileId** | **String**| The custom file's ID. | |

### Return type

[**CustomFile**](CustomFile.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | custom file deleted |  -  |
| **403** | test API token |  -  |
| **404** | custom file not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## deleteFolder

> Folder deleteFolder(folderId)

Delete a folder

Deletes an empty folder and returns it. A folder that still has templates or folders in it can't be deleted.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "folderId_example"; // String | The folder's ID.
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
| **folderId** | **String**| The folder's ID. | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | folder deleted |  -  |
| **409** | folder is not empty |  -  |
| **404** | folder not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## deleteTemplate

> Template deleteTemplate(templateId, version)

Delete a template

Deletes a template's draft and all of its published versions, or one published version (`version`). Returns
the template as it was before it was deleted.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | The template's ID.
        String version = "version_example"; // String | Delete only this published version (`1.2.0`) or the draft (`draft`, when no version has been published). Without it, the draft and every published version are deleted.
        try {
            Template result = apiInstance.deleteTemplate(templateId, version);
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| Delete only this published version (`1.2.0`) or the draft (`draft`, when no version has been published). Without it, the draft and every published version are deleted. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template deleted |  -  |
| **409** | template is locked |  -  |
| **404** | template not found |  -  |
| **422** | invalid version |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## deleteWebhook

> Webhook deleteWebhook(webhookId)

Delete a webhook

Deletes a webhook so it stops receiving events, and returns it.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "webhookId_example"; // String | The webhook's ID.
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
| **webhookId** | **String**| The webhook's ID. | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook deleted |  -  |
| **404** | webhook not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## expireCombinedPdf

> CombinedPdf expireCombinedPdf(combinedPdfId)

Expire a combined PDF

Deletes a combined PDF's PDF and returns the expired combined PDF.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String combinedPdfId = "com_1234567890abcdef05"; // String | The combined PDF's ID.
        try {
            CombinedPdf result = apiInstance.expireCombinedPdf(combinedPdfId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#expireCombinedPdf");
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
| **combinedPdfId** | **String**| The combined PDF's ID. | |

### Return type

[**CombinedPdf**](CombinedPdf.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | combined PDF expired |  -  |
| **403** | test API token |  -  |
| **404** | combined PDF not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## expireSubmission

> Submission expireSubmission(submissionId)

Expire a submission

Deletes a submission's data and PDF now, and returns the expired submission.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | The submission's ID.
        try {
            Submission result = apiInstance.expireSubmission(submissionId);
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
| **submissionId** | **String**| The submission's ID. | |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | submission expired |  -  |
| **403** | test API token |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## generateSubmissionFiles

> Submission generateSubmissionFiles(submissionId, body, wait)

Generate more files

Adds formats to a processed submission's files, in the background, without using credits again: `pdf`, the
PDF of a Word template's submission that made only its Word document (converted from that document), `docx`,
the Word document of a Word template's submission that made only its PDF (made again from its data and the
template version it used), `odt`, a Word template's submission's OpenDocument file (converted from its Word
document, or from one made again when it didn't keep one), and `png`, a PNG image of each page of the PDF (up
to 100 pages), which makes the PDF first when the submission doesn't have one. To make them with the submission, add them to
`output_formats` when you create it.

Each new file is listed in `files` while it's made: on sync.api hosts the request waits for them (unless you
pass `wait=false`), otherwise poll GET /submissions/{submission_id} until none of their `state` is `pending`.
A file that couldn't be made has the state `error` and an `error_message`, and the submission stays
processed. Asking for a format the submission already has (or is making) changes nothing.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | The submission's ID.
        GenerateSubmissionFilesRequest body = new GenerateSubmissionFilesRequest(); // GenerateSubmissionFilesRequest | The formats to make.
        Boolean wait = true; // Boolean | Wait until the files have been generated before responding. Default true on sync.api hosts.
        try {
            Submission result = apiInstance.generateSubmissionFiles(submissionId, body, wait);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#generateSubmissionFiles");
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
| **submissionId** | **String**| The submission's ID. | |
| **body** | [**GenerateSubmissionFilesRequest**](GenerateSubmissionFilesRequest.md)| The formats to make. | |
| **wait** | **Boolean**| Wait until the files have been generated before responding. Default true on sync.api hosts. | [optional] |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | images of the pages requested |  -  |
| **409** | files not possible |  -  |
| **422** | invalid request |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's submission_id instead of sending the request again. |  -  |


## generateSubmissionPreview

> Submission generateSubmissionPreview(submissionId)

Generate a preview PDF

Generates a preview of a submission's PDF in the background, such as for a submission still waiting for its
signature requests. It's in `files.preview` once `preview_generated_at` changes.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef03"; // String | The submission's ID.
        try {
            Submission result = apiInstance.generateSubmissionPreview(submissionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#generateSubmissionPreview");
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
| **submissionId** | **String**| The submission's ID. | |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | preview requested |  -  |
| **409** | preview not possible |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getCombinedPdf

> CombinedPdf getCombinedPdf(combinedPdfId)

Get a combined PDF

Returns a combined PDF, with a temporary link to download it once it has been generated.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String combinedPdfId = "com_1234567890abcdef05"; // String | The combined PDF's ID.
        try {
            CombinedPdf result = apiInstance.getCombinedPdf(combinedPdfId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getCombinedPdf");
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
| **combinedPdfId** | **String**| The combined PDF's ID. | |

### Return type

[**CombinedPdf**](CombinedPdf.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | combined PDF |  -  |
| **404** | combined PDF not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getCustomFile

> CustomFile getCustomFile(customFileId)

Get a custom file

Returns a custom file, with a temporary URL to download it.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String customFileId = "customFileId_example"; // String | The custom file's ID.
        try {
            CustomFile result = apiInstance.getCustomFile(customFileId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getCustomFile");
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
| **customFileId** | **String**| The custom file's ID. | |

### Return type

[**CustomFile**](CustomFile.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | custom file found |  -  |
| **404** | custom file not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getFolder

> Folder getFolder(folderId)

Get a folder

Returns a folder.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "folderId_example"; // String | The folder's ID.
        try {
            Folder result = apiInstance.getFolder(folderId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getFolder");
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
| **folderId** | **String**| The folder's ID. | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | folder found |  -  |
| **404** | folder not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getPresignUrl

> UploadPresign getPresignUrl()

Get a presigned URL to upload a file

Returns a presigned S3 form for uploading a file directly to DocSpring, for files too large to send in a
request body. POST the `fields` and the file (as `file`) to `url` as multipart/form-data, then pass
`fields.key` as the `cache_id` when you create a custom file.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        try {
            UploadPresign result = apiInstance.getPresignUrl();
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

[**UploadPresign**](UploadPresign.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | presigned URL created |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getSignatureRequest

> SignatureRequest getSignatureRequest(signatureRequestId)

Get a signature request

Returns a signature request, with the values the person has entered so far.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String signatureRequestId = "srq_1234567890abcdef01"; // String | The signature request's ID.
        try {
            SignatureRequest result = apiInstance.getSignatureRequest(signatureRequestId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getSignatureRequest");
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
| **signatureRequestId** | **String**| The signature request's ID. | |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | signature request |  -  |
| **404** | signature request not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getSubmission

> Submission getSubmission(submissionId)

Get a submission

Returns a submission, with its data and links to download its PDF.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionId = "sub_1234567890abcdef01"; // String | The submission's ID.
        try {
            Submission result = apiInstance.getSubmission(submissionId);
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
| **submissionId** | **String**| The submission's ID. | |

### Return type

[**Submission**](Submission.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | processed submission |  -  |
| **404** | submission not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getSubmissionBatch

> SubmissionBatch getSubmissionBatch(submissionBatchId, includeData)

Get a batch

Returns a batch with its submissions. The batch has finished once `processed_at` is set: its `state` is
`processed` when every PDF was generated, or `error` when any submission failed.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String submissionBatchId = "sbb_1234567890abcdef05"; // String | The batch's ID.
        Boolean includeData = true; // Boolean | Include each submission's `data` (null without it).
        try {
            SubmissionBatch result = apiInstance.getSubmissionBatch(submissionBatchId, includeData);
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
| **submissionBatchId** | **String**| The batch's ID. | |
| **includeData** | **Boolean**| Include each submission's `data` (null without it). | [optional] |

### Return type

[**SubmissionBatch**](SubmissionBatch.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | batch |  -  |
| **404** | batch not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplate

> Template getTemplate(templateId, version)

Get a template

Returns a template: its draft, or one of its published versions.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        String version = "latest"; // String | A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`.
        try {
            Template result = apiInstance.getTemplate(templateId, version);
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | PDF template |  -  |
| **404** | template not found |  -  |
| **422** | invalid version |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplateDiff

> TemplateDiff getTemplateDiff(templateId, version)

Compare a version of a template with the one before it

Returns what changed in the template's draft since its latest published version (or in a published version
since the one before it): fields added, removed, changed and moved, the settings that changed, and whether
the document was replaced. Check it before you publish a version.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        String version = "0.1.0"; // String | A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`.
        try {
            TemplateDiff result = apiInstance.getTemplateDiff(templateId, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplateDiff");
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`. | [optional] |

### Return type

[**TemplateDiff**](TemplateDiff.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | the draft's changes since the latest published version |  -  |
| **409** | the template's PDF hasn't been processed |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplateModelCode

> TemplateModelCode getTemplateModelCode(templateId, lang, version, justTypes)

Generate typed code for a template's submission data

Generates types for a template's submission data in TypeScript, JavaScript, Ruby, Python, PHP, Java, C#,
Elixir, Go or Rust, so your app catches mistakes before it calls the API. `root_type_name` is the type of the
whole `data` object, and `just_types=true` leaves out the code that converts JSON to and from the types. Java
returns every class in `code`, each under a `// ClassName.java` comment. A template with no named fields
returns 422.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        ModelCodeLanguage lang = ModelCodeLanguage.fromValue("typescript"); // ModelCodeLanguage | The language to generate the code in.
        String version = "draft"; // String | The template version: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published), the version a submission uses by default.
        Boolean justTypes = true; // Boolean | Return only the types (interfaces, classes or structs), without the code that converts JSON to and from them. Default false. JavaScript has no types, PHP has no types-only code, and Rust's code is only types (serde converts the JSON), so theirs is the same either way.
        try {
            TemplateModelCode result = apiInstance.getTemplateModelCode(templateId, lang, version, justTypes);
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
| **templateId** | **String**| The template's ID. | |
| **lang** | **ModelCodeLanguage**| The language to generate the code in. | [enum: typescript, javascript, ruby, python, php, java, csharp, elixir, go, rust] |
| **version** | **String**| The template version: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published), the version a submission uses by default. | [optional] |
| **justTypes** | **Boolean**| Return only the types (interfaces, classes or structs), without the code that converts JSON to and from them. Default false. JavaScript has no types, PHP has no types-only code, and Rust's code is only types (serde converts the JSON), so theirs is the same either way. | [optional] |

### Return type

[**TemplateModelCode**](TemplateModelCode.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | model code |  -  |
| **422** | unknown language |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplatePageImages

> TemplatePageImages getTemplatePageImages(templateId, version)

Get images of a template's pages

Returns a JPEG image of each page of a PDF template's PDF, with temporary links to download them: the draft's
PDF, or a published version's. Use them to see the pages that fields are placed on.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        String version = "latest"; // String | A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`.
        try {
            TemplatePageImages result = apiInstance.getTemplatePageImages(templateId, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplatePageImages");
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`. | [optional] |

### Return type

[**TemplatePageImages**](TemplatePageImages.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | page images |  -  |
| **409** | no page images |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplatePreview

> TemplatePreview getTemplatePreview(templateId, previewId)

Get a template preview

Returns a preview made with POST /templates/{template_id}/previews. Once it's `processed`, `pages` has a PNG
image of each page with a temporary link to download it: a preview has no PDF. Previews are deleted an hour
after they're created.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef02"; // String | The template's ID.
        String previewId = "tpv_1234567890abcdef0123"; // String | The preview's ID.
        try {
            TemplatePreview result = apiInstance.getTemplatePreview(templateId, previewId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#getTemplatePreview");
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
| **templateId** | **String**| The template's ID. | |
| **previewId** | **String**| The preview's ID. | |

### Return type

[**TemplatePreview**](TemplatePreview.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | preview |  -  |
| **404** | preview not found |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getTemplateSchema

> Map&lt;String, Object&gt; getTemplateSchema(templateId, version)

Get the JSON Schema of a template's submission data

Returns the JSON Schema that a submission's `data` must match. Use it to check data before you create
submissions, or to build a form for the template's fields.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        String version = "draft"; // String | The template version: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published), the version a submission uses by default.
        try {
            Map<String, Object> result = apiInstance.getTemplateSchema(templateId, version);
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| The template version: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published), the version a submission uses by default. | [optional] |

### Return type

**Map&lt;String, Object&gt;**

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template schema |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## getWebhook

> Webhook getWebhook(webhookId)

Get a webhook

Returns a webhook.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "webhookId_example"; // String | The webhook's ID.
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
| **webhookId** | **String**| The webhook's ID. | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook found |  -  |
| **404** | webhook not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listCombinedPdfs

> CombinedPdfList listCombinedPdfs(limit, cursor)

List combined PDFs

Returns the combined PDFs in your account, newest first, one page at a time.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        try {
            CombinedPdfList result = apiInstance.listCombinedPdfs(limit, cursor);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listCombinedPdfs");
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
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |

### Return type

[**CombinedPdfList**](CombinedPdfList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | combined PDFs |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listCustomFiles

> CustomFileList listCustomFiles(limit, cursor)

List custom files

Returns the custom files in your account, newest first, one page at a time.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        try {
            CustomFileList result = apiInstance.listCustomFiles(limit, cursor);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listCustomFiles");
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
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |

### Return type

[**CustomFileList**](CustomFileList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | custom files |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listFolders

> FolderList listFolders(parentFolderId, limit, cursor)

List folders

Returns the folders in your account, newest first, one page at a time. Pass `parent_folder_id` to list the
folders in one folder.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String parentFolderId = "fld_1234567890abcdef02"; // String | Only list the folders in this folder. Without it, the list has every folder, at any depth.
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "fld_1234567890abcdef02"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        try {
            FolderList result = apiInstance.listFolders(parentFolderId, limit, cursor);
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
| **parentFolderId** | **String**| Only list the folders in this folder. Without it, the list has every folder, at any depth. | [optional] |
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |

### Return type

[**FolderList**](FolderList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | folders in a folder |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listSubmissions

> SubmissionList listSubmissions(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles)

List submissions

Returns the submissions in your account, newest first, one page at a time. Each one is a summary: its `data`
is null unless you pass `include_data=true`, and its `files` are empty unless you pass `include_files=true`.
Get a submission by its ID for its signature requests, uploads and page images.


### Example

```java
import java.time.OffsetDateTime;
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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | Only list this template's submissions.
        Boolean test = false; // Boolean | Only list test submissions (true) or live submissions (false).
        OffsetDateTime createdAfter = OffsetDateTime.parse("2018-10-20T08:40:00Z"); // OffsetDateTime | Only list submissions created after this time (RFC 3339, such as `2025-01-31T09:00:00Z`).
        OffsetDateTime createdBefore = OffsetDateTime.parse("2018-10-20T09:00:00Z"); // OffsetDateTime | Only list submissions created before this time.
        Boolean includeData = true; // Boolean | Include each submission's `data` (null without it).
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        SubmissionState state = SubmissionState.fromValue("pending"); // SubmissionState | Only list submissions in this state (one state per request). The ones that failed are `invalid_data`, `error`, `syntax_error`, `image_download_failed` and `image_processing_failed`, and one still `pending` an hour after it was created is stuck.
        Boolean includeFiles = true; // Boolean | Include each submission's generated files and their download links (`files`, empty without it), without the page images' links.
        try {
            SubmissionList result = apiInstance.listSubmissions(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles);
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
| **templateId** | **String**| Only list this template's submissions. | [optional] |
| **test** | **Boolean**| Only list test submissions (true) or live submissions (false). | [optional] |
| **createdAfter** | **OffsetDateTime**| Only list submissions created after this time (RFC 3339, such as `2025-01-31T09:00:00Z`). | [optional] |
| **createdBefore** | **OffsetDateTime**| Only list submissions created before this time. | [optional] |
| **includeData** | **Boolean**| Include each submission's `data` (null without it). | [optional] |
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |
| **state** | **SubmissionState**| Only list submissions in this state (one state per request). The ones that failed are `invalid_data`, `error`, `syntax_error`, `image_download_failed` and `image_processing_failed`, and one still `pending` an hour after it was created is stuck. | [optional] [enum: pending, processed, invalid_data, error, image_download_failed, image_processing_failed, waiting_for_signature_requests, syntax_error, insufficient_credits, account_suspended, license_revoked, accidental, declined] |
| **includeFiles** | **Boolean**| Include each submission's generated files and their download links (`files`, empty without it), without the page images' links. | [optional] |

### Return type

[**SubmissionList**](SubmissionList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | submissions |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listTemplateFields

> TemplateFields listTemplateFields(templateId, version)

List a template's fields

Returns a template's fields with all of their settings, page by page: the draft's fields, or a published
version's. A PDF template's fields are placed on its pages: GET /templates/{template_id}/page_images has images
of the pages.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        String version = "latest"; // String | A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`.
        try {
            TemplateFields result = apiInstance.listTemplateFields(templateId, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#listTemplateFields");
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
| **templateId** | **String**| The template's ID. | |
| **version** | **String**| A published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `draft`. | [optional] |

### Return type

[**TemplateFields**](TemplateFields.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | fields |  -  |
| **409** | the template's PDF hasn't been processed |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listTemplateSubmissions

> SubmissionList listTemplateSubmissions(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles)

List a template's submissions

Returns a template's submissions (from every version of the template), newest first.

### Example

```java
import java.time.OffsetDateTime;
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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        Boolean test = true; // Boolean | Only list test submissions (true) or live submissions (false).
        OffsetDateTime createdAfter = OffsetDateTime.now(); // OffsetDateTime | Only list submissions created after this time (RFC 3339, such as `2025-01-31T09:00:00Z`).
        OffsetDateTime createdBefore = OffsetDateTime.now(); // OffsetDateTime | Only list submissions created before this time.
        Boolean includeData = true; // Boolean | Include each submission's `data` (null without it).
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        SubmissionState state = SubmissionState.fromValue("pending"); // SubmissionState | Only list submissions in this state (one state per request). The ones that failed are `invalid_data`, `error`, `syntax_error`, `image_download_failed` and `image_processing_failed`, and one still `pending` an hour after it was created is stuck.
        Boolean includeFiles = true; // Boolean | Include each submission's generated files and their download links (`files`, empty without it), without the page images' links.
        try {
            SubmissionList result = apiInstance.listTemplateSubmissions(templateId, test, createdAfter, createdBefore, includeData, limit, cursor, state, includeFiles);
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
| **templateId** | **String**| The template's ID. | |
| **test** | **Boolean**| Only list test submissions (true) or live submissions (false). | [optional] |
| **createdAfter** | **OffsetDateTime**| Only list submissions created after this time (RFC 3339, such as `2025-01-31T09:00:00Z`). | [optional] |
| **createdBefore** | **OffsetDateTime**| Only list submissions created before this time. | [optional] |
| **includeData** | **Boolean**| Include each submission's `data` (null without it). | [optional] |
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |
| **state** | **SubmissionState**| Only list submissions in this state (one state per request). The ones that failed are `invalid_data`, `error`, `syntax_error`, `image_download_failed` and `image_processing_failed`, and one still `pending` an hour after it was created is stuck. | [optional] [enum: pending, processed, invalid_data, error, image_download_failed, image_processing_failed, waiting_for_signature_requests, syntax_error, insufficient_credits, account_suspended, license_revoked, accidental, declined] |
| **includeFiles** | **Boolean**| Include each submission's generated files and their download links (`files`, empty without it), without the page images' links. | [optional] |

### Return type

[**SubmissionList**](SubmissionList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template's submissions |  -  |
| **404** | template not found |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listTemplates

> TemplateSummaryList listTemplates(query, parentFolderId, limit, cursor)

List templates

Returns the templates in your account (their drafts), newest first, one page at a time. Each one is a summary:
get a template by its ID for its settings, its PDF in full, its HTML, defaults and published versions.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String query = "rental"; // String | Only list templates whose name contains this text (ignoring case).
        String parentFolderId = "fld_1234567890abcdef01"; // String | Only list the templates in this folder (not in its subfolders).
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        try {
            TemplateSummaryList result = apiInstance.listTemplates(query, parentFolderId, limit, cursor);
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
| **query** | **String**| Only list templates whose name contains this text (ignoring case). | [optional] |
| **parentFolderId** | **String**| Only list the templates in this folder (not in its subfolders). | [optional] |
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |

### Return type

[**TemplateSummaryList**](TemplateSummaryList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | templates |  -  |
| **422** | invalid query parameters |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## listWebhooks

> WebhookList listWebhooks(eventType, mode, templateId, folderId, apiTokenId, limit, cursor)

List webhooks

Returns the webhooks in your account, newest first, one page at a time. Filter them by event type, mode, or
the API token, template or folder they're scoped to.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        WebhookEventType eventType = WebhookEventType.fromValue("submission.processed"); // WebhookEventType | Only list webhooks that subscribe to this event.
        WebhookMode mode = WebhookMode.fromValue("test"); // WebhookMode | Only list webhooks set to this mode.
        String templateId = "tpl_1234567890abcdef01"; // String | Only list webhooks scoped to this template.
        String folderId = "folderId_example"; // String | Only list webhooks scoped to this folder.
        String apiTokenId = "apiTokenId_example"; // String | Only list webhooks scoped to this API token.
        Integer limit = 50; // Integer | How many items to return (1-100, default 50).
        String cursor = "cursor_example"; // String | The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one.
        try {
            WebhookList result = apiInstance.listWebhooks(eventType, mode, templateId, folderId, apiTokenId, limit, cursor);
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
| **eventType** | **WebhookEventType**| Only list webhooks that subscribe to this event. | [optional] [enum: submission.processed, submission.failed, submission.declined, signature_request.viewed, signature_request.completed, signature_request.declined, combined_pdf.processed, combined_pdf.failed, submission_batch.processed, submission_batch.failed, submission.created, submission.updated, submission.expired, signature_request.updated, combined_pdf.expired, template.created, template.updated, template.deleted, webhook.created, webhook.updated, webhook.deleted, custom_file.created, folder.created, folder.updated, folder.deleted] |
| **mode** | **WebhookMode**| Only list webhooks set to this mode. | [optional] [enum: test, live] |
| **templateId** | **String**| Only list webhooks scoped to this template. | [optional] |
| **folderId** | **String**| Only list webhooks scoped to this folder. | [optional] |
| **apiTokenId** | **String**| Only list webhooks scoped to this API token. | [optional] |
| **limit** | **Integer**| How many items to return (1-100, default 50). | [optional] [default to 50] |
| **cursor** | **String**| The previous page's `next_cursor`, to get the next page. It's the ID of that page's last item, so get the next page before you delete or change the items on this one. | [optional] |

### Return type

[**WebhookList**](WebhookList.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhooks for a template and event |  -  |
| **422** | unknown event type |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## moveFolder

> Folder moveFolder(folderId, body)

Move a folder

Moves a folder into another folder, or to the root with `parent_folder_id: null`. Its templates and folders
move with it. A folder can't move into itself or one of its own folders.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "folderId_example"; // String | The folder's ID.
        MoveFolderRequest body = new MoveFolderRequest(); // MoveFolderRequest | Where to move the folder.
        try {
            Folder result = apiInstance.moveFolder(folderId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#moveFolder");
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
| **folderId** | **String**| The folder's ID. | |
| **body** | [**MoveFolderRequest**](MoveFolderRequest.md)| Where to move the folder. | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | folder moved into another folder |  -  |
| **422** | invalid move |  -  |
| **404** | folder not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## moveTemplate

> Template moveTemplate(templateId, body)

Move a template to a folder

Moves a template and all of its published versions to a folder, or to the root (`null`).

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        MoveTemplateRequest body = new MoveTemplateRequest(); // MoveTemplateRequest | Where to move the template.
        try {
            Template result = apiInstance.moveTemplate(templateId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#moveTemplate");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**MoveTemplateRequest**](MoveTemplateRequest.md)| Where to move the template. | |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template moved |  -  |
| **422** | invalid move |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## publishTemplateVersion

> TemplateVersion publishTemplateVersion(templateId, body)

Publish a template version

Publishes the template's draft as a new version. Its content (the PDF or HTML, fields, name and description)
never changes, while settings such as `webhook_url` and `public_submissions` keep following the draft.
`version_type` says which part of the latest version number goes up. While the template's PDF is downloading
or being processed, or DocSpring is setting up its fields, it returns a 409 that says so.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        PublishTemplateVersionRequest body = new PublishTemplateVersionRequest(); // PublishTemplateVersionRequest | The version to publish.
        try {
            TemplateVersion result = apiInstance.publishTemplateVersion(templateId, body);
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**PublishTemplateVersionRequest**](PublishTemplateVersionRequest.md)| The version to publish. | |

### Return type

[**TemplateVersion**](TemplateVersion.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | version published |  -  |
| **422** | invalid version type |  -  |
| **404** | template not found |  -  |
| **409** | no changes to publish |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## removeTemplateFields

> TemplateFields removeTemplateFields(templateId, body)

Remove fields from a template

Removes fields from a template's draft and returns the fields that are left. Conditional logic that used only
the removed fields is removed too.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        RemoveTemplateFieldsRequest body = new RemoveTemplateFieldsRequest(); // RemoveTemplateFieldsRequest | The fields to remove from the template's draft.
        try {
            TemplateFields result = apiInstance.removeTemplateFields(templateId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#removeTemplateFields");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**RemoveTemplateFieldsRequest**](RemoveTemplateFieldsRequest.md)| The fields to remove from the template's draft. | |

### Return type

[**TemplateFields**](TemplateFields.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | fields removed |  -  |
| **422** | a field the template does not have |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## renameFolder

> Folder renameFolder(folderId, body)

Rename a folder

Renames a folder. The name must be unique within its parent folder.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String folderId = "folderId_example"; // String | The folder's ID.
        RenameFolderRequest body = new RenameFolderRequest(); // RenameFolderRequest | The folder's new name.
        try {
            Folder result = apiInstance.renameFolder(folderId, body);
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
| **folderId** | **String**| The folder's ID. | |
| **body** | [**RenameFolderRequest**](RenameFolderRequest.md)| The folder's new name. | |

### Return type

[**Folder**](Folder.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | folder renamed |  -  |
| **422** | name already exists |  -  |
| **404** | folder not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## reorderTemplateFields

> TemplateFields reorderTemplateFields(templateId, body)

Reorder a template's fields

Changes the order of the fields in a template's draft and returns them in their new order. Send every field's
ID: each field stays on its page, and a page's fields are printed in this order, so a later field prints over
an earlier one where they overlap. Their values are in this order in the template's data schema and forms.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        ReorderTemplateFieldsRequest body = new ReorderTemplateFieldsRequest(); // ReorderTemplateFieldsRequest | The new order of the fields in the template's draft.
        try {
            TemplateFields result = apiInstance.reorderTemplateFields(templateId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#reorderTemplateFields");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**ReorderTemplateFieldsRequest**](ReorderTemplateFieldsRequest.md)| The new order of the fields in the template's draft. | |

### Return type

[**TemplateFields**](TemplateFields.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | fields reordered |  -  |
| **422** | a field missing from the order |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## restoreTemplateVersion

> Template restoreTemplateVersion(templateId, body)

Restore a template version

Replaces the template's draft with a copy of one of its published versions. The draft keeps its settings that apply to every version, such as `webhook_url`.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        RestoreTemplateVersionRequest body = new RestoreTemplateVersionRequest(); // RestoreTemplateVersionRequest | The version to restore.
        try {
            Template result = apiInstance.restoreTemplateVersion(templateId, body);
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**RestoreTemplateVersionRequest**](RestoreTemplateVersionRequest.md)| The version to restore. | |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | version restored |  -  |
| **409** | template is locked |  -  |
| **422** | unknown version |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## testAuthentication

> AuthenticationCheck testAuthentication()

Test authentication

Checks whether your API token is valid by making an authenticated request. This endpoint is useful for
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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        try {
            AuthenticationCheck result = apiInstance.testAuthentication();
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

[**AuthenticationCheck**](AuthenticationCheck.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | authentication succeeded |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## updateSignatureRequest

> SignatureRequest updateSignatureRequest(signatureRequestId, body)

Update a signature request

Changes a pending signature request's metadata, or how your app authenticated the person (for the audit trail).
Once the person has opened it, only its metadata can be changed, and a completed or declined signature
request can't be changed.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String signatureRequestId = "srq_1234567890abcdef01"; // String | The signature request's ID.
        UpdateSignatureRequestRequest body = new UpdateSignatureRequestRequest(); // UpdateSignatureRequestRequest | The settings to change. Properties left out keep their values.
        try {
            SignatureRequest result = apiInstance.updateSignatureRequest(signatureRequestId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateSignatureRequest");
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
| **signatureRequestId** | **String**| The signature request's ID. | |
| **body** | [**UpdateSignatureRequestRequest**](UpdateSignatureRequestRequest.md)| The settings to change. Properties left out keep their values. | |

### Return type

[**SignatureRequest**](SignatureRequest.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | signature request updated |  -  |
| **409** | signature request completed |  -  |
| **422** | invalid request |  -  |
| **404** | signature request not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## updateTemplate

> Template updateTemplate(templateId, body)

Update a template

Changes a template's draft. Properties left out keep their values. `defaults` and `html_engine_options`
replace the whole object, and `field_groups` changes only the groups it lists. Settings such as
`webhook_url`, `public_submissions` and `expire_after` apply to every published version too, and setting
`parent_folder_id` moves the template and all of its published versions.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        UpdateTemplateRequest body = new UpdateTemplateRequest(); // UpdateTemplateRequest | The settings to change. Properties left out keep their values.
        try {
            Template result = apiInstance.updateTemplate(templateId, body);
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**UpdateTemplateRequest**](UpdateTemplateRequest.md)| The settings to change. Properties left out keep their values. | |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | template updated |  -  |
| **409** | template is locked |  -  |
| **422** | invalid field group changes |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## updateTemplateDocument

> Template updateTemplateDocument(templateId, body, wait)

Replace a template's document

Replaces a PDF template's PDF, or a Word template's Word document (from a .docx or an .odt), with one you
uploaded with the presigned upload (GET /uploads/presign) (`cache_id`), a link to download it from
(`document_url`), or the file in base64 (`document_base64`). A PDF template's fields stay where they are,
unless `reimport_fields` replaces them with the new PDF's fillable fields, and a Word template gets a field
for each new tag. To send the file as `multipart/form-data` instead, use PUT
/templates/{template_id}/document/upload.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        UpdateTemplateDocumentRequest body = new UpdateTemplateDocumentRequest(); // UpdateTemplateDocumentRequest | The new PDF, or a Word template's new Word document, as one of `cache_id`, `document_url` and `document_base64`.
        Boolean wait = true; // Boolean | Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts.
        try {
            Template result = apiInstance.updateTemplateDocument(templateId, body, wait);
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**UpdateTemplateDocumentRequest**](UpdateTemplateDocumentRequest.md)| The new PDF, or a Word template's new Word document, as one of `cache_id`, `document_url` and `document_base64`. | |
| **wait** | **Boolean**| Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | PDF replaced |  -  |
| **409** | template is locked, so its fields can't be re-imported |  -  |
| **422** | no document, or more than one |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's template_id instead of sending the request again. |  -  |


## updateTemplateFields

> TemplateFields updateTemplateFields(templateId, body)

Update a template's fields

Changes fields of a template's draft and returns all of its fields. Settings left out keep their values. A
shared setting (`type`, `required`, `default`, ...) changes for every field with the same name.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        UpdateTemplateFieldsRequest body = new UpdateTemplateFieldsRequest(); // UpdateTemplateFieldsRequest | The fields to change in the template's draft.
        try {
            TemplateFields result = apiInstance.updateTemplateFields(templateId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#updateTemplateFields");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**UpdateTemplateFieldsRequest**](UpdateTemplateFieldsRequest.md)| The fields to change in the template's draft. | |

### Return type

[**TemplateFields**](TemplateFields.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | fields updated |  -  |
| **422** | invalid changes |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## updateWebhook

> Webhook updateWebhook(webhookId, body)

Update a webhook

Updates a webhook. Only the properties you send change.

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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String webhookId = "webhookId_example"; // String | The webhook's ID.
        UpdateWebhookRequest body = new UpdateWebhookRequest(); // UpdateWebhookRequest | The settings to change. Properties left out keep their values.
        try {
            Webhook result = apiInstance.updateWebhook(webhookId, body);
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
| **webhookId** | **String**| The webhook's ID. | |
| **body** | [**UpdateWebhookRequest**](UpdateWebhookRequest.md)| The settings to change. Properties left out keep their values. | |

### Return type

[**Webhook**](Webhook.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | webhook updated |  -  |
| **403** | turning the webhook on would go over the plan's integration limit |  -  |
| **404** | webhook not found |  -  |
| **422** | invalid webhook |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |


## uploadTemplate

> Template uploadTemplate(document, wait, name, description, parentFolderId, aiFieldNamingLanguage, detectFields, fieldSource, fieldNaming, fieldLogic, outputFormat)

Create a template from an uploaded PDF or Word document

Creates a PDF template from a PDF, or a Word template from a Word document (.docx) or an OpenDocument text
file (.odt), sent with the request (`multipart/form-data`). A Word template needs its `output_format`. For
large files, upload the file with the presigned upload (GET /uploads/presign) and create the template with
POST /templates.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        File document = new File("/path/to/file"); // File | A PDF (for a PDF template) or a Word document (.docx or .odt, for a Word template). DocSpring converts an OpenDocument text file (.odt) to a Word document after responding: the template's `document.state` is `converting` until then (sync.api hosts wait for it).
        Boolean wait = true; // Boolean | Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts.
        String name = "name_example"; // String | The template's name.
        String description = "description_example"; // String | The template's description.
        String parentFolderId = "parentFolderId_example"; // String | The folder to put the template in. Left out, it's created at the root.
        AiFieldNamingLanguage aiFieldNamingLanguage = AiFieldNamingLanguage.fromValue("auto"); // AiFieldNamingLanguage | The language AI field setup names fields in: `auto` uses the form's language when it's written in the Latin alphabet without accents, and English otherwise; `english` always uses English; `form_language` uses the form's language and script. Default: your account's template settings.
        Boolean detectFields = true; // Boolean | Set up the PDF's fields as DocSpring's "Automatically detect fields" upload option does: import or detect the fields, name them with AI, and set up conditional logic. `field_source`, `field_naming` and `field_logic` choose how. Default false. `document.page_processing_statuses` and `document.field_logic_status` show how it's going, and `document.state` becomes `processed` once every page's fields are set up.
        FieldSetupSource fieldSource = FieldSetupSource.fromValue("auto"); // FieldSetupSource | With `detect_fields`, where the fields come from. `auto` (the default) imports the form fields of a fillable PDF and detects the fields of a PDF without them; `pdf_detection` detects the fields from the page layout, even on a fillable PDF; `pdf_form_fields` only imports the PDF's form fields.
        FieldSetupNaming fieldNaming = FieldSetupNaming.fromValue("ai"); // FieldSetupNaming | With `detect_fields`, how the fields are named. `ai` (the default) names them and sets their types and settings with AI; `preserve` keeps the names of the PDF's form fields, and AI only names the fields it detected. `preserve` needs `field_source` `auto` or `pdf_form_fields`.
        FieldSetupLogic fieldLogic = FieldSetupLogic.fromValue("ai"); // FieldSetupLogic | With `detect_fields`, whether AI reads the whole form once the fields are named and sets up conditional logic and required fields (`ai`) or not (`none`). Default: your account's template settings.
        OutputFormat outputFormat = OutputFormat.fromValue("pdf"); // OutputFormat | What each submission of a Word template makes unless its request sets `output_formats`: `docx` (a Word document), `odt` (an OpenDocument file, converted from the Word document) or `pdf`. Required when `document` is a Word document.
        try {
            Template result = apiInstance.uploadTemplate(document, wait, name, description, parentFolderId, aiFieldNamingLanguage, detectFields, fieldSource, fieldNaming, fieldLogic, outputFormat);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#uploadTemplate");
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
| **document** | **File**| A PDF (for a PDF template) or a Word document (.docx or .odt, for a Word template). DocSpring converts an OpenDocument text file (.odt) to a Word document after responding: the template's `document.state` is `converting` until then (sync.api hosts wait for it). | |
| **wait** | **Boolean**| Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts. | [optional] |
| **name** | **String**| The template's name. | [optional] |
| **description** | **String**| The template's description. | [optional] |
| **parentFolderId** | **String**| The folder to put the template in. Left out, it's created at the root. | [optional] |
| **aiFieldNamingLanguage** | **AiFieldNamingLanguage**| The language AI field setup names fields in: `auto` uses the form's language when it's written in the Latin alphabet without accents, and English otherwise; `english` always uses English; `form_language` uses the form's language and script. Default: your account's template settings. | [optional] [enum: auto, english, form_language] |
| **detectFields** | **Boolean**| Set up the PDF's fields as DocSpring's "Automatically detect fields" upload option does: import or detect the fields, name them with AI, and set up conditional logic. `field_source`, `field_naming` and `field_logic` choose how. Default false. `document.page_processing_statuses` and `document.field_logic_status` show how it's going, and `document.state` becomes `processed` once every page's fields are set up. | [optional] |
| **fieldSource** | **FieldSetupSource**| With `detect_fields`, where the fields come from. `auto` (the default) imports the form fields of a fillable PDF and detects the fields of a PDF without them; `pdf_detection` detects the fields from the page layout, even on a fillable PDF; `pdf_form_fields` only imports the PDF's form fields. | [optional] [enum: auto, pdf_detection, pdf_form_fields] |
| **fieldNaming** | **FieldSetupNaming**| With `detect_fields`, how the fields are named. `ai` (the default) names them and sets their types and settings with AI; `preserve` keeps the names of the PDF's form fields, and AI only names the fields it detected. `preserve` needs `field_source` `auto` or `pdf_form_fields`. | [optional] [enum: ai, preserve] |
| **fieldLogic** | **FieldSetupLogic**| With `detect_fields`, whether AI reads the whole form once the fields are named and sets up conditional logic and required fields (`ai`) or not (`none`). Default: your account's template settings. | [optional] [enum: ai, none] |
| **outputFormat** | **OutputFormat**| What each submission of a Word template makes unless its request sets `output_formats`: `docx` (a Word document), `odt` (an OpenDocument file, converted from the Word document) or `pdf`. Required when `document` is a Word document. | [optional] [enum: pdf, docx, odt, png] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | PDF template created |  -  |
| **422** | invalid upload |  -  |
| **403** | the plan's template limit is reached |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's template_id instead of sending the request again. |  -  |


## uploadTemplateDocument

> Template uploadTemplateDocument(templateId, document, wait, reimportFields)

Replace a template's document with an uploaded file

Replaces a PDF template's PDF, or a Word template's Word document, with one sent with the request
(`multipart/form-data`). A PDF template's fields stay where they are, unless `reimport_fields` replaces them
with the new PDF's fillable fields, and a Word template gets a field for each new tag.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        File document = new File("/path/to/file"); // File | The new PDF, or the new Word document (.docx or .odt) of a Word template.
        Boolean wait = true; // Boolean | Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts.
        Boolean reimportFields = true; // Boolean | Replace all of the template's fields with the fillable fields in the new PDF, once DocSpring has processed it (`document.field_reimport_state`). As on a first upload, the default typeface, font size, bold and color are taken from the PDF's fields; the template's other settings are kept. If the PDF has no fillable fields, the template keeps its fields. A locked template can't re-import its fields. Only for PDF templates: a Word template adds a field for each new tag.
        try {
            Template result = apiInstance.uploadTemplateDocument(templateId, document, wait, reimportFields);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#uploadTemplateDocument");
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
| **templateId** | **String**| The template's ID. | |
| **document** | **File**| The new PDF, or the new Word document (.docx or .odt) of a Word template. | |
| **wait** | **Boolean**| Wait until the PDF has been processed, a `document_url`'s PDF or Word document downloaded, and an OpenDocument file converted, before responding. Default true on sync.api hosts. | [optional] |
| **reimportFields** | **Boolean**| Replace all of the template's fields with the fillable fields in the new PDF, once DocSpring has processed it (`document.field_reimport_state`). As on a first upload, the default typeface, font size, bold and color are taken from the PDF's fields; the template's other settings are kept. If the PDF has no fillable fields, the template keeps its fields. A locked template can't re-import its fields. Only for PDF templates: a Word template adds a field for each new tag. | [optional] |

### Return type

[**Template**](Template.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | PDF replaced |  -  |
| **422** | an HTML template |  -  |
| **404** | template not found |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |
| **504** | On a sync.api host, the wait ran out: the record was saved and is still being processed. Get it by the ID in the error's template_id instead of sending the request again. |  -  |


## validateSubmission

> SubmissionValidation validateSubmission(templateId, body, version)

Check a submission without creating it

Checks a submission as creating it would (its data against the template's fields, its settings and signature
requests) without saving it, generating anything or using credits. It doesn't check your account's credits.
The response says whether the submission is valid, and if not, has the error that creating it would return.


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
        defaultClient.setBasePath("https://sync.api.docspring.com/api/v2");
        
        // Configure HTTP basic authorization: api_token_basic
        HttpBasicAuth api_token_basic = (HttpBasicAuth) defaultClient.getAuthentication("api_token_basic");
        api_token_basic.setUsername("YOUR USERNAME");
        api_token_basic.setPassword("YOUR PASSWORD");

        Client apiInstance = new Client(defaultClient);
        String templateId = "tpl_1234567890abcdef01"; // String | The template's ID.
        ValidateSubmissionRequest body = new ValidateSubmissionRequest(); // ValidateSubmissionRequest | The submission's data and settings.
        String version = "latest"; // String | The template version to use: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published).
        try {
            SubmissionValidation result = apiInstance.validateSubmission(templateId, body, version);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Client#validateSubmission");
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
| **templateId** | **String**| The template's ID. | |
| **body** | [**ValidateSubmissionRequest**](ValidateSubmissionRequest.md)| The submission's data and settings. | |
| **version** | **String**| The template version to use: a published version (`1.2.0`, or `1` for the latest 1.x.x), `latest` or `draft`. Default `latest` (the draft when no version has been published). | [optional] |

### Return type

[**SubmissionValidation**](SubmissionValidation.md)

### Authorization

[api_token_basic](../README.md#install-and-configure)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | valid submission |  -  |
| **404** | template not found |  -  |
| **422** | invalid request |  -  |
| **401** | authentication failed |  -  |
| **429** | Too many requests: wait the number of seconds in the Retry-After header, then send the request again. |  * Retry-After - Seconds until you can send the request again. <br>  |

