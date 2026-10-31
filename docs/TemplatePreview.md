

# TemplatePreview

PNG images of a template's pages filled in with data you send (not a PDF), to check how an HTML, PDF or Word template prints with your data before you publish a version or send live data. A preview makes no submission and uses no credits. Its pages are watermarked like a test submission's PDF, and it's deleted an hour after it's created.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The preview's ID. |  |
|**templateId** | **String** | The template's ID. |  |
|**version** | **String** | The published version that was rendered, such as `1.2.0`. Null for the draft. |  |
|**state** | **TemplatePreviewState** | `pending` while it renders (usually a few seconds), then `processed`, or `error` with an `error_message`. |  |
|**errorMessage** | **String** | Why the preview couldn't be rendered, such as an error in an HTML or Word template's Liquid, or a value in the data that a field can't print. |  |
|**pageCount** | **Integer** | How many pages the template printed, once it's processed. |  |
|**pages** | **List&lt;PageImage&gt;** | A PNG image of each page once it's processed, in order: `pages[0]` is page 1. A preview has no PDF. Their `download_url`s expire, so get the preview again when you need them. |  |
|**expiresAt** | **OffsetDateTime** | When the preview and its images are deleted. |  |



