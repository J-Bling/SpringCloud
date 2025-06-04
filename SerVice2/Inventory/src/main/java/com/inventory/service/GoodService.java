package com.inventory.service;

import com.pojo.Good;

public interface GoodService {
    void insert (Good good);
    void delete(Long id);
    void updateRemainder(Long id,Integer count);
    Good find(Long id);
}
