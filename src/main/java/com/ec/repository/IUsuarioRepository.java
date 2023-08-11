package com.ec.repository;

import com.ec.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


public interface IUsuarioRepository {
    Usuario consultarUsuario(String userName);
}
