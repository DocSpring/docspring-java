

# Template

A template that generates PDFs from submission data.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The template's ID. |  |
|**name** | **String** | The template's name. |  |
|**description** | **String** | Shown under the template's name at the top of its hosted forms, and used as their meta description. Not shown on embedded forms or signature requests. |  |
|**templateType** | **TemplateType** | `pdf`: fields placed on an uploaded PDF. `html`: a PDF rendered from HTML and SCSS. It can't be changed after the template is created. |  |
|**ready** | **Boolean** | Whether the template can generate PDFs. HTML templates are always ready. A PDF template is ready once its document has been processed (`document.state` is `processed`). |  |
|**document** | [**TemplateDocument**](TemplateDocument.md) | The PDF of a PDF template. Null for HTML templates, and for a PDF template that has no PDF yet. |  |
|**parentFolderId** | **String** | The ID of the folder the template is in. Null for a template at the root. Setting it moves the template and all of its published versions. |  |
|**path** | **String** | The path of the folder the template is in, such as `/Contracts`. `/` for a template at the root. |  |
|**version** | **String** | The published version this is, such as `1.2.0`. Null for the draft. |  |
|**latestVersion** | **String** | The template's latest published version. Null if no version has been published. |  |
|**versionPublishedAt** | **OffsetDateTime** | When this version was published. Null for the draft. |  |
|**locked** | **Boolean** | A locked template can't be changed or deleted until it's unlocked (`locked` can always be changed). |  |
|**addSignatureRequestSubmissionIdFooters** | **Boolean** | Print the submission ID in the footer of each page of PDFs signed through signature requests. |  |
|**aiFieldNamingLanguage** | **AiFieldNamingLanguage** | The language AI field setup names fields in: `auto` uses the form's language when it's written in the Latin alphabet without accents, and English otherwise; `english` always uses English; `form_language` uses the form's language and script. New templates take it from your account's template settings. Null for HTML templates. |  |
|**allowAdditionalProperties** | **Boolean** | Accept submission data with properties that aren't fields of the template. |  |
|**allowSkippingOptionalFields** | **Boolean** | Visual forms and signature request forms show the Continue button as soon as the required fields are filled in, without visiting each optional field. The `allowSkippingOptionalFields` embed option overrides it. |  |
|**defaultFormMode** | **TemplateFormMode** | The hosted form that /templates/{template_id}/form shows when its URL has no `mode` parameter: `web` (the web form), `visual` (the visual form, where fields are filled in on the PDF) or `dual` (both, in tabs). HTML templates have no visual form, so `web` is the only value they accept. |  |
|**editableSubmissions** | **Boolean** | Generate PDFs whose text and check fields stay fillable ("Generate Editable PDFs"). A submission's `editable` overrides it. |  |
|**embedDomains** | **List&lt;String&gt;** | The sites where the template's signature requests, forms and embedded template editor can be loaded: a host such as `app.example.com`, with an optional leading wildcard (`*.example.com`), port (`localhost:3000`) or scheme (`https://app.example.com`; without one, `http` and `https` both work). When it's empty, live signature requests don't load on any site, and the embedded template editor loads on every site. |  |
|**embedEditAllowSettings** | **Boolean** | Allow the embedded template editor to change sensitive template settings (webhooks, redirect URL, encryption, public access, expiration and so on). |  |
|**embedEditAllowVersioning** | **Boolean** | Allow the embedded template editor to publish, restore, compare and delete published versions. |  |
|**embedEditAllowDocumentReplacement** | **Boolean** | Allow the embedded template editor to replace the template's PDF. |  |
|**encryptPdfs** | **Boolean** | Encrypt generated PDFs with `encrypt_pdfs_password`. |  |
|**hasEncryptPdfsPassword** | **Boolean** | Whether `encrypt_pdfs_password` is set. |  |
|**expireSubmissions** | **Boolean** | Delete each submission's data and PDF after `expire_after` `expiration_interval`. |  |
|**expireAfter** | **Integer** | How many `expiration_interval`s a submission's data and PDF are kept for, when `expire_submissions` is on. At most 5256000 (10 years in minutes). |  |
|**expirationInterval** | **ExpirationInterval** | The unit of `expire_after`. |  |
|**mergeAuditTrailPdf** | **Boolean** | Add the audit trail to the end of PDFs signed through signature requests. |  |
|**parseDatesUsingTemplateDateFormat** | **Boolean** | Date fields also accept NN/NN/YYYY dates (with slashes, dashes or dots), read in the order of the template's default date format: month first for %m/%d/%Y, day first for %d/%m/%Y. When false, date fields only accept YYYY-MM-DD. Applies to PDF templates: an HTML template's date fields only accept YYYY-MM-DD. Date fields that include a time take RFC 3339 date-times either way. |  |
|**publicSubmissions** | **Boolean** | Allow anyone with a submission's ID to download its PDF. |  |
|**publicWebForm** | **Boolean** | Allow anyone to fill in the template's web form. |  |
|**redirectUrl** | **String** | Where the web form sends people after they submit it. |  |
|**hasSlackWebhookUrl** | **Boolean** | Whether `slack_webhook_url` is set. |  |
|**lastChangedAt** | **OffsetDateTime** | When the draft was last changed. |  |
|**lastChangedBy** | [**TemplateActor**](TemplateActor.md) | Who last changed the draft: a user in your account, an API token, or someone using the embedded template editor. Null if no change has been recorded. |  |
|**createdAt** | **OffsetDateTime** | When the template was created. |  |
|**updatedAt** | **OffsetDateTime** | When the template was last updated. |  |
|**defaults** | **TemplateDefaults** |  |  |
|**fieldDependencies** | **List&lt;TemplateFieldDependency&gt;** | Conditional logic: each rule shows or hides its target fields, or makes them required, depending on the values of other fields. |  |
|**fieldGroups** | **List&lt;FieldGroup&gt;** | The groups of the template's fields, with their settings. A field's name puts it in groups: `address/city` is in the group `address`, and `items/0/price` is in the list `items` and its items' group `items/~`. |  |
|**predefinedFields** | [**List&lt;PredefinedField&gt;**](PredefinedField.md) | The field names that people using the embedded template editor choose from, each with the data type and settings a field gets when it's given that name. Setting it replaces the whole list; an empty list turns them off. |  |
|**predefinedFieldsSampleData** | **Map&lt;String, Object&gt;** | Sample submission data that sets `predefined_fields`: each value becomes a predefined field, with a type that fits it (`string`, `number`, `boolean`, `date`, `email` or `url`) and `required_in_template` true. Nested objects and arrays become names with `/`, such as `customer/email`. Without `predefined_fields` in the same request, it replaces them; with them, it adds to them and sets the types of the ones it has values for. |  |
|**html** | **String** | The HTML of an HTML template, as a Liquid template. Null for PDF templates. |  |
|**scss** | **String** | The SCSS of an HTML template. |  |
|**headerHtml** | **String** | The HTML printed at the top of each page of an HTML template. |  |
|**footerHtml** | **String** | The HTML printed at the bottom of each page of an HTML template. |  |
|**htmlEngineOptions** | [**HtmlEngineOptions**](HtmlEngineOptions.md) | How an HTML template's PDFs are printed. Null for PDF templates. Setting it replaces the whole object: options left out use their defaults. |  |
|**embedEditToken** | **String** | The token that opens the template in the embedded template editor. |  |
|**versions** | **List&lt;TemplateVersion&gt;** | The template's published versions, newest first (up to 100). |  |



