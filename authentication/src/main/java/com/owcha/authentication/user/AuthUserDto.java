package com.owcha.authentication.user;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "auth_users", schema = "auth")
public class AuthUserDto {

    @GeneratedValue
    @Id
    private Integer id;
    private String username;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    public AuthUserDto(String username, String email, String password, List<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
}
