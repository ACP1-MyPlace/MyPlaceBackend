package com.acp1.myplace.services.impl;

import org.springframework.stereotype.Service;

import com.acp1.myplace.dto.UserRegister;
import com.acp1.myplace.exceptions.UserAlreadyRegistered;
import com.acp1.myplace.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    // TODO agregar repositorio

    @Override
    public Object registerNewUser(UserRegister user) {
        // TODO 
        // if(repositorio.findUserByMail(user.getMail()).isPresent()){
        //     throw new UserAlreadyRegistered();
        // }
        // repositorio.save(user);

        return "OK"; // TODO cambiar al usuario
    }

    @Override
    public Object getUserByMail(String mail) {
        // TODO Buscar el usuario por mail
        return null;
    }
    
}
