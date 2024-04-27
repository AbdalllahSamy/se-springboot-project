package com.seproject.seproject.service;

import com.seproject.seproject.dao.ManagerDAO;
import com.seproject.seproject.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
   private ManagerDAO managerDAO;

@Autowired
public ManagerService(ManagerDAO managerDAO) {
    this.managerDAO = managerDAO;
}
  public Teacher getTeacherById(int id){
    Teacher theTeacher =managerDAO.getTeacherById(id);
    return theTeacher;
  }
  public List<Teacher> getTeacherByName(String name){
    List<Teacher> theTeacher =managerDAO.getTeachersByName(name);
    return theTeacher;
  }
}
