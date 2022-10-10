package com.acp1.myplace.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.acp1.myplace.dto.JwtResponse;
import com.acp1.myplace.services.JwtManager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtManagerImpl implements JwtManager {
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 10L * 60 * 60;

    private String secret;
    
    
    public JwtManagerImpl(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String getMailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }


    private Boolean isAnExpiredToken(String token) {
        final var expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    
    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    
    @Override
    public JwtResponse generateToken(String mail) {
        
        Map<String, Object> claims = new HashMap<>();
        //claims.put("userId", userId);
        return new JwtResponse(generateToken(claims, mail));
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getMailFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isAnExpiredToken(token));
    }

}
