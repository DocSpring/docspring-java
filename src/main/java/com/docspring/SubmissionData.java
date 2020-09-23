/*
 * API v1
 * DocSpring is a service that helps you fill out and sign PDF templates.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.docspring;

import java.util.Objects;
import java.util.Arrays;
import com.docspring.CreateSubmissionDataRequestData;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SubmissionData
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-24T00:43:49.031+08:00[Asia/Kuala_Lumpur]")
public class SubmissionData {
  public static final String SERIALIZED_NAME_TEST = "test";
  @SerializedName(SERIALIZED_NAME_TEST)
  private Boolean test = null;

  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private Object data = null;

  public static final String SERIALIZED_NAME_HTML = "html";
  @SerializedName(SERIALIZED_NAME_HTML)
  private String html = null;

  public static final String SERIALIZED_NAME_CSS = "css";
  @SerializedName(SERIALIZED_NAME_CSS)
  private String css = null;

  public static final String SERIALIZED_NAME_METADATA = "metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Object metadata = null;

  public static final String SERIALIZED_NAME_FIELD_OVERRIDES = "field_overrides";
  @SerializedName(SERIALIZED_NAME_FIELD_OVERRIDES)
  private Object fieldOverrides = null;

  public static final String SERIALIZED_NAME_DATA_REQUESTS = "data_requests";
  @SerializedName(SERIALIZED_NAME_DATA_REQUESTS)
  private List<CreateSubmissionDataRequestData> dataRequests = null;

  public SubmissionData test(Boolean test) {
    this.test = test;
    return this;
  }

   /**
   * Get test
   * @return test
  **/
  @ApiModelProperty(value = "")
  public Boolean getTest() {
    return test;
  }

  public void setTest(Boolean test) {
    this.test = test;
  }

  public SubmissionData data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public SubmissionData html(String html) {
    this.html = html;
    return this;
  }

   /**
   * Get html
   * @return html
  **/
  @ApiModelProperty(value = "")
  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public SubmissionData css(String css) {
    this.css = css;
    return this;
  }

   /**
   * Get css
   * @return css
  **/
  @ApiModelProperty(value = "")
  public String getCss() {
    return css;
  }

  public void setCss(String css) {
    this.css = css;
  }

  public SubmissionData metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  public SubmissionData fieldOverrides(Object fieldOverrides) {
    this.fieldOverrides = fieldOverrides;
    return this;
  }

   /**
   * Get fieldOverrides
   * @return fieldOverrides
  **/
  @ApiModelProperty(value = "")
  public Object getFieldOverrides() {
    return fieldOverrides;
  }

  public void setFieldOverrides(Object fieldOverrides) {
    this.fieldOverrides = fieldOverrides;
  }

  public SubmissionData dataRequests(List<CreateSubmissionDataRequestData> dataRequests) {
    this.dataRequests = dataRequests;
    return this;
  }

  public SubmissionData addDataRequestsItem(CreateSubmissionDataRequestData dataRequestsItem) {
    if (this.dataRequests == null) {
      this.dataRequests = new ArrayList<CreateSubmissionDataRequestData>();
    }
    this.dataRequests.add(dataRequestsItem);
    return this;
  }

   /**
   * Get dataRequests
   * @return dataRequests
  **/
  @ApiModelProperty(value = "")
  public List<CreateSubmissionDataRequestData> getDataRequests() {
    return dataRequests;
  }

  public void setDataRequests(List<CreateSubmissionDataRequestData> dataRequests) {
    this.dataRequests = dataRequests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmissionData submissionData = (SubmissionData) o;
    return Objects.equals(this.test, submissionData.test) &&
        Objects.equals(this.data, submissionData.data) &&
        Objects.equals(this.html, submissionData.html) &&
        Objects.equals(this.css, submissionData.css) &&
        Objects.equals(this.metadata, submissionData.metadata) &&
        Objects.equals(this.fieldOverrides, submissionData.fieldOverrides) &&
        Objects.equals(this.dataRequests, submissionData.dataRequests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(test, data, html, css, metadata, fieldOverrides, dataRequests);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmissionData {\n");
    
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
    sb.append("    css: ").append(toIndentedString(css)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    fieldOverrides: ").append(toIndentedString(fieldOverrides)).append("\n");
    sb.append("    dataRequests: ").append(toIndentedString(dataRequests)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

