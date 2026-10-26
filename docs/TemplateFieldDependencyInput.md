

# TemplateFieldDependencyInput

A conditional logic rule: when other fields' values meet its conditions, it shows its target fields, makes them required, or both.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**action** | **TemplateFieldDependencyAction** | What the rule does to its targets when its conditions are met. |  |
|**match** | **TemplateFieldDependencyMatch** | Whether all of the conditions (the default) or any of them must be met. |  [optional] |
|**conditions** | [**List&lt;TemplateFieldDependencyConditionInput&gt;**](TemplateFieldDependencyConditionInput.md) | The conditions on other fields' values. |  |
|**targets** | **List&lt;String&gt;** | The names of the fields the rule shows or makes required. |  |
|**group** | **String** | Marks a rule made for a field group in the template editor. Its targets outside the group are removed when the template is saved, and the rule is removed once the group has no fields. |  [optional] |



