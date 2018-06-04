package com.revature.media;



public class Movie extends Media{
	
	private String producer;

	@Override
	public String toString() {
		return "Movie [producer=" + producer + "]";
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String producer, String title, int yearPublished, String genre) {
		super();
		this.producer=producer;
		this.title=title;
		this.yearPublished=yearPublished;
		this.genre=genre;
		// TODO Auto-generated constructor stub
	}



}
