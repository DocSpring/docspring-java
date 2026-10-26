

# SignatureRequestEvent

Something that happened to a signature request outside DocSpring, for its audit trail: you sent the request to the person (`send_request`). The audit trail shows it as reported by your account.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The event's ID. |  |
|**submissionId** | **String** | The ID of the signature request's submission. |  |
|**signatureRequestId** | **String** | The ID of the signature request. |  |
|**eventType** | **SignatureRequestEventType** | What happened. |  |
|**messageType** | **SignatureRequestMessageType** | How you sent the request. Required for `send_request`. |  |
|**messageRecipient** | **String** | Where you sent the request, such as an email address or a phone number. Required for `send_request`. |  |
|**occurredAt** | **OffsetDateTime** | When it happened. Default now. |  |
|**createdAt** | **OffsetDateTime** | When the event was recorded. |  |



