package com.orders.controller;


import com.orders.service.OrderService;
import com.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server/order")
public class OrdersController {
    @Autowired private OrderService service;

    @PostMapping("/insert")
    public String insert(@RequestBody Orders orders){
        return service.insert(orders);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
