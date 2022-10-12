package com.acp1.myplace.services;

import com.acp1.myplace.dto.UserRegister;
import com.acp1.myplace.dto.UsernamePasswordLogin;
import com.acp1.myplace.model.User;

public interface UserService {
    
    void registerNewUser(UserRegister user);

    User getUserByMail(String email);

    User validateUsernameAndPassword(UsernamePasswordLogin userAndPassword);
}
