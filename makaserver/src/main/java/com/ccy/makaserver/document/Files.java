package com.ccy.makaserver.document;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * file
 *
 * @author
 */
public class Files implements Serializable {

  private ObjectId _id;

  private String fid;

  private String themeId;

  private String filePath;

  private String fileType;

  private Double width;

  private Double height;

  private Long createDate;

  public String getFid() {
    return fid;
  }

  public void setFid(String fid) {
    this.fid = fid;
  }

  public String getThemeId() {
    return themeId;
  }

  public void setThemeId(String themeId) {
    this.themeId = themeId;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Long getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Long createDate) {
    this.createDate = createDate;
  }

  public String get_id() {
    return _id.toString();
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

}
