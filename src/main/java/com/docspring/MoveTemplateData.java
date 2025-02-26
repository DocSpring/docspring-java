/*
 * DocSpring API
 * DocSpring provides an API that helps you fill out and sign PDF templates.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.docspring;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.docspring.JSON;


/**
 * MoveTemplateData
 */
@JsonPropertyOrder({
  MoveTemplateData.JSON_PROPERTY_PARENT_FOLDER_ID
})
@JsonTypeName("move_template_data")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class MoveTemplateData {
  public static final String JSON_PROPERTY_PARENT_FOLDER_ID = "parent_folder_id";
  @javax.annotation.Nonnull
  private String parentFolderId;

  public MoveTemplateData() { 
  }

  public MoveTemplateData parentFolderId(@javax.annotation.Nonnull String parentFolderId) {
    this.parentFolderId = parentFolderId;
    return this;
  }

  /**
   * Get parentFolderId
   * @return parentFolderId
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PARENT_FOLDER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getParentFolderId() {
    return parentFolderId;
  }


  @JsonProperty(JSON_PROPERTY_PARENT_FOLDER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setParentFolderId(@javax.annotation.Nonnull String parentFolderId) {
    this.parentFolderId = parentFolderId;
  }


  /**
   * Return true if this move_template_data object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveTemplateData moveTemplateData = (MoveTemplateData) o;
    return Objects.equals(this.parentFolderId, moveTemplateData.parentFolderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentFolderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveTemplateData {\n");
    sb.append("    parentFolderId: ").append(toIndentedString(parentFolderId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

