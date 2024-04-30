package com.seproject.seproject.dao;

import com.seproject.seproject.model.Child;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChildDAOImpl implements ChildDAO {

    private EntityManager entityManager ;

    public ChildDAOImpl() {
    }

    @Autowired
    public ChildDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Child> findAll() {
        TypedQuery<Child> thequery = entityManager.createQuery("from Child", Child.class);
        List<Child> childrens = thequery.getResultList();
        return childrens;
    }




    @Override
    public Child findById(int theId) {
        Child child = entityManager.find(Child.class,theId);
       return child ;
    }

    @Override
    public Child save(Child aclass) {
        Child theChild = entityManager.merge(aclass);
        return theChild;
    }

    @Override
    public void deleteChild(int theId) {
        Child dbChild = entityManager.find(Child.class, theId);
        entityManager.remove(dbChild);
    }
}
