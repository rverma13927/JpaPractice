package com.example.JpaPractice.Controller;


import com.example.JpaPractice.Dto.StudentDto;
import com.example.JpaPractice.Model.Courses;
import com.example.JpaPractice.Model.Student;
import com.example.JpaPractice.Repository.CourseRepo;
import com.example.JpaPractice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepo courseRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<Student> getAllStudent() {
        System.out.println(studentRepository.count());
        return studentRepository.findAll();
    }


    @PostMapping("/save")
    Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/{id}")
    StudentDto getStudent(@PathVariable("id") Integer id) {

        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());

        Set<String> s = new HashSet<>();
        Iterator<Courses> it = student.getCourses().iterator();
        while(it.hasNext()){
            String result = it.next().getCourseName();
            if(result!=null)
            s.add(result);
        }

        studentDto.setCourses(s);
        return  studentDto;
    }

    // post vs put
    @PostMapping("/modifyStudent")
    Student modifyStudent(@RequestBody Student student) {
        Student student_ = studentRepository.findById(student.getId()).get();
        student_.setFirstName(student.getFirstName());
        student_.setLastName(student.getLastName());
        return  studentRepository.save(student_);
//        return  studentRepository.update(student_.getFirstName(),student.getLastName());
    }
    @PostMapping("/update")
    void updateStudent(@RequestBody Student student) {
        Student student_ = studentRepository.findById(student.getId()).get();
        student_.setFirstName(student.getFirstName());
        student_.setLastName(student.getLastName());
        //return  studentRepository.save(student_);
        studentRepository.update(student_.getFirstName(),student.getLastName());
    }

    @GetMapping("/addCourse/{id}/{course_id}")
    void addCourse(@PathVariable("id") Integer id, @PathVariable("course_id") Integer course_id){
        Student student = studentRepository.findById(id).get();
        Courses courses = new Courses();
        courses.setId(course_id);
        student.getCourses().add(courses);
        studentRepository.save(student);
       // Courses courses = courseRepo.findById(course_id).get();
       // student.setCourses((Set<Courses>) courses);

    }

    @GetMapping("/dum")
    void dum(){
//        Query select_student_from_student = entityManager.createQuery("Select Student from Student");
//        List<Student> resultList = (List<Student>)select_student_from_student.getResultList();
        Student integer = studentRepository.getsty();
        System.out.println(integer);
        Iterator<Courses> it = integer.getCourses().iterator();
        while(it.hasNext()){
            System.out.println(it.next().getCourseName());
        }
    }
    @PostMapping("addCourse")
    void addCourse(@RequestBody Courses courses){
        courseRepo.save(courses);
    }



}
