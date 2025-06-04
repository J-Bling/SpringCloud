package com.orders.service.impl;

import com.orders.mapper.OrderMapper;
import com.orders.service.OrderService;
import com.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersServiceImpl implements OrderService {

    @Autowired private OrderMapper mapper;

    @Override
    public String insert(Orders orders) {
        mapper.insert(orders);
        return "ok";
    }

    @Override
    public String delete(Long id) {
        mapper.delete(id);
        return "ok";
    }
}
