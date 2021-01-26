package com.example.JpaPractice.Model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    private Integer id;
    private String bookName;
    private Student students ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }
}
