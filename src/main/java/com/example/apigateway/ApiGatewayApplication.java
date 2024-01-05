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
                .route(r -> r.path("/user/**").uri("http://login-microservice-service:5001"))
                .route(r -> r.path("/message/**").uri("http://message-microservice-service:5002"))
                .route(r -> r.path("/patient/**").uri("http://patient-microservice-service:5003"))
                .route(r -> r.path("/encounter/**").uri("http://patient-microservice-service:5003"))
                .route(r -> r.path("/observation/**").uri("http://patient-microservice-service:5003"))
                .route(r -> r.path("/condition/**").uri("http://patient-microservice-service:5003"))
                .route(r -> r.path("/image/**").uri("http://image-microservice-service:5004"))
                .route(r -> r.path("/search/**").uri("http://quarkus-microservice-service:8080"))
                .build();
    }

}
