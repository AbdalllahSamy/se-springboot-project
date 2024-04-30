package com.seproject.seproject.service;

import com.seproject.seproject.model.Event;

import java.util.List;

public interface EventService {

    public List<Event> findAll();

    public Event findById(int theId);

    public Event save(Event event);

    public void deleteEvent(int theId) ;


}
