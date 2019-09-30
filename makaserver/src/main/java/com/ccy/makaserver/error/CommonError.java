package com.ccy.makaserver.error;

public interface CommonError {
  public int getErrCode();

  public String getErrMsg();

  public CommonError setErrMsg(String errMsg);
}
