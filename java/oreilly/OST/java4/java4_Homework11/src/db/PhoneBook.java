package db;

public class PhoneBook {

  public static void main(String[] args) {
    DatabaseManager databaseManager = new DatabaseManager(args[0], args[1]);
    
    UserInterface userInterface = new UserInterface(databaseManager);
    try {
      userInterface.start();
    }catch(StringIndexOutOfBoundsException e) { }
  }

}
