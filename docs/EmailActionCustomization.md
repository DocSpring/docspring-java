

# EmailActionCustomization

A template's changes to an account email action.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**enabled** | **Boolean** | Whether the account email action sends for this template. It also needs to be on itself (`enabled`). |  |
|**customized** | **List&lt;EmailActionSetting&gt;** | The settings this template changes. The others follow the account email action. |  |
|**consecutiveFailures** | **Integer** | How many of this template's emails in a row have failed because of a setting it changes. |  |
|**failingSince** | **OffsetDateTime** | When the current run of those failures started. |  |
|**lastFailureAt** | **OffsetDateTime** | When one of those emails last failed. |  |
|**lastFailureMessage** | **String** | Why it failed. |  |
|**disabledAt** | **OffsetDateTime** | When DocSpring turned the email action off for this template, such as when an address the template added bounced. |  |
|**disabledReason** | **String** | Why DocSpring turned it off for this template. |  |
|**createdAt** | **OffsetDateTime** | When the template first changed the email action. |  |
|**updatedAt** | **OffsetDateTime** | When the template's changes last changed. |  |



