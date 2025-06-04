package com.orders.mapper;

import com.pojo.Orders;

public interface OrderMapper {
    void insert(Orders orders);
    void delete(Long id);
}
