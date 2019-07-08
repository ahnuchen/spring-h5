package com.ccy.makaserver.error;

public enum EmBusinessError implements CommonError {
  PARAMETER_NOT_VALID(10000, "参数不合法"),
  UNKOWN_ERROR(10001, "未知错误"),
  USER_NOT_EXISTS(20001, "用户不存在!");

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
