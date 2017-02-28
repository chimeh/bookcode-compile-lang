
public class Main {

  public static void main(String[] args) {
    
    Student ben = new Student("Orban", "Ben", 54321);
    
    System.out.println(ben.getFirstName() +" " + ben.getLastName() +" "+ ben.getStudentID());
    
    ben.setProjectScore(50, 6);
    ben.setQuizScore(33, 4);
    
    while(ben.getNextProjectIndex() < 14) {
      ben.setProjectScore(90,ben.getNextProjectIndex());
    }
    
    while(ben.getNextQuizIndex() < 9) {
      ben.setQuizScore(80,ben.getNextQuizIndex());
    }
    
    
    
    System.out.println("\nProject Scores:");
    
      for(int i = 0; ben.getProjectScore(i) > -1; i++) {
        System.out.println(ben.getProjectScore(i));
      }
    
      
      System.out.println("\nQuiz Scores:");
      
      for(int i = 0;ben.getQuizScore(i) > -1; i++) {
        System.out.println(ben.getQuizScore(i));
      }
    
  }

}
