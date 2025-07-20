package com.example.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUser(){
        return "Samuel Tunde Olayiwola";
    }

    public String createUser(String user) {
        return user;
    }
}
