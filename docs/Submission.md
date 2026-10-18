

# Submission


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **String** |  |  |
|**dataRequests** | **List&lt;SubmissionDataRequest&gt;** |  |  |
|**editable** | **Boolean** |  |  |
|**errorMessage** | **String** |  |  |
|**expired** | **Boolean** |  |  |
|**expiresAt** | **String** |  |  |
|**id** | **String** |  |  |
|**jsonSchemaErrors** | **List&lt;String&gt;** |  |  |
|**metadata** | **Object** |  |  |
|**password** | **String** |  |  |
|**processedAt** | **String** |  |  |
|**state** | [**StateEnum**](#StateEnum) |  |  |
|**templateId** | **String** |  |  |
|**templateType** | [**TemplateTypeEnum**](#TemplateTypeEnum) |  |  |
|**templateVersion** | **String** |  |  |
|**test** | **Boolean** |  |  |
|**truncatedText** | **Object** |  |  |
|**pdfHash** | **String** |  |  |
|**downloadUrl** | **String** |  |  |
|**permanentDownloadUrl** | **String** |  |  |
|**previewDownloadUrl** | **String** |  |  |
|**previewGeneratedAt** | **String** |  |  |
|**auditTrailDownloadUrl** | **String** |  |  |
|**actions** | **List&lt;SubmissionAction&gt;** |  |  |
|**source** | [**SourceEnum**](#SourceEnum) |  |  [optional] |
|**referrer** | **String** |  |  [optional] |
|**data** | **Object** |  |  [optional] |



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
| INSUFFICIENT_CREDITS | &quot;insufficient_credits&quot; |
| ACCOUNT_SUSPENDED | &quot;account_suspended&quot; |
| LICENSE_REVOKED | &quot;license_revoked&quot; |
| ACCIDENTAL | &quot;accidental&quot; |
| DECLINED | &quot;declined&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: TemplateTypeEnum

| Name | Value |
|---- | -----|
| PDF | &quot;pdf&quot; |
| HTML | &quot;html&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: SourceEnum

| Name | Value |
|---- | -----|
| API | &quot;api&quot; |
| WEB | &quot;web&quot; |
| REPROCESS | &quot;reprocess&quot; |
| WEBHOOK | &quot;webhook&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



