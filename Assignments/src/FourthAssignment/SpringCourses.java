package FourthAssignment;

import java.util.HashMap;

public class SpringCourses implements Courses {

	private HashMap<Courses, String> coursesSemesterList = new HashMap<Courses, String>();
	
	public SpringCourses(String springSemester) {
		semesterList.add(springSemester);
		this.springSemester = springSemester;
	}

	@Override
	public void getSemesterList() {
		System.out.print("Bahar dönemine ait dersler =>");
		for (String semester : semesterList) {
			 System.out.print("<"+semester + "> ");
		}
		System.out.println("");
	}

	@Override
	public void getCoursesSemesterList(Course course, String semester) {
		coursesSemesterList.put(course, semester);
		
	}


}
