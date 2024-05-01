package com.seproject.seproject.service;


import com.seproject.seproject.model.HomeWork;

import java.util.List;

public interface HomeWorkService {

    public List<HomeWork> findAll();

    public HomeWork findById(int theId);

    public HomeWork save(HomeWork homeWork);

    public void deleteHomeWork(int theId) ;

}
