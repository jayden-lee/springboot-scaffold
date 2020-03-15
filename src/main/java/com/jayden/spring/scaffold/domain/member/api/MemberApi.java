package com.jayden.spring.scaffold.domain.member.api;

import com.jayden.spring.scaffold.domain.member.dto.SignUpRequest;
import com.jayden.spring.scaffold.domain.member.entity.Member;
import com.jayden.spring.scaffold.domain.member.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberApi {

    private final MemberSignUpService memberSignUpService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid SignUpRequest request) {
        Member member = memberSignUpService.doSignUp(request);
        // TODO CREATED, URI
        return ResponseEntity.ok().build();
    }

}
