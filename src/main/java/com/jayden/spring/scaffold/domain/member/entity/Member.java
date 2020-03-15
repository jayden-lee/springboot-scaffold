package com.jayden.spring.scaffold.domain.member.entity;

import com.jayden.spring.scaffold.domain.common.model.BaseTimeEntity;
import com.jayden.spring.scaffold.domain.common.model.Email;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

}
