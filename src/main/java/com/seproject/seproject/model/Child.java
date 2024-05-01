package com.seproject.seproject.model;

import jakarta.persistence.*;
@Entity
@Table(name = "child")
public class Child  extends Person {

    @Column(name = "level")
    private String level;

    @Column(name = "subjects")
    private String subject;

    @Column(name = "rate")
    private String rate;



    @Column(name = "behavior")
    private String behaviour;


    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private KinderClass aClass;


//    @Column(name = "classId")
//    private String classId;


    public Child() {
    }


    public KinderClass getaClass() {
        return aClass;
    }

    public void setaClass(KinderClass aClass) {
        this.aClass = aClass;
    }




    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
