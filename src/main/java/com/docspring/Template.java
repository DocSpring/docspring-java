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
import java.util.ArrayList;
import java.util.List;

/**
 * Template
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2019-11-09T01:21:00.648+07:00[Asia/Bangkok]")
public class Template {
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

  public static final String SERIALIZED_NAME_PERMANENT_DOCUMENT_URL = "permanent_document_url";
  @SerializedName(SERIALIZED_NAME_PERMANENT_DOCUMENT_URL)
  private String permanentDocumentUrl = null;

  public static final String SERIALIZED_NAME_TEMPLATE_TYPE = "template_type";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_TYPE)
  private String templateType = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  public static final String SERIALIZED_NAME_PAGE_DIMENSIONS = "page_dimensions";
  @SerializedName(SERIALIZED_NAME_PAGE_DIMENSIONS)
  private List<List<BigDecimal>> pageDimensions = null;

  public static final String SERIALIZED_NAME_REDIRECT_URL = "redirect_url";
  @SerializedName(SERIALIZED_NAME_REDIRECT_URL)
  private String redirectUrl = null;

  public static final String SERIALIZED_NAME_DOCUMENT_URL = "document_url";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_URL)
  private String documentUrl = null;

  public Template expirationInterval(ExpirationIntervalEnum expirationInterval) {
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

  public Template webhookUrl(String webhookUrl) {
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

  public Template parentFolderId(String parentFolderId) {
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

  public Template expireAfter(BigDecimal expireAfter) {
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

  public Template allowAdditionalProperties(Boolean allowAdditionalProperties) {
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

  public Template publicSubmissions(Boolean publicSubmissions) {
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

  public Template slackWebhookUrl(String slackWebhookUrl) {
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

  public Template path(String path) {
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

  public Template publicWebForm(Boolean publicWebForm) {
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

  public Template editableSubmissions(Boolean editableSubmissions) {
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

  public Template expireSubmissions(Boolean expireSubmissions) {
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

  public Template name(String name) {
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

  public Template permanentDocumentUrl(String permanentDocumentUrl) {
    this.permanentDocumentUrl = permanentDocumentUrl;
    return this;
  }

   /**
   * Get permanentDocumentUrl
   * @return permanentDocumentUrl
  **/
  @ApiModelProperty(value = "")
  public String getPermanentDocumentUrl() {
    return permanentDocumentUrl;
  }

  public void setPermanentDocumentUrl(String permanentDocumentUrl) {
    this.permanentDocumentUrl = permanentDocumentUrl;
  }

  public Template templateType(String templateType) {
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

  public Template id(String id) {
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

  public Template pageDimensions(List<List<BigDecimal>> pageDimensions) {
    this.pageDimensions = pageDimensions;
    return this;
  }

  public Template addPageDimensionsItem(List<BigDecimal> pageDimensionsItem) {
    if (this.pageDimensions == null) {
      this.pageDimensions = new ArrayList<List<BigDecimal>>();
    }
    this.pageDimensions.add(pageDimensionsItem);
    return this;
  }

   /**
   * Get pageDimensions
   * @return pageDimensions
  **/
  @ApiModelProperty(value = "")
  public List<List<BigDecimal>> getPageDimensions() {
    return pageDimensions;
  }

  public void setPageDimensions(List<List<BigDecimal>> pageDimensions) {
    this.pageDimensions = pageDimensions;
  }

  public Template redirectUrl(String redirectUrl) {
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

  public Template documentUrl(String documentUrl) {
    this.documentUrl = documentUrl;
    return this;
  }

   /**
   * Get documentUrl
   * @return documentUrl
  **/
  @ApiModelProperty(value = "")
  public String getDocumentUrl() {
    return documentUrl;
  }

  public void setDocumentUrl(String documentUrl) {
    this.documentUrl = documentUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Template template = (Template) o;
    return Objects.equals(this.expirationInterval, template.expirationInterval) &&
        Objects.equals(this.webhookUrl, template.webhookUrl) &&
        Objects.equals(this.parentFolderId, template.parentFolderId) &&
        Objects.equals(this.expireAfter, template.expireAfter) &&
        Objects.equals(this.allowAdditionalProperties, template.allowAdditionalProperties) &&
        Objects.equals(this.publicSubmissions, template.publicSubmissions) &&
        Objects.equals(this.slackWebhookUrl, template.slackWebhookUrl) &&
        Objects.equals(this.path, template.path) &&
        Objects.equals(this.publicWebForm, template.publicWebForm) &&
        Objects.equals(this.editableSubmissions, template.editableSubmissions) &&
        Objects.equals(this.expireSubmissions, template.expireSubmissions) &&
        Objects.equals(this.name, template.name) &&
        Objects.equals(this.permanentDocumentUrl, template.permanentDocumentUrl) &&
        Objects.equals(this.templateType, template.templateType) &&
        Objects.equals(this.id, template.id) &&
        Objects.equals(this.pageDimensions, template.pageDimensions) &&
        Objects.equals(this.redirectUrl, template.redirectUrl) &&
        Objects.equals(this.documentUrl, template.documentUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationInterval, webhookUrl, parentFolderId, expireAfter, allowAdditionalProperties, publicSubmissions, slackWebhookUrl, path, publicWebForm, editableSubmissions, expireSubmissions, name, permanentDocumentUrl, templateType, id, pageDimensions, redirectUrl, documentUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Template {\n");
    
    sb.append("    expirationInterval: ").append(toIndentedString(expirationInterval)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
    sb.append("    parentFolderId: ").append(toIndentedString(parentFolderId)).append("\n");
    sb.append("    expireAfter: ").append(toIndentedString(expireAfter)).append("\n");
    sb.append("    allowAdditionalProperties: ").append(toIndentedString(allowAdditionalProperties)).append("\n");
    sb.append("    publicSubmissions: ").append(toIndentedString(publicSubmissions)).append("\n");
    sb.append("    slackWebhookUrl: ").append(toIndentedString(slackWebhookUrl)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    publicWebForm: ").append(toIndentedString(publicWebForm)).append("\n");
    sb.append("    editableSubmissions: ").append(toIndentedString(editableSubmissions)).append("\n");
    sb.append("    expireSubmissions: ").append(toIndentedString(expireSubmissions)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    permanentDocumentUrl: ").append(toIndentedString(permanentDocumentUrl)).append("\n");
    sb.append("    templateType: ").append(toIndentedString(templateType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pageDimensions: ").append(toIndentedString(pageDimensions)).append("\n");
    sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
    sb.append("    documentUrl: ").append(toIndentedString(documentUrl)).append("\n");
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

