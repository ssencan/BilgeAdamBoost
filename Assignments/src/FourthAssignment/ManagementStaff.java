package FourthAssignment;

import java.util.LinkedList;

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
		if (course.getClass()== SpringCourses.class) {
			
			course.addCourses(lesson);
		} else if (course.getClass()== FallCourses.class) {
			course.addCourses(lesson);
		}

	}
//Burda course parametresi ile önceden initiate edilmiş dönemi parametre alarak o döneme ait ders listesi gösterilmesi sağlanıyor.
	public void showCourses(Courses course) {
	    if (course.getClass()== SpringCourses.class) {
	        LinkedList<String> springCourseList = course.getCoursesList();
	        System.out.println("Spring Courses:");
	        for (String courses : springCourseList) {
	            System.out.println(courses);
	        }
	    } else {
	        System.out.println("No Spring courses available.");
	    }

	    if (course.getClass()== FallCourses.class) {
	        LinkedList<String> fallCourseList = course.getCoursesList();
	        System.out.println("Fall Courses:");
	        for (String courses : fallCourseList) {
	            System.out.println(courses);
	        }
	    } else {
	        System.out.println("No Fall courses available.");
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
