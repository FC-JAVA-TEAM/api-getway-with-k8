package com.sm.noteApp.apigateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/*
 * JwtUtil will validate token  and contains secret key according to algorithm used
 * The secret key needs to be same in user service and API-Gateway
 *
 * @author Shilpi
 * @since 2025-03-06
 */

@Service
//@Slf4j
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    // private static String SECRET_KEY = "DIGITALIZATION";
    private static String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";


    // Validate Token
    public static boolean validateToken(String token) {
        LOGGER.debug("Validating token: {}", token);
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            LOGGER.debug("Token validated successfully");
        } catch (Exception e) {
            LOGGER.error("Error validating token", e);
            return false;
        }
        return true;

    }

    // Extract Username
    public static String extractUsername(String token) {
        LOGGER.debug("Extracting username from token: {}", token);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            LOGGER.debug("Username extracted: {}", claims.getSubject());
            return claims.getSubject();
        } catch (Exception e) {
            LOGGER.error("Error extracting username from token", e);
            return null;
        }
    }
}