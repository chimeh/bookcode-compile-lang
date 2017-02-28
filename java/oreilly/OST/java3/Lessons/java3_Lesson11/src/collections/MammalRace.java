package collections;

import java.util.*;

public class MammalRace {

  public static void main(String[] args) {
    MammalRace testing = new MammalRace();
    testing.race();
  }
  
  public void race() {
    Human me = new Human("me(Human)");
    Three_toedSloth frank = new Three_toedSloth("frank sloth");
    Cheetah chester = new Cheetah("chester cheetah");
    
    List<Mammal> critters = new ArrayList<Mammal>();
    critters.add(me);
    critters.add(frank);
    critters.add(chester);
    
    System.out.println("Original Objects: ");
    System.out.println(critters);
    
    ListIterator<? extends Mammal> crittersIter = critters.listIterator();
    System.out.println("Elements of the list by their names: ");
    while(crittersIter.hasNext()) {
      System.out.println(crittersIter.next().getName() + ", ");
    }
    System.out.println();
    
    Collections.sort(critters, new Comparator<Mammal>() {
      public int compare(Mammal a, Mammal b) {
        if (a.getSpeed() < b.getSpeed()) return -1;
        if (a.getSpeed() > b.getSpeed()) return 1;
        return 0;
      }
    });
    
    System.out.println("\n Sorted from slowest to fastest, "
        + "with speed information:");
    
    for(Mammal each : critters) {
      System.out.println("Name: " + each.getName() + " Speed: "
          + each.getSpeed() + " mph");
    }
    
    Collections.sort(critters, new Comparator<Mammal>() {
      public int compare(Mammal a, Mammal b) {
        if(a.getHeight() < b.getHeight()) return -1;
        if(a.getHeight() > b.getHeight()) return 1;
        return 0;
      }
    });
    System.out.println("\nSorted from shortest to tallest, "
        + "with height information:");
    for(Mammal each : critters) {
      System.out.println("Name: " + each.getName()
          + " Height: " + each.getHeight() + " m");
    }
  }
}
