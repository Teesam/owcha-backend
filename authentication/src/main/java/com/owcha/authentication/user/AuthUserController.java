package com.owcha.authentication.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth")
public class AuthUserController {

    private final AuthUserService service;

    public AuthUserController(AuthUserService service){
        this.service = service;
    }

//    @PostMapping("/createUser")
//    public String registerUser(AuthUserDto user){
//        return service.createUser(user);
//    }

    @PostMapping("/createUser")
    public AuthUserDto registerUser(@RequestBody AuthUserDto user){
        return service.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUserLoginDto user){
        return service.login(user);
    }
}
