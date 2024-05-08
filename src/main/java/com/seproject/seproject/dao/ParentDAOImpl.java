package com.seproject.seproject.dao;


import com.seproject.seproject.model.Parent;
import com.seproject.seproject.model.Role;
import com.seproject.seproject.model.User;
import com.seproject.seproject.service.AuthenticationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ParentDAOImpl implements ParentDAO{

    private EntityManager entityManager ;
    private PasswordEncoder passwordEncoder;
    private AuthenticationService authenticationService;
    public ParentDAOImpl() {
    }



    @Autowired
    public ParentDAOImpl(EntityManager entityManager, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }
    @Override
    public List<Parent> findAll() {
        TypedQuery<Parent> thequery = entityManager.createQuery("from Parent",Parent.class);
        List<Parent> parents = thequery.getResultList();
        return parents;
    }


    @Override
    public Parent findById(int theId) {
     Parent theParent = entityManager.find(Parent.class,theId);

        return theParent;
    }

    @Override
    public Parent save(Parent parent) {

        Parent theParent = entityManager.merge(parent);
        User user = new User();
        user.setFirstName(theParent.getFirstName());
        user.setLastName(theParent.getLastName());
        user.setRole(Role.USER);
        user.setUsername(theParent.getEmail());
        user.setPassword(passwordEncoder.encode(theParent.getPassword()));
        authenticationService.register(user);
        return theParent;
    }

    @Override
    public void deleteParent(int theId) {
        Parent dbparent = entityManager.find(Parent.class, theId);
        entityManager.remove(dbparent);
    }



}
