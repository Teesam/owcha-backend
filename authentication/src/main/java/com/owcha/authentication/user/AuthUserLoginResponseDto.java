package com.owcha.authentication.user;

public class AuthUserLoginResponseDto {

    private String token;

    public AuthUserLoginResponseDto(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public void setToken( String token){
        this.token = token;
    }
}
