package com.consumer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeignTest {
    @Autowired private BookService bookService ;

    @Test
    public void add(){
        System.out.println(bookService.add("ok"));
    }

    @Test
    public void delete(){
        System.out.println(bookService.delete(1));
    }

    @Test
    public void find(){
        System.out.println(bookService.find(1));
    }

    @Test
    public void finds(){
        System.out.println(bookService.finds());
    }
}
