package com.mattvalli.JustHibernate.Chapter1.model;

public class Movie {
	// PROPERTIES
	private int 	id			= 0;
	private String 	title		= null;
	private String	synopsis	= null;
	private String	director	= null;

	// CONSTRUCTORS
	public Movie() {}
	
	
	// SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	// GETTERS
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public String getDirector() {
		return director;
	}
}
