package prodcons;

public class Consumer extends Thread {
  private Soup soup;
  private MyTableSetting bowlView;
  private Thread consumerThread;
  
  public Consumer(MyTableSetting bowl, Soup s) {
    bowlView = bowl;
    soup = s;
  }

  public void run() {
    String c;
    while(consumerThread != null) {
    for(int i =0; i < 10; i++) {
      c = soup.eat();
      System.out.println("Ate a letter: " + c);
      bowlView.repaint();
      
      try {
        sleep((int)(Math.random()*3000));
      }catch (InterruptedException e) {}
    }
   }
  }
  
  public void start() {
    if (consumerThread == null) {
      consumerThread = new Thread(this);
      consumerThread.start();
    }
  }
  
  public void stopThread() {
    consumerThread = null;
  }
}
