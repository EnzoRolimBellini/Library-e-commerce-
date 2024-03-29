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
	 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	 
}
