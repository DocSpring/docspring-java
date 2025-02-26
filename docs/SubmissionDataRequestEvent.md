

# SubmissionDataRequestEvent


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**submissionId** | **String** |  |  |
|**submissionDataRequestId** | **String** |  |  |
|**eventType** | [**EventTypeEnum**](#EventTypeEnum) |  |  |
|**messageType** | [**MessageTypeEnum**](#MessageTypeEnum) |  |  |
|**messageRecipient** | **String** |  |  |
|**occurredAt** | **String** |  |  |



## Enum: EventTypeEnum

| Name | Value |
|---- | -----|
| SEND_REQUEST | &quot;send_request&quot; |
| VIEW_REQUEST | &quot;view_request&quot; |
| ACCEPTED_TERMS | &quot;accepted_terms&quot; |
| DECLINE_REQUEST | &quot;decline_request&quot; |
| SIGN_REQUEST | &quot;sign_request&quot; |
| ALL_COMPLETED | &quot;all_completed&quot; |



## Enum: MessageTypeEnum

| Name | Value |
|---- | -----|
| EMAIL | &quot;email&quot; |
| SMS | &quot;sms&quot; |
| FAX | &quot;fax&quot; |
| MAIL | &quot;mail&quot; |
| SLACK | &quot;slack&quot; |
| MSTEAMS | &quot;msteams&quot; |
| DISCORD | &quot;discord&quot; |
| TELEGRAM | &quot;telegram&quot; |
| WHATSAPP | &quot;whatsapp&quot; |



