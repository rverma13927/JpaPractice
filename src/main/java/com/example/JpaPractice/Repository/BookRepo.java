package com.example.JpaPractice.Repository;

import com.example.JpaPractice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
