package com.seproject.seproject.service;




import com.seproject.seproject.model.Parent;

import java.util.List;

public interface ParentService {
    public List<Parent> findAll();

    public Parent findById(int theId);

    public Parent save(Parent parent);

    public void deleteParent(int theId);


}
