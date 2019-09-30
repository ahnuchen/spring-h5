package com.ccy.makaserver.controller;


import com.ccy.makaserver.error.BusinessException;
import com.ccy.makaserver.formdata.UsersFormData;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/auth")

public class LoginController extends BaseController {
  @Autowired
  private LoginService loginService;

  @Autowired
  private HttpServletRequest request;

  @PostMapping("/register")
  public CommonReturnType register(@RequestBody UsersFormData usersFormData) throws BusinessException {
    return loginService.register(usersFormData);
  }

  @PostMapping("/login")
  public CommonReturnType login(@RequestBody UsersFormData usersFormData) throws BusinessException {
    return loginService.login(usersFormData);
  }

  @GetMapping("/logout")
  public CommonReturnType logout() throws BusinessException{
    return loginService.logout(request);
  }
}
