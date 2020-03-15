package com.jayden.spring.scaffold.domain.user.entity;

import com.jayden.spring.scaffold.domain.common.model.BaseTimeEntity;
import com.jayden.spring.scaffold.domain.common.model.EmailAddress;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Embedded
    private EmailAddress emailAddress;

    @Column(name = "password")
    private String password;

    public static User create(String username, EmailAddress emailAddress, String password) {
        User user = new User();
        user.username = username;
        user.emailAddress = emailAddress;
        user.password = password;
        return user;
    }
}
