

# CreateTemplatePreviewRequest

The data to render the template with.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**data** | **Map&lt;String, Object&gt;** | The values of the template's fields, by field name, as you'd send them to create a submission. They're rendered as they are: they aren't checked against the template's fields. A value that a field can't print, such as an image URL that doesn't download, makes the preview's `state` `error`, with an `error_message`. |  |



