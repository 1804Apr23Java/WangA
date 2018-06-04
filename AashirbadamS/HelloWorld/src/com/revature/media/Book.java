package com.revature.media;

public class Book extends Media {
	private String author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Book(String author, String title, int yearPublished, String genre) {
		super();
		this.author=author;
		this.title=title;
		this.yearPublished=yearPublished;
		this.genre=genre;
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public String toString() {
		return "Book [author=" + author + "]";
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	

}
