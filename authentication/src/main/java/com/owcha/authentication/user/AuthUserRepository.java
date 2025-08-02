package com.owcha.authentication.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUserDto, Integer> {
    AuthUserDto findByUsername(String username);
    Optional<AuthUserDto> findByEmail(String email);
}
