

# CreateTemplateRequest

The template to create.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The template's name. |  [optional] |
|**description** | **String** | Shown under the template's name at the top of its hosted forms, and used as their meta description. Not shown on embedded forms or signature requests. |  [optional] |
|**templateType** | **TemplateType** | `pdf`: fields placed on an uploaded PDF. `html`: a PDF rendered from HTML and SCSS. It can't be changed after the template is created. |  |
|**parentFolderId** | **String** | The ID of the folder the template is in. Null for a template at the root. Setting it moves the template and all of its published versions. |  [optional] |
|**locked** | **Boolean** | A locked template can't be changed or deleted until it's unlocked (`locked` can always be changed). |  [optional] |
|**addSignatureRequestSubmissionIdFooters** | **Boolean** | Print the submission ID in the footer of each page of PDFs signed through signature requests. |  [optional] |
|**aiFieldNamingLanguage** | **AiFieldNamingLanguage** | The language AI field setup names fields in: `auto` uses the form's language when it's written in the Latin alphabet without accents, and English otherwise; `english` always uses English; `form_language` uses the form's language and script. New templates take it from your account's template settings. Null for HTML templates. |  [optional] |
|**allowAdditionalProperties** | **Boolean** | Accept submission data with properties that aren't fields of the template. |  [optional] |
|**allowSkippingOptionalFields** | **Boolean** | Visual forms and signature request forms show the Continue button as soon as the required fields are filled in, without visiting each optional field. The `allowSkippingOptionalFields` embed option overrides it. |  [optional] |
|**defaultFormMode** | **TemplateFormMode** | The hosted form that /templates/{template_id}/form shows when its URL has no `mode` parameter: `web` (the web form), `visual` (the visual form, where fields are filled in on the PDF) or `dual` (both, in tabs). HTML templates have no visual form, so `web` is the only value they accept. |  [optional] |
|**editableSubmissions** | **Boolean** | Generate PDFs whose text and check fields stay fillable ("Generate Editable PDFs"). A submission's `editable` overrides it. |  [optional] |
|**embedDomains** | **List&lt;String&gt;** | The sites where the template's signature requests, forms and embedded template editor can be loaded: a host such as `app.example.com`, with an optional leading wildcard (`*.example.com`), port (`localhost:3000`) or scheme (`https://app.example.com`; without one, `http` and `https` both work). When it's empty, live signature requests don't load on any site, and the embedded template editor loads on every site. |  [optional] |
|**embedEditAllowSettings** | **Boolean** | Allow the embedded template editor to change sensitive template settings (webhooks, redirect URL, encryption, public access, expiration and so on). |  [optional] |
|**embedEditAllowVersioning** | **Boolean** | Allow the embedded template editor to publish, restore, compare and delete published versions. |  [optional] |
|**embedEditAllowDocumentReplacement** | **Boolean** | Allow the embedded template editor to replace the template's PDF. |  [optional] |
|**encryptPdfs** | **Boolean** | Encrypt generated PDFs with `encrypt_pdfs_password`. |  [optional] |
|**encryptPdfsPassword** | **String** | The password that opens encrypted PDFs. It's never returned; `has_encrypt_pdfs_password` says if it's set. |  [optional] |
|**expireSubmissions** | **Boolean** | Delete each submission's data and PDF after `expire_after` `expiration_interval`. |  [optional] |
|**expireAfter** | **Integer** | How many `expiration_interval`s a submission's data and PDF are kept for, when `expire_submissions` is on. At most 5256000 (10 years in minutes). |  [optional] |
|**expirationInterval** | **ExpirationInterval** | The unit of `expire_after`. |  [optional] |
|**mergeAuditTrailPdf** | **Boolean** | Add the audit trail to the end of PDFs signed through signature requests. |  [optional] |
|**parseDatesUsingTemplateDateFormat** | **Boolean** | Date fields also accept NN/NN/YYYY dates (with slashes, dashes or dots), read in the order of the template's default date format: month first for %m/%d/%Y, day first for %d/%m/%Y. When false, date fields only accept YYYY-MM-DD. Applies to PDF templates: an HTML template's date fields only accept YYYY-MM-DD. Date fields that include a time take RFC 3339 date-times either way. |  [optional] |
|**publicSubmissions** | **Boolean** | Allow anyone with a submission's ID to download its PDF. |  [optional] |
|**publicWebForm** | **Boolean** | Allow anyone to fill in the template's web form. |  [optional] |
|**redirectUrl** | **String** | Where the web form sends people after they submit it. |  [optional] |
|**slackWebhookUrl** | **String** | A Slack incoming webhook URL that is notified about the template's submissions. It's never returned; `has_slack_webhook_url` says if it's set. |  [optional] |
|**defaults** | [**TemplateDefaultsInput**](TemplateDefaultsInput.md) | The default style of the template's fields. Setting it replaces the whole object. |  [optional] |
|**fieldDependencies** | [**List&lt;TemplateFieldDependencyInput&gt;**](TemplateFieldDependencyInput.md) | The template's conditional logic rules. Setting them replaces all of the rules. |  [optional] |
|**predefinedFields** | [**List&lt;PredefinedFieldInput&gt;**](PredefinedFieldInput.md) | The field names that people using the embedded template editor choose from, each with the data type and settings a field gets when it's given that name. Setting it replaces the whole list; an empty list turns them off. |  [optional] |
|**predefinedFieldsSampleData** | **Map&lt;String, Object&gt;** | Sample submission data that sets `predefined_fields`: each value becomes a predefined field, with a type that fits it (`string`, `number`, `boolean`, `date`, `email` or `url`) and `required_in_template` true. Nested objects and arrays become names with `/`, such as `customer/email`. Without `predefined_fields` in the same request, it replaces them; with them, it adds to them and sets the types of the ones it has values for. |  [optional] |
|**html** | **String** | The HTML of an HTML template, as a Liquid template. Null for PDF templates. |  [optional] |
|**scss** | **String** | The SCSS of an HTML template. |  [optional] |
|**headerHtml** | **String** | The HTML printed at the top of each page of an HTML template. |  [optional] |
|**footerHtml** | **String** | The HTML printed at the bottom of each page of an HTML template. |  [optional] |
|**htmlEngineOptions** | [**HtmlEngineOptionsInput**](HtmlEngineOptionsInput.md) | Null resets the options to their defaults. |  [optional] |
|**cacheId** | **String** | A PDF template's document: the `fields.key` of a file you uploaded with the presigned upload (GET /uploads/presign). A PDF template needs one of `cache_id`, `document_url` and `document_base64`. To upload the PDF with the request, use POST /templates/upload. |  [optional] |
|**documentUrl** | **String** | An https:// link to the template's PDF (up to 100 MB), instead of `cache_id`. DocSpring downloads it after responding, following redirects to other https:// links: the template's `document.state` is `downloading` until then (sync.api hosts wait for it). If it can't be downloaded, the state is `download_failed` and `document.error_message` says why. |  [optional] |
|**documentBase64** | **String** | The template's PDF, encoded as base64 (a `data:` URI works too), instead of `cache_id`. Up to 7 MB before it's encoded: send a larger file with `cache_id` or `document_url`. |  [optional] |
|**filename** | **String** | The PDF's file name, for a `cache_id` (presigned uploads don't send one) or `document_base64`. A `document_url`'s is the last part of its path unless you set it. |  [optional] |
|**detectFields** | **Boolean** | Set up the PDF's fields as DocSpring's "Automatically detect fields" upload option does: import or detect the fields, name them with AI, and set up conditional logic. `field_source`, `field_naming` and `field_logic` choose how. Default false. `document.page_processing_statuses` and `document.field_logic_status` show how it's going, and `document.state` becomes `processed` once every page's fields are set up. |  [optional] |
|**fieldSource** | **FieldSetupSource** | With `detect_fields`, where the fields come from. `auto` (the default) imports the form fields of a fillable PDF and detects the fields of a PDF without them; `pdf_detection` detects the fields from the page layout, even on a fillable PDF; `pdf_form_fields` only imports the PDF's form fields. |  [optional] |
|**fieldNaming** | **FieldSetupNaming** | With `detect_fields`, how the fields are named. `ai` (the default) names them and sets their types and settings with AI; `preserve` keeps the names of the PDF's form fields, and AI only names the fields it detected. `preserve` needs `field_source` `auto` or `pdf_form_fields`. |  [optional] |
|**fieldLogic** | **FieldSetupLogic** | With `detect_fields`, whether AI reads the whole form once the fields are named and sets up conditional logic and required fields (`ai`) or not (`none`). Default: your account's template settings. |  [optional] |



