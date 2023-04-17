package com.example.demo;

import java.util.List;
import com.example.demo.model.Account;
import com.example.demo.model.Book;

public interface IAccountService {
	List<Account> find();

	
	Account create( String name, String email, String password, double balance, String phone);
	void update(Integer id, String name, String email, String phone, String password, String newPassword);
	void delete(int id);
}
