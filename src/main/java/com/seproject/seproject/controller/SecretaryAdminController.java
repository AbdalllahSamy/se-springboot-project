package com.seproject.seproject.controller;

import com.seproject.seproject.model.Secretary;
import com.seproject.seproject.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class SecretaryAdminController {
    private SecretaryService secretaryService;

    @Autowired
    public SecretaryAdminController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

//    return all teacher

    @GetMapping("/secretary")
    public List<Secretary> findAll(){
        return  secretaryService.findAll() ;
    }

//Search about teacher with id

    @GetMapping("/secretary/{id}")
    public Secretary findall(@PathVariable("id")int  theId){
        Secretary dbSecretary = secretaryService.findById( theId);
        if(dbSecretary == null){
            throw new RuntimeException("the Secretary with this id : " + theId +" not exist") ;
        }
        return  dbSecretary;
    }

// Add teacher

    @PostMapping("/secretary")
    public  Secretary addTeacher(@RequestBody Secretary secretary){
        secretary.setId(0);
        Secretary dbSecretary = secretaryService.save(secretary) ;

        return  dbSecretary ;
    }

//    Ubdate teacher

    @PutMapping("/secretary")
    public Secretary update(@RequestBody Secretary secretary){
        Secretary dbSecretary = secretaryService.save(secretary);
        return  dbSecretary ;
    }

    // Delete Teacher

    @DeleteMapping("/secretary/{id}")
    public  String  delete(@PathVariable("id") int theId){
        Secretary emp = secretaryService.findById(theId);
        if(emp == null){
            throw new RuntimeException("already not exist" + theId);
        }
        secretaryService.deleteSecretary(theId);
        return "deleted done " + theId ;
    }



}
