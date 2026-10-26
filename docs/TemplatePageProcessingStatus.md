

# TemplatePageProcessingStatus

How processing is going on one page of a PDF template's PDF.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**image** | **TemplatePageImageStatus** | The page's image, which the template editor shows. `pending` until it's rendered. |  |
|**fields** | **TemplatePageFieldsStatus** | Setting up the page's fields: `pending` while they're imported or detected, `naming` while AI names them, then `processed` or `failed`. `disabled` when DocSpring doesn't set up the page's fields. |  |
|**aiNaming** | **TemplatePageAiNamingStatus** | `failed` or `skipped` when AI didn't name the page's fields as asked (`ai_error` says why), and the fields kept plain names. Null otherwise. |  |
|**aiError** | **TemplatePageAiError** | Why AI naming failed or was skipped: `unavailable` (the AI service was unavailable: set up the fields again later), `error`, `credits` (the account had no free AI pages or credits left) or `skipped` (someone skipped AI setup in the template editor). Null when `ai_naming` is. |  |
|**detectedBoxes** | **List&lt;List&lt;BigDecimal&gt;&gt;** | While AI names the page's fields, the boxes field detection found: `[x, y, width, height]` in PDF points from the page's top-left corner. Null otherwise. |  |



