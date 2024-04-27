package com.seproject.seproject.controller;

import com.seproject.seproject.model.Teacher;
import com.seproject.seproject.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerRestController {

   private ManagerService managerService;
   @Autowired
    public ManagerRestController(ManagerService managerService) {
    this.managerService = managerService;
}

    @GetMapping("/admin/searchForTeacher/{id}")
    public Teacher getTeacherById(@PathVariable int id){
        Teacher theTeacher =managerService.getTeacherById(id);
        return theTeacher;
    }
    @GetMapping("/admin/searchForTeachers/{name}")
     public List<Teacher>getTeacherByName(@PathVariable String name){
        return managerService.getTeacherByName(name);
     }
}
