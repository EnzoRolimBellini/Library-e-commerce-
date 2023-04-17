package com.example.demo;

import java.util.List;
import com.example.demo.model.Book;
import com.example.demo.model.Genre;

public interface IBookService {
    List<Book> find();
    
    Book create(int numberPages, String author, Genre genre, String editor, String date, double price, String title);
    void update();
    void delete(int id);
}
