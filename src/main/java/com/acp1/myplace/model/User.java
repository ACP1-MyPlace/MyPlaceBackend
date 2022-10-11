package com.acp1.myplace.model;

import com.acp1.myplace.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
