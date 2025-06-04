package com.pojo;

import lombok.Data;

@Data
public class Good {
    private Long id;
    private String name;
    private String type;
    private Long remainder;
    private Integer value;
    private Integer master;
}
