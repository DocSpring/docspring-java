

# SubmissionBatch

Submissions created together in one request. Their files are only generated when every submission in the batch is valid.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The batch's ID. |  |
|**state** | **SubmissionBatchState** | `pending` while the files are being generated, then `processed`. `error` as soon as a submission fails, while the others can still be pending: the batch has finished once `processed_at` is set. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Your own data about the batch, such as an ID from your app. |  |
|**totalCount** | **Integer** | The number of submissions in the request. |  |
|**pendingCount** | **Integer** | The submissions whose files haven't been generated yet. |  |
|**errorCount** | **Integer** | The submissions that were invalid or whose files couldn't be generated. |  |
|**completionPercentage** | **Integer** | The percentage of the batch's submissions that have finished, from 0 to 100. |  |
|**submissions** | **List&lt;Submission&gt;** | The batch's submissions, in the order of the request. Their `data` is null unless you pass `include_data=true`. A batch that failed validation only has the submissions that were recorded as `invalid_data`. |  |
|**processedAt** | **OffsetDateTime** | When every submission had finished. |  |
|**createdAt** | **OffsetDateTime** | When the batch was created. |  |
|**updatedAt** | **OffsetDateTime** | When the batch was last updated. |  |



