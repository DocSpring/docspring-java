

# TemplateDocument

A PDF template's PDF.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**filename** | **String** | The PDF's file name. |  |
|**md5** | **String** | The MD5 hash of the PDF. |  |
|**state** | **TemplateDocumentState** | `pending` while DocSpring processes the PDF, then `processed`. `password_required`, `malformed_pdf` and `unknown_error` mean the PDF couldn't be processed, and `error_message` says why: upload it again or upload another one. |  |
|**errorMessage** | **String** | Why the PDF couldn't be processed, and how to fix it. Null unless `state` is an error. |  |
|**fieldReimportState** | **FieldReimportState** | Whether the fields are being re-imported from this PDF (`reimport_fields` when the PDF was replaced): `requested` while DocSpring processes the PDF, then `imported`, or `no_fields` when the PDF had no fillable fields and the template kept its fields. `none` when no re-import was asked for, or when it couldn't run (the PDF couldn't be processed, or the template was locked or published while it was). |  |
|**pageCount** | **Integer** | 0 until the PDF has been processed. |  |
|**pageDimensions** | **List&lt;List&lt;BigDecimal&gt;&gt;** | Each page's width and height in PDF points. Null until the PDF has been processed. |  |
|**hasFillableFields** | **Boolean** | Whether the PDF has fillable form fields. Null until DocSpring has read the PDF. |  |
|**pageProcessingStatuses** | [**List&lt;TemplatePageProcessingStatus&gt;**](TemplatePageProcessingStatus.md) | How processing is going on each page, in page order: its image, and its fields when DocSpring sets them up (`detect_fields` when the template was created). `state` becomes `processed` once every page is done. Empty until DocSpring has read the PDF, and for PDFs uploaded before DocSpring recorded page statuses. |  |
|**fieldLogicStatus** | **TemplateFieldLogicStatus** | AI field setup's last step, which reads the whole form once every page is done and can still rename fields and add conditional logic and required fields: `pending` or `processing` until it finishes, then `processed`, `failed` or `skipped`. Null until every page is done, and when there's no logic step to run (`field_logic` is `none`, or the PDF has no fields). |  |
|**downloadUrl** | **String** | A temporary link to download the PDF. |  |
|**permanentUrl** | **String** | A link to download the PDF that doesn't expire. Null until the PDF has been processed. |  |



