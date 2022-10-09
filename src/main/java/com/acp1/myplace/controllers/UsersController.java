package com.acp1.myplace.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acp1.myplace.dto.UserRegister;
import com.acp1.myplace.services.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String getConfiguration(@RequestBody @Valid UserRegister user){
        userService.registerNewUser(user);
        return "Hello";
    }

}
