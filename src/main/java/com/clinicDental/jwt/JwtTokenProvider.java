package com.clinicDental.jwt;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication){
        String username=authentication.getName();
        Date dateNow=new Date();
        Date dateExpiration=new Date(dateNow.getTime()+jwtExpirationInMs);
        String token=Jwts.builder()
                .setSubject(username)
                .setIssuedAt(dateNow)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
        return token;
    }

    public String getUsernameJwt(String token){
        Claims claims=Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public boolean validatorToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            throw  new Exception("Invalid signature JWT");
        }catch (MalformedJwtException ex){
            throw new Exception("Token JWT does not valid");
        }catch (ExpiredJwtException ex){
            throw new Exception("Token JWT expired");
        }catch (UnsupportedJwtException ex){
            throw new Exception("Unsupported JWT");
        }catch (IllegalArgumentException ex){
            throw new Exception("Empty JWT Claims");
        }
    }
}
