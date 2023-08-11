package com.ec.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.sql.Time;
import java.util.Date;

public class JWTUtils {

    public String generateJwtToken(Authentication authentication, String nombre){
        //el tiempo de expiracion en un archivo de configurcion y en milisegundos
        return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+10000))
                .signWith(SignatureAlgorithm.HS512,"semilla1").compact();
    }

}
