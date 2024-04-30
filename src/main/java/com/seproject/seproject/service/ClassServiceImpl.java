package com.seproject.seproject.service;

import com.seproject.seproject.dao.ClassDAO;
import com.seproject.seproject.model.KinderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClassServiceImpl implements  ClassService{

    ClassDAO classDAO ;


    @Autowired
    public ClassServiceImpl(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }



    @Override
    public List<KinderClass> findAll() {
        return classDAO.findAll();
    }

    @Override
    public KinderClass findById(int theId) {
        return classDAO.findById(theId);
    }

    @Override
    @Transactional
    public KinderClass save(KinderClass aclass) {
        return classDAO.save(aclass);
    }

    @Override
    @Transactional
    public void deleteClass(int theId) {
   classDAO.deleteClass(theId);
    }
}
