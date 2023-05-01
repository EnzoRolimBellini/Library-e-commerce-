package com.example.demo.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "books")
public class Book   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBook")
	 private UUID idBook;
	@Column(name = "author", nullable = false)
	 private String author;
	@Column(name = "numberPages", nullable = false)
	 private int numberPages;
	@Column(name = "genre", nullable = false)
	@Enumerated(EnumType.STRING)
	 private Genre genre;
	@Column(name = "editor", nullable = false)
	 private String editor;
	@Column(name = "date", nullable = false)
	 private LocalDateTime date;
	@Column(name = "description")
	 private String description;
	@Column(name = "price", nullable = false)
	 private double price;
	@Column(name = "notes")
	 private List<String> notes;
	@Column(name = "title", nullable = false)
	 private String title;
	@Column(name = "isbn10", nullable = false, unique = true, length = 10)
	 private String isbn10;
	@Column(name = "dimensions")
	 private String dimensions;
	@Column(name = "fk_accounts")
	@ManyToMany(mappedBy = "arrayBooks")
	 private List<Account> arrayAccounts;
	
	
	 
	 public Book(int numberPages, String author, Genre genre, String editor, LocalDateTime date, double price, String title){
		 this.numberPages = numberPages;
		 this.author = author;
		 this.genre = genre;
		 this.editor = editor;
		 this.date = date;
		 this.title = title;
		 
	 }
	  
	 
	 public String getAuthor() {
		 return author;
	 }
	 
	 public void setAuthor(String author) {
		 this.author = author;
	 }
	 
	 public UUID getIdBooks() {
		return idBook;
	}

	public void setIdBooks(UUID idBooks) {
		this.idBook = idBooks;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public void createNote() {
		 
			 String noteEvaluation = null;
		
			 do {
				 Scanner userText = new Scanner(System.in);
			 String note = String.valueOf(userText.nextLine());
			 if(note != null) {
			 this.notes.add(note);
			 noteEvaluation	= note;
			 }else {
				System.out.println("Você não colocou nenhum valor na nota");
			 }
			 }while(noteEvaluation != null);
	 
	 }
	 
	public List<String> getNotes() {
		return this.notes;
		//for(int i =0; i < this.notas.size(); i++) {
			//return this.notas.get(i);
		//}
	}	  
	 
	 public  void removeNotes(int currentIndex) {
		 this.notes.remove(currentIndex);
	 }
	 
	
	 
	 public void browseNotes() {
		 int currentIndex = 0;
		 while(true) {
			 Scanner scan = new Scanner(System.in);
			 String action = scan.nextLine();
			 
			 
			 if(action.equals("próximo")) {
				 currentIndex++;
			 }
			 
			 if(action.equals("anterior")) {
				 currentIndex--;
			 }
			 
			 this.notes.get(currentIndex);
		 }
		
	 }
	 
	  
	 public void setNote(int currentIndex, String newText) {	 
		this.notes.set(currentIndex, newText);	 
	 }
	 
	

}
