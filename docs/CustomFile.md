

# CustomFile

A PDF you uploaded to merge with other PDFs (POST /combined_pdfs). Get an upload URL with GET /uploads/presign first.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The custom file's ID. |  |
|**downloadUrl** | **String** | A temporary link to download the file. |  |
|**size** | **Integer** | The file's size in bytes. |  |
|**contentType** | **String** | The file's media type, such as `application/pdf`. |  |
|**createdAt** | **OffsetDateTime** | When the custom file was created. |  |
|**updatedAt** | **OffsetDateTime** | When the custom file was last updated. |  |



