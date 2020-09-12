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
import com.docspring.CombinedSubmission;
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
 * CreateCombinedSubmissionResponse
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-12T21:51:07.029+08:00[Asia/Kuala_Lumpur]")
public class CreateCombinedSubmissionResponse {
  public static final String SERIALIZED_NAME_COMBINED_SUBMISSION = "combined_submission";
  @SerializedName(SERIALIZED_NAME_COMBINED_SUBMISSION)
  private CombinedSubmission combinedSubmission = null;

  public static final String SERIALIZED_NAME_ERRORS = "errors";
  @SerializedName(SERIALIZED_NAME_ERRORS)
  private List<String> errors = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    SUCCESS("success"),
    
    ERROR("error");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status = null;

  public CreateCombinedSubmissionResponse combinedSubmission(CombinedSubmission combinedSubmission) {
    this.combinedSubmission = combinedSubmission;
    return this;
  }

   /**
   * Get combinedSubmission
   * @return combinedSubmission
  **/
  @ApiModelProperty(value = "")
  public CombinedSubmission getCombinedSubmission() {
    return combinedSubmission;
  }

  public void setCombinedSubmission(CombinedSubmission combinedSubmission) {
    this.combinedSubmission = combinedSubmission;
  }

  public CreateCombinedSubmissionResponse errors(List<String> errors) {
    this.errors = errors;
    return this;
  }

  public CreateCombinedSubmissionResponse addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<String>();
    }
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * Get errors
   * @return errors
  **/
  @ApiModelProperty(value = "")
  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public CreateCombinedSubmissionResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCombinedSubmissionResponse createCombinedSubmissionResponse = (CreateCombinedSubmissionResponse) o;
    return Objects.equals(this.combinedSubmission, createCombinedSubmissionResponse.combinedSubmission) &&
        Objects.equals(this.errors, createCombinedSubmissionResponse.errors) &&
        Objects.equals(this.status, createCombinedSubmissionResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(combinedSubmission, errors, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCombinedSubmissionResponse {\n");
    
    sb.append("    combinedSubmission: ").append(toIndentedString(combinedSubmission)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

