
public class Test {
  int total;
  
  public static void main(String[] args) {
    Test myTest = new Test();
    myTest.demo();
  }
  
  public void demo() {
    String[] grades = new String[4];
    defaultFillGrade(grades);
    for(int i=0; i < grades.length; i++)
      System.out.print(grades[i] + " ");
  }
  
  public void defaultFillGrade(String[] grades) {
    for(int studentNum=0; studentNum < grades.length; studentNum++)
      grades[studentNum] = "A";
  }
  
}
