package com.ccy.makaserver.controller;

import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController extends BaseController {
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/users")
    public List<Users> index() {
        List<Users> users = usersRepository.findAll();
        return users;
    }
}
