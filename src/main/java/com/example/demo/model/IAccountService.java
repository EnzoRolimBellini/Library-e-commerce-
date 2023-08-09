package com.example.demo.model;


import java.util.List;
import java.util.UUID;


public interface IAccountService {
	List<Account> find();

	
	Account create( Account account);
	void update(UUID id, String name, String email, String phone, String password, String newPassword);
	void delete(UUID id);
}
