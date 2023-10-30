package FourthAssignment;

import java.util.LinkedList;

public class Student extends User {

	private LinkedList<String> studentCoursesList = new LinkedList<String>();

	public Student(String userName, int password) {
		super(userName, password);

	}

	@Override
	public void viewPersonalInfo() {
		System.out.println("Student info");

	}

	public void enrollCourse() {
		
	}

	public void calculateGPA() {
		System.out.println("GPA hesaplandı");
	}

}
