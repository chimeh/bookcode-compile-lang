package salesGUI;

public class Main {
  
  public static void main(String[] args) {
    
    SalesApp newApp = new SalesApp();
    SalesUserInterface appFrame = new SalesUserInterface(newApp);
    System.out.println("I think I made it and am back");
    appFrame.app.setMyUserInterface(appFrame);
  }

}
