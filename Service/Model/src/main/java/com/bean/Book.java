package com.bean;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String bookName;
    private Boolean status;
    private Long created;

    public Book(){}
    public Book(String bookName){
        this.bookName=bookName;
        this.status=true;
        this.created=System.currentTimeMillis();
    }
}
