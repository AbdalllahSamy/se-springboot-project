package com.seproject.seproject.dao;


import com.seproject.seproject.model.KinderClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDAOImpl implements  ClassDAO{

  private  EntityManager entityManager ;

    public ClassDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public List<KinderClass> findAll() {
        TypedQuery<KinderClass> thequery = entityManager.createQuery("from KinderClass", KinderClass.class);
        List<KinderClass> classes = thequery.getResultList();
        return classes;
    }



    @Override
    public KinderClass findById(int theId) {
        KinderClass aClass = entityManager.find(KinderClass.class,theId);
        return aClass ;
    }


    @Override
    public KinderClass save(KinderClass acless) {
        KinderClass aClass = entityManager.merge(acless);
        return aClass;
    }


    @Override
    public void deleteClass(int theId) {
        KinderClass aClass = entityManager.find(KinderClass.class, theId);
        entityManager.remove(aClass);
    }
}
