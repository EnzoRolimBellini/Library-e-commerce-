package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AccountService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/digital-book")
public class AccountController {
  
	@Autowired
	AccountService service;
	
}
