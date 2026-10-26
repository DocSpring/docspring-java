

# TemplateDefaultsInput

The default style of the template's fields. Each field can override it.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**typeface** | **Typeface** | The font of text fields. |  [optional] |
|**fontSize** | **Integer** | The font size in points, a whole number. |  [optional] |
|**characterSpacing** | **BigDecimal** | Extra space between characters, in points (0 to 50). |  [optional] |
|**color** | **String** | The text color, as 6 hex digits without `#`, such as `444444`. |  [optional] |
|**backgroundColor** | **String** | The field's background color, as 6 hex digits. |  [optional] |
|**bold** | **Boolean** | Print text in bold. |  [optional] |
|**uppercase** | **Boolean** | Print text in capital letters. |  [optional] |
|**alignment** | **TextAlignment** | How text is aligned in its field. `justify` lines up both edges of every line of multiline text except the last of each paragraph. |  [optional] |
|**opacity** | **BigDecimal** | The opacity of the field's content, from 0 (invisible) to 1. |  [optional] |
|**dateFormat** | **String** | How date fields are printed, as a strftime format such as `%m/%d/%Y`. |  [optional] |
|**dateTimeFormat** | **String** | How date-time fields are printed, as a strftime format such as `%m/%d/%Y %H:%M:%S`. |  [optional] |
|**checkColor** | **String** | The color of check marks, as 6 hex digits. |  [optional] |
|**checkCharacter** | **CheckCharacter** | The character that a ticked check box prints. |  [optional] |
|**checkBackgroundColor** | **String** | The check box's background color, as 6 hex digits. |  [optional] |
|**requiredFieldBackgroundColor** | **String** | The background color that highlights required fields on visual forms and signature request forms, as 6 hex digits. PDFs don't print it. |  [optional] |
|**trueText** | **String** | The text a boolean field prints for `true`. |  [optional] |
|**falseText** | **String** | The text a boolean field prints for `false`. |  [optional] |
|**shapeFillColor** | **String** | The fill color of shapes, as 6 hex digits. |  [optional] |
|**shapeBorderColor** | **String** | The border color of shapes, as 6 hex digits. |  [optional] |
|**shapeBorderWidth** | **Integer** | The border width of shapes, in whole points (at least 1). |  [optional] |



