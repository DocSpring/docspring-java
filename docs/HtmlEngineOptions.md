

# HtmlEngineOptions

How an HTML template's PDFs are printed.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**format** | **PageFormat** | The paper size. `Custom` uses `width` and `height`. |  |
|**width** | **String** | The page width for the `Custom` format, with a unit (`8.5in`, `210mm`). |  [optional] |
|**height** | **String** | The page height for the `Custom` format, with a unit. |  [optional] |
|**scale** | **BigDecimal** | How much to scale the page, such as `0.8`. `1` prints it at its normal size. |  |
|**landscape** | **Boolean** | Print pages in landscape orientation. |  |
|**printBackground** | **Boolean** | Print background colors and images. |  |
|**marginTop** | **String** | The top margin, with a unit, such as `1in` or `20mm`. |  |
|**marginBottom** | **String** | The bottom margin, with a unit. |  |
|**marginLeft** | **String** | The left margin, with a unit. |  |
|**marginRight** | **String** | The right margin, with a unit. |  |



