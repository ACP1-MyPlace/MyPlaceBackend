package com.acp1.myplace.services;

import com.acp1.myplace.dto.user.UserRegister;
import com.acp1.myplace.dto.user.UsernamePasswordLogin;
import com.acp1.myplace.model.user.User;

public interface UserService {
    
    void registerNewUser(UserRegister user);

    User getUserByMail(String email);

    User validateUsernameAndPassword(UsernamePasswordLogin userAndPassword);
}
