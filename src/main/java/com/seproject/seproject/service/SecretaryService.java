package com.seproject.seproject.service;

import com.seproject.seproject.model.Secretary;

import java.util.List;

public interface SecretaryService {

    public List<Secretary> findAll();

    public Secretary findById(int theId);

    public Secretary save(Secretary secretary);

    public void deleteSecretary(int theId) ;

}
