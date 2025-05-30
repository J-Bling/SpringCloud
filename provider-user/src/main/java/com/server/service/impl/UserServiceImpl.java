package com.server.service.impl;

import com.pojo.User;
import com.server.mapper.UserMapper;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
