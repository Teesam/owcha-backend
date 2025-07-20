package com.owcha.authentication.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserDto, Integer> {
    AuthUserDto findByUsername(String username);
}
