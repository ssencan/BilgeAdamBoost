package ThirdAssignment;

public class Student extends User {

	public Student(String userName, int password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void viewPersonalInfo() {
		System.out.println("Student info");	
		
	}
	public void enrollCourse(String course) {
		System.out.println(course + " dersine kaydolundu");
	}
	
	public void calculateGPA() {
		System.out.println("GPA hesaplandı");
	}
	
	

}
