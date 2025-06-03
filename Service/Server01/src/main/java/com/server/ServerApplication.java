package com.server;

import com.mapper.BookMapper;
import com.mapper.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }

    @Bean
    public BookMapper bookMapper() throws IOException {
        return new BookServiceImpl();
    }
}
