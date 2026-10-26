

# TemplateFieldDependencyConditionInput

A condition on a field's value.

## oneOf schemas
* [FieldComparisonCondition](FieldComparisonCondition.md)
* [FieldEqualsCondition](FieldEqualsCondition.md)
* [FieldInCondition](FieldInCondition.md)
* [FieldPresenceCondition](FieldPresenceCondition.md)
* [FieldRangeCondition](FieldRangeCondition.md)

## Example
```java
// Import classes:
import com.docspring.TemplateFieldDependencyConditionInput;
import com.docspring.FieldComparisonCondition;
import com.docspring.FieldEqualsCondition;
import com.docspring.FieldInCondition;
import com.docspring.FieldPresenceCondition;
import com.docspring.FieldRangeCondition;

public class Example {
    public static void main(String[] args) {
        TemplateFieldDependencyConditionInput exampleTemplateFieldDependencyConditionInput = new TemplateFieldDependencyConditionInput();

        // create a new FieldComparisonCondition
        FieldComparisonCondition exampleFieldComparisonCondition = new FieldComparisonCondition();
        // set TemplateFieldDependencyConditionInput to FieldComparisonCondition
        exampleTemplateFieldDependencyConditionInput.setActualInstance(exampleFieldComparisonCondition);
        // to get back the FieldComparisonCondition set earlier
        FieldComparisonCondition testFieldComparisonCondition = (FieldComparisonCondition) exampleTemplateFieldDependencyConditionInput.getActualInstance();

        // create a new FieldEqualsCondition
        FieldEqualsCondition exampleFieldEqualsCondition = new FieldEqualsCondition();
        // set TemplateFieldDependencyConditionInput to FieldEqualsCondition
        exampleTemplateFieldDependencyConditionInput.setActualInstance(exampleFieldEqualsCondition);
        // to get back the FieldEqualsCondition set earlier
        FieldEqualsCondition testFieldEqualsCondition = (FieldEqualsCondition) exampleTemplateFieldDependencyConditionInput.getActualInstance();

        // create a new FieldInCondition
        FieldInCondition exampleFieldInCondition = new FieldInCondition();
        // set TemplateFieldDependencyConditionInput to FieldInCondition
        exampleTemplateFieldDependencyConditionInput.setActualInstance(exampleFieldInCondition);
        // to get back the FieldInCondition set earlier
        FieldInCondition testFieldInCondition = (FieldInCondition) exampleTemplateFieldDependencyConditionInput.getActualInstance();

        // create a new FieldPresenceCondition
        FieldPresenceCondition exampleFieldPresenceCondition = new FieldPresenceCondition();
        // set TemplateFieldDependencyConditionInput to FieldPresenceCondition
        exampleTemplateFieldDependencyConditionInput.setActualInstance(exampleFieldPresenceCondition);
        // to get back the FieldPresenceCondition set earlier
        FieldPresenceCondition testFieldPresenceCondition = (FieldPresenceCondition) exampleTemplateFieldDependencyConditionInput.getActualInstance();

        // create a new FieldRangeCondition
        FieldRangeCondition exampleFieldRangeCondition = new FieldRangeCondition();
        // set TemplateFieldDependencyConditionInput to FieldRangeCondition
        exampleTemplateFieldDependencyConditionInput.setActualInstance(exampleFieldRangeCondition);
        // to get back the FieldRangeCondition set earlier
        FieldRangeCondition testFieldRangeCondition = (FieldRangeCondition) exampleTemplateFieldDependencyConditionInput.getActualInstance();
    }
}
```


