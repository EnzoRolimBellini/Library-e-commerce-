package com.example.demo;

import java.util.List;
import com.example.demo.model.Account;

public interface IAccountService {
	List<Account> find();
	
	Account create(Account account, String name, String email, String password, String phone);
	void update(Integer id, String name, String email, String phone, String password, String newPassword);
	void delete(int id);
}
