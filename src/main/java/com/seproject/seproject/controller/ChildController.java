package com.seproject.seproject.controller;


import com.seproject.seproject.model.Child;
import com.seproject.seproject.service.ChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ChildController {

    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    //    return all child
    @GetMapping("/child")
    public List<Child> findAll(){
        return  childService.findAll() ;
    }


    //Search about Child with id
    @GetMapping("/child/{id}")
    public Child findall(@PathVariable("id")int  theId){
        Child dbChild = childService.findById( theId);
        if(dbChild == null){
            throw new RuntimeException("the Child with this id : " + theId +" not exist") ;
        }
        return  dbChild;
    }


    // Add Child
    @PostMapping("/child")
    public  Child addParent(@RequestBody Child child){
        child.setId(0);
        Child dbChild = childService.save(child) ;

        return  dbChild ;
    }


    // Update Child
    @PutMapping("/child")
    public  Child updateParent(@RequestBody Child child){
        Child dbChild = childService.save(child) ;

        return  dbChild ;
    }



//    delete child

    @DeleteMapping("/child/{id}")
    public String delete(@PathVariable("id") int theId) {
        Child child = childService.findById(theId);
        if (child == null) {
            throw new RuntimeException("Child with ID " + theId + " not found.");
        }
        childService.deleteChild(theId);
        return "Child with ID " + theId + " deleted successfully.";
    }


}
