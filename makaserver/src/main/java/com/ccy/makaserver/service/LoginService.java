package com.ccy.makaserver.service;


import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.error.BusinessException;
import com.ccy.makaserver.error.EmBusinessError;
import com.ccy.makaserver.formdata.UsersFormData;
import com.ccy.makaserver.repository.UsersRepository;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.utils.MD5Utils;
import com.ccy.makaserver.vo.UserTokenVo;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class LoginService {
  @Autowired
  private UsersRepository usersRepository;

  public CommonReturnType register(UsersFormData u) throws BusinessException {
    Users users = new Users(u.getLoginId(), u.getName(), u.getPassword());
    Boolean existsUser = usersRepository.existsUsersByLoginId(u.getLoginId());

    if (existsUser) {
      throw new BusinessException(EmBusinessError.LOGIN_ID_EXISTS);
    }
    UserTokenVo userTokenVo = new UserTokenVo();
    String password = MD5Utils.calc(u.getPassword());
    String token = UUID.randomUUID().toString().replace("-", "");
    users.setPassword(password);
    users.setRole("user");
    users.setProvider("local");
    users.setToken(token);
    usersRepository.save(users);
    userTokenVo.setToken(token);
    return CommonReturnType.success(userTokenVo);
  }

  public CommonReturnType login(UsersFormData u) throws BusinessException {
    String loginId = u.getLoginId();
    String password = u.getPassword();
    if (loginId == null || password == null) {
      throw new BusinessException(EmBusinessError.PARAMETER_NOT_VALID.setErrMsg("用户名或者密码不能为空"));
    }
    String encryptPwd = MD5Utils.calc(password);
    Users users = usersRepository.findByLoginIdAndPassword(loginId, encryptPwd);
    System.out.println(loginId);
    System.out.println(encryptPwd);
    System.out.println(password);
    System.out.println(users);
    if (users == null) {
      throw new BusinessException(EmBusinessError.NOT_VALID_LOGIN);
    }
    String token = UUID.randomUUID().toString().replace("-", "");
    users.setToken(token);
    usersRepository.save(users);
    UserTokenVo userTokenVo = new UserTokenVo();
    BeanUtils.copyProperties(users, userTokenVo);
    return CommonReturnType.success(userTokenVo);
  }

  public CommonReturnType logout(HttpServletRequest request) {
    Users users = (Users) request.getAttribute("user");
    users.setToken("");
    usersRepository.save(users);
    return CommonReturnType.success("用户已退出登录");
  }
}
