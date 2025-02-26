

# SubmissionBatchWithSubmissions


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**state** | [**StateEnum**](#StateEnum) |  |  |
|**metadata** | **Object** |  |  |
|**processedAt** | **String** |  |  |
|**totalCount** | **Integer** |  |  |
|**pendingCount** | **Integer** |  |  |
|**errorCount** | **Integer** |  |  |
|**completionPercentage** | **BigDecimal** |  |  |
|**submissions** | [**List&lt;SubmissionPreview&gt;**](SubmissionPreview.md) |  |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| PROCESSED | &quot;processed&quot; |
| ERROR | &quot;error&quot; |



