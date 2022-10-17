package com.acp1.myplace.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.acp1.myplace.domain.user.UserType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRegister {

    private static final int MIN_PASSWORD_LENGTH = 6;

    private @Email String mail;
    private @Size(min=MIN_PASSWORD_LENGTH) String password;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotNull UserType type;

}
