package collections;

import java.util.*;

public class CollectionsAlgorithms {

  private Integer numberGenerator() {
    int randomInt = (int)(Math.random() * 100);
    return Integer.valueOf(randomInt);
  }
  
  public List<Integer> createAList(int howMany){
    List<Integer> createdList = new ArrayList<Integer>(howMany);
    for(int i = 0; i < howMany; i++)
      createdList.add(numberGenerator());
    return createdList;
  }
  
  public static void main(String[] args) {
    CollectionsAlgorithms testMe = new CollectionsAlgorithms();
    testMe.tryThis();
  }
  
  public void tryThis() {
    List<Integer> myList = createAList(7);
    System.out.println("Created list: " + myList);
    
    List<Integer> myCopy = createAList(7);
    System.out.println("Second list: " + myCopy);
    
    Collections.fill(myCopy, Integer.valueOf(0));
    System.out.println("Second list with 0s: " + myCopy);
    
    Collections.copy(myCopy, myList);
    System.out.println("Copied first into second list so " 
        + "we can mess with it: \n    " + myCopy);
    
    System.out.println();
    Collections.sort(myCopy);
    System.out.println("Sorted list: " + myCopy);
    
    int foundFirst = Collections.binarySearch(myCopy, myList.get(0));
    System.out.println("Found first in original list at index " + foundFirst + " in sorted list ");
    
    Collections.reverse(myCopy);
    System.out.println("Reversed order of list: " + myCopy);
    
    Collections.shuffle(myCopy);
    System.out.println("Shuffled list: " + myCopy);
    
    Integer min = Collections.min(myCopy);
    System.out.println("Min value is: " + min.intValue() + ", Max value is: " + Collections.max(myCopy).intValue());
    
    myCopy = Collections.emptyList();
    System.out.println("Emptied list: " + myCopy);
    
    System.out.println("Still have orignal created list: " + myList);
    
  }
}
