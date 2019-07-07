package com.ccy.springh5;

import com.ccy.springh5.bean.Users;
import com.ccy.springh5.dao.UsersDao;
import com.ccy.springh5.dao.impl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = BaseDaoImpl.class)
@RestController
@RequestMapping("/user")

public class Springh5Application {

  public static void main(String[] args) {

    SpringApplication.run(Springh5Application.class, args);


  }
  @Autowired
  private UsersDao userDao;

  @RequestMapping("/all")
  public List<Users> index () {
    List<Users> users = userDao.findAll();
    return users;
  }

  @RequestMapping("/index")
  public String home(){
    return "hello";
  }

}
