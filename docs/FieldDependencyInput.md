

# FieldDependencyInput

A field's own conditional logic rule: when other fields' values meet its conditions, the field is shown, made required, or both.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**action** | **TemplateFieldDependencyAction** | What the rule does to the fields it applies to when its conditions are met. |  |
|**match** | **TemplateFieldDependencyMatch** | Whether all of the conditions (the default) or any of them must be met. |  [optional] |
|**conditions** | [**List&lt;TemplateFieldDependencyConditionInput&gt;**](TemplateFieldDependencyConditionInput.md) | The conditions on other fields' values. |  |



