package com.mapper;

import com.bean.Book;
import java.util.List;

public interface BookMapper {
    void add(Book book);
    void delete( Integer id);
    Book find(Integer id);
    List<Book> finds();
}
