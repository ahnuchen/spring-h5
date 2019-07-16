package com.ccy.makaserver.controller;

import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.repository.UsersRepository;
import org.bson.types.ObjectId;
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

  @RequestMapping("/users")
  public List<Users> index(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Users currentUser = (Users) session.getAttribute("user");
    System.out.println(currentUser);
    List<Users> users = usersRepository.findAll();
    return users;
  }
}
