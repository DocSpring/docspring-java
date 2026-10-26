

# FieldRangeCondition

A condition on whether a number field's value is in a range.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**field** | **String** | The name of the field whose value is compared. |  |
|**operator** | **String** | Must be `range`. |  |
|**value** | **Object** | The lower end of the range, a number (or a number as a string, as the template editor saves it). Null or left out for no lower end. A range needs `value`, `range_max` or both. |  [optional] |
|**rangeMax** | **Object** | The upper end of the range, a number (or a number as a string, as the template editor saves it). Null or left out for no upper end. |  [optional] |



