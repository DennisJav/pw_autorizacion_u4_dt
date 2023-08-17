package com.ec.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private static final Logger LOG= LoggerFactory.getLogger(JWTUtils.class);
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.expiration.ms}")
    private Integer jwtExpiration;

    public String generateJwtToken(Authentication authentication, String nombre){
        //el tiempo de expiracion en un archivo de configurcion y en milisegundos
        LOG.info("semilla"+jwtSecret);
        LOG.info("tiempo: "+jwtExpiration);
        return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+this.jwtExpiration))
                .signWith(SignatureAlgorithm.HS512,this.jwtSecret).compact();
    }

}
