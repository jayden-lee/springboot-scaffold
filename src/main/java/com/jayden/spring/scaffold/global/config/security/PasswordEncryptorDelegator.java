package com.jayden.spring.scaffold.global.config.security;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptorDelegator implements PasswordEncryptor {

    // TODO Spring Security 추가 후 PasswordEncoder 사용하도록 수정 필요
    @Override
    public String encrypt(String rawPassword) {
        return rawPassword;
    }
}
