package com.ccy.makaserver.filter;

import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.error.BusinessException;
import com.ccy.makaserver.error.EmBusinessError;
import com.ccy.makaserver.repository.UsersRepository;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginHandlerIntercepter implements HandlerInterceptor {
  private UsersRepository usersRepository;

  public LoginHandlerIntercepter(UsersRepository repository) {
    this.usersRepository = repository;
  }

  public LoginHandlerIntercepter LoginHandlerIntercepter(UsersRepository usersRepository1){
    this.usersRepository = usersRepository1;
    return this;
  }


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestURI = request.getRequestURI();
    System.out.println("---------------------------");
    System.out.println(requestURI);
    if (requestURI.contains("/api") && !requestURI.contains("/register") && !requestURI.contains("/login")) {
      //说明处在编辑的页面
      HttpSession session = request.getSession();
      String token = request.getHeader("token");
      System.out.println(token);
      if (token == null) {
        throw new BusinessException(EmBusinessError.USER_NEED_LOGIN);
      }
      Users users = usersRepository.findUsersByToken(token);
      if (users != null) {
        session.setAttribute("user", users);
        request.setAttribute("loginId", users.getLoginId());
        //登陆成功的用户
        return true;
      } else {
        //没有登陆，转向登陆界面
        throw new BusinessException(EmBusinessError.USER_NEED_LOGIN);
      }
    } else {
      return true;
    }
  }
}

