package com.seproject.seproject.service;

import com.seproject.seproject.dao.EventDAO;
import com.seproject.seproject.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    private EventDAO eventDAO;
    @Autowired
    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    @Override
    public Event findById(int theId) {
        return eventDAO.findById(theId);
    }

    @Override
    public Event save(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public void deleteEvent(int theId) {
    eventDAO.deleteEvent(theId);
    }
}
