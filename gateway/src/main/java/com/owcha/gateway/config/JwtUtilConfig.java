package com.owcha.gateway.config;

import com.example.auth.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtUtilConfig {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration-ms}")
    private long expiration;

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil(secretKey, expiration);
    }

}
