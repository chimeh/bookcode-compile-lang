package demo;

public class MultiTest {

  public static void main(String args[]) {
    TestThread t1, t2, t3;
    
    t1 = new TestThread("Thread1", (int)(Math.random()*3000));
    t2 = new TestThread("Thread2", (int)(Math.random()*2000));
    t3 = new TestThread("Thread3", (int)(Math.random()*1000));
    
    t1.start();
    t2.start();
    t3.start();
    
  }
}
