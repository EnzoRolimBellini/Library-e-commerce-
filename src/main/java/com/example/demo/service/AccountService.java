package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService implements IAccountService {
	
    private AccountBookValidation av = new AccountBookValidation();
   
	
	@Autowired
	AccountRepository repository;


	@Override
	public List<Account> find() {
		return	repository.findAllByOrderByIdAsc();
	}

	@Override
	public Account create(Account account) {
		boolean value = av.accountValidation(account);
		
		if(!value) {
			throw new IllegalArgumentException("Os valores postos para criar a conta não são válidos");
		}
		return repository.save(account);
	}

	

	@Override
	public void update(UUID id, String name, String email, String phone, String password, String newPassword) {
		
		Optional<Account> containAccountValue =  repository.findById(id); 
		
		if(containAccountValue.isPresent()) {
			Account a = containAccountValue.get();
			if(a.getPassword() == password) {
			
				if(a.verifyName(name) &&  name != a.getName())  {
					 repository.save(a);
				}else {
				     throw  new IllegalArgumentException();
				}
				if(a.verifyEmail(email) && email != a.getEmail()) {
					 repository.save( a);
				}else {
					 throw  new IllegalArgumentException();
				}
			
				if(a.verifyPhone(phone)  &&  phone != a.getPhone()) {
					repository.save(a);
				}else {
					 throw  new IllegalArgumentException();
				}
			
				if(a.verifyPassword(newPassword) && newPassword != a.getPassword()) {
					repository.save(a);
				}else {
					 throw  new IllegalArgumentException();
				}
			}else {
				throw new RuntimeException("A senha informada está incorreta");
			}
			
		}else {
		  throw new RuntimeException("Não há nenhuma conta");
		}
		 
		
			
	}

	@Override
	public void delete(UUID id) {
		 repository.deleteById(id);
	}
	
}
