package com.ccy.makaserver.document;

import javafx.util.converter.LocalDateTimeStringConverter;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * page
 *
 * @author
 */



public class Pages implements Serializable {

    private ObjectId _id;

    /**
     * 页面标题
     */
    private String title;

    /**
     * 页面描述
     */
    private String description;

    /**
     * 页面类型h5/spa
     */
    private String type;

    private String loginId;

    private Long createDate;

    private List<Object> pages;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoginId() {
        return loginId;
    }

    public List<Object> getPages() {
        return pages;
    }

    public void setPages(List<Object> pages) {
        this.pages = pages;
    }

    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }
}
