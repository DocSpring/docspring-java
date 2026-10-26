

# PageImage

An image of one page of a PDF, a PNG of a submission's page or a JPEG of a template's.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**page** | **Integer** | The page number, from 1. |  |
|**width** | **Integer** | The image's width in pixels. |  |
|**height** | **Integer** | The image's height in pixels. |  |
|**downloadUrl** | **String** | A temporary link to download the image. A submission's is null when your account turns off download links for submissions. |  |
|**permanentUrl** | **String** | A link to download a submission's image that doesn't expire: it redirects to a new temporary link. It needs your API token or a signed-in session, except for a submission of a template that makes its submissions public. Null for a template's page images. |  |
|**filename** | **String** | The image's file name, such as `sub_123_page_1.png`. |  |
|**contentType** | **String** | The image's media type, `image/png` for a submission's pages or `image/jpeg` for a template's. |  |
|**size** | **Integer** | The image's size in bytes. |  |
|**sha256** | **String** | The SHA-256 hash of the image. Null for a template's page images. |  |



