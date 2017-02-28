
public class Main {
	public static void main(String[] args) {
		Student s = new Student("Markiewicz", "Kelly", 1);
		// output student information
		System.out.println("Student ID = " + s.getStudentId());
		System.out.println("Student first name = " + s.getFirstName());
		System.out.println("Student last name = " + s.getLastName());
				
		int i = 0;
		while (i < s.getProjectSize()) {
			System.out.println("Original project scores = " + s.getProjectScore(i));
			i++;
		}
		
		int j = 0;
		while (j < s.getQuizSize()) {
			System.out.println("Original quiz scores = " + s.getQuizScore(j));
			j++;
		}
		
		// Fill the projects and quizzes for this student
		int scoreP = 86;
		while (s.getNextProjectIndex() != -1) {
			s.setProjectScore(scoreP, s.getNextProjectIndex());
			scoreP++;
		}
		
		int k = 0;
		while (k < s.getProjectSize()) {
			System.out.println("Inserted project scores = " + s.getProjectScore(k));
			k++;
		}
		
		int scoreQ = 91;
		while (s.getNextQuizIndex() != -1) {
			s.setQuizScore(scoreQ, s.getNextQuizIndex());	
			scoreQ++;
		}
				
		int m = 0;
		while (m < s.getQuizSize()) {
			System.out.println("Inserted quiz scores = " + s.getQuizScore(m));
			m++;
		}
		
		System.out.println("Insert project score out of bounds successful? = " + s.setProjectScore(101, 15));
		System.out.println("Insert quiz score out of bounds successful? = " + s.setQuizScore(999, 10));		
	}
}
