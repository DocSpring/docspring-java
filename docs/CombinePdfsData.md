

# CombinePdfsData


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deleteCustomFiles** | **Boolean** | Delete the custom files in source_pdfs once the combined PDF has been processed (they&#39;re kept if it fails). Other combined submissions can&#39;t use them after that. A test API token can&#39;t delete custom files. |  [optional] |
|**expiresIn** | **Integer** |  |  [optional] |
|**metadata** | **Object** |  |  [optional] |
|**password** | **String** |  |  [optional] |
|**sourcePdfs** | **List&lt;Object&gt;** |  |  |
|**test** | **Boolean** | Deprecated, and has no effect. A combined PDF is a test or live document because of its source PDFs. |  [optional] |



