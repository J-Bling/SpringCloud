package com.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;
import java.util.List;

@FeignClient(name = "server")
public interface BookService {
    @GetMapping("/book/add")
    String add(@RequestParam("book-name") String bookName);

    @GetMapping("/book/delete")
    String delete(@RequestParam("id") Integer id);

    @GetMapping("/book/find")
    Book find(@RequestParam("id") Integer id);

    @GetMapping("/book/finds")
    List<Book> finds();
}


