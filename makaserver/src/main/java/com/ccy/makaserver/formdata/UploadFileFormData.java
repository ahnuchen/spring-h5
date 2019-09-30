package com.ccy.makaserver.formdata;

import org.springframework.web.multipart.MultipartFile;

//image: (binary)
//  themeId: undefined
//  fileType: image
//  width: 48
//  height:
public class UploadFileFormData {
  private MultipartFile image;
  private String fileType;
  private String themeId;

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

  private Double width;
  private Double height;

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getThemeId() {
    return themeId;
  }

  public void setThemeId(String themeId) {
    this.themeId = themeId;
  }

  public MultipartFile getImage() {
    return image;
  }

  public void setImage(MultipartFile image) {
    this.image = image;
  }
}
