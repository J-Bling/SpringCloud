package com.productor.service.impl;

import com.bean.Productor;
import com.productor.service.ProductorService;
import org.springframework.stereotype.Service;

@Service
public class ProductorServiceImpl implements ProductorService {

    @Override
    public Productor random(String name) {
        return new Productor(name);
    }
}
