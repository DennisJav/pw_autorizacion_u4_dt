package com.ec.repository;

import com.ec.entity.Usuario;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UsuarioRepoImpl implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Usuario consultarUsuario(String userName) {

        TypedQuery<Usuario> myQuery = this.entityManager
                .createQuery("Select e from Usuario e Where e.userName = :dato", Usuario.class);
        myQuery.setParameter("dato", userName);

        return myQuery.getSingleResult();
    }
}
