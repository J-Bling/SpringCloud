package com.user.service.impl;

import com.pojo.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper mapper;

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }

    @Override
    public void updateBalance(Integer id, Integer money) {
        mapper.updateBalance(id,money);
    }
}
