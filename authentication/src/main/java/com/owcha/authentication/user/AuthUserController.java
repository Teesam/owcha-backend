package com.owcha.authentication.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthUserController {

    private final AuthUserService service;

    public AuthUserController(AuthUserService service){
        this.service = service;
    }

    @PostMapping("/createUser")
    public String registerUser(AuthUserDto user){
        return service.createUser(user);
    }
}
