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
import java.math.BigDecimal;

/**
 * PendingTemplate
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-24T00:43:49.031+08:00[Asia/Kuala_Lumpur]")
public class PendingTemplate {
  /**
   * Gets or Sets expirationInterval
   */
  @JsonAdapter(ExpirationIntervalEnum.Adapter.class)
  public enum ExpirationIntervalEnum {
    MINUTES("minutes"),
    
    HOURS("hours"),
    
    DAYS("days");

    private String value;

    ExpirationIntervalEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ExpirationIntervalEnum fromValue(String text) {
      for (ExpirationIntervalEnum b : ExpirationIntervalEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static class Adapter extends TypeAdapter<ExpirationIntervalEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ExpirationIntervalEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ExpirationIntervalEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ExpirationIntervalEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_EXPIRATION_INTERVAL = "expiration_interval";
  @SerializedName(SERIALIZED_NAME_EXPIRATION_INTERVAL)
  private ExpirationIntervalEnum expirationInterval = null;

  public static final String SERIALIZED_NAME_WEBHOOK_URL = "webhook_url";
  @SerializedName(SERIALIZED_NAME_WEBHOOK_URL)
  private String webhookUrl = null;

  public static final String SERIALIZED_NAME_PARENT_FOLDER_ID = "parent_folder_id";
  @SerializedName(SERIALIZED_NAME_PARENT_FOLDER_ID)
  private String parentFolderId = null;

  public static final String SERIALIZED_NAME_EXPIRE_AFTER = "expire_after";
  @SerializedName(SERIALIZED_NAME_EXPIRE_AFTER)
  private BigDecimal expireAfter = null;

  public static final String SERIALIZED_NAME_ALLOW_ADDITIONAL_PROPERTIES = "allow_additional_properties";
  @SerializedName(SERIALIZED_NAME_ALLOW_ADDITIONAL_PROPERTIES)
  private Boolean allowAdditionalProperties = null;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description = null;

  public static final String SERIALIZED_NAME_PUBLIC_SUBMISSIONS = "public_submissions";
  @SerializedName(SERIALIZED_NAME_PUBLIC_SUBMISSIONS)
  private Boolean publicSubmissions = null;

  public static final String SERIALIZED_NAME_SLACK_WEBHOOK_URL = "slack_webhook_url";
  @SerializedName(SERIALIZED_NAME_SLACK_WEBHOOK_URL)
  private String slackWebhookUrl = null;

  public static final String SERIALIZED_NAME_PATH = "path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path = null;

  public static final String SERIALIZED_NAME_PUBLIC_WEB_FORM = "public_web_form";
  @SerializedName(SERIALIZED_NAME_PUBLIC_WEB_FORM)
  private Boolean publicWebForm = null;

  public static final String SERIALIZED_NAME_EDITABLE_SUBMISSIONS = "editable_submissions";
  @SerializedName(SERIALIZED_NAME_EDITABLE_SUBMISSIONS)
  private Boolean editableSubmissions = null;

  public static final String SERIALIZED_NAME_EXPIRE_SUBMISSIONS = "expire_submissions";
  @SerializedName(SERIALIZED_NAME_EXPIRE_SUBMISSIONS)
  private Boolean expireSubmissions = null;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name = null;

  public static final String SERIALIZED_NAME_TEMPLATE_TYPE = "template_type";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_TYPE)
  private String templateType = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  public static final String SERIALIZED_NAME_LOCKED = "locked";
  @SerializedName(SERIALIZED_NAME_LOCKED)
  private Boolean locked = null;

  public static final String SERIALIZED_NAME_REDIRECT_URL = "redirect_url";
  @SerializedName(SERIALIZED_NAME_REDIRECT_URL)
  private String redirectUrl = null;

  public PendingTemplate expirationInterval(ExpirationIntervalEnum expirationInterval) {
    this.expirationInterval = expirationInterval;
    return this;
  }

   /**
   * Get expirationInterval
   * @return expirationInterval
  **/
  @ApiModelProperty(value = "")
  public ExpirationIntervalEnum getExpirationInterval() {
    return expirationInterval;
  }

  public void setExpirationInterval(ExpirationIntervalEnum expirationInterval) {
    this.expirationInterval = expirationInterval;
  }

  public PendingTemplate webhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
    return this;
  }

   /**
   * Get webhookUrl
   * @return webhookUrl
  **/
  @ApiModelProperty(value = "")
  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }

  public PendingTemplate parentFolderId(String parentFolderId) {
    this.parentFolderId = parentFolderId;
    return this;
  }

   /**
   * Get parentFolderId
   * @return parentFolderId
  **/
  @ApiModelProperty(value = "")
  public String getParentFolderId() {
    return parentFolderId;
  }

  public void setParentFolderId(String parentFolderId) {
    this.parentFolderId = parentFolderId;
  }

  public PendingTemplate expireAfter(BigDecimal expireAfter) {
    this.expireAfter = expireAfter;
    return this;
  }

   /**
   * Get expireAfter
   * @return expireAfter
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getExpireAfter() {
    return expireAfter;
  }

  public void setExpireAfter(BigDecimal expireAfter) {
    this.expireAfter = expireAfter;
  }

  public PendingTemplate allowAdditionalProperties(Boolean allowAdditionalProperties) {
    this.allowAdditionalProperties = allowAdditionalProperties;
    return this;
  }

   /**
   * Get allowAdditionalProperties
   * @return allowAdditionalProperties
  **/
  @ApiModelProperty(value = "")
  public Boolean getAllowAdditionalProperties() {
    return allowAdditionalProperties;
  }

  public void setAllowAdditionalProperties(Boolean allowAdditionalProperties) {
    this.allowAdditionalProperties = allowAdditionalProperties;
  }

  public PendingTemplate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PendingTemplate publicSubmissions(Boolean publicSubmissions) {
    this.publicSubmissions = publicSubmissions;
    return this;
  }

   /**
   * Get publicSubmissions
   * @return publicSubmissions
  **/
  @ApiModelProperty(value = "")
  public Boolean getPublicSubmissions() {
    return publicSubmissions;
  }

  public void setPublicSubmissions(Boolean publicSubmissions) {
    this.publicSubmissions = publicSubmissions;
  }

  public PendingTemplate slackWebhookUrl(String slackWebhookUrl) {
    this.slackWebhookUrl = slackWebhookUrl;
    return this;
  }

   /**
   * Get slackWebhookUrl
   * @return slackWebhookUrl
  **/
  @ApiModelProperty(value = "")
  public String getSlackWebhookUrl() {
    return slackWebhookUrl;
  }

  public void setSlackWebhookUrl(String slackWebhookUrl) {
    this.slackWebhookUrl = slackWebhookUrl;
  }

  public PendingTemplate path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public PendingTemplate publicWebForm(Boolean publicWebForm) {
    this.publicWebForm = publicWebForm;
    return this;
  }

   /**
   * Get publicWebForm
   * @return publicWebForm
  **/
  @ApiModelProperty(value = "")
  public Boolean getPublicWebForm() {
    return publicWebForm;
  }

  public void setPublicWebForm(Boolean publicWebForm) {
    this.publicWebForm = publicWebForm;
  }

  public PendingTemplate editableSubmissions(Boolean editableSubmissions) {
    this.editableSubmissions = editableSubmissions;
    return this;
  }

   /**
   * Get editableSubmissions
   * @return editableSubmissions
  **/
  @ApiModelProperty(value = "")
  public Boolean getEditableSubmissions() {
    return editableSubmissions;
  }

  public void setEditableSubmissions(Boolean editableSubmissions) {
    this.editableSubmissions = editableSubmissions;
  }

  public PendingTemplate expireSubmissions(Boolean expireSubmissions) {
    this.expireSubmissions = expireSubmissions;
    return this;
  }

   /**
   * Get expireSubmissions
   * @return expireSubmissions
  **/
  @ApiModelProperty(value = "")
  public Boolean getExpireSubmissions() {
    return expireSubmissions;
  }

  public void setExpireSubmissions(Boolean expireSubmissions) {
    this.expireSubmissions = expireSubmissions;
  }

  public PendingTemplate name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PendingTemplate templateType(String templateType) {
    this.templateType = templateType;
    return this;
  }

   /**
   * Get templateType
   * @return templateType
  **/
  @ApiModelProperty(value = "")
  public String getTemplateType() {
    return templateType;
  }

  public void setTemplateType(String templateType) {
    this.templateType = templateType;
  }

  public PendingTemplate id(String id) {
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

  public PendingTemplate locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

   /**
   * Get locked
   * @return locked
  **/
  @ApiModelProperty(value = "")
  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public PendingTemplate redirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
    return this;
  }

   /**
   * Get redirectUrl
   * @return redirectUrl
  **/
  @ApiModelProperty(value = "")
  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PendingTemplate pendingTemplate = (PendingTemplate) o;
    return Objects.equals(this.expirationInterval, pendingTemplate.expirationInterval) &&
        Objects.equals(this.webhookUrl, pendingTemplate.webhookUrl) &&
        Objects.equals(this.parentFolderId, pendingTemplate.parentFolderId) &&
        Objects.equals(this.expireAfter, pendingTemplate.expireAfter) &&
        Objects.equals(this.allowAdditionalProperties, pendingTemplate.allowAdditionalProperties) &&
        Objects.equals(this.description, pendingTemplate.description) &&
        Objects.equals(this.publicSubmissions, pendingTemplate.publicSubmissions) &&
        Objects.equals(this.slackWebhookUrl, pendingTemplate.slackWebhookUrl) &&
        Objects.equals(this.path, pendingTemplate.path) &&
        Objects.equals(this.publicWebForm, pendingTemplate.publicWebForm) &&
        Objects.equals(this.editableSubmissions, pendingTemplate.editableSubmissions) &&
        Objects.equals(this.expireSubmissions, pendingTemplate.expireSubmissions) &&
        Objects.equals(this.name, pendingTemplate.name) &&
        Objects.equals(this.templateType, pendingTemplate.templateType) &&
        Objects.equals(this.id, pendingTemplate.id) &&
        Objects.equals(this.locked, pendingTemplate.locked) &&
        Objects.equals(this.redirectUrl, pendingTemplate.redirectUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationInterval, webhookUrl, parentFolderId, expireAfter, allowAdditionalProperties, description, publicSubmissions, slackWebhookUrl, path, publicWebForm, editableSubmissions, expireSubmissions, name, templateType, id, locked, redirectUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PendingTemplate {\n");
    
    sb.append("    expirationInterval: ").append(toIndentedString(expirationInterval)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
    sb.append("    parentFolderId: ").append(toIndentedString(parentFolderId)).append("\n");
    sb.append("    expireAfter: ").append(toIndentedString(expireAfter)).append("\n");
    sb.append("    allowAdditionalProperties: ").append(toIndentedString(allowAdditionalProperties)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    publicSubmissions: ").append(toIndentedString(publicSubmissions)).append("\n");
    sb.append("    slackWebhookUrl: ").append(toIndentedString(slackWebhookUrl)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    publicWebForm: ").append(toIndentedString(publicWebForm)).append("\n");
    sb.append("    editableSubmissions: ").append(toIndentedString(editableSubmissions)).append("\n");
    sb.append("    expireSubmissions: ").append(toIndentedString(expireSubmissions)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    templateType: ").append(toIndentedString(templateType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
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

