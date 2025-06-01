package com.productor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductorApplication.class);
    }
}
