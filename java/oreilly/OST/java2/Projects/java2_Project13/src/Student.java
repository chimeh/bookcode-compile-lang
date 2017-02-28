
public class Student {
  
  private String lastName, firstName;
  private int studentID;
  private double[] projects;
  private double[] quizzes;
  
  public Student(String lastName, String firstName, int studentID) {
    super();
    this.lastName = lastName;
    this.firstName = firstName;
    this.studentID = studentID;
    
    projects = new double[15];
    quizzes = new double[10];
    
    for(int i = 0; i<projects.length; i++) {
      projects[i] = -1.0;
    }
    
    for(int i = 0; i<quizzes.length; i++) {
      quizzes[i] = -1.0;
    }
    
  }
  
  public double getProjectScore(int index) {
    //return array value, else -1.0 if out of bounds
    if(index > projects.length) {
      return -1.0;
    }
    else {
      return projects[index];
    }
  }
  
  public boolean setProjectScore(double score, int projectNumber){
    if(projectNumber < projects.length) {
      projects[projectNumber] = score;
      return true;
    }
    else {
      return false;
    }
    
  }
  
  public double getQuizScore(int index) {
    //return array value, else -1.0 if out of bounds
    if(index > quizzes.length) {
      return -1.0;
    }
    else {
      return quizzes[index];
    }
  }
  
  public boolean setQuizScore(double score, int quizNumber) {
    if(quizNumber < quizzes.length) {
      quizzes[quizNumber] = score;
      return true;
    }
    else {
      return false;
    }
  }
  
  public int getNextProjectIndex() {
    //find next -1.0 value in array, else return -1 if full
    int retVal = -1;
    
    for(int i = 0; i < projects.length; i++) {
      if(this.getProjectScore(i) == -1.0) {
        retVal = i;
        return retVal;
      }
      
    }
    return retVal;
  }
  
  public int getNextQuizIndex() {
    //find next -1.0 value in array, else return -1 if full
    int retVal = -1;
    
    for(int i = 0; i < quizzes.length; i++) {
      if(this.getQuizScore(i) == -1.0) {
        retVal = i;
        return retVal;
      }
    }
    return retVal;
  }
  
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public int getStudentID() {
    return studentID;
  }
  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }
  
}
