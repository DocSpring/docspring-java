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
 * CombinedSubmissionData
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-12T21:51:07.029+08:00[Asia/Kuala_Lumpur]")
public class CombinedSubmissionData {
  public static final String SERIALIZED_NAME_TEST = "test";
  @SerializedName(SERIALIZED_NAME_TEST)
  private Boolean test = null;

  public static final String SERIALIZED_NAME_SUBMISSION_IDS = "submission_ids";
  @SerializedName(SERIALIZED_NAME_SUBMISSION_IDS)
  private List<String> submissionIds = new ArrayList<String>();

  public static final String SERIALIZED_NAME_METADATA = "metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Object metadata = null;

  public static final String SERIALIZED_NAME_EXPIRES_IN = "expires_in";
  @SerializedName(SERIALIZED_NAME_EXPIRES_IN)
  private Integer expiresIn = null;

  public CombinedSubmissionData test(Boolean test) {
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

  public CombinedSubmissionData submissionIds(List<String> submissionIds) {
    this.submissionIds = submissionIds;
    return this;
  }

  public CombinedSubmissionData addSubmissionIdsItem(String submissionIdsItem) {
    this.submissionIds.add(submissionIdsItem);
    return this;
  }

   /**
   * Get submissionIds
   * @return submissionIds
  **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getSubmissionIds() {
    return submissionIds;
  }

  public void setSubmissionIds(List<String> submissionIds) {
    this.submissionIds = submissionIds;
  }

  public CombinedSubmissionData metadata(Object metadata) {
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

  public CombinedSubmissionData expiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * Get expiresIn
   * @return expiresIn
  **/
  @ApiModelProperty(value = "")
  public Integer getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CombinedSubmissionData combinedSubmissionData = (CombinedSubmissionData) o;
    return Objects.equals(this.test, combinedSubmissionData.test) &&
        Objects.equals(this.submissionIds, combinedSubmissionData.submissionIds) &&
        Objects.equals(this.metadata, combinedSubmissionData.metadata) &&
        Objects.equals(this.expiresIn, combinedSubmissionData.expiresIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(test, submissionIds, metadata, expiresIn);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CombinedSubmissionData {\n");
    
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
    sb.append("    submissionIds: ").append(toIndentedString(submissionIds)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
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

