package com.seproject.seproject.service;
import com.seproject.seproject.model.KinderClass;

import java.util.List;

public interface ClassService {

    public List<KinderClass> findAll();

    public KinderClass findById(int theId);

    public KinderClass save(KinderClass child);

    public void deleteClass(int theId) ;


}
