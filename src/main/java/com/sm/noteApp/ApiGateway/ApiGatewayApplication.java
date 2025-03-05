package com.sm.noteApp.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sm.noteApp.ApiGateway.security.JwtFilter;


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	
	@Bean
    public OncePerRequestFilter jwtFilter() {
        return new JwtFilter();
    }
	 
}
