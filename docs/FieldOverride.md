

# FieldOverride

Changes to one field's settings for this submission only. Settings left out keep the template's.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_static** | **Boolean** | Print the field's `default` (a fixed value, or a formula for a number field) on the PDF instead of a value from `data`. |  [optional] |
|**editable** | **Boolean** | Keep this field fillable in the PDF instead of flattening it to text. The submission's `editable` overrides it. |  [optional] |
|**_default** | **String** | The value used when `data` has none for the field. |  [optional] |
|**title** | **String** | The field's label on the signing form. |  [optional] |
|**required** | **Boolean** | Whether `data` must have a value for the field. |  [optional] |
|**optionList** | **String** | The values the field can take, separated by commas, such as `Yes,No`. Null allows any value. |  [optional] |
|**combinedFieldNames** | **String** | The names of the fields a combined field joins, separated by commas. |  [optional] |
|**combinedFieldType** | **CombinedFieldType** | How a combined field joins its fields' values. |  [optional] |
|**combinedFieldSeparator** | **String** | The text between the values of a combined field, such as `, `. |  [optional] |
|**combinedFieldFormat** | **String** | The text a combined field prints, with `$0`, `$1` and so on for its fields' values, such as `$0, $1`. |  [optional] |
|**integer** | **Boolean** | Whether a number field takes only whole numbers. |  [optional] |
|**includeTime** | **Boolean** | Whether a date field takes a date and time (RFC 3339) rather than a date (YYYY-MM-DD). |  [optional] |
|**signatureAllowDraw** | **Boolean** | Let the person draw their signature or initials on the signing form. |  [optional] |
|**signatureAllowType** | **Boolean** | Let the person type their signature or initials on the signing form. |  [optional] |
|**barcodeSymbology** | **BarcodeSymbology** | The kind of barcode a field with display_type `barcode` prints. |  [optional] |
|**hidden** | **Boolean** | Leave the field off the PDF. Its value is still in the data, and combined fields can use it. |  [optional] |
|**x** | **BigDecimal** | The distance from the left edge of the page, in the template editor's page units. |  [optional] |
|**y** | **BigDecimal** | The distance from the top of the page, in the template editor's page units. |  [optional] |
|**width** | **BigDecimal** | The field's width, in the template editor's page units. |  [optional] |
|**height** | **BigDecimal** | The field's height, in the template editor's page units. |  [optional] |
|**rotation** | **BigDecimal** | The field's rotation in degrees, clockwise. |  [optional] |
|**displayType** | **FieldDisplayType** | How the field's value is drawn on the PDF. |  [optional] |
|**opacity** | **BigDecimal** | The field's opacity, from 0 (invisible) to 1 (solid). |  [optional] |
|**dateTimeFormat** | **String** | How a date field's value is printed, as a strftime format such as `%m/%d/%Y`. Null uses the template's date format. |  [optional] |
|**typeface** | **Typeface** | The font of the field's text. Null uses the template's default. |  [optional] |
|**fontSize** | **Integer** | The font size in points, a whole number. Null uses the template's default. |  [optional] |
|**characterSpacing** | **BigDecimal** | Extra space between characters, in points (0 to 50). |  [optional] |
|**bold** | **Boolean** | Print the text in bold. |  [optional] |
|**uppercase** | **Boolean** | Print the text in capitals. |  [optional] |
|**strikethrough** | **Boolean** | Strike through the text. |  [optional] |
|**keepLeadingSpaces** | **Boolean** | Keep the spaces at the start of the text and of each line, so you can line text up with spaces. |  [optional] |
|**overflow** | **TextOverflow** | What happens to text that doesn't fit in the field. |  [optional] |
|**multiline** | **Boolean** | Wrap the text over several lines when it doesn't fit on one. |  [optional] |
|**multilineLines** | **Integer** | The number of lines in a multiline field, for a PDF with ruled lines. Null for no fixed number of lines. |  [optional] |
|**maxLength** | **Integer** | The most characters the field takes. Null for no limit. |  [optional] |
|**color** | **String** | The text color, as 6 hex digits without `#`, such as `444444`. Null uses the template's default. |  [optional] |
|**backgroundColor** | **String** | The field's background color, as 6 hex digits without `#`. Null for none. |  [optional] |
|**alignment** | **TextAlignment** | How text is aligned in its field. `justify` lines up both edges of every line of multiline text except the last of each paragraph. |  [optional] |
|**vAlignment** | **TextVerticalAlignment** | How text is aligned vertically in its field. |  [optional] |
|**comb** | **Boolean** | Print one character in each of the field's equally spaced boxes (combs). |  [optional] |
|**combNumberOfCells** | **Integer** | The number of boxes in a comb field. |  [optional] |
|**combValueOffset** | **Integer** | The character of the value that the first box starts from, for a value split over several comb fields (such as the parts of a Social Security number). |  [optional] |
|**shapeType** | **ShapeType** | The shape a field with display_type `shape` draws. |  [optional] |
|**shapeSides** | **Integer** | The number of sides of a `polygon` shape. |  [optional] |
|**shapeBorderWidth** | **Integer** | The width of a shape's border, in points, a whole number. |  [optional] |
|**shapeBorderColor** | **String** | The color of a shape's border, as 6 hex digits without `#`. |  [optional] |
|**shapeFillColor** | **String** | The color a shape is filled with, as 6 hex digits without `#`. Null for no fill. |  [optional] |
|**checkCharacter** | **CheckCharacter** | The character that a ticked check box prints. |  [optional] |
|**checkColor** | **String** | The color of the check mark, as 6 hex digits without `#`. Null uses the template's default. |  [optional] |
|**qrcodeColor** | **String** | The color of a QR code, as 6 hex digits without `#`. Null for black. |  [optional] |
|**trueText** | **String** | What a boolean field with display_type `text` prints for `true`. |  [optional] |
|**falseText** | **String** | What a boolean field with display_type `text` prints for `false`. |  [optional] |
|**condition** | **String** | The value a check mark or shape is drawn for: it's drawn when the field's value matches, as `string_condition_type` or `number_condition_type` says. |  [optional] |
|**stringConditionType** | **StringConditionType** | How a string field's value is compared with `condition`. |  [optional] |
|**numberConditionType** | **NumberConditionType** | How a number field's value is compared with `condition`, or with `number_condition_range_min` and `number_condition_range_max` for `range`. |  [optional] |
|**numberConditionRangeMin** | **BigDecimal** | The lower end of a `range` condition. |  [optional] |
|**numberConditionRangeMax** | **BigDecimal** | The upper end of a `range` condition. |  [optional] |
|**numberConditionRangeExclusiveMin** | **Boolean** | Leave the lower end itself out of a `range` condition. |  [optional] |
|**numberConditionRangeExclusiveMax** | **Boolean** | Leave the upper end itself out of a `range` condition. |  [optional] |
|**invertBooleanCondition** | **Boolean** | Draw a boolean field's check mark or shape for `false` instead of `true`. |  [optional] |
|**decimalPlaces** | **Integer** | The number of decimal places a number field prints. Null prints the value as it was sent. |  [optional] |
|**imageScaleType** | **ImageScaleType** | How an image is resized to its field. |  [optional] |
|**imageGravity** | **ImageGravity** | Where an image sits in its field when it doesn't fill it, or which part is kept when it's cropped. |  [optional] |



