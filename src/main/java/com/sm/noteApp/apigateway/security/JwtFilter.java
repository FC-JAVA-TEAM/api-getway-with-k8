package com.sm.noteApp.apigateway.security;

import java.net.URI;

import org.springframework.http.HttpStatus;
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
public class JwtFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        System.out.println("Intercepting request: " + exchange.getRequest().getURI());
       
        	
        // Example: Add a custom header
        exchange.getResponse().getHeaders().add("X-Custom-Header", "Reactive");
        
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        
        String path = exchange.getRequest().getURI().getPath();
        if (path.matches("/auth/.*")) {
            // Allow access to public endpoints without JWT validation
            return chain.filter(exchange);
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	 exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        	//exchange.getResponse().getWriter().write("Missing or invalid token");
        	  return exchange.getResponse().setComplete();
        }
        String token = authHeader.substring(7);  // Extract the token (removes "Bearer ")

        // If token validation fails, respond with Unauthorized
        if (!JwtUtil.validateToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

       
        return chain.filter(exchange);
    }
    
    
    

    
}