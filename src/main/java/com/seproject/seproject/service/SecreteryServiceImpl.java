package com.seproject.seproject.service;

import com.seproject.seproject.dao.SecretaryDAO;
import com.seproject.seproject.model.Secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SecreteryServiceImpl implements SecretaryService{

    private SecretaryDAO secretaryDAO ;

    public SecreteryServiceImpl() {
    }

    @Autowired
    public SecreteryServiceImpl(SecretaryDAO secretaryDAO) {
        this.secretaryDAO = secretaryDAO;
    }


    @Override
    public List<Secretary> findAll() {

        return secretaryDAO.findAll();
    }

    @Override
    public Secretary findById(int theId) {
        return secretaryDAO.findById(theId);
    }
@Transactional
    @Override
    public Secretary save(Secretary secretary) {
        return secretaryDAO.save(secretary);
    }

@Transactional
    @Override
    public void deleteSecretary(int theId) {
        secretaryDAO.deleteSecretary(theId);
    }
}
