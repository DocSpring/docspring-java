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
import com.docspring.TemplatesdesccachedUploadTemplateDocument;
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
 * TemplatesdesccachedUploadTemplate
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-12T20:46:39.723+08:00[Asia/Kuala_Lumpur]")
public class TemplatesdesccachedUploadTemplate {
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

  public static final String SERIALIZED_NAME_SCSS = "scss";
  @SerializedName(SERIALIZED_NAME_SCSS)
  private String scss = null;

  public static final String SERIALIZED_NAME_EXPIRE_AFTER = "expire_after";
  @SerializedName(SERIALIZED_NAME_EXPIRE_AFTER)
  private BigDecimal expireAfter = null;

  public static final String SERIALIZED_NAME_ALLOW_ADDITIONAL_PROPERTIES = "allow_additional_properties";
  @SerializedName(SERIALIZED_NAME_ALLOW_ADDITIONAL_PROPERTIES)
  private Boolean allowAdditionalProperties = null;

  public static final String SERIALIZED_NAME_DOCUMENT = "document";
  @SerializedName(SERIALIZED_NAME_DOCUMENT)
  private TemplatesdesccachedUploadTemplateDocument document = null;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description = null;

  public static final String SERIALIZED_NAME_PUBLIC_SUBMISSIONS = "public_submissions";
  @SerializedName(SERIALIZED_NAME_PUBLIC_SUBMISSIONS)
  private Boolean publicSubmissions = null;

  public static final String SERIALIZED_NAME_SLACK_WEBHOOK_URL = "slack_webhook_url";
  @SerializedName(SERIALIZED_NAME_SLACK_WEBHOOK_URL)
  private String slackWebhookUrl = null;

  public static final String SERIALIZED_NAME_HEADER_HTML = "header_html";
  @SerializedName(SERIALIZED_NAME_HEADER_HTML)
  private String headerHtml = null;

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

  public static final String SERIALIZED_NAME_HTML = "html";
  @SerializedName(SERIALIZED_NAME_HTML)
  private String html = null;

  public static final String SERIALIZED_NAME_FOOTER_HTML = "footer_html";
  @SerializedName(SERIALIZED_NAME_FOOTER_HTML)
  private String footerHtml = null;

  /**
   * Gets or Sets templateType
   */
  @JsonAdapter(TemplateTypeEnum.Adapter.class)
  public enum TemplateTypeEnum {
    PDF("pdf"),
    
    HTML("html");

    private String value;

    TemplateTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TemplateTypeEnum fromValue(String text) {
      for (TemplateTypeEnum b : TemplateTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static class Adapter extends TypeAdapter<TemplateTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TemplateTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TemplateTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TemplateTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_TEMPLATE_TYPE = "template_type";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_TYPE)
  private TemplateTypeEnum templateType = null;

  public static final String SERIALIZED_NAME_REDIRECT_URL = "redirect_url";
  @SerializedName(SERIALIZED_NAME_REDIRECT_URL)
  private String redirectUrl = null;

  public TemplatesdesccachedUploadTemplate expirationInterval(ExpirationIntervalEnum expirationInterval) {
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

  public TemplatesdesccachedUploadTemplate webhookUrl(String webhookUrl) {
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

  public TemplatesdesccachedUploadTemplate scss(String scss) {
    this.scss = scss;
    return this;
  }

   /**
   * Get scss
   * @return scss
  **/
  @ApiModelProperty(value = "")
  public String getScss() {
    return scss;
  }

  public void setScss(String scss) {
    this.scss = scss;
  }

  public TemplatesdesccachedUploadTemplate expireAfter(BigDecimal expireAfter) {
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

  public TemplatesdesccachedUploadTemplate allowAdditionalProperties(Boolean allowAdditionalProperties) {
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

  public TemplatesdesccachedUploadTemplate document(TemplatesdesccachedUploadTemplateDocument document) {
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @ApiModelProperty(value = "")
  public TemplatesdesccachedUploadTemplateDocument getDocument() {
    return document;
  }

  public void setDocument(TemplatesdesccachedUploadTemplateDocument document) {
    this.document = document;
  }

  public TemplatesdesccachedUploadTemplate description(String description) {
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

  public TemplatesdesccachedUploadTemplate publicSubmissions(Boolean publicSubmissions) {
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

  public TemplatesdesccachedUploadTemplate slackWebhookUrl(String slackWebhookUrl) {
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

  public TemplatesdesccachedUploadTemplate headerHtml(String headerHtml) {
    this.headerHtml = headerHtml;
    return this;
  }

   /**
   * Get headerHtml
   * @return headerHtml
  **/
  @ApiModelProperty(value = "")
  public String getHeaderHtml() {
    return headerHtml;
  }

  public void setHeaderHtml(String headerHtml) {
    this.headerHtml = headerHtml;
  }

  public TemplatesdesccachedUploadTemplate publicWebForm(Boolean publicWebForm) {
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

  public TemplatesdesccachedUploadTemplate editableSubmissions(Boolean editableSubmissions) {
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

  public TemplatesdesccachedUploadTemplate expireSubmissions(Boolean expireSubmissions) {
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

  public TemplatesdesccachedUploadTemplate name(String name) {
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

  public TemplatesdesccachedUploadTemplate html(String html) {
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

  public TemplatesdesccachedUploadTemplate footerHtml(String footerHtml) {
    this.footerHtml = footerHtml;
    return this;
  }

   /**
   * Get footerHtml
   * @return footerHtml
  **/
  @ApiModelProperty(value = "")
  public String getFooterHtml() {
    return footerHtml;
  }

  public void setFooterHtml(String footerHtml) {
    this.footerHtml = footerHtml;
  }

  public TemplatesdesccachedUploadTemplate templateType(TemplateTypeEnum templateType) {
    this.templateType = templateType;
    return this;
  }

   /**
   * Get templateType
   * @return templateType
  **/
  @ApiModelProperty(value = "")
  public TemplateTypeEnum getTemplateType() {
    return templateType;
  }

  public void setTemplateType(TemplateTypeEnum templateType) {
    this.templateType = templateType;
  }

  public TemplatesdesccachedUploadTemplate redirectUrl(String redirectUrl) {
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
    TemplatesdesccachedUploadTemplate templatesdesccachedUploadTemplate = (TemplatesdesccachedUploadTemplate) o;
    return Objects.equals(this.expirationInterval, templatesdesccachedUploadTemplate.expirationInterval) &&
        Objects.equals(this.webhookUrl, templatesdesccachedUploadTemplate.webhookUrl) &&
        Objects.equals(this.scss, templatesdesccachedUploadTemplate.scss) &&
        Objects.equals(this.expireAfter, templatesdesccachedUploadTemplate.expireAfter) &&
        Objects.equals(this.allowAdditionalProperties, templatesdesccachedUploadTemplate.allowAdditionalProperties) &&
        Objects.equals(this.document, templatesdesccachedUploadTemplate.document) &&
        Objects.equals(this.description, templatesdesccachedUploadTemplate.description) &&
        Objects.equals(this.publicSubmissions, templatesdesccachedUploadTemplate.publicSubmissions) &&
        Objects.equals(this.slackWebhookUrl, templatesdesccachedUploadTemplate.slackWebhookUrl) &&
        Objects.equals(this.headerHtml, templatesdesccachedUploadTemplate.headerHtml) &&
        Objects.equals(this.publicWebForm, templatesdesccachedUploadTemplate.publicWebForm) &&
        Objects.equals(this.editableSubmissions, templatesdesccachedUploadTemplate.editableSubmissions) &&
        Objects.equals(this.expireSubmissions, templatesdesccachedUploadTemplate.expireSubmissions) &&
        Objects.equals(this.name, templatesdesccachedUploadTemplate.name) &&
        Objects.equals(this.html, templatesdesccachedUploadTemplate.html) &&
        Objects.equals(this.footerHtml, templatesdesccachedUploadTemplate.footerHtml) &&
        Objects.equals(this.templateType, templatesdesccachedUploadTemplate.templateType) &&
        Objects.equals(this.redirectUrl, templatesdesccachedUploadTemplate.redirectUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationInterval, webhookUrl, scss, expireAfter, allowAdditionalProperties, document, description, publicSubmissions, slackWebhookUrl, headerHtml, publicWebForm, editableSubmissions, expireSubmissions, name, html, footerHtml, templateType, redirectUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplatesdesccachedUploadTemplate {\n");
    
    sb.append("    expirationInterval: ").append(toIndentedString(expirationInterval)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
    sb.append("    scss: ").append(toIndentedString(scss)).append("\n");
    sb.append("    expireAfter: ").append(toIndentedString(expireAfter)).append("\n");
    sb.append("    allowAdditionalProperties: ").append(toIndentedString(allowAdditionalProperties)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    publicSubmissions: ").append(toIndentedString(publicSubmissions)).append("\n");
    sb.append("    slackWebhookUrl: ").append(toIndentedString(slackWebhookUrl)).append("\n");
    sb.append("    headerHtml: ").append(toIndentedString(headerHtml)).append("\n");
    sb.append("    publicWebForm: ").append(toIndentedString(publicWebForm)).append("\n");
    sb.append("    editableSubmissions: ").append(toIndentedString(editableSubmissions)).append("\n");
    sb.append("    expireSubmissions: ").append(toIndentedString(expireSubmissions)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
    sb.append("    footerHtml: ").append(toIndentedString(footerHtml)).append("\n");
    sb.append("    templateType: ").append(toIndentedString(templateType)).append("\n");
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

