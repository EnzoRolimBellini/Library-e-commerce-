package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.model.Book;
import com.example.demo.model.Genre;

@Service
public class BookService implements IBookService {
	
	
	
    
	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> find() {
		return repository.findAllByOrderIdAsc();
	}

	@Override
	public Book create(Book book) {
		
		AccountBookValidation av = new AccountBookValidation();
		boolean value = av.bookValidation(book);
		if(!value) {
			throw new IllegalArgumentException();
		} 
		return repository.save(book);
	}

	@Override
	public void update(UUID idBook,int numberPages, String author, Genre genre, String editor, LocalDateTime registrationDate, double price, String title ) {
			Optional<Book> containBookValue = repository.findById(idBook);

		
		
	}

	@Override
	public void delete(UUID idBook) {
		
		repository.deleteById(idBook);
		
	}
    
}
