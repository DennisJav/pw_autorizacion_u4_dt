package com.ec.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
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
    @Value("${app.jwt.expiration}")
    private Integer jwtExpiration;

    public String generateJwtToken(String userName,String semilla, Integer tiempoVigencia){
        //el tiempo de expiracion en un archivo de configurcion y en milisegundos
        LOG.info("semilla"+jwtSecret);
        LOG.info("tiempo: "+jwtExpiration);
        return Jwts.builder().setSubject(userName).setIssuedAt(new Date())

                .setExpiration(new Date(System.currentTimeMillis() + tiempoVigencia))

                .signWith(SignatureAlgorithm.HS512, semilla).compact();
    }


//    @Value("${app.jwt.expiration.ms}")
//    public boolean validateJwtToken(String token){
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            return true;
//        }catch (ExpiredJwtException e){
//            LOG.error("Token expirado", e.getMessage());
//        }catch (SignatureException e){
//            LOG.error("Token invalido", e.getMessage());
//        }
//
//        return false;
//    }

}
