package com.ccy.makaserver.controller;


import com.ccy.makaserver.error.BusinessException;
import com.ccy.makaserver.formdata.UsersFormData;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")

public class LoginController extends BaseController {
  @Autowired
  private LoginService loginService;


  @PostMapping("/register")
  public CommonReturnType register(UsersFormData usersFormData) throws BusinessException {
    return loginService.register(usersFormData);
  }

  @PostMapping("/login")
  public CommonReturnType login(UsersFormData usersFormData) throws BusinessException {
    return loginService.login(usersFormData);
  }

  @PostMapping("/logout")
  public CommonReturnType logout(HttpServletRequest request) {
    return loginService.logout(request);
  }
}
