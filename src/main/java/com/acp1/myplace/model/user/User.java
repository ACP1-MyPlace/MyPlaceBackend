package com.acp1.myplace.model.user;

import com.acp1.myplace.domain.user.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column @NotNull
    private String email;

    @Column
    private String firstName;

    @Column
    private String password;

    @Column
    private String lastName;

    @Column @NotNull
    private UserType type;

    @Builder
    public User(@NotNull String email, String firstName, String password, String lastName, @NotNull UserType type) {
        this.email = email;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.type = type;
    }
}
