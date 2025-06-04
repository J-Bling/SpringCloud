package com.payment.service.impl;

import com.payment.service.InventoryService;
import com.payment.service.OrderService;
import com.payment.service.PaymentService;
import com.payment.service.UserService;
import com.pojo.Good;
import com.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired private InventoryService inventoryService;
    @Autowired private UserService userService;
    @Autowired private OrderService orderService;


    @Override
    public String PlaceOrder(Integer userId, Long goodId) {
        Good good = inventoryService.find(goodId);
        if(good==null) throw new RuntimeException("没有该good");

        if(good.getRemainder()==0) throw new RuntimeException("没有库存");

        System.out.println("买家扣款"+userService.update(userId,-(good.getValue())));
        System.out.println("卖家到账"+userService.update(good.getMaster(),good.getValue()));

        System.out.println("库存扣一"+inventoryService.update(goodId,-1));

        Orders orders = new Orders();
        orders.setCreateAt(System.currentTimeMillis());
        orders.setBuyerId(userId);
        orders.setSellerId(good.getMaster());
        orders.setGoodId(goodId);

        return "订单创建"+orderService.insert(orders);
    }
}
