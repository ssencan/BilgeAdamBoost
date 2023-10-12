package FourthAssignment;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// Student stu = new Student("Tc",12);
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
		ManagementStaff ms1 = new ManagementStaff("TC12", 5587);
		SpringCourses bahar1 = new SpringCourses();
		// sıkıntı burda yeni bir obje oluşturduğun için son eklenene göre oluyor
		SpringCourses bahar2 = new SpringCourses();
		FallCourses güz1 = new FallCourses();
		FallCourses güz2 = new FallCourses();

		ArrayList<Courses> coursesList = new ArrayList<>();

		ms.assignCourse(bahar1, "Görüntü İşleme");

		ms.assignCourse(bahar1, "Yapay Zeka");
		ms1.assignCourse(bahar1, "Bilgisayar Mimarisi");
		ms.assignCourse(bahar2, "Siber Güvenlik");
		ms.assignCourse(güz1, "Computer Network");
		ms1.assignCourse(güz1, "Kablosuz Haberleşme Ağları");
		ms.assignCourse(güz1, "Mobil");
		// ms.assignCourse(güz2, "Mobil1221");
		
		//Oluşturulan dönemler dizide tutuldu. Çünkü başka yıllara ait dönemler olabilir.
		coursesList.add(bahar1);
		coursesList.add(bahar2);
		coursesList.add(güz1);
		coursesList.add(güz2);

		ms.showCourses(güz1);

		Student st1 = new Student("tc2323", 858745, new FallCourses());
		// st1.enrollCourse();

	}

}
