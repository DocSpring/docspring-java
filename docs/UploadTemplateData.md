
# UploadTemplateData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expirationInterval** | [**ExpirationIntervalEnum**](#ExpirationIntervalEnum) |  |  [optional]
**webhookUrl** | **String** |  |  [optional]
**scss** | **String** |  |  [optional]
**allowAdditionalProperties** | **Boolean** |  |  [optional]
**document** | [**UploadTemplateDataDocument**](UploadTemplateDataDocument.md) |  |  [optional]
**expireAfter** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**description** | **String** |  |  [optional]
**publicSubmissions** | **Boolean** |  |  [optional]
**slackWebhookUrl** | **String** |  |  [optional]
**headerHtml** | **String** |  |  [optional]
**publicWebForm** | **Boolean** |  |  [optional]
**editableSubmissions** | **Boolean** |  |  [optional]
**expireSubmissions** | **Boolean** |  |  [optional]
**name** | **String** |  |  [optional]
**footerHtml** | **String** |  |  [optional]
**html** | **String** |  |  [optional]
**templateType** | [**TemplateTypeEnum**](#TemplateTypeEnum) |  |  [optional]
**redirectUrl** | **String** |  |  [optional]


<a name="ExpirationIntervalEnum"></a>
## Enum: ExpirationIntervalEnum
Name | Value
---- | -----
MINUTES | &quot;minutes&quot;
HOURS | &quot;hours&quot;
DAYS | &quot;days&quot;


<a name="TemplateTypeEnum"></a>
## Enum: TemplateTypeEnum
Name | Value
---- | -----
PDF | &quot;pdf&quot;
HTML | &quot;html&quot;



