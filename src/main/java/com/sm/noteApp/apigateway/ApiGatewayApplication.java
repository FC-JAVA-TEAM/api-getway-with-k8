package com.sm.noteApp.apigateway;

import com.sm.noteApp.apigateway.security.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

/*
 * ApiGatewayApplication is the main class containing bean registration for Jwtfilter
 *
 * @author Shilpi
 * @since 2025-03-06
 */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public WebFilter jwtFilter() {
        return new JwtFilter();
    }

}
