package db;

import java.sql.*;

public class DatabaseManager {
  private Connection connection;
  private Statement statement;
  private ResultSet resultSet, duplicateEntry;
  private boolean loginSuccessful;
  
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
       loginSuccessful = true;
 
       statement = connection.createStatement();
       DatabaseMetaData aboutDB = connection.getMetaData();
       String[] tableType = {"TABLE"};
       ResultSet rs = aboutDB.getTables(null, null, "PhoneBook", tableType);
      
       if(!inspectForTable(rs)) {
         statement.execute("create table PhoneBook (Name varchar (32), PhoneNumber varchar(18));");
         rs.close();
        }
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
        loginSuccessful = false; 
    }
    catch (java.lang.Exception exception){
      exception.printStackTrace();
    }
  }
  
  public void addEntry (String name, String phoneNumber) {
    try {
      duplicateEntry = statement.executeQuery("SELECT Name FROM PhoneBook WHERE Name LIKE" + "'%" + name + "%'");
      
      if(!duplicateEntry.next()) {
        statement.execute("insert into PhoneBook values('" + name + "', '" + phoneNumber + "');");
      }
      else {
        System.out.println("Duplicate Entry! Try again");
      }
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
  
  private static boolean inspectForTable (ResultSet rs) throws SQLException {
    int i;
    ResultSetMetaData rsmd = rs.getMetaData();
    int numCols = rsmd.getColumnCount();
    
    for(i=1; i<=numCols; i++) {
      if(i>1) System.out.print(", ");
      System.out.print(rsmd.getColumnLabel(i));
    }
    System.out.println("");
    
    boolean more = rs.next();
    while (more) {
      for(i=1; i<=numCols; i++) {
        System.out.print(rs.getString(i)+"\n");
        if (rsmd.getColumnLabel(i) == "TABLE_NAME")
          if(rs.getString(i).equals("PhoneBook")){
            System.out.println("Found one that equals " + rs.getString(i));
            return true;
          }
      }
      System.out.println("");
      more = rs.next();
    }
    return false;
  }
  
  public void getEntries() {
    try {
      resultSet = statement.executeQuery("SELECT * FROM PhoneBook");
      
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numCols = metaData.getColumnCount();
      int i;
      System.out.println("");
      for(i=1; i <= numCols; i++) {
        if(i > 1) System.out.print("\t\t\t\t");
        System.out.print(metaData.getColumnLabel(i));
      }
      System.out.println("");
      System.out.println("");
      
      boolean more = resultSet.next();
      while(more) {
        for(i = 1; i <=numCols; i++) {
          System.out.print(resultSet.getString(i) + "\t\t\t\t");
        }
        System.out.println("");
        more = resultSet.next();
      }
      resultSet.close();
      System.out.println("");
    }
    catch (SQLException exception) {
      System.out.println("\n*** SQLException caught ***\n");
      
      while ( exception != null) 
      {
          System.out.println("SQLState:   " + exception.getSQLState());
          System.out.println("Message:    " + exception.getMessage());
          System.out.println("Error code: " + exception.getErrorCode());

          exception = exception.getNextException();   
          System.out.println("");
      }
    }
  catch (java.lang.Exception exception ) 
  {
      exception.printStackTrace();
  }
}
  
  public void searchName(String name) {
    try {
      resultSet = statement.executeQuery("SELECT*FROM PhoneBook WHERE Name LIKE " + "'%" + name +"%'");
      
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numCols = metaData.getColumnCount();
      int i;
      System.out.println("");
      for(i=1; i <= numCols; i++) {
        if(i > 1) System.out.print("\t\t\t\t");
        System.out.print(metaData.getColumnLabel(i));
      }
      System.out.println("");
      System.out.println("");
      
      boolean more = resultSet.next();
      while(more) {
        for(i = 1; i <=numCols; i++) {
          System.out.print(resultSet.getString(i) + "\t\t\t\t");
        }
        System.out.println("");
        more = resultSet.next();
      }
      resultSet.close();
      System.out.println("");
    }
    catch (SQLException exception) {
      System.out.println("\n*** SQLException caught ***\n");
      
      while ( exception != null) 
      {
          System.out.println("SQLState:   " + exception.getSQLState());
          System.out.println("Message:    " + exception.getMessage());
          System.out.println("Error code: " + exception.getErrorCode());

          exception = exception.getNextException();   
          System.out.println("");
      }
    }
  catch (java.lang.Exception exception ) 
  {
      exception.printStackTrace();
  }
    
  }
  
  public void searchPhone(String phone) {
    try {
      resultSet = statement.executeQuery("SELECT*FROM PhoneBook WHERE PhoneNumber LIKE " + "'%" + phone +"%'");
      
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numCols = metaData.getColumnCount();
      int i;
      System.out.println("");
      for(i=1; i <= numCols; i++) {
        if(i > 1) System.out.print("\t\t\t\t");
        System.out.print(metaData.getColumnLabel(i));
      }
      System.out.println("");
      System.out.println("");
      
      boolean more = resultSet.next();
      while(more) {
        for(i = 1; i <=numCols; i++) {
          System.out.print(resultSet.getString(i) + "\t\t\t\t");
        }
        System.out.println("");
        more = resultSet.next();
      }
      resultSet.close();
      System.out.println("");
    }
    catch (SQLException exception) {
      System.out.println("\n*** SQLException caught ***\n");
      
      while ( exception != null) 
      {
          System.out.println("SQLState:   " + exception.getSQLState());
          System.out.println("Message:    " + exception.getMessage());
          System.out.println("Error code: " + exception.getErrorCode());

          exception = exception.getNextException();   
          System.out.println("");
      }
    }
  catch (java.lang.Exception exception ) 
  {
      exception.printStackTrace();
  }
    
  }
    
  
  public void close(boolean remove) {
    try {
      if(remove) {
        statement.execute("drop table PhoneBook;");
      }
      statement.close();
      connection.close();
    }
    catch(SQLException exception) {
      System.out.println("\n*** SQLException caught ***\n");
      while(exception != null) {
        System.out.println("SQLState:  " + exception.getSQLState());
        System.out.println("Message:   " + exception.getMessage());
        System.out.println("ErrorCode: " + exception.getErrorCode());
        exception = exception.getNextException ();   
        System.out.println("");
      }
    }
      catch(java.lang.Exception exception) {
        exception.printStackTrace();
      }
  }

  public boolean isLoginSuccessful() {
    return loginSuccessful;
  }

  public void setLoginSuccessful(boolean loginStatus) {
    this.loginSuccessful = loginStatus;
  }
  
}
