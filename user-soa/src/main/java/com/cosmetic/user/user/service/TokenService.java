package com.cosmetic.user.user.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SECERT_KEY = "bright";


    // check signature
    public void validateToken() {

    }

    public String getUsernameFromToken(String token) {
        System.out.println(token);
        try{
            return Jwts.parser().setSigningKey(SECERT_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (Exception ex){
            return ex.toString();
        }
    }
}
