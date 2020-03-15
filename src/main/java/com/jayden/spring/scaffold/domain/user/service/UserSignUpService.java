package com.jayden.spring.scaffold.domain.user.service;

import com.jayden.spring.scaffold.domain.user.dao.UserRepository;
import com.jayden.spring.scaffold.domain.user.dto.SignUpRequest;
import com.jayden.spring.scaffold.domain.user.entity.User;
import com.jayden.spring.scaffold.domain.user.exception.EmailDuplicateException;
import com.jayden.spring.scaffold.global.config.security.PasswordEncryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncryptor passwordEncryptor;

    public User doSignUp(SignUpRequest request) {
        if (userRepository.existsByEmailAddress(request.getEmailAddress())) {
            throw new EmailDuplicateException(request.getEmailAddress());
        }

        String encryptedPassword = passwordEncryptor.encrypt(request.getPassword());

        User newUser = User.create(request.getUsername(), request.getEmailAddress(), encryptedPassword);
        userRepository.save(newUser);

        return newUser;
    }
}
