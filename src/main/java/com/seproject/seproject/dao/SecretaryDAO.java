package com.seproject.seproject.dao;


import com.seproject.seproject.model.Secretary;

import java.util.List;

public interface SecretaryDAO {

    public List<Secretary> findAll();

    public Secretary findById(int theId);

    public Secretary save(Secretary secretary);

    public void deleteSecretary(int theId) ;

}
