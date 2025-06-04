package com.pojo;

import lombok.Data;

@Data
public class Orders {
    private Long id;
    private Long goodId;
    private Integer sellerId;
    private Integer buyerId;
    private Long createAt;
}
