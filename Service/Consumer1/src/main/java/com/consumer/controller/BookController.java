package com.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.consumer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Book;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired private BookService bookService;

    public static class Error{
        public Integer code;
        public String message;
        public Error(){}
        public Error(Integer code,String message){this.code=code;this.message=message;}
    }

    public static List<Book> handleBlock(BlockException be){
        System.out.println("限流");
//        throw new ResponseStatusException(HttpStatus.TOO_EARLY);
        return null;
    }

    public static Error fallback(Throwable throwable){
        System.out.println("熔断");
        throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE);
    }

    @GetMapping("/add/{name}")
    @SentinelResource(value = "add")
    public String add(@PathVariable("name") String name){
        return bookService.add(name);
    }

    @GetMapping("/delete/{id}")
    @SentinelResource(value = "delete")
    public String delete(@PathVariable("id") Integer id){
        return bookService.delete(id);
    }

    @SentinelResource(value = "find")
    @GetMapping("/find/{id}")
    public Book find(@PathVariable("id") Integer id){
        return bookService.find(id);
    }

    @GetMapping("/finds")
    @SentinelResource(value = "finds",blockHandler = "handleBlock",fallback = "fallback")
    public List<Book> finds(){
        List<Book> books =bookService.finds();
        System.out.println(books.size());
        return books;
    }
}
