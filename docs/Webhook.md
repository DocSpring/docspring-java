

# Webhook

An endpoint that DocSpring sends a POST request to when a subscribed event happens.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The webhook's ID. |  |
|**name** | **String** | A name for the webhook, shown in the dashboard. |  |
|**url** | **String** | The endpoint that receives webhook POST requests. |  |
|**enabled** | **Boolean** | Whether DocSpring sends events to the webhook. Webhooks are disabled after repeated failures. |  |
|**eventTypes** | **List&lt;WebhookEventType&gt;** | The events the webhook subscribes to. A webhook made in the dashboard can also subscribe to API token, account integration and user events, which are listed with their own names. |  |
|**mode** | **WebhookMode** | Only send events for test or live submissions. Null sends both. |  |
|**version** | **Integer** | The format of the requests DocSpring sends. Webhooks created with API v2 use 4: each event's `data` is the resource as API v2 returns it. Webhooks made in the dashboard or with API v1 use 3, which has API v1's resources and names (`combined_submission`, `submission_data_request`). Versions 1 and 2 are legacy formats for submission events. |  |
|**apiTokenIds** | **List&lt;String&gt;** | Only send events from these API tokens. Combined with the other scope lists using OR. Applies to submission, signature request, combined PDF, submission batch and custom file events. |  |
|**templateIds** | **List&lt;String&gt;** | Only send events for these templates. Combined with the other scope lists using OR. Applies to submission, signature request and template events. |  |
|**folderIds** | **List&lt;String&gt;** | Only send events for templates in these folders, including their subfolders. Combined with the other scope lists using OR. Applies to submission, signature request, template and folder events. |  |
|**includeSubmissionData** | **Boolean** | Include the submission's field data in the payload. When false, the submission's data and truncated_text, and each signature request's data, ip_address and user_agent, are null. |  |
|**stripFields** | **List&lt;String&gt;** | Dot-separated paths to remove from the event's data object. Form fields live under `data` (`data.ssn` removes the ssn field). A bare name removes a top-level key (`metadata` removes the whole metadata object). |  |
|**headers** | **Map&lt;String, String&gt;** | Headers to send with each request. |  |
|**consecutiveFailures** | **Integer** | How many deliveries in a row have failed. |  |
|**lastFailureAt** | **OffsetDateTime** | When a delivery last failed. |  |
|**disabledAt** | **OffsetDateTime** | When the webhook was disabled. Null while it is enabled. |  |
|**disabledReason** | **String** | Why the webhook was disabled, such as after repeated failures. |  |
|**secret** | **String** | The key that signs each request (the X-DocSpring-Signature header), so you can check that a request came from DocSpring. Null for some webhooks created before signing existed. |  |
|**createdAt** | **OffsetDateTime** | When the webhook was created. |  |
|**updatedAt** | **OffsetDateTime** | When the webhook was last updated. |  |



