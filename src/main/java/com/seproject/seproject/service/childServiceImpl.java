package com.seproject.seproject.service;

import com.seproject.seproject.dao.ChildDAO;
import com.seproject.seproject.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class childServiceImpl implements ChildService {

    ChildDAO childDAO ;

    @Autowired
    public childServiceImpl(ChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    @Override
    public List<Child> findAll() {
        return childDAO.findAll();
    }

    @Override
    public Child findById(int theId) {
        return childDAO.findById(theId);
    }

    @Transactional
    @Override
    public Child save(Child child) {
        return childDAO.save(child);
    }
    @Transactional
    @Override
    public void deleteChild(int theId) {
      childDAO.deleteChild(theId);
    }
}
