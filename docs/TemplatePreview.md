

# TemplatePreview


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addDataRequestSubmissionIdFooters** | **Boolean** |  |  |
|**allowAdditionalProperties** | **Boolean** |  |  |
|**description** | **String** |  |  |
|**documentFilename** | **String** |  |  |
|**documentMd5** | **String** |  |  |
|**documentParseError** | **Boolean** |  |  |
|**documentProcessed** | **Boolean** |  |  |
|**documentState** | [**DocumentStateEnum**](#DocumentStateEnum) |  |  |
|**documentUrl** | **String** |  |  |
|**editableSubmissions** | **Boolean** |  |  |
|**embedDomains** | **String** |  |  |
|**encryptPdfsPassword** | **String** |  |  |
|**encryptPdfs** | **Boolean** |  |  |
|**expirationInterval** | **String** |  |  |
|**expireAfter** | **Integer** |  |  |
|**expireSubmissions** | **Boolean** |  |  |
|**externalPredefinedFieldsTemplateId** | **String** |  |  |
|**externalPredefinedFieldsTemplateName** | **String** |  |  |
|**firstTemplate** | **Boolean** |  |  |
|**id** | **String** |  |  |
|**locked** | **Boolean** |  |  |
|**mergeAuditTrailPdf** | **Boolean** |  |  |
|**name** | **String** |  |  |
|**pageCount** | **Integer** |  |  |
|**pageDimensions** | **List&lt;List&lt;BigDecimal&gt;&gt;** |  |  |
|**parentFolderId** | **String** |  |  |
|**path** | **String** |  |  |
|**permanentDocumentUrl** | **String** |  |  |
|**publicSubmissions** | **Boolean** |  |  |
|**publicWebForm** | **Boolean** |  |  |
|**redirectUrl** | **String** |  |  |
|**slackWebhookUrl** | **String** |  |  |
|**templateType** | [**TemplateTypeEnum**](#TemplateTypeEnum) |  |  |
|**updatedAt** | **String** |  |  |
|**webhookUrl** | **String** |  |  |
|**demo** | **Boolean** |  |  |



## Enum: DocumentStateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| PROCESSED | &quot;processed&quot; |
| PASSWORD_REQUIRED | &quot;password_required&quot; |
| MALFORMED_PDF | &quot;malformed_pdf&quot; |
| UNKNOWN_ERROR | &quot;unknown_error&quot; |



## Enum: TemplateTypeEnum

| Name | Value |
|---- | -----|
| PDF | &quot;pdf&quot; |
| HTML | &quot;html&quot; |



