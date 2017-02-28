package prodcons;

public class Producer extends Thread {
  private Soup soup;
  private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private MyTableSetting bowlView;
  private Thread producerThread = this;
  
  public Producer(MyTableSetting bowl, Soup s) {
    bowlView = bowl;
    soup = s;
  }
  
  public void run() {
    String c;
    while(producerThread != null) {
    for (int i = 0; i < 10; i++) {
      c = String.valueOf(alphabet.charAt((int)(Math.random() * 26)));
      soup.add(c);
      System.out.println("Added " + c + " to the soup.");
      bowlView.repaint();
      
      try {
        sleep((int)Math.random()*2000);
      } catch (InterruptedException e) {}
    }
   }
  }
  
  public void stopThread() {
    producerThread = null;
  }

}
