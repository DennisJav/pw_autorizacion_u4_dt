package com.ec.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthEntryPointJWT implements AuthenticationEntryPoint {

    private static final Logger LOG = LoggerFactory.getLogger(AuthEntryPointJWT.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //aqui es donde se programa lo que queremo que retorne cuando hay un error
        LOG.error("Usuario No Autorizado {}",authException.getMessage());

    }
}
