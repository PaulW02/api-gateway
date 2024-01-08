package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/user/**").uri("https://login-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/message/**").uri("https://message-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/patient/**").uri("https://patient-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/encounter/**").uri("https://patient-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/observation/**").uri("https://patient-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/condition/**").uri("https://patient-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/image/**").uri("https://image-microservice.app.cloud.cbh.kth.se/"))
                .route(r -> r.path("/search/**").uri("https://quarkus-microservice.app.cloud.cbh.kth.se/"))
                .build();
    }

}
