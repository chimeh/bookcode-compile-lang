package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AccessLinkedList {

  public static void main(String[] args) {
    AccessLinkedList testing = new AccessLinkedList();
    testing.tryThis();
  }
  
  public void tryThis() {
    List<String> first = new LinkedList<String>();
    first.add("Mick");
    first.add("Keith");
    first.add("Charlie");
    first.add("Bill");
    first.add("Ron");
    System.out.println("First:  " + first);
    
    List<String> last = new LinkedList<String>();
    last.add("Jagger");
    last.add("Richards");
    last.add("Watts");
    last.add("Wyman");
    last.add("Wood");
    System.out.println("Last: " + last);
    
    ListIterator<String> firstIter = first.listIterator();
    Iterator<String> lastIter = last.iterator();
    
    while(lastIter.hasNext()) {
      if(firstIter.hasNext())
        firstIter.next();
      firstIter.add(lastIter.next());
    }
    System.out.println("\nMerged all into first:\n");
    System.out.println(first);
    
    List<String> temp = new LinkedList<String>();
    
    lastIter = last.iterator();
    while(lastIter.hasNext()) {
      lastIter.next();
      if(lastIter.hasNext()) {
        temp.add(lastIter.next());
        lastIter.remove();
      }
    }
    
    System.out.println("\nRemoved every other element in last\n");
    System.out.println("Last has become: " + last);
    
    first.removeAll(last);
    
    System.out.println("First is now: " + first);
    
    for(String each: temp) {
      int location = first.indexOf (each);
      System.out.println(each);
      first.remove(location);
    }
    System.out.println(" First is back to: " + first);
  }
}
