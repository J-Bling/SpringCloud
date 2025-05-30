package com.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true) //链式
public class User implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Long created;

    private String db_source;
    public User(){}
    public User(String name ,String email){
        this.name=  name;this.email =email;this.created=System.currentTimeMillis();
    }
}
