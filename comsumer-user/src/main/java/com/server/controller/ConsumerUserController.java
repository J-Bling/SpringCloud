package com.server.controller;

import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerUserController {
    @Autowired private RestTemplate restTemplate;

    private final String REST_URL_PREFIX="http://SPRING-CLOUD-PROVIDER-USER";

    @RequestMapping("/find/{id}")
    public User find(@PathVariable("id") int id){
        try {
            String url = REST_URL_PREFIX + "/user/find/" + id;
            System.out.println(url);
            User user = restTemplate.getForObject(url, User.class);

            if (user != null) {
                System.out.println("user is " + user.toString());
            }
            System.out.println("u is" + user);
            return user;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping("/find-all")
    public List<User> findAll(){
        return (List<User>) restTemplate.getForObject(REST_URL_PREFIX+"/user/find-all", List.class);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        restTemplate.delete(REST_URL_PREFIX+"/user/delete/"+id);
        return "ok";
    }
}
