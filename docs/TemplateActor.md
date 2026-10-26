

# TemplateActor

A user in your account, an API token, or someone using the embedded template editor.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **TemplateActorType** | `user`: a user in your account. `api`: an API token. `external_user`: someone using the embedded template editor, as identified by your app. |  |
|**userId** | **String** | The user's ID, for `user`. |  |
|**externalId** | **String** | The ID your app gave the embedded editor's user, for `external_user`. |  |
|**name** | **String** | The user's name, or the name your app gave the embedded editor's user. |  |
|**email** | **String** | The email address your app gave the embedded editor's user, for `external_user`. |  |



