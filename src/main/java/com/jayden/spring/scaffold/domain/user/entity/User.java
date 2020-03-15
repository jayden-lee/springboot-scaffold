package com.jayden.spring.scaffold.domain.user.entity;

import com.jayden.spring.scaffold.domain.common.model.BaseTimeEntity;
import com.jayden.spring.scaffold.domain.common.model.Email;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

}
