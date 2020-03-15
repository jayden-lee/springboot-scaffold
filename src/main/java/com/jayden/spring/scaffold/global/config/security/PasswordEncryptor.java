package com.jayden.spring.scaffold.global.config.security;

public interface PasswordEncryptor {

    String encrypt(String rawPassword);
}