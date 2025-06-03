package com.bean;

import lombok.Data;

@Data
public class Productor {
    private String name;

    public Productor(){}
    public Productor(String name){
        this.name=name;
    }
}
