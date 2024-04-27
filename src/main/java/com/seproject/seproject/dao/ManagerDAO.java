package com.seproject.seproject.dao;


import com.seproject.seproject.model.*;
import com.seproject.seproject.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDAO {
    //fields
    private EntityManager entityManager;

    //constructor
    @Autowired
    public ManagerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //functions
    public Teacher getTeacherById(int id){
        Teacher theTeacher =entityManager.find(Teacher.class, id);
        return theTeacher;
    }
    public List<Teacher> getTeachersByName(String name) {
        String query = "SELECT t FROM Teacher t WHERE t.firstName LIKE :name";
        //handle the name input
        String formattedName = name.replace(" ", "%");
        String formattedName2 = "%" + formattedName + "%";
    
        // Execute the query
        TypedQuery<Teacher> theQuery = entityManager.createQuery(query, Teacher.class);
        theQuery.setParameter("name", formattedName2);
        List<Teacher> teachers = theQuery.getResultList();
    
        return teachers;
    }
    
}
