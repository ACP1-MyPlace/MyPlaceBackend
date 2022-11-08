package com.acp1.myplace.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acp1.myplace.dto.JwtResponse;
import com.acp1.myplace.dto.user.UserRegister;
import com.acp1.myplace.services.JwtManager;
import com.acp1.myplace.services.UserService;

@RestController
@RequestMapping("api/v1/users")
public class RegisterController {

    private UserService userService;



    public RegisterController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUpUser(@RequestBody @Valid UserRegister user){
        userService.registerNewUser(user);
    }

}
