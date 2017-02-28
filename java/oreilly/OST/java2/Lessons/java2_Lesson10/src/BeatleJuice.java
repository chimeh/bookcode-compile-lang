
public class BeatleJuice {
  public static void main(String[] args) {
    String[] beatles;
    beatles = new String[5];
    
    beatles[0] = "John Lennon";
    beatles[1] = "Paul McCartney";
    beatles[2] = "George Harrison";
    beatles[3] = "Ringo Starr";
    beatles[4] = "George Martin";
    
    for(String item: beatles) {
      System.out.println("Element is: " + item);
    }
    
    System.out.println("\nSize of the beatles array is " + beatles.length);
  }
}
