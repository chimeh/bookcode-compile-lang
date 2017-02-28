package db;

public class PhoneBook {

  public PhoneBook() {
    String[] info = PasswordDialog.login(this);
    DatabaseManager databaseManager = new DatabaseManager(info[0], info[1]);
    UserInterface userInterface = new UserInterface(databaseManager);
    userInterface.start();
  }
  public static void main(String[] args) {
    PhoneBook myApp = new PhoneBook();
  }

}
