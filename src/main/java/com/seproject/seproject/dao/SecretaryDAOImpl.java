package com.seproject.seproject.dao;


import com.seproject.seproject.model.Role;
import com.seproject.seproject.model.Secretary;
import com.seproject.seproject.model.User;
import com.seproject.seproject.service.AuthenticationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SecretaryDAOImpl implements SecretaryDAO{


    //    define field for entity manger
    private EntityManager entityManager ;
    private PasswordEncoder passwordEncoder;
    private AuthenticationService authenticationService;

//   constractor for inject entitymanager


    public SecretaryDAOImpl() {
    }


    @Autowired
    public SecretaryDAOImpl(EntityManager entityManager, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }



    @Override
    public List<Secretary> findAll() {

        TypedQuery<Secretary> thequery = entityManager.createQuery("from Secretary",Secretary.class);
        List<Secretary> secretaries = thequery.getResultList();

        return secretaries ;

    }
    @Override
    public Secretary findById(int theId) {

        Secretary dbeSecretary = entityManager.find(Secretary.class,theId);

        return dbeSecretary;
    }

    @Override
    public Secretary save(Secretary secretary) {
        Secretary dbeSecretary = entityManager.merge(secretary);
        User user = new User();
        user.setFirstName(dbeSecretary.getFirstName());
        user.setLastName(dbeSecretary.getLastName());
        user.setRole(Role.SEC);
        user.setUsername(dbeSecretary.getEmail());
        user.setPassword(passwordEncoder.encode(dbeSecretary.getPassword()));
        authenticationService.register(user);
        return dbeSecretary;

    }

    @Override
    public void deleteSecretary(int theId) {
        Secretary dbeSecretary = entityManager.find(Secretary.class, theId);
        entityManager.remove(dbeSecretary);
    }
}
