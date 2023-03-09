package com.example.demo;

import com.example.demo.model.Account;

public class AccountCreation  {
	private Account a;
	
	public Account  AccountCreation(String name, String email, String password, String phone) {
		if(name != null && email != null && password != null && phone != null) {
		a = new Account();
		a.setName(name);
		a.setEmail(email);
		a.setPassword(password);
		a.setPhone(phone);
		}else {
			System.out.println("Os campos estão nulos ou não prencheram os requisitos ");
		}
		return a;
	}
}
