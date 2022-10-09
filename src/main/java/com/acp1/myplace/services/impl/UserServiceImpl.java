package com.acp1.myplace.services.impl;

import org.springframework.stereotype.Service;

import com.acp1.myplace.dto.UserRegister;
import com.acp1.myplace.exceptions.UserAlreadyRegistered;
import com.acp1.myplace.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    // TODO agregar repositorio

    @Override
    public String registerNewUser(UserRegister user) {
        // TODO 
        // if(repositorio.findUserByMail(user.getMail()).isPresent()){
        //     throw new UserAlreadyRegistered();
        // }
        // repositorio.save(user);

        return "OK"; // TODO ver respuesta
    }
    
}
