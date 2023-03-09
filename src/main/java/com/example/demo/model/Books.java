package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "books")
public class Books   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBooks")
	 private int idBooks;
	@Column(name = "numberPages")
	 private int numberPages;
	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	 private Genre genre;
	@Column(name = "editor")
	 private String editor;
	@Column(name = "date")
	 private String date;
	@Column(name = "description")
	 private String description;
	@Column(name = "price")
	 private double price;
	@Column(name = "notes")
	 private List<String> notes = new ArrayList<>();
	@Column(name = "title")
	 private String title;
	@Column(name = "isbn10")
	 private String[] isbn10 = new String[13];
	@Column(name = "dimensions")
	 private int[] dimensions = new int[3];
	
	 
	 public Books(int numberPages, Genre genre, String editor, String date, double price, String title){
		 this.numberPages = numberPages;
		 this.genre = genre;
		 this.editor = editor;
		 this.date = date;
		 this.title = title;
		 
	 }
	 
	 public int getNumberPages() {
		 return numberPages;
	 }
	 
	 public String getTitle() {
		 return this.title;
	 }
	 
	 public Genre getGenre() {
		 return this.genre;
	 }
	 
	 public String getEditor() {
		 return this.editor;
	 }
	 
	 public String getDate() {
		 return this.date;
	 }
	 
	 public double getPrice() {
		 return this.price;
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
