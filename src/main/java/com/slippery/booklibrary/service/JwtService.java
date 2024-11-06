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

    private final String SECRETSTRING ="3bd2dc39ea0524f82bc880ef6b82dbc06fd3ef76d61bebdf117d2c174a4c76e57871c7b4e3158048e5845716eb3acbb2753ba9346eb1a4ce51cd086af69503b750d215e797b1865275d5396c004489df6f20cb1ba0b66469b45d44d2532ea410decad56dba84fb910d5e17f09ec5e629e9eb6d797a37b8fb78ccf28aa40a0e9dcebc9ba4e920d3933e7278b28481e3f98818917d9e5aaf6f7f09208a1a6ec4bb2e3d241abd24364d57fa9deeb99e98c61a89f79966bbc5c24b49bec6fa0226239ca7441cad00184d325d7da70dcb3dabde4da77adc20eaf01bfb4a2b0c8520786b5c1b1b0fb72bc4a38bf38fd5cc81f6b294edee035bfda35bb3d9ba030213d2";
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
