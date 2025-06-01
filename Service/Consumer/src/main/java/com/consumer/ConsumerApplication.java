package com.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ConsumerApplication.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

