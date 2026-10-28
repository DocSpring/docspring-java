

# TemplateSummary

A template in a list: its name, type, folder, latest published version and whether it's ready. Get a template by its ID for its settings, its PDF in full, its HTML, defaults, field dependency rules and published versions.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The template's ID. |  |
|**name** | **String** | The template's name. |  |
|**description** | **String** | Shown under the template's name at the top of its hosted forms, and used as their meta description. Not shown on embedded forms or signature requests. |  |
|**templateType** | **TemplateType** | `pdf`: fields placed on an uploaded PDF. `html`: a PDF rendered from HTML and SCSS. It can't be changed after the template is created. |  |
|**ready** | **Boolean** | Whether the template can generate PDFs. HTML templates are always ready. A PDF template is ready once DocSpring has stored its PDF, made an image of each page and finished looking for fields on each page, which can be after `document.state` becomes `processed`. A PDF template with no PDF (`document` is null) isn't ready. |  |
|**document** | [**TemplateDocumentSummary**](TemplateDocumentSummary.md) | The PDF of a PDF template: its file name, page count and processing state. Null for HTML templates, and for a PDF template that has no PDF yet. |  |
|**parentFolderId** | **String** | The ID of the folder the template is in. Null for a template at the root. Setting it moves the template and all of its published versions. |  |
|**path** | **String** | The path of the folder the template is in, such as `/Contracts`. `/` for a template at the root. |  |
|**latestVersion** | **String** | The template's latest published version. Null if no version has been published. |  |
|**versionPublishedAt** | **OffsetDateTime** | When this version was published. Null for the draft. |  |
|**locked** | **Boolean** | A locked template can't be changed or deleted until it's unlocked (`locked` can always be changed). |  |
|**lastChangedAt** | **OffsetDateTime** | When the draft was last changed. |  |
|**createdAt** | **OffsetDateTime** | When the template was created. |  |
|**updatedAt** | **OffsetDateTime** | When the template was last updated. |  |



