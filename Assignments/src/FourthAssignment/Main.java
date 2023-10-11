package FourthAssignment;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		//Student stu = new Student("Tc",12);
//		stu.getPassword();
//		stu.setPassword(24);
//		stu.getPassword();
//		Lecturer lt =new Lecturer("TC1",5587);
//		lt.login();
//		lt.permissionRequest();
//		ManagementStaff m = new ManagementStaff("TC2", 1787);
//		m.viewPersonalInfo();
//		m.assignCourse("Calculus");
//		m.assignCourse("Fizik");
//		m.assignCourse("Veri yapilari");
//		m.dropCourse("Calculus");
//		LinkedList<String> courses =m.getAssignedCourses();
//		for (String string : courses) {
//			System.out.println(string);
//		}//Yönetimin açtığı dersler
//		int password = lt.getPassword();
//		System.out.println(password);
//		stu.enrollCourse(courses.getFirst());//Yönetimin açtığı derslere göre öğrenci kayıt oluyo
		
		ManagementStaff ms = new ManagementStaff("TC12", 5587);
		SpringCourses sc = new SpringCourses();
		//sıkıntı burda yeni bir obje oluşturduğun için son eklenene göre oluyor
		SpringCourses ssc = new SpringCourses();
		FallCourses fc = new FallCourses();
		ms.assignCourse(sc, "Görüntü İşleme");
		ms.assignCourse(ssc, "Siber Güvenlik");
		ms.assignCourse(sc, "Yapay Zeka");
		ms.assignCourse(sc, "Bilgisayar Mimarisi");
		ms.assignCourse(fc, "Computer Network");
		ms.assignCourse(fc, "Kablosuz Haberleşme Ağları");
		ms.assignCourse(fc, "Mobil");
		ms.showCourses();
	
		Student st1 = new Student("tc2323",858745,new FallCourses());
		//st1.enrollCourse();
		
	}

}
