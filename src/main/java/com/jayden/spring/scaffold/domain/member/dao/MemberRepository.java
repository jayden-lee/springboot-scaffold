package com.jayden.spring.scaffold.domain.member.dao;

import com.jayden.spring.scaffold.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
