

# GeneratedFile

A file that DocSpring generated, such as a submission's PDF. A file made after its submission was processed is listed while it's being made: check its `state` before using its links.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**state** | **GeneratedFileState** | `processed` once the file has been made. `pending` while it's being made, and `error` if it couldn't be made (see `error_message`). |  |
|**errorMessage** | **String** | Why the file couldn't be made, when `state` is `error`. |  |
|**downloadUrl** | **String** | A temporary link to download the file. Null until the file has been made, and when your account turns off download links for submissions. |  |
|**permanentUrl** | **String** | A link to download the file that doesn't expire: it redirects to a new temporary link. It needs your API token or a signed-in session, except for a submission of a template that makes its submissions public. Null until the file has been made. |  |
|**filename** | **String** | The file's name, such as `sub_123.pdf`. |  |
|**contentType** | **String** | The file's media type, such as `application/pdf`. |  |
|**size** | **Integer** | The file's size in bytes. Null until the file has been made. |  |
|**sha256** | **String** | The SHA-256 hash of the file. Null until the file has been made. |  |



