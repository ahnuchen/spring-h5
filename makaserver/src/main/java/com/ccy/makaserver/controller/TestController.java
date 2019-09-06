package com.ccy.makaserver.controller;

import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.repository.UsersRepository;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.vo.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
  @Autowired
  private UsersRepository usersRepository;

  @GetMapping(value = "/basicpage",produces = "text/html")
  public ModelAndView basicPage() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("hello", "你好thymeleaf");
    mv.setViewName("/basic.html");
    String str = mv.toString();
    System.out.println(str);
    return mv;
  }
}
