package com.seproject.seproject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;

    @Column(name = "publisher_id")
    private int publisher_id;

    //constructors


    public Event() {

    }

    public Event(Date date, String content, String type, int publisher_id) {
        this.date = date;
        this.content = content;
        this.type = type;
        this.publisher_id = publisher_id;
    }

    //getters and setters

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
