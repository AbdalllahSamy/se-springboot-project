package com.seproject.seproject.dao;


import com.seproject.seproject.model.Parent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ParentDAOImpl implements ParentDAO{

    private EntityManager entityManager ;

    public ParentDAOImpl() {
    }

    @Autowired
    public ParentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
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
        return theParent;
    }

    @Override
    public void deleteParent(int theId) {
        Parent dbparent = entityManager.find(Parent.class, theId);
        entityManager.remove(dbparent);
    }



}
