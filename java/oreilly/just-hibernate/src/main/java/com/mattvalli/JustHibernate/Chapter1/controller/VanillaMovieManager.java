package com.mattvalli.JustHibernate.Chapter1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VanillaMovieManager {
	// PROPERTIES
	private Connection connection = null;

	// Database Properties
	private String url			= "jdbc:mysql://localhost:3307/JH";
	private String driverClass	= "com.mysql.jdbc.Driver";
	private String username		= "just-hibernate";
	private String password		= "test-hibernate";
	
	// Queries
	private String insertSql	= "INSERT INTO MOVIES VALUES(?,?,?,?)";
	private String selectSQL	= "SELECT * FROM MOVIES";
	

	// METHODS
	/** This method connects our application to the MySQL Database using the JDBC
	 * 
	 * @return A JDBC Connection Instance
	 */
	private Connection getConnection() {
		try {
			// Get an Instance of the driverClass for the current database (JDBC Compliant API)
			Class.forName(driverClass).newInstance();
			
			// Call the static method of the DriverManager (A Connection Factory) to retrieve a Connection Instance
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return connection;
	}
	
	private void persistMovie() {
		try {
			// Create a prepared statement to improve writing to database performance
			PreparedStatement pst = getConnection().prepareStatement(insertSql);
			
			// Manually Hard Code an instance insert
			pst.setInt(1,1001);
			pst.setString(2,"Top Gun");
			pst.setString(3, "Action Film");
			pst.setString(4, "Tony Scott");
			
			// Execute the SQL Statement
			pst.execute();
			System.out.println("Movie persisted successfully!");
			
		} catch (Exception e) {
			// Handle any exception during execution of Try Block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void queryMovies() {
		try {
			Statement statement = this.getConnection().createStatement();
			ResultSet result	= statement.executeQuery(selectSQL);
			
			while (result.next()) {
				System.out.println("Movie Found: " + result.getInt("ID") + ", Title: " + result.getString("TITLE"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
