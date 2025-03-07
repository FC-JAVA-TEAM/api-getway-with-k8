package com.sm.noteApp.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/*
 * SecurityConfig for security configuration 
 * 
 * @author Shilpi
 * @since 2025-03-06
 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for Gateway
            .authorizeExchange(exchanges -> exchanges
                .anyExchange().permitAll() // Allow all requests
            );

        return http.build();
    }
}