package prodcons;

public class Consumer extends Thread {
  private Soup soup;
  private MyTableSetting bowlView;
  
  public Consumer(MyTableSetting bowl, Soup s) {
    bowlView = bowl;
    soup = s;
  }

  public void run() {
    String c;
    for(int i =0; i < 10; i++) {
      c = soup.eat();
      System.out.println("Ate a letter: " + c);
      bowlView.recentlyAte(c);
      bowlView.repaint();
      
      try {
        sleep((int)(Math.random()*3000));
      }catch (InterruptedException e) {}
    }
  }
}
