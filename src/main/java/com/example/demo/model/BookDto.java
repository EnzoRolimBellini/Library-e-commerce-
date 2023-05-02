package com.example.demo.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class BookDto {
         @NotBlank	
	     private String author;
         @NotBlank	
		 private int numberPages;
         @NotBlank	
		 @Enumerated(EnumType.STRING)
		 private Genre genre;
         @NotBlank	
		 private String editor;
         @NotBlank	
		 private String description;
         @NotBlank	
		 private double price;
         @NotBlank	
		 private String title;
         @NotBlank		
		 private String isbn10;
         @NotBlank		
		 private String dimensions;

}		 
