package com.example.JpaPractice.Dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

@Repository
public class DaoOfAll {
    @PersistenceContext
    private EntityManager entityManager;
//   private List<String> coursesOptByStudent(Integer id){
//       // Query query = entityManager.createNativeQuery("select c.course_name from courses c join student s on s.id=")
//    }

}
