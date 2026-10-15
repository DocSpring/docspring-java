

# ErrorOrMultipleErrorsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**error** | **String** | Single error message (when only one error occurred) |  [optional] |
|**errors** | **List&lt;String&gt;** | Array of error messages (when multiple validation errors occurred) |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ERROR | &quot;error&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



