package com.ccy.makaserver.controller;


import com.ccy.makaserver.error.BusinessException;
import com.ccy.makaserver.error.EmBusinessError;
import com.ccy.makaserver.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.OK)
  public CommonReturnType exceptionHandler(HttpServletRequest request, Exception e) {
    Map<String, Object> resData = new HashMap<>();
    BusinessException be;
    if (e instanceof BusinessException) {
      be = (BusinessException) e;
    } else {
      be = new BusinessException(EmBusinessError.UNKOWN_ERROR);
    }
    resData.put("errCode", be.getErrCode());
    resData.put("errMsg", be.getErrMsg());
    return CommonReturnType.fail(resData);
  }
}
