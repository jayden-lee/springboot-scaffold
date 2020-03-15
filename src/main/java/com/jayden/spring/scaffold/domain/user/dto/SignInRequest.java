package com.jayden.spring.scaffold.domain.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class SignInRequest {

    @Email(message = "Email address should be valid")
    @Size(max = 100, message = "Email address must not be more than 100 characters")
    @NotNull
    private String email;

    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    @NotNull
    private String password;
}

