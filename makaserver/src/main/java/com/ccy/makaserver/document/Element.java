package com.ccy.makaserver.document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * element
 *
 * @author
 */
public class Element implements Serializable {
  private Integer zindex;

  private String color;

  private String fontWeight;

  private String bg;

  private String iconKey;

  private String textAlign;

  private String text;

  private Integer transform;

  private Integer opacity;

  private Byte loop;

  private Byte playing;

  private Integer delay;

  private Integer duration;

  private String animatedName;

  private Double lineHeight;

  private Double height;

  private Double width;

  private Integer top;

  private Integer left;

  private String videoSrc;

  private String imgSrc;

  /**
   * 文件类型video/pic
   */
  private String type;

  public Integer getZindex() {
    return zindex;
  }

  public void setZindex(Integer zindex) {
    this.zindex = zindex;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getFontWeight() {
    return fontWeight;
  }

  public void setFontWeight(String fontWeight) {
    this.fontWeight = fontWeight;
  }

  public String getBg() {
    return bg;
  }

  public void setBg(String bg) {
    this.bg = bg;
  }

  public String getIconKey() {
    return iconKey;
  }

  public void setIconKey(String iconKey) {
    this.iconKey = iconKey;
  }

  public String getTextAlign() {
    return textAlign;
  }

  public void setTextAlign(String textAlign) {
    this.textAlign = textAlign;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getTransform() {
    return transform;
  }

  public void setTransform(Integer transform) {
    this.transform = transform;
  }

  public Integer getOpacity() {
    return opacity;
  }

  public void setOpacity(Integer opacity) {
    this.opacity = opacity;
  }

  public Byte getLoop() {
    return loop;
  }

  public void setLoop(Byte loop) {
    this.loop = loop;
  }

  public Byte getPlaying() {
    return playing;
  }

  public void setPlaying(Byte playing) {
    this.playing = playing;
  }

  public Integer getDelay() {
    return delay;
  }

  public void setDelay(Integer delay) {
    this.delay = delay;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public String getAnimatedName() {
    return animatedName;
  }

  public void setAnimatedName(String animatedName) {
    this.animatedName = animatedName;
  }

  public Double getLineHeight() {
    return lineHeight;
  }

  public void setLineHeight(Double lineHeight) {
    this.lineHeight = lineHeight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public Integer getTop() {
    return top;
  }

  public void setTop(Integer top) {
    this.top = top;
  }

  public Integer getLeft() {
    return left;
  }

  public void setLeft(Integer left) {
    this.left = left;
  }

  public String getVideoSrc() {
    return videoSrc;
  }

  public void setVideoSrc(String videoSrc) {
    this.videoSrc = videoSrc;
  }

  public String getImgSrc() {
    return imgSrc;
  }

  public void setImgSrc(String imgSrc) {
    this.imgSrc = imgSrc;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
