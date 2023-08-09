package com.example.demo.model;





import jakarta.validation.constraints.NotBlank;

public class BookDto {
         @NotBlank
	     private String author;
         @NotBlank
		 private int numberPages;
         @NotBlank	
		 private String editor;
         @NotBlank	
		 private double price;
         @NotBlank	
		 private String title;
         @NotBlank		
		 private String isbn10;
         @NotBlank		
		 private String dimensions;
         
         
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getNumberPages() {
			return numberPages;
		}
		public void setNumberPages(int numberPages) {
			this.numberPages = numberPages;
		}
		
		public String getEditor() {
			return editor;
		}
		public void setEditor(String editor) {
			this.editor = editor;
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
         
         
        

}		 
