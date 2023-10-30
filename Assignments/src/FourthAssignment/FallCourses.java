package FourthAssignment;

import java.util.LinkedList;

public class FallCourses implements Courses {
	private String fallSemester;
	private LinkedList<String> fallCoursesList = new LinkedList<String>();
	private static LinkedList<String> semesterList = new LinkedList<String>();
	//Her management staff örneği oluştuğunda ayrı semester listesi tutmasın, ortak müfreadat üzerinde çalışsınlar istiyorum. BU yüzden bu listeler static.

	public FallCourses(String fallSemester) {
		semesterList.add(fallSemester);
		this.fallSemester = fallSemester;
	}

	@Override
	public void addCourses(String lesson) {
		fallCoursesList.add(lesson);

	}

	@Override
	public LinkedList<String> getCoursesList() {

		return fallCoursesList;
	}

	@Override
	public void getSemesterList() {
		System.out.print("Güz dönemine ait dersler =>");
		for (String semester : semesterList) {
			System.out.print("<"+semester + "> ");
		}
		System.out.println("");
	}

}
