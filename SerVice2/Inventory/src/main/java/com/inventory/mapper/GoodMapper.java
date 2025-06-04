package com.inventory.mapper;

import com.pojo.Good;
import org.apache.ibatis.annotations.Param;

public interface GoodMapper {
    void insert (Good good);
    void delete(Long id);
    void updateRemainder(@Param("id") Long id,@Param("count") Integer count);
    Good find(Long id);
}
