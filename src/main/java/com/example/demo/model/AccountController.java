package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
/*
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/digital-book")
public class AccountController {
  
	@Autowired
	AccountService accountService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto){
		var account = new Account();
		BeanUtils.copyProperties(accountDto, account);
		account.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(account));
		
	}
	
}
*/