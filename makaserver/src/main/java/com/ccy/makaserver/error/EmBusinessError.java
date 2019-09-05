package com.ccy.makaserver.error;

public enum EmBusinessError implements CommonError {


  //用户相关
  USER_NOT_EXISTS(20001, "用户不存在!"),

  LOGIN_ID_EXISTS(20002,"用户id重复"),
  USER_NEED_LOGIN(20003, "需要登录"),
  NOT_VALID_LOGIN(20004, "用户名或者密码错误"),
  EMPTY_USER_NAME(20005,"用户名不能为空"),
  EMPTY_PASSWORD(20006,"密码不能为空"),

//  登陆相关


  PARAMETER_NOT_VALID(10000, "参数不合法"),
  UNKOWN_ERROR(10001, "未知错误");

  private int errCode;
  private String errMsg;

  private EmBusinessError(int errCode, String errMsg) {
    this.errMsg = errMsg;
    this.errCode = errCode;
  }

  @Override
  public int getErrCode() {
    return this.errCode;
  }

  @Override
  public String getErrMsg() {
    return this.errMsg;
  }

  @Override
  public CommonError setErrMsg(String errMsg) {
    this.errMsg = errMsg;
    return this;
  }

}
