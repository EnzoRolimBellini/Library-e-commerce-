package com.example.demo.model;

import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name ="idaccount")
	 private UUID idAccount;
	 @Column(name = "books_fk", length = 300)
	 @ManyToMany
	 @JoinTable(name = "accounts_books",
	            joinColumns = @JoinColumn(name = "accounts_fk", referencedColumnName = "idAccount" ),
	            inverseJoinColumns = @JoinColumn(name = "books_fk", referencedColumnName = "idBook")
               )	           
	 private List<Book> arrayBooks;
	 @Column(name = "name", nullable = false)
	 private String name;
	 @Column(name ="email", nullable = false, unique = true)
	 private String email;
	 @Column(name="password", nullable = false)
	 private String password;
	 @Column(name = "balance", nullable = false)
	 private double balance;
	 @Column(name ="phone", nullable = false, unique = true)
	 private String phone; 
	 @Column(name = "date", nullable = false)
	 private LocalDateTime registrationDate;
	 
	
	 // getters e setters
	
	public UUID getIdAccount() {
			return idAccount;
		}
	
	public void setAccount(UUID idAccount) {
		this.idAccount = idAccount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name) {
			this.name = name;
	}
	 
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		Boolean regexGmailCom = email.contains("@gmail.com");
		Boolean regexGmailComBr = email.contains("@gmail.com.br");
		
		 if(regexGmailCom || regexGmailComBr) {
			 this.email = email;
			 System.out.println("email correto");
		 }else {
			 System.out.println("Você não colocou a escrita do email de forma correta");
		 }
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		Boolean regexPassword = password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$");
		
		 if(regexPassword) {
			this.password = password;
			if(this.password == password) {
				System.out.println("Senha correta");
			}
	 }else {
		 System.out.println("Sua senha deu errado");
	  }
	} 
	 
	 
	 public String getPhone() {
		return phone;
	 }
	
	 public void setPhone(String phone) {
		 Boolean regexPhone = phone.matches(".{9,}");
		 
		 if(regexPhone) {
				this.phone = phone;
				System.out.println("Telefone correto");
			 }else {
				 System.out.println("Seu telefone tem que conter nove posições, nem mais nem menos");
			 }
	 }
	 
	 
	 public List<Book> getArrayBooks() {
			return arrayBooks;
		}   
	 

	 public void setArrayBooks(List<Book> arrayBooks) {
			this.arrayBooks = arrayBooks;
		}

	 public double getBalance() {
			return balance;
		}	

	 public void setBalance(double balance) {
			this.balance = balance;
		}	

	 public LocalDateTime getRegistrationDate() {
			return registrationDate;
		}

	 public void setRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
		}
	 
	 //fim dos metodos getters  e setters
	 
	// métodos de verificar valores
	 
	 
	public boolean verifyName(String name) {	
			Boolean newName = name.matches("[a-zA-Z]");
			if(newName) {
				this.name = name;
				return true;
			}else {
				throw  new RuntimeException("Seu nome só pode ter letras.");
			}
	} 
	
	

	public boolean verifyPassword(String password) {
		Boolean regexPassword = password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$");
		
				if(regexPassword) {
					this.password = password;
					return true;
				}else {
					System.out.println("A nova senha não é forte o suficiente.");
					return false;
				}
			}
			
	    	
			
		
		public boolean verifyPhone(String phone) {
			Boolean regexPhone = phone.matches(".{9,}");			
				if(regexPhone) {
					this.phone = phone;
					return true;
				}else {
					throw  new RuntimeException();
				}
			}
				
		
		
		public boolean verifyEmail(String email) {
			Boolean regexGmailCom = email.contains("@gmail.com");
			Boolean regexGmailComBr = email.contains("@gmail.com.br");
				if(regexGmailCom || regexGmailComBr) {
					this.email = email;
					return true;
				}else {
					System.out.println("O email não é compatível.");
					return false;
				}
			}
		
	

	//fim dos métodos que verificão valores
	
	//metodo para depositar	 
		public boolean changeDeposit(double value, String password){
			 if(password == this.password) {
				 this.balance = value;
				 return true;
			 }else {
				 System.out.println("Senha incorreta");
				 return false;
			 }		 
		 }
	//fim do método para depositar
		
		
	//método que retorna em ordem alfabética a lista de livros do úsuario
		public HashMap<Book, String> getLibrary(Book l) {
			
			HashMap<Book, String> books = new HashMap<>();
			
			if(l.getTitle() != null && l.getGenre() != null && l.getEditor() != null && l.getDate() != null && l.getPrice() != 0) {		
					arrayBooks.add(l);
			}else {
				System.out.println("Esse livro não possui todos os dados");
			}
			
			for(int i = 0; i < arrayBooks.size(); i++) {
				Book book	=	arrayBooks.get(i);
				String firstLetter = String.valueOf(book.getTitle().charAt(0));
				books.put(book, firstLetter);
			}
			
			return books;
		}
	 //fim do método que retorna em ordem alfabética os livros da conta	
	
	
}
