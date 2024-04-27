package com.seproject.seproject.dao;


import com.seproject.seproject.model.Secretary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SecretaryDAOImpl implements SecretaryDAO{


    //    define field for entity manger
    private EntityManager entityManager ;

//   constractor for inject entitymanager


    public SecretaryDAOImpl() {
    }

    @Autowired
    public SecretaryDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
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
        return dbeSecretary;

    }

    @Override
    public void deleteSecretary(int theId) {
        Secretary dbeSecretary = entityManager.find(Secretary.class, theId);
        entityManager.remove(dbeSecretary);
    }
}
