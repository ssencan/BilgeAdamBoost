package FourthAssignment;

import java.util.LinkedList;

public class FallCourses implements Courses {
	private LinkedList<String> fallCoursesList = new LinkedList<String>();

	@Override
	public void addCourses(String lesson) {
		fallCoursesList.add(lesson);

	}

	@Override
	public LinkedList<String> getCoursesList() {

		return fallCoursesList;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
