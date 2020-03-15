package com.jayden.spring.scaffold.domain.user.dao;

import com.jayden.spring.scaffold.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
