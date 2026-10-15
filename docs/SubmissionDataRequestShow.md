

# SubmissionDataRequestShow


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**email** | **String** |  |  |
|**name** | **String** |  |  |
|**order** | **Integer** |  |  |
|**sortOrder** | **Integer** |  |  |
|**fields** | **List&lt;String&gt;** |  |  |
|**metadata** | **Object** |  |  |
|**state** | [**StateEnum**](#StateEnum) |  |  |
|**viewedAt** | **String** |  |  |
|**completedAt** | **String** |  |  |
|**declinedAt** | **String** |  |  |
|**data** | **Object** |  |  |
|**authType** | [**AuthTypeEnum**](#AuthTypeEnum) |  |  |
|**authSecondFactorType** | [**AuthSecondFactorTypeEnum**](#AuthSecondFactorTypeEnum) |  |  |
|**authProvider** | **String** |  |  |
|**authSessionStartedAt** | **String** |  |  |
|**authSessionIdHash** | **String** |  |  |
|**authUserIdHash** | **String** |  |  |
|**authUsernameHash** | **String** |  |  |
|**authPhoneNumberHash** | **String** |  |  |
|**ipAddress** | **String** |  |  |
|**userAgent** | **String** |  |  |
|**submissionId** | **String** |  |  |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| COMPLETED | &quot;completed&quot; |
| DECLINED | &quot;declined&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: AuthTypeEnum

| Name | Value |
|---- | -----|
| NONE | &quot;none&quot; |
| PASSWORD | &quot;password&quot; |
| OAUTH | &quot;oauth&quot; |
| EMAIL_LINK | &quot;email_link&quot; |
| PHONE_NUMBER | &quot;phone_number&quot; |
| LDAP | &quot;ldap&quot; |
| SAML | &quot;saml&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: AuthSecondFactorTypeEnum

| Name | Value |
|---- | -----|
| NONE | &quot;none&quot; |
| PHONE_NUMBER | &quot;phone_number&quot; |
| TOTP | &quot;totp&quot; |
| MOBILE_PUSH | &quot;mobile_push&quot; |
| SECURITY_KEY | &quot;security_key&quot; |
| FINGERPRINT | &quot;fingerprint&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



