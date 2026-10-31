

# TemplateSummary

A template in a list: its name, type, folder, latest published version and whether it's ready. Get a template by its ID for its settings, its PDF in full, its HTML, defaults, field dependency rules and published versions.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The template's ID. |  |
|**name** | **String** | The template's name. |  |
|**description** | **String** | Shown under the template's name at the top of its hosted forms, and used as their meta description. Not shown on embedded forms or signature requests. |  |
|**templateType** | **TemplateType** | `pdf`: fields placed on an uploaded PDF. `html`: a PDF rendered from HTML and SCSS. `docx`: a Word document with tags where the data goes, which makes Word documents or PDFs. It can't be changed after the template is created. |  |
|**outputFormat** | **OutputFormat** | What each submission makes unless its request sets `output_formats`: `docx` (a Word document), `odt` (an OpenDocument file, converted from the Word document) or `pdf`. A Word template's is chosen when it's created; PDF and HTML templates always make PDFs. A Word template that encrypts its PDFs makes PDFs, because Word documents and OpenDocument files can't be password-protected. |  |
|**ready** | **Boolean** | Whether the template can make documents. HTML templates are always ready. A PDF template is ready once DocSpring has stored its PDF, made an image of each page and finished looking for fields on each page, which can be after `document.state` becomes `processed`. A PDF template with no PDF (`document` is null) isn't ready. A Word template is ready once it has a Word document (a `document_url`'s has been downloaded). |  |
|**document** | [**TemplateDocumentSummary**](TemplateDocumentSummary.md) | The PDF of a PDF template, or the Word document of a Word template: its file name, page count and processing state. Null for HTML templates, and for a PDF template that has no PDF yet. A template created from a `document_url`, or a Word template created from an OpenDocument file (.odt), has one, with no file, while it's downloaded or converted. |  |
|**parentFolderId** | **String** | The ID of the folder the template is in. Null for a template at the root. Setting it moves the template and all of its published versions. |  |
|**path** | **String** | The path of the folder the template is in, such as `/Contracts`. `/` for a template at the root. |  |
|**latestVersion** | **String** | The template's latest published version. Null if no version has been published. |  |
|**versionPublishedAt** | **OffsetDateTime** | When this version was published. Null for the draft. |  |
|**locked** | **Boolean** | A locked template can't be changed or deleted until it's unlocked (`locked` can always be changed). |  |
|**lastChangedAt** | **OffsetDateTime** | When the draft was last changed. |  |
|**createdAt** | **OffsetDateTime** | When the template was created. |  |
|**updatedAt** | **OffsetDateTime** | When the template was last updated. |  |



