

# SubmissionValidation

Whether creating the submission would succeed, checked without saving it or making any files. `error` is the error that creating it would return (`validation_failed`, or `invalid_data` for data that doesn't match the template's fields), and is left out when `valid` is true.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**valid** | **Boolean** | True when creating the submission would succeed. |  |
|**templateId** | **String** | The template's ID. |  |
|**templateVersion** | **String** | The published version the request was checked against, such as `1.2.0`. Null for the draft. |  |
|**error** | **ErrorInfo** |  |  [optional] |



