package com.seproject.seproject.controller;

import com.seproject.seproject.model.Event;
import com.seproject.seproject.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class EventController  {

    private EventService eventService ;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //    return all homework
    @GetMapping("/event")
    public List<Event> findAll(){
        return  eventService.findAll() ;
    }


    //Search about class with id
    @GetMapping("/event/{id}")
    public Event findall(@PathVariable("id")int  theId){
        Event dbEvent = eventService.findById( theId);
        if(dbEvent == null){
            throw new RuntimeException("the Event with this id : " + theId +" not exist") ;
        }
        return dbEvent;
    }



    // Add homework
    @PostMapping("/event")
    public  Event addParent(@RequestBody Event event){
        event.setId(0);
        Event event1 = eventService.save(event) ;

        return  event1 ;
    }


    // Update homework
    @PutMapping("/event")
    public  Event updateParent(@RequestBody Event event){
        Event dbEvent = eventService.save(event) ;

        return  dbEvent ;
    }



    //    delete homework

    @DeleteMapping("/event/{id}")
    public String delete(@PathVariable("id") int theId) {
        Event event = eventService.findById(theId);
        if (event == null) {
            throw new RuntimeException("Event with ID " + theId + " not found.");
        }
        eventService.deleteEvent(theId);
        return "Event with ID " + theId + " deleted successfully.";
    }
}
