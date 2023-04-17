package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Genre;

@Service
public class BookService implements IBookService {
	
	private AccountBookValidation av = new AccountBookValidation();
    
	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> find() {
		return repository.findAllByOrderIdAsc();
	}

	@Override
	public Book create(int numberPages, String author, Genre genre, String editor, String date, double price, String title) {
		boolean value = av.bookverification(numberPages, author, genre, editor, date, price, title);
		if(value == false) {
			throw new RuntimeException("Os dados do livro não estão corretos");
		}
		Book book = new Book(numberPages, author, genre, editor, date, price, title);
		return repository.save(book);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		
		repository.deleteById(id);
		
	}
    
}
