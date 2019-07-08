package com.ccy.makaserver.response;

public class CommonReturnType {
  private Object data;
  private String status;
  private Integer code;
  private String message;

  public static CommonReturnType success(Object result) {
    return CommonReturnType.create(result, "success", 200);
  }

  public static CommonReturnType fail(Object result) {
    return CommonReturnType.create(result, "fail", 201);
  }

  public static CommonReturnType fail() {
    return CommonReturnType.create("fail", 201);
  }

  public static CommonReturnType fail(String message) {
    return CommonReturnType.create(message, "fail", 201);
  }

  public static CommonReturnType create(Object result, String status, Integer code) {
    CommonReturnType type = new CommonReturnType();
    type.setData(result);
    type.setCode(code);
    type.setStatus(status);
    return type;
  }

  public static CommonReturnType create(String status, Integer code) {
    CommonReturnType type = new CommonReturnType();
    type.setCode(code);
    type.setStatus(status);
    return type;
  }

  public static CommonReturnType create(String message, String status, Integer code) {
    CommonReturnType type = new CommonReturnType();
    type.setCode(code);
    type.setStatus(status);
    type.setMessage(message);
    return type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
