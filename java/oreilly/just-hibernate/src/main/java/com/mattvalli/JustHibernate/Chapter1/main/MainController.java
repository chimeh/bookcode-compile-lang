package com.mattvalli.JustHibernate.Chapter1.main;

import com.mattvalli.JustHibernate.Chapter1.dao.MoviePersistor;
import com.mattvalli.JustHibernate.Chapter1.model.Movie;

public class MainController {

	public static void main(String[] args) {
		// Pseudocode
		
		// Get an instance of the JDBC Compliant Class responsible for persisting Movie objects in database
		MoviePersistor moviePersistor = new MoviePersistor();
		
		// Create a Sample Movie
		Movie movie = new Movie();
		movie.setId(1);
		movie.setTitle("Jaws");
		movie.setDirector("Steven Spielberg");
		movie.setSynopsis("3 men hunt a dangerous Great White Shark taking lives off the coast of their island during peak holiday season.");
		
		// Pass the Movie object to MoviePersistor to save in a Database
		moviePersistor.persist(movie);
	}

}
