package com.server.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> findAll();
    User find(Integer id);
    void delete(Integer id);
}
