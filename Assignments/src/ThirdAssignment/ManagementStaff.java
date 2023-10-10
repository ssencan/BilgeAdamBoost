package ThirdAssignment;

import java.util.LinkedList;

public class ManagementStaff extends Staff {
	
	private LinkedList<String> assignedCourses = new LinkedList<>();
	
	public LinkedList<String> getAssignedCourses() {
		return assignedCourses;
	}

	public void setAssignedCourses(LinkedList<String> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}

	public ManagementStaff(String userName, int password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void viewPersonalInfo() {
		System.out.println("Management Staff info");		
	}
	
	public void manageStaff() {
		System.out.println("Çalışanlar kontrol edildi");
	}
	
	public void assignCourse(String lesson) {
		assignedCourses.add(lesson);	
	}
	
	public void dropCourse(String lesson) {
		 if (assignedCourses.contains(lesson)) {
		        assignedCourses.remove(lesson);
		        System.out.println(lesson + " dersi kayıtlardan çıkarıldı.");
		    } else {
		        System.out.println(lesson + " dersi listede bulunamadı.");
		    }
    }
	
}
