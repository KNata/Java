package SQLPractice;

public class Course {
	
	private String subject;
	private int yearOfTeaching;
	
	Course(String aSubject, int anYearOfTeaching) {
		subject = aSubject;
		yearOfTeaching = anYearOfTeaching;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the yearOfTeaching
	 */
	public int getYearOfTeaching() {
		return yearOfTeaching;
	}
}
