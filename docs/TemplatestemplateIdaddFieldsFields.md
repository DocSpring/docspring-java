
# TemplatestemplateIdaddFieldsFields

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**backgroundColorFieldName** | **String** |  |  [optional]
**uppercase** | **Boolean** |  |  [optional]
**metadata** | **String** |  |  [optional]
**barcodeSymbology** | **String** |  |  [optional]
**minLength** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**integer** | **Boolean** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**required** | **Boolean** |  |  [optional]
**combValueOffset** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**imageGravity** | [**ImageGravityEnum**](#ImageGravityEnum) |  |  [optional]
**overflow** | [**OverflowEnum**](#OverflowEnum) |  |  [optional]
**qrcodeColor** | **String** |  |  [optional]
**colorFieldRequired** | **Boolean** |  |  [optional]
**backgroundColorFieldRequired** | **Boolean** |  |  [optional]
**id** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**imageScaleType** | [**ImageScaleTypeEnum**](#ImageScaleTypeEnum) |  |  [optional]
**exclusiveMinimum** | **Boolean** |  |  [optional]
**height** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**numberConditionRangeExclusiveMax** | **Boolean** |  |  [optional]
**invertBooleanCondition** | **Boolean** |  |  [optional]
**shapeFillColorFieldName** | **String** |  |  [optional]
**_static** | **Boolean** |  |  [optional]
**shapeBorderColorFieldName** | **String** |  |  [optional]
**vAlignment** | [**VAlignmentEnum**](#VAlignmentEnum) |  |  [optional]
**bold** | **Boolean** |  |  [optional]
**shapeBorderWidth** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**combNumberOfCells** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**shapeBorderColor** | **String** |  |  [optional]
**comb** | **Boolean** |  |  [optional]
**typeface** | **String** |  |  [optional]
**shapeType** | [**ShapeTypeEnum**](#ShapeTypeEnum) |  |  [optional]
**condition** | **String** |  |  [optional]
**displayType** | [**DisplayTypeEnum**](#DisplayTypeEnum) |  |  [optional]
**checkColor** | **String** |  |  [optional]
**multilineLines** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**multiline** | **Boolean** |  |  [optional]
**trueText** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**fontSize** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**page** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**alignment** | [**AlignmentEnum**](#AlignmentEnum) |  |  [optional]
**maxLength** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**autoCalculateMaxLength** | **Boolean** |  |  [optional]
**colorFieldName** | **String** |  |  [optional]
**qrcodeColorFieldName** | **String** |  |  [optional]
**numberConditionRangeMin** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**color** | **String** |  |  [optional]
**hidden** | **Boolean** |  |  [optional]
**checkColorFieldRequired** | **Boolean** |  |  [optional]
**combinedFieldFormat** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**shapeBorderColorFieldRequired** | **Boolean** |  |  [optional]
**combinedFieldNames** | **String** |  |  [optional]
**title** | **String** |  |  [optional]
**numberConditionRangeExclusiveMin** | **Boolean** |  |  [optional]
**combinedFieldSeparator** | **String** |  |  [optional]
**exclusiveMaximum** | **Boolean** |  |  [optional]
**_default** | **String** |  |  [optional]
**combinedFieldType** | **String** |  |  [optional]
**dateTimeFormat** | **String** |  |  [optional]
**qrcodeColorFieldRequired** | **Boolean** |  |  [optional]
**currency** | **Boolean** |  |  [optional]
**falseText** | **String** |  |  [optional]
**strikethrough** | **Boolean** |  |  [optional]
**characterSpacing** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**numberConditionRangeMax** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**backgroundColor** | **String** |  |  [optional]
**checkColorFieldName** | **String** |  |  [optional]
**checkCharacter** | [**CheckCharacterEnum**](#CheckCharacterEnum) |  |  [optional]
**rotation** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**optionList** | **String** |  |  [optional]
**shapeFillColor** | **String** |  |  [optional]
**stringConditionType** | [**StringConditionTypeEnum**](#StringConditionTypeEnum) |  |  [optional]
**shapeFillColorFieldRequired** | **Boolean** |  |  [optional]
**decimalPlaces** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**includeTime** | **Boolean** |  |  [optional]
**width** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**x** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**maximum** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**y** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**signatureAllowDraw** | **Boolean** |  |  [optional]
**numberConditionType** | [**NumberConditionTypeEnum**](#NumberConditionTypeEnum) |  |  [optional]
**opacity** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**minimum** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**signatureAllowType** | **Boolean** |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
STRING | &quot;string&quot;
NUMBER | &quot;number&quot;
BOOLEAN | &quot;boolean&quot;
DATE | &quot;date&quot;
ADDRESS | &quot;address&quot;
COUNTRY | &quot;country&quot;
EMAIL | &quot;email&quot;
URL | &quot;url&quot;
IMAGE | &quot;image&quot;
SIGNATURE | &quot;signature&quot;
BARCODE | &quot;barcode&quot;
COMBINED | &quot;combined&quot;


<a name="ImageGravityEnum"></a>
## Enum: ImageGravityEnum
Name | Value
---- | -----
NORTHWEST | &quot;NorthWest&quot;
NORTH | &quot;North&quot;
NORTHEAST | &quot;NorthEast&quot;
WEST | &quot;West&quot;
CENTER | &quot;Center&quot;
EAST | &quot;East&quot;
SOUTHWEST | &quot;SouthWest&quot;
SOUTH | &quot;South&quot;
SOUTHEAST | &quot;SouthEast&quot;


<a name="OverflowEnum"></a>
## Enum: OverflowEnum
Name | Value
---- | -----
SHRINK_TO_FIT | &quot;shrink_to_fit&quot;
TRUNCATE | &quot;truncate&quot;


<a name="ImageScaleTypeEnum"></a>
## Enum: ImageScaleTypeEnum
Name | Value
---- | -----
FIT | &quot;fit&quot;
FILL | &quot;fill&quot;
STRETCH | &quot;stretch&quot;


<a name="VAlignmentEnum"></a>
## Enum: VAlignmentEnum
Name | Value
---- | -----
BOTTOM | &quot;bottom&quot;
CENTER | &quot;center&quot;
TOP | &quot;top&quot;


<a name="ShapeTypeEnum"></a>
## Enum: ShapeTypeEnum
Name | Value
---- | -----
SQUARE | &quot;square&quot;
RECTANGLE | &quot;rectangle&quot;
CIRCLE | &quot;circle&quot;
ELLIPSE | &quot;ellipse&quot;


<a name="DisplayTypeEnum"></a>
## Enum: DisplayTypeEnum
Name | Value
---- | -----
TEXT | &quot;text&quot;
CHECK | &quot;check&quot;
QRCODE | &quot;qrcode&quot;
BARCODE | &quot;barcode&quot;
IMAGE | &quot;image&quot;
SHAPE | &quot;shape&quot;


<a name="AlignmentEnum"></a>
## Enum: AlignmentEnum
Name | Value
---- | -----
LEFT | &quot;left&quot;
CENTER | &quot;center&quot;
RIGHT | &quot;right&quot;


<a name="CheckCharacterEnum"></a>
## Enum: CheckCharacterEnum
Name | Value
---- | -----
_10003_ | &quot;&amp;#10003;&quot;
_10004_ | &quot;&amp;#10004;&quot;
_10006_ | &quot;&amp;#10006;&quot;
_10007_ | &quot;&amp;#10007;&quot;
_10008_ | &quot;&amp;#10008;&quot;


<a name="StringConditionTypeEnum"></a>
## Enum: StringConditionTypeEnum
Name | Value
---- | -----
EQUALS | &quot;equals&quot;
CONTAINS | &quot;contains&quot;
STARTS_WITH | &quot;starts_with&quot;
ENDS_WITH | &quot;ends_with&quot;
REGEX | &quot;regex&quot;


<a name="NumberConditionTypeEnum"></a>
## Enum: NumberConditionTypeEnum
Name | Value
---- | -----
EQUALS | &quot;equals&quot;
RANGE | &quot;range&quot;
GTE | &quot;gte&quot;
GT | &quot;gt&quot;
LTE | &quot;lte&quot;
LT | &quot;lt&quot;



