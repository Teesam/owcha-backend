package com.owcha.authentication.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthUserRepository repository;

    public AuthUserService(BCryptPasswordEncoder bCryptPasswordEncoder, AuthUserRepository repository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.repository = repository;
    }

    public String createUser(AuthUserDto user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "User succesfully saved";
    }
}
