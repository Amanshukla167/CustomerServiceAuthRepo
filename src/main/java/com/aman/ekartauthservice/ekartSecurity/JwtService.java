package com.aman.ekartauthservice.ekartSecurity;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private String SecurityKey = "234ghnm#3454#3hxcvbjuytfvbn87yds2345fvcxzgjw48ism7$qsdcv5432$#$2";

    private Key geyKey() {
        byte[] bytes = SecurityKey.getBytes();
        return Keys.hmacShaKeyFor(bytes);
    }


    private long Expriation = 1000 * 60 * 15;


    public String genrateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + Expriation))
                .signWith(geyKey()).compact();


    };


    public Claims extractToken(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(geyKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String extractEmail(String token){
        String extratedEmail  =  extractToken(token).getSubject();

        return  extratedEmail;
    }

    public String extractedRole(String token){
        return  extractToken(token).get("role" , String.class);
    }

    public Date extractExpireDate(String token){
        return extractToken(token).getExpiration();
    }

    public  boolean isTokenExpired(String token){
      return  extractToken(token).getExpiration().before(new Date());
    }

    public boolean isTokenValid(String email , String token){
          return (email.equals(extractEmail(token)) && !isTokenExpired(token));

    }




}

