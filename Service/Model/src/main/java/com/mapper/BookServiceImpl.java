package com.mapper;

import com.bean.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class BookServiceImpl implements BookMapper {
    private final SqlSessionFactory sqlSessionFactory;

    public BookServiceImpl() throws IOException {
        // MyBatis 初始化（完全隐藏在内部）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    public void add(Book book) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.add(book);
            session.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try(SqlSession session = sqlSessionFactory.openSession()){
            BookMapper mapper =session.getMapper(BookMapper.class);
            mapper.delete(id);
        }
    }

    @Override
    public Book find(Integer id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.find(id);
        }
    }

    @Override
    public List<Book> finds() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.finds();
        }
    }

}