package com.sm.noteApp.ApiGateway.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.function.*;

@Service
public class JwtUtil {

    private static String SECRET_KEY = "DIGITALIZATION";


 // Validate Token
    public static boolean validateToken(String token) {
        try {
            try {
				Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract Username
    public static String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}