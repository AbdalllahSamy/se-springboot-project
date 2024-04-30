package com.seproject.seproject.service;


import com.seproject.seproject.dao.HomeWorkDAO;
import com.seproject.seproject.model.HomeWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class HomeWorkServiceImpl implements HomeWorkService{

   private HomeWorkDAO homeWorkDAO ;

   @Autowired
    public HomeWorkServiceImpl(HomeWorkDAO homeWorkDAO) {
        this.homeWorkDAO = homeWorkDAO;
    }


    @Override
    public List<HomeWork> findAll() {
        return homeWorkDAO.findAll();
    }

    @Override
    public HomeWork findById(int theId) {
        return homeWorkDAO.findById(theId);
    }
    @Transactional

    @Override
    public HomeWork save(HomeWork homeWork) {
        return homeWorkDAO.save(homeWork);
    }
@Transactional
    @Override
    public void deleteHomeWork(int theId) {
     homeWorkDAO.deleteHomeWork(theId);
    }
}
