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
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,token,Authorization");
    response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
    if(request.getMethod().toLowerCase().equals("options")){
      response.setStatus(204);
      return true;
    }
    if ((requestURI.contains("/api") || requestURI.contains("/auth")) && !requestURI.contains("/register") && !requestURI.contains("/login")) {
      //说明处在编辑的页面
      HttpSession session = request.getSession();
      String token = request.getHeader("token");
      System.out.println(token);
      if (token == null) {
        response.setStatus(401);
        return false;
      }
      Users users = usersRepository.findUsersByToken(token);
      if (users != null) {
        session.setAttribute("user", users);
        request.setAttribute("loginId", users.getLoginId());
        //登陆成功的用户
        return true;
      } else {
        response.setStatus(401);
        return false;
      }
    } else {
      return true;
    }
  }
}

