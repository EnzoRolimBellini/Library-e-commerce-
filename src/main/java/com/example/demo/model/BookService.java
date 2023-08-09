package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
	
	
	
    
	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> find() {
		return repository.findAllByOrderIdAsc();
	}

	@Override
	public Book save(Book book) {
		
		return repository.save(book);
	}

	@Override
	public void update(UUID idBook,int numberPages, String author, String editor, LocalDateTime registrationDate, double price, String title ) {
		
	}

	@Override
	public void delete(UUID idBook) {
		
		repository.deleteById(idBook);
		
	}
    
}
