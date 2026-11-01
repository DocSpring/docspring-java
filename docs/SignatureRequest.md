

# SignatureRequest

A request for someone to fill in their fields of a submission and sign it. Someone who only fills in fields for the people who sign later (such as an employer's section) has a signature request too. The submission's PDF is generated once every signature request is completed.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The signature request's ID. |  |
|**submissionId** | **String** | The ID of the submission the signature request belongs to. |  |
|**name** | **String** | The name of the person the request is for. |  |
|**email** | **String** | Their email address. Null when they have none. |  |
|**fields** | **List&lt;String&gt;** | The fields this person fills in. Null for a signature request created with API v1 without a field list: it asks for every field the submission's data doesn't have. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Your own data about the signature request, such as an ID from your app. |  |
|**role** | **String** | Which of the template's signers the person is. Until templates have roles of their own, a template's signers are `Signer 1`, `Signer 2` and so on, up to `Signer 100`: `Signer 1` is the one whose details the template's `@@signature_requests/0` fields print. |  |
|**sortOrder** | **Integer** | The signer's position, from 0: `Signer 1` is 0. The template's `@@signature_requests/&lt;sort_order&gt;` fields print this signature request's details. |  |
|**sendEmail** | **Boolean** | Whether DocSpring emails this person their signing link. |  |
|**signingStep** | **Integer** | When this person signs, when the submission's `signing_order` is `sequential`: everyone in step 1 first, then step 2, and so on. Null when everyone can sign at once. |  |
|**sentAt** | **OffsetDateTime** | When DocSpring first emailed this person their signing link. Null until it has, and when it doesn't email them (`send_email` is false). |  |
|**emailStatus** | **SignatureRequestEmailStatus** | What happened to the latest email DocSpring sent this person with their signing link: `sent` until the email service reports on it, then `delayed` (still trying), `delivered`, `undelivered` (it stopped trying, as with a full mailbox), `bounced` (the address doesn't exist) or `complained` (marked as spam). `failed` means DocSpring couldn't send the first email with their link, and `unknown` that it couldn't tell whether that email went: neither is sent again. Null until DocSpring has emailed them or tried to. |  |
|**state** | **SignatureRequestState** | `pending` until the person completes the signature request (`completed`) or declines it (`declined`). |  |
|**data** | **Map&lt;String, Object&gt;** | The values this person entered for their own fields (`fields`). Null when their submission's data is left out: in lists without `include_data=true`, in the events of a webhook that leaves out submission data, and once the submission has expired. |  |
|**viewedAt** | **OffsetDateTime** | When the person first opened the signature request. |  |
|**completedAt** | **OffsetDateTime** | When they completed it. |  |
|**declinedAt** | **OffsetDateTime** | When they declined it. |  |
|**authType** | **SignatureRequestAuthType** | How your app authenticated the person before it showed them the signature request. |  |
|**authSecondFactorType** | **SignatureRequestAuthSecondFactorType** | The second factor your app authenticated them with, if any. |  |
|**authProvider** | **String** | The service that authenticated them, such as `google`. Required when `auth_type` is `oauth`. |  |
|**authSessionStartedAt** | **OffsetDateTime** | When your app authenticated them. Set for you with `email_link`. |  |
|**authSessionIdHash** | **String** | A hash of your app's session ID, for the audit trail. |  |
|**authUserIdHash** | **String** | Their user ID in your app, or a SHA-256 hash of a salt and the user ID. |  |
|**authUsernameHash** | **String** | Their username in your app, or a SHA-256 hash of a salt and the username. |  |
|**authPhoneNumberHash** | **String** | The phone number they authenticated with, or a SHA-256 hash of a salt and the phone number. |  |
|**ipAddress** | **String** | The IP address they completed the signature request from. Null in the events of a webhook that leaves out submission data. |  |
|**userAgent** | **String** | The User-Agent header of the browser they completed the signature request with. Null in the events of a webhook that leaves out submission data. |  |
|**createdAt** | **OffsetDateTime** | When the signature request was created. |  |
|**updatedAt** | **OffsetDateTime** | When the signature request was last updated. |  |



