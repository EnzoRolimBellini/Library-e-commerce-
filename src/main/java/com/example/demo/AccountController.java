package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/digital-book")
public class AccountController {
  
	@Autowired
	AccountService accountService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto){
		
		return null;
		
	}
	
}
