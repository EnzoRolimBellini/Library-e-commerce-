package com.example.demo;


import com.example.demo.model.Genre;

public class AccountBookValidation {
    
    
    private String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private String regexName = "^[a-zA-Z\\s]+$";
	private String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$";
	private String regexPhone = ".{9,}"; 
	private String regexDate = " ^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private Boolean validation;
   
    public boolean accountverification(String name, String email, String password, String phone, double balance) {
    	
    	
    	if(name.matches(regexName) && email.matches(regexEmail) && password.matches(regexPassword) && phone.matches(regexPhone) && balance >= 0) {
    	     this.validation = true;	
    	}else {
    		 this.validation = false;
    	}
    	
    	return validation;
    }
    
    public boolean bookverification(int numberPages, String author, Genre genre, String editor, String date, double price, String title) {
    	if(numberPages > 0 && author.matches(regexName) && genre != null && editor.matches(regexName) && date.matches(regexDate) && price > 0 && title.matches(regexName) && !title.isBlank() ) {
    		this.validation = true;
    	}else {
    		this.validation = false;
    	}
    	
    	return validation;
    }
}
