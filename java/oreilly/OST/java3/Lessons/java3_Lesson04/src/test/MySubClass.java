package test;

public class MySubClass extends MySuperClass {
  int j;

  public MySubClass() {
    System.out.println("\nMySubClass(), returned after waiting for everything to get done and come back to me");
    System.out.println(" after supers are called by default, inherited i is " + i + " and my own j is initialized to " + j);
    System.out.println(" when all is done here, j is now " + ++j);
  }

  public MySubClass(int x) {
    super(x);
    System.out.println("\nMySubClass(int x), returned after passing value of " + x
        + " and then waiting for everything to get done and come back to me");
  }

  public static void main(String[] args) {
    MySubClass testing = new MySubClass(50);
    System.out.println("\nEnd of main after instantiation. Value of i is " + testing.i);
  }

}
