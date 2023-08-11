package com.ec.service;

import com.ec.entity.Usuario;
import com.ec.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections.*;
import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario us = this.usuarioRepository.consultarUsuario(username);

        //user recibe tres paramtros, 1. nombre del usuario, 2. pasword, 3. lista de roles para ese usuario
        return new User(us.getUserName(),us.getPasword(), emptyList());
    }
}
