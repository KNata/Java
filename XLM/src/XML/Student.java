package XML;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	
	
	Student(int anId, String aFirstName, String aLastName) {
		id = anId;
		firstName = aFirstName;
		lastName = aLastName;
	}


	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}
	
}
