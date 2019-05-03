package com.utad.desarrollo.seguro.config.security;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder
        implements PasswordEncoder {

    @Override
    public String encode(
            CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(
            CharSequence rawPassword,
            String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

}
