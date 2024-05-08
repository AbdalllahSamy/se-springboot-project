package com.seproject.seproject.dao;

import com.seproject.seproject.model.Event;

import java.util.List;

public  interface EventDAO {

    public List<Event> findAll();

    public Event findById(int theId);

    public Event save(Event event);

    public void deleteEvent(int theId) ;

}
