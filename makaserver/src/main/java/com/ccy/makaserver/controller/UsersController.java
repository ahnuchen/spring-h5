package com.ccy.makaserver.controller;

import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.repository.UsersRepository;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.vo.UserInfoVo;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController extends BaseController {
  @Autowired
  private UsersRepository usersRepository;

  @RequestMapping("/userinfo")
  public CommonReturnType userinfo(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Users currentUser = (Users) session.getAttribute("user");
    UserInfoVo userInfoVo = new UserInfoVo();
    BeanUtils.copyProperties(currentUser,userInfoVo);
    return CommonReturnType.success(userInfoVo);
  }
}
