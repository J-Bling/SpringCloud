package com.payment.service;

import com.pojo.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-server")
public interface OrderService {
    @PostMapping("/server/order/insert")
    public String insert(@RequestBody Orders orders);

    @DeleteMapping("/server/order/delete/{id}")
    public String delete(@PathVariable("id") Long id);
}
