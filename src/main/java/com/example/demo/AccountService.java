package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class AccountService implements IAccountService {
	
	AccountCreation ca = new AccountCreation();
	
	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> find() {
		return	repository.findAllByOrderByIdAsc();
	}

	@Override
	public Account create(Account a, String name, String email, String password, String phone) {
		a = ca.AccountCreation(name, email, password, phone);
		return repository.save(a);
	}

	

	@Override
	public void update(Integer id, String name, String email, String phone, String password, String newPassword) {
		
		Optional<Account>containAccountValue =  repository.findById(id); 
		
		if(containAccountValue.isPresent()) {
			Account a = containAccountValue.get();
			if(a.getPassword() == password) {
				if(a.verifyName(name) || name != null || name != a.getName())  {
					repository.save(a);
				}
				if(a.verifyEmail(email) || email != null || email != a.getEmail()) {
					repository.save( a);
				}
			
				if(a.verifyPhone(phone) || phone != null || phone != a.getPhone()) {
					repository.save(a);
				}
			
				if(a.verifyPassword(newPassword) || newPassword != null || newPassword != a.getPassword()) {
					repository.save(a);
				}
			}else {
				throw new RuntimeException("A senha informada está incorreta");
			}
			
		}else {
		  throw new RuntimeException("Não há nenhuma conta");
		}
		 
		
			
	}

	@Override
	public void delete(int id) {
		 repository.deleteById(id);
	}
	
}
