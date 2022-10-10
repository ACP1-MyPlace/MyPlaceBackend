package com.acp1.myplace.services;

import com.acp1.myplace.dto.UserRegister;

public interface UserService {
    
    Object registerNewUser(UserRegister user); // TODO cambiar al tipo de usuario

    Object getUserByMail(String mail); // TODO cambiar al tipo de usuario
}
