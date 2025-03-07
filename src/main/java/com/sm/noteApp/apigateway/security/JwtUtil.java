package com.sm.noteApp.apigateway.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.*;
/*
 * JwtUtil will validate token  and contains secret key according to algorithm used
 * The secret key needs to be same in user service and API-Gateway
 * 
 * @author Shilpi
 * @since 2025-03-06
 */

@Service
public class JwtUtil {

   // private static String SECRET_KEY = "DIGITALIZATION";
    private static String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";


 // Validate Token
    public static boolean validateToken(String token) {
            try {
				Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return false;
			}
            return true;

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