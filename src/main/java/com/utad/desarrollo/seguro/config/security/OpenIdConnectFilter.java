package com.utad.desarrollo.seguro.config.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenIdConnectFilter
        extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private OAuth2RestOperations oAuth2RestOperations;

    public OpenIdConnectFilter() {
        super("/oauth2-callback");
        setAuthenticationManager(new NoopAuthenticationManager());
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        OAuth2AccessToken oAuth2Token = null;
        try {
            oAuth2Token = oAuth2RestOperations.getAccessToken();
        } catch (OAuth2Exception e) {
            throw new BadCredentialsException("Could not obtain access token", e);
        }

        Jwt jwt = null;
        try {
            jwt = JwtHelper.decode((String) oAuth2Token.getAdditionalInformation().get("id_token"));
        } catch (InvalidTokenException e) {
            throw new BadCredentialsException("Could not obtain user details from token", e);
        }

        Map<String, Object> claims = new ObjectMapper().readValue(jwt.getClaims(), new TypeReference<HashMap<String, Object>>() {});
        String email = (String) claims.get("email");
        String role = null;

        switch (email) {

            case "s3curitybug@gmail.com":
                role = "ROLE_ADMIN";
                break;

            default:
                role = "ROLE_USER";

        }

        return new UsernamePasswordAuthenticationToken(email, null, Arrays.asList(new SimpleGrantedAuthority(role)));

    }

    private static class NoopAuthenticationManager
            implements AuthenticationManager {

        @Override
        public Authentication authenticate(
                Authentication authentication)
                throws AuthenticationException {
            throw new UnsupportedOperationException("No authentication should be done with this AuthenticationManager");
        }

    }

}
