package com.user.controller;

import com.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server/user")
public class UserController {
    @Autowired private UserService service;

    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        try{
            service.insert(user);
            return "ok";
        }catch (Exception e){
            return "error : " + e.getMessage();
        }
    }

    @PutMapping("/update/{id}/{count}")
    public String update(@PathVariable("id") Integer id,@PathVariable("count") Integer count){
        try{
            service.updateBalance(id,count);
            return "ok";
        }catch (Exception e){
            return "error : " + e.getMessage();
        }
    }
}
