package com.example.user;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getUser")
    public String getUser(){
        return service.getUser();
    }

    @PostMapping("/createUser")
    public String creatUser(@RequestBody String user){
        return service.createUser(user);
    }
}