package com.orders.service;


import com.pojo.Orders;

public interface OrderService {
    String insert(Orders orders);
    String delete(Long id);
}
