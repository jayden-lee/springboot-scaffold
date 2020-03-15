package com.jayden.spring.scaffold.domain.user.api;

import com.jayden.spring.scaffold.domain.user.dto.SignInRequest;
import com.jayden.spring.scaffold.domain.user.dto.SignUpRequest;
import com.jayden.spring.scaffold.domain.user.entity.User;
import com.jayden.spring.scaffold.domain.user.service.UserSignUpService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserApi {

    private final UserSignUpService userSignUpService;

    @ApiOperation(value = "사용자 회원가입")
    @PostMapping(value = "signup")
    public ResponseEntity signUp(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.doSignUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
