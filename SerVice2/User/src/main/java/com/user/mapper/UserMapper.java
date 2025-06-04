package com.user.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void insert(User user);
    void updateBalance(@Param("id") Integer id,@Param("money") Integer money);
}
