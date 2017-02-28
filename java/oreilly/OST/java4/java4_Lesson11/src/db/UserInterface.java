package db;

import java.sql.*;
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
          + "\n then enter a command: (choose)"
          + "\n A (then Enter) to Add a phone book entry,"
          + "\n D (then Enter) to Display all phone book entries,"
          + "\n K (then Enter) to Exit and Keep the entries,"
          + "\n or Q (then Enter) to Quit and Remove the entries: ");
      
      String command = in.nextLine();
      
      if(command.charAt(0) == 'A') {
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = in.nextLine();
        database.addEntry (name, phoneNumber);
      }
      else if(command.charAt(0) == 'D') {
        database.getEntries();
      }
      else if (command.charAt(0) == 'K') {
        System.out.println("Bye");
        database.close(false);
        return;
      }
      else if (command.charAt(0) != 'Q') {
        System.out.println("Invalid command. Please enter either A, K, or Q.");
      }
      else {
        System.out.println("Bye");
        database.close(true);
        return;
      }
    }
  }
}
