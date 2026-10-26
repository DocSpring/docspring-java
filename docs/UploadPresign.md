

# UploadPresign

A presigned S3 form for uploading a file. POST `fields` and the file (as `file`, last) to `url` as multipart/form-data. Then use `fields.key` as the `cache_id` when you create a custom file.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | The S3 URL to upload the file to. |  |
|**method** | **UploadMethod** | The HTTP method for the upload. |  |
|**fields** | **Map&lt;String, String&gt;** | Form fields to send with the file. Send them all, as they are. `key` is the uploaded file's ID: pass it as `cache_id`. |  |
|**headers** | **Map&lt;String, String&gt;** | Headers to send with the upload. |  |



