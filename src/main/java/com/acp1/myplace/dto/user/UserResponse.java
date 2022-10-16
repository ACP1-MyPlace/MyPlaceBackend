package com.acp1.myplace.dto.user;

import com.acp1.myplace.domain.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private @NotNull Long id;
    private @NotBlank String mail;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotNull UserType type;

}
