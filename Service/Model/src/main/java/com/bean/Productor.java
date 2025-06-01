package com.bean;


import lombok.Data;

import java.util.UUID;

@Data
public class Productor {
    private String id;
    private Long created;
    private String name;

    public Productor(){}
    public Productor(String name){
        this.name=name;
        created=System.currentTimeMillis();
        this.id = UUID.randomUUID().toString().replace("-","");
    }
}
