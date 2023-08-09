package com.example.demo.model;


import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name= "Account")
public class Account {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_account")
	 private UUID idAccount;
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	 @JoinTable(name = "accounts_books_table",
	            joinColumns = {@JoinColumn(name = "accounts_id", referencedColumnName = "id_account" )},
	            inverseJoinColumns = {@JoinColumn(name = "books_id", referencedColumnName = "id_book")}
               )	           
	 private Set<Book> arrayBooks;
	 @Column(name = "name", nullable = true)
	 private String name;
	 @Column(name ="email", nullable = true)
	 private String email; 
	 @Column(name="password", nullable = true)
	 private String password;
	 @Column(name = "balance", nullable = true)
	 private double balance;
	 @Column(name ="phone", nullable = true)
	 private String phone; 
	 @Column(name = "date", nullable = true)
	 private LocalDateTime registrationDate;
	 
	 
	public UUID getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(UUID idAccount) {
		this.idAccount = idAccount;
	}
	
	public Set<Book> getArrayBooks() {
		return arrayBooks;
	}
	public void setArrayBooks(Set<Book> arrayBooks) {
		this.arrayBooks = arrayBooks;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	 
	
}
