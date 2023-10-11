package FourthAssignment;

import java.util.LinkedList;

public class ManagementStaff extends Staff {

	private Courses springCourse;
	private Courses fallCourse;

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
		if (course instanceof SpringCourses) {
			this.springCourse = course;
			this.springCourse.addCourses(lesson);
		} else if (course instanceof FallCourses) {
			this.fallCourse = course;
			this.fallCourse.addCourses(lesson);
		}

	}

	public void showCourses() {
	    if (springCourse != null) {
	        LinkedList<String> springCourseList = springCourse.getCoursesList();
	        System.out.println("Spring Courses:");
	        for (String course : springCourseList) {
	            System.out.println(course);
	        }
	    } else {
	        System.out.println("No Spring courses available.");
	    }

	    if (fallCourse != null) {
	        LinkedList<String> fallCourseList = fallCourse.getCoursesList();
	        System.out.println("Fall Courses:");
	        for (String course : fallCourseList) {
	            System.out.println(course);
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
