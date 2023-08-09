package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountService {
	
    
   
	
	
	AccountRepository repository;
	
	@Autowired
	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Account> find() {
		return	repository.findAllByOrderByIdAsc();
	}

	@Override
	@Transactional
	public Account create(Account account) {
		return repository.save(account);
	}

	

	@Override
	public void update(UUID id, String name, String email, String phone, String password, String newPassword) {
			
	}

	@Override
	public void delete(UUID id) {
		 repository.deleteById(id);
	}
	
}
