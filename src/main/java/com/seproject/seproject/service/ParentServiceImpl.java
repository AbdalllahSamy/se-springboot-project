package com.seproject.seproject.service;


import com.seproject.seproject.dao.ParentDAO;
import com.seproject.seproject.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ParentServiceImpl implements  ParentService{


   private ParentDAO parentDAO ;


@Autowired
    public ParentServiceImpl(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }


    @Override
    public List<Parent> findAll() {
        return parentDAO.findAll();
    }

    @Override
    public Parent findById(int theId) {
        return parentDAO.findById(theId);
    }

    @Transactional
    @Override
    public Parent save(Parent parent) {
        return parentDAO.save(parent);
    }
@Transactional
    @Override
    public void deleteParent(int theId) {
        parentDAO.deleteParent(theId);
    }

}
