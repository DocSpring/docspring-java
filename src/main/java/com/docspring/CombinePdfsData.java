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
 * CombinePdfsData
 */
@javax.annotation.Generated(value = "com.docspring.codegen.DocSpringJavaClientCodegen", date = "2020-09-12T21:51:07.029+08:00[Asia/Kuala_Lumpur]")
public class CombinePdfsData {
  public static final String SERIALIZED_NAME_TEST = "test";
  @SerializedName(SERIALIZED_NAME_TEST)
  private Boolean test = null;

  public static final String SERIALIZED_NAME_SOURCE_PDFS = "source_pdfs";
  @SerializedName(SERIALIZED_NAME_SOURCE_PDFS)
  private List<Object> sourcePdfs = new ArrayList<Object>();

  public static final String SERIALIZED_NAME_METADATA = "metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Object metadata = null;

  public static final String SERIALIZED_NAME_EXPIRES_IN = "expires_in";
  @SerializedName(SERIALIZED_NAME_EXPIRES_IN)
  private Integer expiresIn = null;

  public static final String SERIALIZED_NAME_DELETE_CUSTOM_FILES = "delete_custom_files";
  @SerializedName(SERIALIZED_NAME_DELETE_CUSTOM_FILES)
  private Boolean deleteCustomFiles = null;

  public CombinePdfsData test(Boolean test) {
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

  public CombinePdfsData sourcePdfs(List<Object> sourcePdfs) {
    this.sourcePdfs = sourcePdfs;
    return this;
  }

  public CombinePdfsData addSourcePdfsItem(Object sourcePdfsItem) {
    this.sourcePdfs.add(sourcePdfsItem);
    return this;
  }

   /**
   * Get sourcePdfs
   * @return sourcePdfs
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Object> getSourcePdfs() {
    return sourcePdfs;
  }

  public void setSourcePdfs(List<Object> sourcePdfs) {
    this.sourcePdfs = sourcePdfs;
  }

  public CombinePdfsData metadata(Object metadata) {
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

  public CombinePdfsData expiresIn(Integer expiresIn) {
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

  public CombinePdfsData deleteCustomFiles(Boolean deleteCustomFiles) {
    this.deleteCustomFiles = deleteCustomFiles;
    return this;
  }

   /**
   * Get deleteCustomFiles
   * @return deleteCustomFiles
  **/
  @ApiModelProperty(value = "")
  public Boolean getDeleteCustomFiles() {
    return deleteCustomFiles;
  }

  public void setDeleteCustomFiles(Boolean deleteCustomFiles) {
    this.deleteCustomFiles = deleteCustomFiles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CombinePdfsData combinePdfsData = (CombinePdfsData) o;
    return Objects.equals(this.test, combinePdfsData.test) &&
        Objects.equals(this.sourcePdfs, combinePdfsData.sourcePdfs) &&
        Objects.equals(this.metadata, combinePdfsData.metadata) &&
        Objects.equals(this.expiresIn, combinePdfsData.expiresIn) &&
        Objects.equals(this.deleteCustomFiles, combinePdfsData.deleteCustomFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(test, sourcePdfs, metadata, expiresIn, deleteCustomFiles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CombinePdfsData {\n");
    
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
    sb.append("    sourcePdfs: ").append(toIndentedString(sourcePdfs)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    deleteCustomFiles: ").append(toIndentedString(deleteCustomFiles)).append("\n");
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

