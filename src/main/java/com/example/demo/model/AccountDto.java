package com.example.demo.model;


import jakarta.validation.constraints.NotBlank;

public class AccountDto {
	 
	 @NotBlank	
	 private String name;
	 @NotBlank	
	 private String email;
	 @NotBlank	
	 private String password;
	 @NotBlank	
	 private double balance;
	 @NotBlank	
	 private String phone; 
}
