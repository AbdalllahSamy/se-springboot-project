package com.seproject.seproject.controller;

import com.seproject.seproject.model.Teacher;
import com.seproject.seproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class TeacherAdminController {
    private TeacherService teacherService;

    @Autowired
    public TeacherAdminController(TeacherService theTeacherService) {
        this.teacherService = theTeacherService;
    }

//    return all teacher

    @GetMapping("/teacher")
    public List<Teacher> findAll(){
        return  teacherService.findAll() ;
    }

//Search about teacher with id

    @GetMapping("/teacher/{id}")
    public Teacher findall(@PathVariable("id")int  theId){
        Teacher dbteacher = teacherService.findById( theId);
        if(dbteacher == null){
            throw new RuntimeException("the teacher with this id : " + theId +" not exist") ;
//        System.out.println("emplyouee not excds");
        }
        return  dbteacher;
    }

// Add teacher

    @PostMapping("/teacher")
    public  Teacher addTeacher(@RequestBody Teacher teacher){
        teacher.setId(0);
        Teacher dbteacher = teacherService.save(teacher) ;

        return  dbteacher ;
    }

//    Ubdate teacher

    @PutMapping("/teacher")
    public Teacher update(@RequestBody Teacher theTeacher){
        Teacher dbTeacher = teacherService.save(theTeacher);
        return  dbTeacher ;
    }

    // Delete Teacher

    @DeleteMapping("/teacher/{id}")
    public  String  delete(@PathVariable("id") int theId){
        Teacher emp = teacherService.findById(theId);
        if(emp == null){
            throw new RuntimeException("already not exist" + theId);
        }
        teacherService.deleteTeacher(theId);
        return "deleted done " + theId ;
    }




}
