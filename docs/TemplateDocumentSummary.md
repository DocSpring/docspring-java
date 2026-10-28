

# TemplateDocumentSummary

A PDF template's PDF, as template lists show it.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**filename** | **String** | The PDF's file name. Null until a `document_url` has been downloaded. |  |
|**state** | **TemplateDocumentState** | `pending` while DocSpring processes the PDF, then `processed` (`ready` says when its pages are done too). `password_required`, `malformed_pdf` and `unknown_error` mean the PDF couldn't be processed, and `error_message` says why: upload it again or upload another one. `downloading` while DocSpring downloads a `document_url`, then as for an upload. `download_failed` means it couldn't be downloaded, and `error_message` says why. A template keeps its PDF while a new one is downloaded, and when it couldn't be. |  |
|**errorMessage** | **String** | Why the PDF couldn't be processed or downloaded, and how to fix it. Null unless `state` is an error. |  |
|**pageCount** | **Integer** | 0 until the PDF has been processed. |  |



