package com.owcha.authentication.config;

import com.owcha.authentication.user.AuthUserDto;
import com.owcha.authentication.user.AuthUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository repository;

    public CustomUserDetailsService(AuthUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserDto user = repository.findByUsername(username);
        if(Objects.isNull(user))
            throw new UsernameNotFoundException("User not available");
        return new CustomUserDetails(user);
    }
}
