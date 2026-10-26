

# UpdateSignatureRequestRequest

The settings to change. Properties left out keep their values.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**metadata** | **Map&lt;String, Object&gt;** | Your own data about the signature request, such as an ID from your app. |  [optional] |
|**authType** | **SignatureRequestAuthType** | How your app authenticated the person before it showed them the signature request. |  [optional] |
|**authSecondFactorType** | **SignatureRequestAuthSecondFactorType** | The second factor your app authenticated them with, if any. |  [optional] |
|**authProvider** | **String** | The service that authenticated them, such as `google`. Required when `auth_type` is `oauth`. |  [optional] |
|**authSessionStartedAt** | **OffsetDateTime** | When your app authenticated them. Set for you with `email_link`. |  [optional] |
|**authSessionIdHash** | **String** | A hash of your app's session ID, for the audit trail. |  [optional] |
|**authUserIdHash** | **String** | Their user ID in your app, or a SHA-256 hash of a salt and the user ID. |  [optional] |
|**authUsernameHash** | **String** | Their username in your app, or a SHA-256 hash of a salt and the username. |  [optional] |
|**authPhoneNumberHash** | **String** | The phone number they authenticated with, or a SHA-256 hash of a salt and the phone number. |  [optional] |



