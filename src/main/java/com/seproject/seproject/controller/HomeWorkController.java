package com.seproject.seproject.controller;


import com.seproject.seproject.model.HomeWork;
import com.seproject.seproject.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class HomeWorkController {

    private HomeWorkService homeWorkService ;

    @Autowired
    public HomeWorkController(HomeWorkService homeWorkService) {
        this.homeWorkService = homeWorkService;
    }


    //    return all homework
    @GetMapping("/homework")
    public List<HomeWork> findAll(){
        return  homeWorkService.findAll() ;
    }


    //Search about class with id
    @GetMapping("/homework/{id}")
    public HomeWork findall(@PathVariable("id")int  theId){
        HomeWork dbhomework = homeWorkService.findById( theId);
        if(dbhomework == null){
            throw new RuntimeException("the HomeWork with this id : " + theId +" not exist") ;
        }
        return dbhomework;
    }



    // Add homework
    @PostMapping("/homework")
    public  HomeWork addParent(@RequestBody HomeWork homeWork){
        homeWork.setId(0);
        HomeWork homeWork1 = homeWorkService.save(homeWork) ;

        return  homeWork1 ;
    }


    // Update homework
    @PutMapping("/homework")
    public  HomeWork updateParent(@RequestBody HomeWork homeWork){
        HomeWork dbHomework = homeWorkService.save(homeWork) ;

        return  dbHomework ;
    }



    //    delete homework

    @DeleteMapping("/homework/{id}")
    public String delete(@PathVariable("id") int theId) {
        HomeWork homeWork = homeWorkService.findById(theId);
        if (homeWork == null) {
            throw new RuntimeException("Homework with ID " + theId + " not found.");
        }
        homeWorkService.deleteHomeWork(theId);
        return "Homework with ID " + theId + " deleted successfully.";
    }
}
