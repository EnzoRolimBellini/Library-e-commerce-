package com.example.demo.service;


import java.time.LocalDateTime;

import com.example.demo.model.Account;
import com.example.demo.model.Book;


public class AccountBookValidation {
    
    
    private String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private String regexName = "^[a-zA-Z\\s]+$";
	private String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$";
	private String regexPhone = ".{9,}"; 
    private Boolean validation;
   
   

	public  Boolean accountValidation(Account account) {
    	
    	
    	if(account.getName().matches(regexName) && account.getEmail().matches(regexEmail) && account.getPassword().matches(regexPassword) && account.getPhone().matches(regexPhone) && account.getBalance() >= 0) {
    	     this.validation = true;	
    	}else {
    		 this.validation = false;
    	}
    	
    	return validation;
    }
    
    public  Boolean bookValidation(Book book) {
    	if(book.getNumberPages() > 0 && book.getAuthor().matches(regexName) &&  book.getEditor().matches(regexName) && book.getPrice() > 0 && book.getTitle().matches(regexName) && !book.getTitle().isBlank() ) {
    		this.validation = true;
    	}else {
    		this.validation = false;
    	}
    	
    	return validation;
    }
}
