package FourthAssignment;

import java.util.LinkedList;
import java.util.Scanner;

public class ManagementStaff extends Staff {

	public ManagementStaff(String userName, int password) {
		super(userName, password);
	}

	@Override
	public void viewPersonalInfo() {
		System.out.println("Management Staff info");
	}

	public void manageStaff() {
		System.out.println("Çalışanlar kontrol edildi");
	}

	// Yönetim Ders dönemini ve ders ismini Dependency Injection ile Courses
	// interfacini kullanan Spring ve Fall Courses içindeki listeye ekler.
	public void assignCourse(Courses course, String lesson) {
		if (course.getClass() == SpringCourses.class) {

			course.addCourses(lesson);
		} else if (course.getClass() == FallCourses.class) {
			course.addCourses(lesson);
		}

	}

//Burda course parametresi ile önceden initiate edilmiş dönemi parametre alarak o döneme ait ders listesi gösterilmesi sağlanıyor.
	// Zaten dönemler belli mantıken de hangi döneme gelindiyse güz veya bahar ona
	// göre ekleme yapabiliyor.
	// burda eklenen semesterları ekranda göstertip onu gösterteliim. show courses
	// parametre almasın course içinden seçileni alsın
	// obje adı ile semestera adı aynı olmalı logicte onu zorlamaya bak. sonrası
	// Hashmaple semester ve obje tutmayı dene
	// tek hashmap olursa assigncourse ederken de semester lazım olacak
	public void showCourses(Courses course) {
	    System.out.println("Mevcut dönemler: " + course.getSemesterList());
	    System.out.println("Hangi dönemi seçmek istiyorsunuz?");
	    Scanner scn = new Scanner(System.in);
	    String semester = scn.nextLine();

	    LinkedList<String> coursesList = new LinkedList<String>();

	    if (course instanceof SpringCourses) {
	        coursesList = course.getCoursesList();
	    } else if (course instanceof FallCourses) {
	        coursesList = course.getCoursesList();
	    }

	    if (course.getSemesterList().contains(semester)) { // Eğer dönem liste içinde varsa
	        System.out.println(semester + " Dönemi Dersleri:");
	        for (String courseName : coursesList) {
	            System.out.println(courseName);
	        }
	    } else {
	        System.out.println("Bu dönem için ders bulunamadı.");
	    }
	}

//	public void dropCourse(String lesson) {
//		 if (assignedCourses.contains(lesson)) {
//		        assignedCourses.remove(lesson);
//		        System.out.println(lesson + " dersi kayıtlardan çıkarıldı.");
//		    } else {
//		        System.out.println(lesson + " dersi listede bulunamadı.");
//		    }
//    }

}
