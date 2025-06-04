package com.app.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetWayApplication.class);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("book",r->r.path("/api/book/**").uri("lb://consumer1"))
                .route("all",r->r.path("/**").uri("https://github.com"))
                .build();
    }
}
