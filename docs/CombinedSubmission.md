

# CombinedSubmission


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**state** | [**StateEnum**](#StateEnum) |  |  |
|**expired** | **Boolean** |  |  |
|**expiresIn** | **Integer** |  |  |
|**expiresAt** | **String** |  |  |
|**processedAt** | **String** |  |  |
|**errorMessage** | **String** |  |  |
|**submissionIds** | **List&lt;String&gt;** |  |  |
|**sourcePdfs** | **List&lt;Object&gt;** |  |  |
|**metadata** | **Object** |  |  |
|**password** | **String** |  |  |
|**pdfHash** | **String** |  |  |
|**downloadUrl** | **String** |  |  |
|**actions** | [**List&lt;CombinedSubmissionAction&gt;**](CombinedSubmissionAction.md) |  |  |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| PROCESSED | &quot;processed&quot; |
| ERROR | &quot;error&quot; |



