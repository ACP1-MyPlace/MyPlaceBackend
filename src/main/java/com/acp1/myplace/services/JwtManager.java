package com.acp1.myplace.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.acp1.myplace.dto.JwtResponse;

public interface JwtManager {
    public boolean validateToken(String token, UserDetails userDetails);

    public String getMailFromToken(String token);

    public JwtResponse generateToken(String mail);
}
