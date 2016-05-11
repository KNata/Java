package GUIDatabase;


public class Teacher {
	private String name = null;
	private String surname = null;
	
	public Teacher(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

}
