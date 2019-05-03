package com.utad.desarrollo.seguro.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.utad.desarrollo.seguro.entity.UserEntity;
import com.utad.desarrollo.seguro.repository.UsersRepository;

@Configuration
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {
       
        UserEntity user = usersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("");
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRole())));

    }

}