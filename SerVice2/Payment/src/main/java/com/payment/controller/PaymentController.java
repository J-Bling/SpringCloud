package com.payment.controller;


import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay")
public class PaymentController {
    @Autowired private PaymentService paymentService;

    @GetMapping("/pay/{userId}/{goodId}")
    public String pay(@PathVariable("userId") Integer userId , @PathVariable("goodId") Long goodId){
        try{
            return paymentService.PlaceOrder(userId,goodId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
