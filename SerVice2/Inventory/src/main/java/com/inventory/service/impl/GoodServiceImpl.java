package com.inventory.service.impl;

import com.inventory.mapper.GoodMapper;
import com.inventory.service.GoodService;
import com.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodServiceImpl implements GoodService {
    @Autowired private GoodMapper mapper;

    @Override
    public void insert(Good good) {
        mapper.insert(good);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public void updateRemainder(Long id,Integer count) {
        mapper.updateRemainder(id,count);
    }

    @Override
    public Good find(Long id){
        return mapper.find(id);
    }
}
