package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
    List<Book> findAllByOrderIdAsc();
    
}