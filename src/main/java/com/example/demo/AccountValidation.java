package com.example.demo;



public class AccountValidation {
    
    private String name;
    private String email;
    private String password;
    private String phone;
    private String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private String regexName = "^[a-zA-Z\\s]+$";
	private String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$";
	private String regexPhone = ".{9,}";
    private Boolean validation;
    
    public boolean accountverification(String name, String email, String password, String phone) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.phone = phone;
    	
    	if(this.name.matches(regexName) && this.email.matches(regexEmail) && this.password.matches(regexPassword) && this.phone.matches(regexPhone)) {
    	     this.validation = true;	
    	}else {
    		 this.validation = false;
    	}
    	
    	return validation;
    }
}
