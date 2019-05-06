package com.example.statement.service;


import com.example.statement.response.CustomException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SECERT_KEY = "bright";


    // check signature
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECERT_KEY).parseClaimsJws(cleanToken(token));
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public String getUsernameFromToken(String token) {
        if(validateToken(token)){
            return Jwts.parser().setSigningKey(SECERT_KEY).parseClaimsJws(cleanToken(token)).getBody().getSubject();
        }else {
            return "Expired or invalid JWT token";
        }
    }

    private String cleanToken(String token){
        return token.split(" ")[1];
    }
}
