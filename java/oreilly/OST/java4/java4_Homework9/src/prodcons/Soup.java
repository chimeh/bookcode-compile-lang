package prodcons;

import java.util.*;

public class Soup {
  private ArrayList<String> buffer = new ArrayList<String>();
  private int capacity = 6;
  
  public synchronized String eat() {
    while(buffer.isEmpty()) {
      try {
        wait();
      }catch(InterruptedException e) {}
    }
    
    String toReturn = buffer.get((int)(Math.random()*buffer.size()));
    buffer.remove(toReturn);
    buffer.trimToSize();
    notifyAll();
    return(toReturn);
  }
  
  public synchronized void add(String c) {
    while(buffer.size() == capacity) {
      try {
        wait();
      }catch (InterruptedException e) {}
    }
    buffer.add(c);
    notifyAll();
  }
  
  public ArrayList<String>getContents(){
    return(buffer);
  }
  
  public void emptyBuffer() {
    buffer.clear();
  }

}
