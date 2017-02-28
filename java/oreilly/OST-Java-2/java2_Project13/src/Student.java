
public class Student {
	private String lastName;
	private String firstName;
	private int studentId;
	private double[] projects;
	private double[] quizzes;
	
	public Student(String lastName, String firstName, int studentId) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentId = studentId;
		projects = new double[15];
		quizzes = new double[10];
		
		int i = 0;
		while (i < projects.length) {
			projects[i] = -1.0;
			i++;
		}
				
		int j = 0;
		while (j < quizzes.length) {
			quizzes[j] = -1.0;
			j++;
		}
	}

	public boolean setProjectScore(double score, int projectNum) {
		//if projectNum is within bounds then insert score into array
		if ((projectNum >= 0) && (projectNum < projects.length)) {
			projects[projectNum] = score;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setQuizScore(double score, int quizNum) {
		//if quizNum is within bounds then insert score into array
		if ((quizNum >= 0) && (quizNum < quizzes.length)) {
			quizzes[quizNum] = score;
			return true;
		} else {
			return false;
		}
	}
	
	public double getProjectScore(int projectNum) {
		//return score or -1.0 if array index is out of bounds
		if ((projectNum >= 0) && (projectNum < projects.length)) {
			return projects[projectNum];
		} else {
			return -1.0;
		}
	}
	
	public double getQuizScore(int quizNum) {
		//return score or -1.0 if array index is out of bounds
		if ((quizNum >= 0) && (quizNum < quizzes.length)) {
			return quizzes[quizNum];
		} else {
			return -1.0;
		}
	}
	
	public int getProjectSize() {
		return projects.length;
	}
	
	public int getQuizSize() {
		return quizzes.length;
	}
	
	public int getNextProjectIndex() {
		//return index of -1.0 in array.  If array is full, then return -1
		int j = -1;
		int i = 0;
		
		while (i < projects.length) {
			if (projects[i] == -1.0) {
				j = i;
			} 
			i++;
		}
		return j;
	}
	
	public int getNextQuizIndex() {
		//return index of -1.0 in array.  If array is full, then return -1
		int j = -1;
		int i = 0;
		
		while (i < quizzes.length) {
			if (quizzes[i] == -1.0) {
				j = i;
			} 
			i++;
		}
		return j;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	

}
