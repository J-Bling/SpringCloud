package com.server.controller;


import com.bean.Book;
import com.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookMapper session;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController() throws IOException {

    }

    @GetMapping("/add")
    public String add(@RequestParam("book-name") String bookName){
        try{
            session.add(new Book(bookName));
            return "成功";
        }catch (Exception e){
            logger.error(e.getMessage());
            return "失败";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        try{
            session.delete(id);
            return "ok";
        }catch (Exception e){
            logger.error(e.getMessage());
            return "no";
        }
    }

    @GetMapping("/find")
    public Book find(@RequestParam("id") Integer id){
        try{
            return session.find(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @GetMapping("/finds")
    public List<Book> finds(){
        try{
            List<Book> books =session.finds();
            logger.info(Arrays.toString(books.toArray()));
            return books;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
