package com.seproject.seproject.controller;


import com.seproject.seproject.model.KinderClass;
import com.seproject.seproject.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/admin")
public class ClassController {

    private ClassService classService ;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //    return all class
    @GetMapping("/class")
    public List<KinderClass> findAll(){
        return  classService.findAll() ;
    }

    //Search about class with id
    @GetMapping("/class/{id}")
    public KinderClass findall(@PathVariable("id")int  theId){
        KinderClass dbClass = classService.findById( theId);
        if(dbClass == null){
            throw new RuntimeException("the Class with this id : " + theId +" not exist") ;
        }
        return  dbClass;
    }

    // Add class
    @PostMapping("/class")
    public  KinderClass addParent(@RequestBody KinderClass aClass){
        aClass.setId(0);
        KinderClass dbClass = classService.save(aClass) ;

        return  dbClass ;
    }

    // Update class
    @PutMapping("/class")
    public  KinderClass updateParent(@RequestBody KinderClass aclass){
        KinderClass dbClass = classService.save(aclass) ;

        return  dbClass ;
    }


    //    delete class

    @DeleteMapping("/class/{id}")
    public String delete(@PathVariable("id") int theId) {
        KinderClass aClass = classService.findById(theId);
        if (aClass == null) {
            throw new RuntimeException("Class with ID " + theId + " not found.");
        }
        classService.deleteClass(theId);
        return "Class with ID " + theId + " deleted successfully.";
    }

}
