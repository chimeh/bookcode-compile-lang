package demo;

public class TestThread extends Thread{

  private String whoAmI;
  private int delay;
  
  public TestThread(String s, int d) {
    whoAmI = s;
    delay = d;
  }
  
  public void run() {
    try {
      sleep(delay);
    }
    catch (InterruptedException e) {
      
    }
    System.out.println(whoAmI + " has delay time of " + delay);
  }
}
