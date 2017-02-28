package demo;

public class AnotherThread {

  public static void main(String[] args) {
    ThreadTest t = new ThreadTest();
    t.start();
  }
}

  class ThreadTest extends Thread {
    
    public void run() {
      while(true) {
        System.out.println("b: ");
        try {
          sleep(300);
        }
        catch (InterruptedException e) {}
      }
    }
  }
    
