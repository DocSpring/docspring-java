

# SubmissionPreview


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **String** |  |  |
|**dataRequests** | [**List&lt;SubmissionDataRequest&gt;**](SubmissionDataRequest.md) |  |  |
|**editable** | **Boolean** |  |  |
|**expired** | **Boolean** |  |  |
|**expiresAt** | **String** |  |  |
|**id** | **String** |  |  |
|**jsonSchemaErrors** | **List&lt;String&gt;** |  |  |
|**metadata** | **Object** |  |  |
|**password** | **String** |  |  |
|**processedAt** | **String** |  |  |
|**state** | [**StateEnum**](#StateEnum) |  |  |
|**templateId** | **String** |  |  |
|**test** | **Boolean** |  |  |
|**truncatedText** | **Object** |  |  |
|**pdfHash** | **String** |  |  |
|**downloadUrl** | **String** |  |  |
|**permanentDownloadUrl** | **String** |  |  |
|**previewDownloadUrl** | **String** |  |  |
|**previewGeneratedAt** | **String** |  |  |
|**auditTrailDownloadUrl** | **String** |  |  |
|**actions** | [**List&lt;SubmissionAction&gt;**](SubmissionAction.md) |  |  |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| PROCESSED | &quot;processed&quot; |
| INVALID_DATA | &quot;invalid_data&quot; |
| ERROR | &quot;error&quot; |
| IMAGE_DOWNLOAD_FAILED | &quot;image_download_failed&quot; |
| IMAGE_PROCESSING_FAILED | &quot;image_processing_failed&quot; |
| WAITING_FOR_DATA_REQUESTS | &quot;waiting_for_data_requests&quot; |
| SYNTAX_ERROR | &quot;syntax_error&quot; |
| ACCOUNT_SUSPENDED | &quot;account_suspended&quot; |
| LICENSE_REVOKED | &quot;license_revoked&quot; |
| ACCIDENTAL | &quot;accidental&quot; |



