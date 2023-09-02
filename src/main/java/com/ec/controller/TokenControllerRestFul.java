package com.ec.controller;

import com.ec.entity.Usuario;
import com.ec.security.JWTUtils;
import com.ec.service.to.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestFul {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtil;
    @GetMapping("/obtener")
    private String obtenerToken(@RequestBody UsuarioTO user){
        this.authenticated(user.getUserName(), user.getPasword());
        return this.jwtUtil.generateJwtToken(user.getUserName(),user.getSemilla(),user.getTiempoVigencia());
    }



    private void authenticated(String usuario, String pasword){
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, pasword));
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }


}
