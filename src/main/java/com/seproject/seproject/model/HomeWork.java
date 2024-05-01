package com.seproject.seproject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "homework")
public class HomeWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "date")
    private Date date;

    @Column(name = "content")
    private String content;

    @Column(name = "level")
    private String level;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;
//

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private KinderClass aClass;

    // Constructors, getters, and setters


    public HomeWork() {
    }

    public HomeWork(int id, String subject, Date date, String content,
                    String level, Teacher teacher, KinderClass aClass) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.content = content;
        this.level = level;
        this.teacher = teacher;
        this.aClass = aClass;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public KinderClass getaClass() {
        return aClass;
    }

    public void setaClass(KinderClass aClass) {
        this.aClass = aClass;
    }
}
