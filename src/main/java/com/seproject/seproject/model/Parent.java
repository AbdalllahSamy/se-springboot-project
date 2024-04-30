package com.seproject.seproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="parent")
public class Parent extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Child child;


    public Parent() {
    }

    public Parent(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
