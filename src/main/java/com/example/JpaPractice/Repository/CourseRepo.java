package com.example.JpaPractice.Repository;

import com.example.JpaPractice.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Courses,Integer> {

   @Query("select C FROM Courses C WHERE C.id=?1")
    List<Courses> findCourseById(Integer id);
}
