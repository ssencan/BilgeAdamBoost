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
		SpringCourses bahar1 = new SpringCourses("1. Bahar Dönemi");
		// sıkıntı burda yeni bir obje oluşturduğun için son eklenene göre oluyor
		SpringCourses bahar2 = new SpringCourses("2. Bahar Dönemi");
		FallCourses güz1 = new FallCourses("1. Güz Dönemi ");
		FallCourses güz2 = new FallCourses("2. Güz Dönemi");

		ms.assignCourse(bahar1, "Görüntü İşleme");
		ms.assignCourse(bahar1, "Yapay Zeka");
		ms1.assignCourse(bahar1, "Bilgisayar Mimarisi");
		ms.assignCourse(bahar2, "Siber Güvenlik");
		ms.assignCourse(güz1, "Computer Network");
		ms1.assignCourse(güz1, "Kablosuz Haberleşme Ağları");
		ms.assignCourse(güz1, "Mobil");
		// ms.assignCourse(güz2, "Mobil1221");

		ms.showCourses(güz1);

		Student st1 = new Student("tc2323", 858745);

		/*
		 * buna benzer yapmaya çalış import java.util.ArrayList; import java.util.List;
		 * 
		 * // Örnek bir sınıf class ListManager { private List<String> nameList;
		 * 
		 * // Constructor public ListManager() { this.nameList = new ArrayList<>(); }
		 * 
		 * // Listeye ekleme metodunu tanımlayalım public void addToNameList(String
		 * name) { this.nameList.add(name); } }
		 * 
		 * // Ana sınıf public class Main { public static void main(String[] args) { //
		 * İlgili sınıfın örneğini oluşturun ListManager listManager = new
		 * ListManager();
		 * 
		 * // Yeni bir obje oluşturun Object obj = new Object();
		 * 
		 * // Oluşturulan objenin adını (referansını) ilgili sınıfa gönderin
		 * listManager.addToNameList(obj.toString()); } }
		 * 
		 */

	}

}
