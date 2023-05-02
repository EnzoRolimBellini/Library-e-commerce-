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
	
	private AccountBookValidation av = new AccountBookValidation();
	
    
	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> find() {
		return repository.findAllByOrderIdAsc();
	}

	@Override
	public Book create(int numberPages, String author, Genre genre, String editor, LocalDateTime registrationDate, double price, String title) {
		boolean value = av.bookverification(numberPages, author, genre, editor, registrationDate, price, title);
		if(value == false) {
			throw new RuntimeException("Os dados do livro não estão corretos");
		}
		Book book = new Book();
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
