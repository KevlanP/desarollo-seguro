package com.utad.desarrollo.seguro.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.utad.desarrollo.seguro.dto.UserDto;
import com.utad.desarrollo.seguro.service.UsersService;

@Configuration
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        UserDto user = usersService.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("");
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRole())));

    }

}