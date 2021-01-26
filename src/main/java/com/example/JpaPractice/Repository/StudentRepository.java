package com.example.JpaPractice.Repository;

import com.example.JpaPractice.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Modifying
    @Transactional
    @Query("update Student s set s.firstName=?1 , s.lastName=?2")
    void update(String firstName,String lastName);

    @Transactional
    @Query("select s from Student s where s.id =1")
    Student getsty();

}
