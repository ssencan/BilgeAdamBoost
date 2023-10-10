package ThirdAssignment;

public class Lecturer extends Staff {

	public Lecturer(String userName, int password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void viewPersonalInfo() {
		System.out.println("Lecturer info");	
	}
	
	public void assignGrade() {
		System.out.println("Not verildi");
	}
	
}
