package com.seproject.seproject.dao;
import com.seproject.seproject.model.Child;

import java.util.List;

public interface ChildDAO {

    public List<Child> findAll();

    public Child findById(int theId);

    public Child save(Child child);

    public void deleteChild(int theId) ;

}
