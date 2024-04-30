package com.seproject.seproject.controller;


import com.seproject.seproject.model.Parent;
import com.seproject.seproject.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ParentController {

    private ParentService parentService ;
    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    //    return all teacher
    @GetMapping("/parent")
    public List<Parent> findAll(){
        return  parentService.findAll() ;
    }

    //Search about teacher with id
    @GetMapping("/parent/{id}")
    public Parent findall(@PathVariable("id")int  theId){
        Parent dbParent = parentService.findById( theId);
        if(dbParent == null){
            throw new RuntimeException("the Parent with this id : " + theId +" not exist") ;
        }
        return  dbParent;
    }

// Add Parent
    @PostMapping("/parent")
    public  Parent addParent(@RequestBody Parent parent){
        parent.setId(0);
        Parent dbParent = parentService.save(parent) ;

        return  dbParent ;
    }


    // Update Parent
    @PutMapping("/parent")
    public  Parent updateParent(@RequestBody Parent parent){
        Parent dbParent = parentService.save(parent) ;

        return  dbParent ;
    }


//    delete parent

    @DeleteMapping("/parent/{id}")
    public String delete(@PathVariable("id") int theId) {
        Parent parent = parentService.findById(theId);
        if (parent == null) {
            throw new RuntimeException("Parent with ID " + theId + " not found.");
        }
        parentService.deleteParent(theId);
        return "Parent with ID " + theId + " deleted successfully.";
    }




}
