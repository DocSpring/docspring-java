

# TemplateFieldChanges

The fields that changed between two versions of a template.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**added** | **List&lt;Field&gt;** | The fields that `to_version` has and `from_version` doesn't. |  |
|**removed** | **List&lt;Field&gt;** | The fields that `from_version` has and `to_version` doesn't, as they were. |  |
|**changed** | [**List&lt;TemplateFieldChange&gt;**](TemplateFieldChange.md) | The fields with changed settings. |  |
|**reordered** | [**List&lt;TemplateFieldMove&gt;**](TemplateFieldMove.md) | The fields that moved in the template's field order (the order of its fields across all its pages, as the fields endpoint lists them): fields that swapped places, or the field that moved the furthest. The fields that a move pushed along aren't listed. |  |



