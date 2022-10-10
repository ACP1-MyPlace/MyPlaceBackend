package com.acp1.myplace.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class UsernamePasswordLogin {
    private static final int MIN_PASSWORD_LENGTH = 6;

    private @Email String mail;
    private @Size(min=MIN_PASSWORD_LENGTH) String password;
}
