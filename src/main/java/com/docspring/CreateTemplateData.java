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
import com.docspring.TemplatesdesccachedUploadTemplate;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CreateTemplateData
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-12T21:51:07.029+08:00[Asia/Kuala_Lumpur]")
public class CreateTemplateData {
  public static final String SERIALIZED_NAME_TEMPLATE = "template";
  @SerializedName(SERIALIZED_NAME_TEMPLATE)
  private TemplatesdesccachedUploadTemplate template = null;

  public CreateTemplateData template(TemplatesdesccachedUploadTemplate template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(required = true, value = "")
  public TemplatesdesccachedUploadTemplate getTemplate() {
    return template;
  }

  public void setTemplate(TemplatesdesccachedUploadTemplate template) {
    this.template = template;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTemplateData createTemplateData = (CreateTemplateData) o;
    return Objects.equals(this.template, createTemplateData.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTemplateData {\n");
    
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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

