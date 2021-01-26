//package com.example.JpaPractice.Repository;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.Entity;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//public class CoursesEnroll {
//    @Column(name = "student_id")
//    Integer studentId;
//
//    @Column(name = "course_id")
//    Integer courseId;
//
//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CoursesEnroll that = (CoursesEnroll) o;
//        return Objects.equals(studentId, that.studentId) &&
//                Objects.equals(courseId, that.courseId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(studentId, courseId);
//    }
//}
