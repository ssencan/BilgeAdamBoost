package FourthAssignment;

import java.util.LinkedList;

public class Student extends User {
	private Courses courses;
	private LinkedList<String> studentCoursesList = new LinkedList<String>();

	public Student(String userName, int password, Courses courses) {
		super(userName, password);
		this.courses = courses;
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
