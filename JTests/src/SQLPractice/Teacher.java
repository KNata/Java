package SQLPractice;

public class Teacher {

	private String name;
	private String subject;
	private int yearOfTeaching;
	
	Teacher(String aName, String aSubject, int aYearOfTeaching) {
		name = aName;
		subject = aSubject;
		yearOfTeaching = aYearOfTeaching;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
