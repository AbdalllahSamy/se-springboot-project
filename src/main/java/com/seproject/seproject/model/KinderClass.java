package com.seproject.seproject.model;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Table(name = "class") // "class" is a reserved keyword in Java, so use backticks in MySQL or choose a different table name
public class KinderClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subjects")
    private String subject;

    @Column(name = "level")
    private String level;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    // Constructors

    public KinderClass() {
    }

    public KinderClass(String subject, Teacher teacher, String name, String level) {
        this.subject = subject;
        this.teacher = teacher;
        this.name = name;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // toString() method

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
