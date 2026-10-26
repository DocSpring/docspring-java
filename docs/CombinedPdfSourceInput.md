

# CombinedPdfSourceInput

A PDF to merge.

## oneOf schemas
* [CombinedPdfSourcePdf](CombinedPdfSourcePdf.md)
* [CustomFileSourcePdf](CustomFileSourcePdf.md)
* [SubmissionSourcePdf](SubmissionSourcePdf.md)
* [TemplateSourcePdf](TemplateSourcePdf.md)
* [UrlSourcePdf](UrlSourcePdf.md)

## Example
```java
// Import classes:
import com.docspring.CombinedPdfSourceInput;
import com.docspring.CombinedPdfSourcePdf;
import com.docspring.CustomFileSourcePdf;
import com.docspring.SubmissionSourcePdf;
import com.docspring.TemplateSourcePdf;
import com.docspring.UrlSourcePdf;

public class Example {
    public static void main(String[] args) {
        CombinedPdfSourceInput exampleCombinedPdfSourceInput = new CombinedPdfSourceInput();

        // create a new CombinedPdfSourcePdf
        CombinedPdfSourcePdf exampleCombinedPdfSourcePdf = new CombinedPdfSourcePdf();
        // set CombinedPdfSourceInput to CombinedPdfSourcePdf
        exampleCombinedPdfSourceInput.setActualInstance(exampleCombinedPdfSourcePdf);
        // to get back the CombinedPdfSourcePdf set earlier
        CombinedPdfSourcePdf testCombinedPdfSourcePdf = (CombinedPdfSourcePdf) exampleCombinedPdfSourceInput.getActualInstance();

        // create a new CustomFileSourcePdf
        CustomFileSourcePdf exampleCustomFileSourcePdf = new CustomFileSourcePdf();
        // set CombinedPdfSourceInput to CustomFileSourcePdf
        exampleCombinedPdfSourceInput.setActualInstance(exampleCustomFileSourcePdf);
        // to get back the CustomFileSourcePdf set earlier
        CustomFileSourcePdf testCustomFileSourcePdf = (CustomFileSourcePdf) exampleCombinedPdfSourceInput.getActualInstance();

        // create a new SubmissionSourcePdf
        SubmissionSourcePdf exampleSubmissionSourcePdf = new SubmissionSourcePdf();
        // set CombinedPdfSourceInput to SubmissionSourcePdf
        exampleCombinedPdfSourceInput.setActualInstance(exampleSubmissionSourcePdf);
        // to get back the SubmissionSourcePdf set earlier
        SubmissionSourcePdf testSubmissionSourcePdf = (SubmissionSourcePdf) exampleCombinedPdfSourceInput.getActualInstance();

        // create a new TemplateSourcePdf
        TemplateSourcePdf exampleTemplateSourcePdf = new TemplateSourcePdf();
        // set CombinedPdfSourceInput to TemplateSourcePdf
        exampleCombinedPdfSourceInput.setActualInstance(exampleTemplateSourcePdf);
        // to get back the TemplateSourcePdf set earlier
        TemplateSourcePdf testTemplateSourcePdf = (TemplateSourcePdf) exampleCombinedPdfSourceInput.getActualInstance();

        // create a new UrlSourcePdf
        UrlSourcePdf exampleUrlSourcePdf = new UrlSourcePdf();
        // set CombinedPdfSourceInput to UrlSourcePdf
        exampleCombinedPdfSourceInput.setActualInstance(exampleUrlSourcePdf);
        // to get back the UrlSourcePdf set earlier
        UrlSourcePdf testUrlSourcePdf = (UrlSourcePdf) exampleCombinedPdfSourceInput.getActualInstance();
    }
}
```


