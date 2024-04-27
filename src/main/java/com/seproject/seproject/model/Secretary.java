package com.seproject.seproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="secretary")
public class Secretary extends Person{

   
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Secretary() {
    }
//Constructor
   
//    Setter & getter


  
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
