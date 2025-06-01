package com.mapper;

import com.bean.Book;
import feign.Param;

import java.util.List;

public interface BookMapper {
    void add(Book book);
    void delete(@Param("id") Integer id);
    Book find(@Param("id") Integer id);
    List<Book> finds();
}
