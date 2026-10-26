

# UpdateWebhookRequest

The settings to change. Properties left out keep their values.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | A name for the webhook, shown in the dashboard. |  [optional] |
|**url** | **String** | The endpoint that receives webhook POST requests. |  [optional] |
|**enabled** | **Boolean** | Whether DocSpring sends events to the webhook. Webhooks are disabled after repeated failures. |  [optional] |
|**eventTypes** | **Set&lt;WebhookEventType&gt;** | The events the webhook subscribes to. A webhook made in the dashboard can also subscribe to API token, account integration and user events, which are listed with their own names. |  [optional] |
|**mode** | **WebhookMode** | Only send events for test or live submissions. Null sends both. |  [optional] |
|**apiTokenIds** | **Set&lt;String&gt;** | Only send events from these API tokens. Combined with the other scope lists using OR. Applies to submission, signature request, combined PDF, submission batch and custom file events. |  [optional] |
|**templateIds** | **Set&lt;String&gt;** | Only send events for these templates. Combined with the other scope lists using OR. Applies to submission, signature request and template events. |  [optional] |
|**folderIds** | **Set&lt;String&gt;** | Only send events for templates in these folders, including their subfolders. Combined with the other scope lists using OR. Applies to submission, signature request, template and folder events. |  [optional] |
|**includeSubmissionData** | **Boolean** | Include the submission's field data in the payload. When false, the submission's data and truncated_text, and each signature request's data, ip_address and user_agent, are null. |  [optional] |
|**stripFields** | **List&lt;String&gt;** | Dot-separated paths to remove from the event's data object. Form fields live under `data` (`data.ssn` removes the ssn field). A bare name removes a top-level key (`metadata` removes the whole metadata object). |  [optional] |
|**headers** | **Map&lt;String, String&gt;** | Headers to send with each request. |  [optional] |



