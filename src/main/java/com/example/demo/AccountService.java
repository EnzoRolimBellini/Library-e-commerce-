package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class AccountService implements IAccountService {
	
    private AccountValidation av = new AccountValidation();
	
	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> find() {
		return	repository.findAllByOrderByIdAsc();
	}

	@Override
	public Account create(Account a, String name, String email, String password, String phone) {
		boolean value = av.accountverification(name, email, password, phone);
		if(value == false) {
			throw new RuntimeException("Os valores postos para criar a conta não são válidos");
		}
		return repository.save(a);
	}

	

	@Override
	public void update(Integer id, String name, String email, String phone, String password, String newPassword) {
		
		Optional<Account>containAccountValue =  repository.findById(id); 
		
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
	public void delete(int id) {
		 repository.deleteById(id);
	}
	
}
