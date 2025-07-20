package com.example.auth.jwt;

import com.example.auth.dto.AuthUserDetails;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtTokenValidator {
    private final JwtUtil jwtUtil;

    public JwtTokenValidator(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthUserDetails validateToken(String token) {
        Claims claims = jwtUtil.extractAllClaims(token);
        Long id = claims.get("id", Integer.class).longValue();
        String username = claims.getSubject();
        List<String> roles = claims.get("roles", List.class);
        return new AuthUserDetails(id, username, roles);
    }
}
