

# Webhook


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**name** | **String** |  |  |
|**url** | **String** |  |  |
|**enabled** | **Boolean** |  |  |
|**eventTypes** | **List&lt;String&gt;** |  |  |
|**mode** | [**ModeEnum**](#ModeEnum) |  |  |
|**version** | **Integer** |  |  |
|**apiTokenIds** | **List&lt;String&gt;** |  |  |
|**templateIds** | **List&lt;String&gt;** |  |  |
|**folderIds** | **List&lt;String&gt;** |  |  |
|**includeSubmissionData** | **Boolean** |  |  |
|**stripFields** | **List&lt;String&gt;** |  |  |
|**headers** | **Map&lt;String, String&gt;** |  |  |
|**consecutiveFailures** | **Integer** |  |  |
|**lastFailureAt** | **String** |  |  |
|**disabledAt** | **String** |  |  |
|**disabledReason** | **String** |  |  |
|**secret** | **String** |  |  |
|**createdAt** | **String** |  |  |
|**updatedAt** | **String** |  |  |



## Enum: ModeEnum

| Name | Value |
|---- | -----|
| TEST | &quot;test&quot; |
| LIVE | &quot;live&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



