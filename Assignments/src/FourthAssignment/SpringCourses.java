package FourthAssignment;

import java.util.LinkedList;

public class SpringCourses implements Courses {
	private LinkedList<String> springCoursesList = new LinkedList<String>();

	@Override
	public void addCourses(String lesson) {
		springCoursesList.add(lesson);

	}

	@Override
	public LinkedList<String> getCoursesList() {
		return springCoursesList;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
