package com.seproject.seproject.dao;


import com.seproject.seproject.model.HomeWork;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HomeWorkDAOImpl implements HomeWorkDAO {

    private EntityManager entityManager ;

    @Autowired
    public HomeWorkDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<HomeWork> findAll() {
        TypedQuery<HomeWork> thequery = entityManager.createQuery("from HomeWork", HomeWork.class);
        List<HomeWork> homeWork = thequery.getResultList();
        return homeWork ;
    }

    @Override
    public HomeWork findById(int theId) {
        HomeWork homeWork = entityManager.find(HomeWork.class,theId);
        return homeWork ;
    }

    @Override
    public HomeWork save(HomeWork homeWork) {
        HomeWork homeWork1 = entityManager.merge(homeWork);
        return homeWork1;
    }

    @Override
    public void deleteHomeWork(int theId) {
        HomeWork homeWork = entityManager.find(HomeWork.class, theId);
        entityManager.remove(homeWork);
    }
}
