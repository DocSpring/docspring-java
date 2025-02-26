

# SubmissionBatch


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



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| PROCESSED | &quot;processed&quot; |
| ERROR | &quot;error&quot; |



