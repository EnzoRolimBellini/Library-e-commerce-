package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Account")
public class AccountController {
	
	@GetMapping
	public String getString(){
		return "Hello World";
	}
	
}
