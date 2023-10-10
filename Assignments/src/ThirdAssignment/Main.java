package ThirdAssignment;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Student stu = new Student("Tc",12);
//		stu.getPassword();
//		stu.setPassword(24);
//		stu.getPassword();
		Lecturer lt =new Lecturer("TC1",5587);
		lt.login();
		lt.permissionRequest();
		ManagementStaff m = new ManagementStaff("TC2", 1787);
		m.viewPersonalInfo();
		m.assignCourse("Calculus");
		m.assignCourse("Fizik");
		m.assignCourse("Veri yapilari");
		m.dropCourse("Calculus");
		LinkedList<String> courses =m.getAssignedCourses();
		for (String string : courses) {
			System.out.println(string);
		}//Yönetimin açtığı dersler
		int password = lt.getPassword();
		System.out.println(password);
		stu.enrollCourse(courses.getFirst());//Yönetimin açtığı derslere göre öğrenci kayıt oluyo
		
		
	}

}
