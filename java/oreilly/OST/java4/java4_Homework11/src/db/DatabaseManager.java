package db;

import java.sql.*;

public class DatabaseManager {
  private Connection connection;
  private Statement statement;
  
  public DatabaseManager (String username, String password) {
    String url = "jdbc:mysql://sql.useractive.com:3306/" + username;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver is set; ready to go!");
    }
    catch (Exception e) {
      System.out.println("Failed to load JDBC/ODBC driver.");
      return;
    }
    
    try {
      connection = DriverManager.getConnection(url, username, password);
      statement = connection.createStatement();
      statement.execute("create table PhoneBook (Name varchar (32), PhoneNumber varchar (18));");
    }
    catch(SQLException exception) {
      System.out.println("\n***SQLException caught ***\n");
      while(exception != null) {
        System.out.println("SQLState:  "+exception.getSQLState());
        System.out.println("Message:  "+exception.getMessage());
        System.out.println("Error code:  "+exception.getErrorCode());
        exception = exception.getNextException();
        System.out.println("");
      }
    }
    catch (java.lang.Exception exception){
      exception.printStackTrace();
    }
  }
  
  public void addEntry (String name, String phoneNumber) {
    try {
      statement.execute("insert into PhoneBook values('" + name + "', '" + phoneNumber + "');");
    }
    catch (SQLException exception) {
      System.out.println("\n***SQLException caught ***\n");
      
      while(exception != null) {
        System.out.println("SQLState:    "+ exception.getSQLState()  );
        System.out.println("Message:    "+ exception.getMessage()  );
        System.out.println("Error Code:    "+ exception.getErrorCode()  );
        exception = exception.getNextException();
        System.out.println("");
      }
    }
    catch(java.lang.Exception exception) {
      exception.printStackTrace();
    }
  }
  
  public void dropTable() {
    try {
      statement.execute("drop table PhoneBook");
    }
    catch (SQLException exception) {
      System.out.println("\n***SQLException caught ***\n");
      
      while(exception != null) {
        System.out.println("SQLState:    "+ exception.getSQLState()  );
        System.out.println("Message:    "+ exception.getMessage()  );
        System.out.println("Error Code:    "+ exception.getErrorCode()  );
        exception = exception.getNextException();
        System.out.println("");
      }
    }
    catch(java.lang.Exception exception) {
      exception.printStackTrace();
    }
  }
}
