package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Book;
import com.example.demo.model.Genre;

public interface IBookService {
    List<Book> find();
    
    Book create(Book book);
    void update(UUID idBook ,int numberPages, String author, Genre genre, String editor, LocalDateTime registrationDate, double price, String title);
    void delete(UUID idBook);
}
