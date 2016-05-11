package SQLPractice;

public class Student {
	
	private String name;
	private int course;
	
	Student(String aName, int aCourse) {
		name = aName;
		course = aCourse;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the course
	 */
	public int getCourse() {
		return course;
	}

}
