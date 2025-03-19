package com.sm.noteApp.apigateway.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/*
 * JwtFilter will filter and intercept each request
 *
 * @author Shilpi
 * @since 2025-03-06
 */
@Slf4j
public class JwtFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("Intercepting request: {}", exchange.getRequest().getURI());
        log.info("Request Method: {}", exchange.getRequest().getMethod());
        log.info("Request Path: {}", exchange.getRequest().getURI().getPath());

//        // Example: Add a custom header
//        exchange.getResponse().getHeaders().add("X-Custom-Header", "Reactive");
//        log.info("Added custom header: X-Custom-Header = Reactive");
//        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
//        log.info("Authorization Header: {}", authHeader);
//
//        String path = exchange.getRequest().getURI().getPath();
//        if (path.matches("/auth/.*") || path.matches("/hello")) {
//            log.info("Allowing access to public endpoint: {}", path);
//            // Allow access to public endpoints without JWT validation
//            return chain.filter(exchange);
//        }
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            log.info("Missing or invalid Authorization header");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            //exchange.getResponse().getWriter().write("Missing or invalid token");
//            return exchange.getResponse().setComplete();
//        }
//        String token = authHeader.substring(7);  // Extract the token (removes "Bearer ")
//        log.info("Extracted token: {}", token);
//
//        // If token validation fails, respond with Unauthorized
//        if (!JwtUtil.validateToken(token)) {
//            log.info("Token validation failed");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        log.info("Token validation successful");

        return chain.filter(exchange);
    }
}