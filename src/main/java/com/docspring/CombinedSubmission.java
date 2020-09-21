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
import com.docspring.CombinedSubmissionAction;
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
 * CombinedSubmission
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-21T19:06:58.618+08:00[Asia/Kuala_Lumpur]")
public class CombinedSubmission {
  public static final String SERIALIZED_NAME_METADATA = "metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Object metadata = null;

  public static final String SERIALIZED_NAME_EXPIRED = "expired";
  @SerializedName(SERIALIZED_NAME_EXPIRED)
  private Boolean expired = null;

  public static final String SERIALIZED_NAME_EXPIRES_AT = "expires_at";
  @SerializedName(SERIALIZED_NAME_EXPIRES_AT)
  private String expiresAt = null;

  public static final String SERIALIZED_NAME_SOURCE_PDFS = "source_pdfs";
  @SerializedName(SERIALIZED_NAME_SOURCE_PDFS)
  private List<Object> sourcePdfs = null;

  public static final String SERIALIZED_NAME_PDF_HASH = "pdf_hash";
  @SerializedName(SERIALIZED_NAME_PDF_HASH)
  private String pdfHash = null;

  public static final String SERIALIZED_NAME_DOWNLOAD_URL = "download_url";
  @SerializedName(SERIALIZED_NAME_DOWNLOAD_URL)
  private String downloadUrl = null;

  public static final String SERIALIZED_NAME_SUBMISSION_IDS = "submission_ids";
  @SerializedName(SERIALIZED_NAME_SUBMISSION_IDS)
  private List<String> submissionIds = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  /**
   * Gets or Sets state
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    PENDING("pending"),
    
    PROCESSED("processed"),
    
    ERROR("error");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private StateEnum state = null;

  public static final String SERIALIZED_NAME_ACTIONS = "actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private List<CombinedSubmissionAction> actions = null;

  public CombinedSubmission metadata(Object metadata) {
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

  public CombinedSubmission expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

   /**
   * Get expired
   * @return expired
  **/
  @ApiModelProperty(value = "")
  public Boolean getExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public CombinedSubmission expiresAt(String expiresAt) {
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

  public CombinedSubmission sourcePdfs(List<Object> sourcePdfs) {
    this.sourcePdfs = sourcePdfs;
    return this;
  }

  public CombinedSubmission addSourcePdfsItem(Object sourcePdfsItem) {
    if (this.sourcePdfs == null) {
      this.sourcePdfs = new ArrayList<Object>();
    }
    this.sourcePdfs.add(sourcePdfsItem);
    return this;
  }

   /**
   * Get sourcePdfs
   * @return sourcePdfs
  **/
  @ApiModelProperty(value = "")
  public List<Object> getSourcePdfs() {
    return sourcePdfs;
  }

  public void setSourcePdfs(List<Object> sourcePdfs) {
    this.sourcePdfs = sourcePdfs;
  }

  public CombinedSubmission pdfHash(String pdfHash) {
    this.pdfHash = pdfHash;
    return this;
  }

   /**
   * Get pdfHash
   * @return pdfHash
  **/
  @ApiModelProperty(value = "")
  public String getPdfHash() {
    return pdfHash;
  }

  public void setPdfHash(String pdfHash) {
    this.pdfHash = pdfHash;
  }

  public CombinedSubmission downloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

   /**
   * Get downloadUrl
   * @return downloadUrl
  **/
  @ApiModelProperty(value = "")
  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public CombinedSubmission submissionIds(List<String> submissionIds) {
    this.submissionIds = submissionIds;
    return this;
  }

  public CombinedSubmission addSubmissionIdsItem(String submissionIdsItem) {
    if (this.submissionIds == null) {
      this.submissionIds = new ArrayList<String>();
    }
    this.submissionIds.add(submissionIdsItem);
    return this;
  }

   /**
   * Get submissionIds
   * @return submissionIds
  **/
  @ApiModelProperty(value = "")
  public List<String> getSubmissionIds() {
    return submissionIds;
  }

  public void setSubmissionIds(List<String> submissionIds) {
    this.submissionIds = submissionIds;
  }

  public CombinedSubmission id(String id) {
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

  public CombinedSubmission state(StateEnum state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public CombinedSubmission actions(List<CombinedSubmissionAction> actions) {
    this.actions = actions;
    return this;
  }

  public CombinedSubmission addActionsItem(CombinedSubmissionAction actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<CombinedSubmissionAction>();
    }
    this.actions.add(actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @ApiModelProperty(value = "")
  public List<CombinedSubmissionAction> getActions() {
    return actions;
  }

  public void setActions(List<CombinedSubmissionAction> actions) {
    this.actions = actions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CombinedSubmission combinedSubmission = (CombinedSubmission) o;
    return Objects.equals(this.metadata, combinedSubmission.metadata) &&
        Objects.equals(this.expired, combinedSubmission.expired) &&
        Objects.equals(this.expiresAt, combinedSubmission.expiresAt) &&
        Objects.equals(this.sourcePdfs, combinedSubmission.sourcePdfs) &&
        Objects.equals(this.pdfHash, combinedSubmission.pdfHash) &&
        Objects.equals(this.downloadUrl, combinedSubmission.downloadUrl) &&
        Objects.equals(this.submissionIds, combinedSubmission.submissionIds) &&
        Objects.equals(this.id, combinedSubmission.id) &&
        Objects.equals(this.state, combinedSubmission.state) &&
        Objects.equals(this.actions, combinedSubmission.actions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, expired, expiresAt, sourcePdfs, pdfHash, downloadUrl, submissionIds, id, state, actions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CombinedSubmission {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    sourcePdfs: ").append(toIndentedString(sourcePdfs)).append("\n");
    sb.append("    pdfHash: ").append(toIndentedString(pdfHash)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
    sb.append("    submissionIds: ").append(toIndentedString(submissionIds)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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

