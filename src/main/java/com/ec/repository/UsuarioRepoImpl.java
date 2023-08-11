package com.ec.repository;

import com.ec.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UsuarioRepoImpl implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario consultarUsuario(String userName) {

        TypedQuery<Usuario> myQuery = this.entityManager
                .createQuery("Select e from Estudiante e Where e.userName = :dato", Usuario.class);
        myQuery.setParameter("dato", userName);

        return myQuery.getSingleResult();
    }
}
