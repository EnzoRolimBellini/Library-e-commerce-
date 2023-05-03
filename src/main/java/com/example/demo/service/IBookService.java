package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Book;


public interface IBookService {
    List<Book> find();
    
    Book save(Book book);
    void update(UUID idBook ,int numberPages, String author, String editor, LocalDateTime registrationDate, double price, String title);
    void delete(UUID idBook);
}
