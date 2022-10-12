package com.acp1.myplace.services.impl;

import org.springframework.stereotype.Service;

import com.acp1.myplace.dto.UserRegister;
import com.acp1.myplace.dto.UsernamePasswordLogin;
import com.acp1.myplace.exceptions.UserAlreadyRegistered;
import com.acp1.myplace.exceptions.UserNotFoundException;
import com.acp1.myplace.model.User;
import com.acp1.myplace.repositories.UserRepository;
import com.acp1.myplace.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{


    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerNewUser(UserRegister dto) {

        if(repository.findByEmail(dto.getMail()).isPresent()){
            throw new UserAlreadyRegistered();
        }
        var user = User.builder()
            .email(dto.getMail())
            .firstName(dto.getFirstName())
            .lastName(dto.getLastName())
            .password(dto.getPassword())
            .type(dto.getType())
            .build();
        repository.save(user);
    }

    @Override
    public User getUserByMail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User validateUsernameAndPassword(UsernamePasswordLogin userAndPassword) {
        var user = repository.findByEmail(userAndPassword.getMail()).orElseThrow(() -> new UserNotFoundException());
        if(!user.getPassword().equals(userAndPassword.getPassword())){
            throw new UserNotFoundException();
        }
        return user;
    }
    
}
