

# CombinedPdf

A PDF made by merging other PDFs: submissions, other combined PDFs, templates, custom files and PDFs from URLs.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The combined PDF's ID. |  |
|**state** | **CombinedPdfState** | `pending` until the PDF has been generated, then `processed`. `insufficient_credits`: waiting for credits; `error_message` says whether the PDF is generated once you add them. `account_suspended`: waiting for the account to be reactivated, for up to 30 days. `error`: the PDFs couldn't be merged (see `error_message`). Waiting ends in `error` if it's discarded or takes over 30 days. |  |
|**sourcePdfs** | [**List&lt;CombinedPdfSource&gt;**](CombinedPdfSource.md) | The PDFs to merge, in order. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Your own data about the combined PDF, such as an ID from your app. Its `pdf_filename` key names the PDF's file (`files.pdf.filename`, and its download): a `.pdf` ending is removed, each run of characters other than letters, digits, `-`, `_` and `.` becomes one `_`, and the first 128 characters are kept, then `.pdf` is added. Without it, the file is named after the combined PDF's ID (`com_1234567890abcdef01.pdf`). |  |
|**hasPassword** | **Boolean** | Whether the PDF needs a password to open (`password`). |  |
|**deleteCustomFiles** | **Boolean** | Delete the custom files in `source_pdfs` once the combined PDF has been generated (they're kept if it fails). Other combined PDFs can't use them after that. A test API token can't delete custom files. |  |
|**errorMessage** | **String** | Why the PDFs couldn't be merged, when `state` is `error`. |  |
|**files** | **CombinedPdfFiles** | The generated files, by format. Empty until the PDF has been generated, and once it has expired. |  |
|**actions** | **List&lt;SubmissionAction&gt;** | The uploads of the PDF to your storage (account integrations). |  |
|**expired** | **Boolean** | An expired combined PDF's PDF, metadata, password and source URLs have been deleted. |  |
|**expiresAt** | **OffsetDateTime** | When the combined PDF expires (`expires_in` after it's generated). Null if it's kept until you delete it. |  |
|**processedAt** | **OffsetDateTime** | When the PDF was generated. Null until then. |  |
|**createdAt** | **OffsetDateTime** | When the combined PDF was created. |  |
|**updatedAt** | **OffsetDateTime** | When the combined PDF was last updated. |  |



