package com.jayden.spring.scaffold.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jayden.spring.scaffold.domain.common.model.EmailAddress;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class SignUpRequest {

    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    @NotNull
    private String username;

    @Email(message = "Email address should be valid")
    @Size(max = 100, message = "Email address must not be more than 100 characters")
    @NotNull
    private String email;

    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    @NotNull
    private String password;

    @JsonIgnore
    public EmailAddress getEmailAddress() {
        return EmailAddress.of(email);
    }
}

