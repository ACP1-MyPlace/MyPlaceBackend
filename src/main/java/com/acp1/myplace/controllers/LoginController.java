package com.acp1.myplace.controllers;

import com.acp1.myplace.dto.JwtResponse;
import com.acp1.myplace.dto.user.UsernamePasswordLogin;
import com.acp1.myplace.services.JwtManager;
import com.acp1.myplace.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class LoginController {

    private final JwtManager jwtManager;

    private UserService userService;

    public LoginController(JwtManager jwtManager,UserService userService){
        this.jwtManager = jwtManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid UsernamePasswordLogin usernameAndPassword){
        var user = userService.validateUsernameAndPassword(usernameAndPassword);
        return jwtManager.generateToken(user.getEmail(),user.getType());
    }
}
