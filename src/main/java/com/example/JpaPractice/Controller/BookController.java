package com.example.JpaPractice.Controller;

import com.example.JpaPractice.Model.Book;
import com.example.JpaPractice.Model.Student;
import com.example.JpaPractice.Repository.BookRepo;
import com.example.JpaPractice.Repository.CourseRepo;
import com.example.JpaPractice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepo courseRepo;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;
    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    List<Student> getAllBook() {
        System.out.println(studentRepository.count());
        return studentRepository.findAll();
    }

    @PostMapping("/add/{bookName}")
    void addBook(@PathVariable("bookName") String bookName) {
        Book book = new Book();
        book.setBookName(bookName);
        bookRepo.save(book);
    }

    @PostMapping("/add/{studentId}/{bookId}")
    void addBookToStudent(@PathVariable("studentId") Integer studentId, @PathVariable("bookId") Integer bookId) {
            //Student student = studentRepository.findById(studentId).get();
            Student student = new Student();
            student.setId(studentId);
            Book book = bookRepo.findById(bookId).get();
            book.setStudents(student);
            bookRepo.save(book);
    }

}
