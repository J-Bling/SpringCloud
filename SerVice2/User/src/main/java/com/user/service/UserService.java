package com.user.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    void insert(User user);
    void updateBalance(@Param("id") Integer id, @Param("money") Integer money);
}
