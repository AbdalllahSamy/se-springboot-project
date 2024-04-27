package com.seproject.seproject.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Person {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name") // Updated to match the column name in the database
    private String firstName;
    @Column(name = "last_name") // Updated to match the column name in the database
    private String lastName;
    @Column(name = "bio")
    private String bio;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "country")
    private String country;


        //getters and setters

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getBio() {
            return bio;
        }
        public void setBio(String bio) {
            this.bio = bio;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }

        
}
