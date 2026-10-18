

# CreateSubmissionResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**submission** | **SubmissionPreview** |  |  |
|**error** | **String** |  |  [optional] |
|**errors** | **List&lt;String&gt;** |  |  [optional] |
|**code** | **String** | &#x60;insufficient_credits&#x60; when the response is a 402. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| SUCCESS | &quot;success&quot; |
| ERROR | &quot;error&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



