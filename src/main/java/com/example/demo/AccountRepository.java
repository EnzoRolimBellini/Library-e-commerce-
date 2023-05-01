package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
	
	List<Account> findAllByOrderByIdAsc(); 
}
