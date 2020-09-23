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

/**
 * CreateSubmissionDataRequestTokenResponseToken
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-24T00:43:49.031+08:00[Asia/Kuala_Lumpur]")
public class CreateSubmissionDataRequestTokenResponseToken {
  public static final String SERIALIZED_NAME_EXPIRES_AT = "expires_at";
  @SerializedName(SERIALIZED_NAME_EXPIRES_AT)
  private String expiresAt = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  public static final String SERIALIZED_NAME_SECRET = "secret";
  @SerializedName(SERIALIZED_NAME_SECRET)
  private String secret = null;

  public static final String SERIALIZED_NAME_DATA_REQUEST_URL = "data_request_url";
  @SerializedName(SERIALIZED_NAME_DATA_REQUEST_URL)
  private String dataRequestUrl = null;

  public CreateSubmissionDataRequestTokenResponseToken expiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

   /**
   * Get expiresAt
   * @return expiresAt
  **/
  @ApiModelProperty(value = "")
  public String getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }

  public CreateSubmissionDataRequestTokenResponseToken id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CreateSubmissionDataRequestTokenResponseToken secret(String secret) {
    this.secret = secret;
    return this;
  }

   /**
   * Get secret
   * @return secret
  **/
  @ApiModelProperty(value = "")
  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public CreateSubmissionDataRequestTokenResponseToken dataRequestUrl(String dataRequestUrl) {
    this.dataRequestUrl = dataRequestUrl;
    return this;
  }

   /**
   * Get dataRequestUrl
   * @return dataRequestUrl
  **/
  @ApiModelProperty(value = "")
  public String getDataRequestUrl() {
    return dataRequestUrl;
  }

  public void setDataRequestUrl(String dataRequestUrl) {
    this.dataRequestUrl = dataRequestUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSubmissionDataRequestTokenResponseToken createSubmissionDataRequestTokenResponseToken = (CreateSubmissionDataRequestTokenResponseToken) o;
    return Objects.equals(this.expiresAt, createSubmissionDataRequestTokenResponseToken.expiresAt) &&
        Objects.equals(this.id, createSubmissionDataRequestTokenResponseToken.id) &&
        Objects.equals(this.secret, createSubmissionDataRequestTokenResponseToken.secret) &&
        Objects.equals(this.dataRequestUrl, createSubmissionDataRequestTokenResponseToken.dataRequestUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiresAt, id, secret, dataRequestUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSubmissionDataRequestTokenResponseToken {\n");
    
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("    dataRequestUrl: ").append(toIndentedString(dataRequestUrl)).append("\n");
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

