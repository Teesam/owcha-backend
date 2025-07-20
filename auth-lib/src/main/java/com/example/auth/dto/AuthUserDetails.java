package com.example.auth.dto;

import java.util.List;

public class AuthUserDetails {
    private Long id;
    private String username;
    private List<String> roles;

    public AuthUserDetails(Long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public List<String> getRoles() { return roles; }
}
