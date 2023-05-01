package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
	
    List<Book> findAllByOrderIdAsc();
    
}
