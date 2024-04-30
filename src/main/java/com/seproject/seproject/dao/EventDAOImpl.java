package com.seproject.seproject.dao;

import com.seproject.seproject.model.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO{


    private EntityManager entityManager ;

    @Autowired
    public EventDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Event> findAll() {
        TypedQuery<Event> thequery = entityManager.createQuery("from Event", Event.class);
        List<Event> events = thequery.getResultList();
        return events ;
    }

    @Override
    public Event findById(int theId) {
        Event event = entityManager.find(Event.class,theId);
        return event ;
    }

    @Override
    public Event save(Event event) {
        Event event1 = entityManager.merge(event);
        return event1;
    }

    @Override
    public void deleteEvent(int theId) {
        Event event = entityManager.find(Event.class, theId);
        entityManager.remove(event);
    }
}
