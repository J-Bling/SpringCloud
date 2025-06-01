package com.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);

        // 打印所有配置源
        Environment env = context.getEnvironment();
        System.out.println("=== 加载的配置源 ===");
        ((AbstractEnvironment) env).getPropertySources().forEach(ps -> {
            System.out.println("-> " + ps.getName());
        });

        // 检查关键配置
        System.out.println("user.age = " + env.getProperty("user.age"));
        System.out.println("user.name = " + env.getProperty("user.name"));
    }
}

