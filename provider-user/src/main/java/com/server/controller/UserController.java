package com.server.controller;

import com.pojo.User;
import com.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/add")
    public String add(User user) {
        userService.add(user);
        return "ok";
    }

    @GetMapping("/find-all")
    public List<User> findAll() {
        List<User> users = userService.findAll();
        logger.info(users.toString());
        return users;
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "ok";
    }
}
