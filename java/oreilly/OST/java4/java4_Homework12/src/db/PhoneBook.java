package db;

public class PhoneBook {

  public PhoneBook() {
    int i =0;
    
    while(i < 3) {
      String[] info = PasswordDialog.login(this);
      DatabaseManager databaseManager = new DatabaseManager(info[0], info[1]);
      
      if(databaseManager.isLoginSuccessful()) {
        UserInterface userInterface = new UserInterface(databaseManager);
        userInterface.start();
        break;
      }
      i++;
    }
    
    if(i ==3) {
      PasswordDialog.showFailMessage();
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    PhoneBook myApp = new PhoneBook();
  }

}
