package com.slippery.booklibrary.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final String SECRETSTRING ="";
    private final Long EXPIRYTIME =1800000L;

    protected SecretKey generateSecretKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRETSTRING );
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRYTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();
    }
}
