package com.owcha.authentication.user;

import com.owcha.authentication.config.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final com.owcha.authentication.jwt.JwtService jwtService;

    private final AuthUserRepository repository;

    public AuthUserService(com.owcha.authentication.jwt.JwtService jwtService, AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder, AuthUserRepository repository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthUserDto createUser(AuthUserDto user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

    public ResponseEntity<?> login(AuthUserLoginDto user){
        try {
            // Authenticate credentials
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );

            // If successful, fetch user details
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            AuthUserDto users = repository.findByEmail(userDetails.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate token
            String token = jwtService.generateToken(users);

            return ResponseEntity.ok(new AuthUserLoginResponseDto(token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
