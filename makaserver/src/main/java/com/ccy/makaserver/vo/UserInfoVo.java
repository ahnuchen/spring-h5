package com.ccy.makaserver.vo;

import org.bson.types.ObjectId;

public class UserInfoVo {
  private ObjectId _id;
  private String loginId;
  private String name;

  public ObjectId get_id() {
    return _id;
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
