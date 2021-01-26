package com.example.JpaPractice.Dto;

import com.example.JpaPractice.Model.Courses;

import java.util.Set;

public class StudentDto {
    private Integer id;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private Set<String>courses;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }
}
