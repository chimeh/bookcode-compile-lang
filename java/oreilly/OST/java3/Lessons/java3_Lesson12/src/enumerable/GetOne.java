package enumerable;

public class GetOne {

  public static void main(String[] args) {
    MammalEnum test;
    test = MammalEnum.CHEETAH;
    System.out.println(test + " height is " + test.getHeight());
  }
}
