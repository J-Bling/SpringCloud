package com.productor.controller;

import com.bean.Productor;
import com.productor.service.ProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class ProductorController {
    @Autowired private ProductorService productorService;

    @GetMapping("/random/{name}")
    public Productor random(@PathVariable("name") String name){
        return productorService.random(name);
    }
}
