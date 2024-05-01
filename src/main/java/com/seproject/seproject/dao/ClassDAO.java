package com.seproject.seproject.dao;

import com.seproject.seproject.model.KinderClass;

import java.util.List;

public interface ClassDAO {

    public List<KinderClass> findAll();

    public KinderClass findById(int theId);

    public KinderClass save(KinderClass child);

    public void deleteClass(int theId) ;


}
