package com.acp1.myplace.controllers;

import com.acp1.myplace.dto.JwtResponse;
import com.acp1.myplace.dto.UsernamePasswordLogin;
import com.acp1.myplace.services.JwtManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class LoginController {

    private final JwtManager jwtManager;

    public LoginController(JwtManager jwtManager){
        this.jwtManager = jwtManager;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid UsernamePasswordLogin user){
        return jwtManager.generateToken(user.getMail());
    }
}
