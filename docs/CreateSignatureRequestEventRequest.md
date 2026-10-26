

# CreateSignatureRequestEventRequest

The event to record.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**eventType** | **SignatureRequestEventType** | `send_request`: you sent the signature request to the person (`message_type` and `message_recipient` are required). It's the only event the API records: DocSpring records everything that happens in the signing form itself, and people decline a signature request in its form. |  |
|**messageType** | **SignatureRequestMessageType** | How you sent the request. Required for `send_request`. |  [optional] |
|**messageRecipient** | **String** | Where you sent the request, such as an email address or a phone number. Required for `send_request`. |  [optional] |
|**occurredAt** | **OffsetDateTime** | When it happened. Default now. |  [optional] |



