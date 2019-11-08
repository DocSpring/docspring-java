
# SubmissionAction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  | 
**integrationId** | **String** |  | 
**state** | [**StateEnum**](#StateEnum) |  | 
**actionCategory** | [**ActionCategoryEnum**](#ActionCategoryEnum) |  | 
**actionType** | [**ActionTypeEnum**](#ActionTypeEnum) |  | 
**resultData** | **Object** |  | 


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
PROCESSED | &quot;processed&quot;
FAILED | &quot;failed&quot;
ERROR | &quot;error&quot;


<a name="ActionCategoryEnum"></a>
## Enum: ActionCategoryEnum
Name | Value
---- | -----
NOTIFICATION | &quot;notification&quot;
FILE_UPLOAD | &quot;file_upload&quot;


<a name="ActionTypeEnum"></a>
## Enum: ActionTypeEnum
Name | Value
---- | -----
WEBHOOK | &quot;webhook&quot;
SLACK_WEBHOOK | &quot;slack_webhook&quot;
EMAIL | &quot;email&quot;
AWS_S3_UPLOAD | &quot;aws_s3_upload&quot;



