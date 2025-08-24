package service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudBeanConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productModule", r -> r.path("/products/**")
                        .uri("lb://product-service"))
                .route("stockModule", r -> r.path("/stocks/**")
                        .uri("lb://stock-service"))
                .build();
    }
}