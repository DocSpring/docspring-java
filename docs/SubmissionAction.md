

# SubmissionAction

An upload of a PDF to your storage, such as an S3 bucket.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The upload's ID. |  |
|**integrationId** | **String** | The ID of the account integration it used. |  |
|**state** | **SubmissionActionState** | `pending` until the upload has run, then `processed`. `failed`: your storage rejected it. `error`: it failed in DocSpring. |  |
|**actionType** | **SubmissionActionType** | The kind of storage, such as `aws_s3_upload` for an S3 bucket. |  |
|**resultData** | **Map&lt;String, Object&gt;** | Where the PDF was uploaded, such as the S3 bucket and key. |  |
|**errorMessage** | **String** | Why the upload failed, when `state` is `failed` or `error`. |  |



