package com.jayden.spring.scaffold.domain.member.service;

import com.jayden.spring.scaffold.domain.member.dao.MemberRepository;
import com.jayden.spring.scaffold.domain.member.dto.SignUpRequest;
import com.jayden.spring.scaffold.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberRepository memberRepository;

    public Member doSignUp(SignUpRequest request) {
        return null;
    }
}
