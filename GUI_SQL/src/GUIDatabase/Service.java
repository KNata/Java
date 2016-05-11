package GUIDatabase;


public class Service {
	
	public static Student getStudent(String name, String surname) throws Exception
	{
		if(name == null || surname ==null ||name.equals("")||surname.equals("")) throw new Exception("Wrong parameters to create Student");
		return new Student(name,surname);
	}
	public static Teacher getTeacher(String name, String surname) throws Exception{
		if(name == null || name.equals("")||surname == null ||surname.equals("")) throw new Exception("Wrong parameters");
		return new Teacher(name,surname);
	}
	public static Course getCourse(String name) throws Exception
	{
		if(name == null || name.equals("")) throw new Exception("Wrong input");
		return new Course(name);
	}

}
