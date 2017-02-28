package db;

import java.sql.*;
import java.text.Format;
import java.util.*;

public class UserInterface {

  private DatabaseManager database;
  
  public UserInterface(DatabaseManager theDatabaseManager) {
    database = theDatabaseManager;
  }
  
  public void start() {
    Scanner in = new Scanner(System.in);
    while(true) {
      System.out.println("Click in the Console,"
          + " then enter a command:"
          + "\nA (then Enter) to Add a phone book entry, \n" 
          + "Q (then Enter) to quit.");
      
      String command = in.nextLine();
      
      if(command.isEmpty()) {
        command = "Please enter a valid entry";
        System.out.println(command);
      }
      else if(command.charAt(0) == 'A') {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = in.nextLine();
        
        while(!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            System.out.println("Please enter phone number in format\n xxx-xxx-xxxx");
            phoneNumber = in.nextLine();
        }
        database.addEntry (name, phoneNumber);
      }
      else if(command.charAt(0) == 'Q') {
        database.dropTable();
        System.exit(0);
      }
      else {
        command = "Please enter a valid entry";
        System.out.println(command);
      }

    }
  }
}
