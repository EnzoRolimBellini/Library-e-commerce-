package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public interface IBookService {
    List<Book> find();
    
    Book save(Book book);
    void update(UUID idBook ,int numberPages, String author, String editor, LocalDateTime registrationDate, double price, String title);
    void delete(UUID idBook);
}
