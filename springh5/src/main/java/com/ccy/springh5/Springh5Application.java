package com.ccy.springh5;

import com.ccy.springh5.bean.User;
import com.ccy.springh5.bean.UserInfo;
import com.ccy.springh5.dao.UserDao;
import com.ccy.springh5.dao.UserInfoDao;
import com.ccy.springh5.dao.impl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
  private UserDao userDao;

  @RequestMapping("/all")
  public List<User> index () {
    List<User> users = userDao.findAll();
    return users;
  }

  @RequestMapping("/index")
  public String home(){
    return "hello";
  }

}
