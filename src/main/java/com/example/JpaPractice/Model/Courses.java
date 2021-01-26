package com.example.JpaPractice.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Courses {

    private Integer id;
    private java.lang.String courseName;


    private Set<Student> students;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getCourseName() {
        return courseName;
    }

    public void setCourseName(java.lang.String courseName) {
        this.courseName = courseName;
    }
    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
