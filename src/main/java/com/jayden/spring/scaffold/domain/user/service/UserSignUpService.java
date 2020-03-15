package com.jayden.spring.scaffold.domain.user.service;

import com.jayden.spring.scaffold.domain.user.dao.UserRepository;
import com.jayden.spring.scaffold.domain.user.dto.SignUpRequest;
import com.jayden.spring.scaffold.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;

    public User doSignUp(SignUpRequest request) {
        return null;
    }
}
