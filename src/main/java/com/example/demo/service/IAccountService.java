package com.example.demo.service;


import java.util.List;
import java.util.UUID;

import com.example.demo.model.Account;


public interface IAccountService {
	List<Account> find();

	
	Account create( Account account);
	void update(UUID id, String name, String email, String phone, String password, String newPassword);
	void delete(UUID id);
}
