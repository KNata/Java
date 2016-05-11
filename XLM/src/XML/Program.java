package XML;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		Student firstStudent = new Student(1, "Natalia", "Kiselyk");
		Student secondStudent = new Student(2, "Olha", "Ivanova");
		Student thirldStudent = new Student(3, "Oleh", "Kovalchuk");
		Student forthStudent = new Student(4, "Angrii", "Tanchin");
		Student fifthStudent = new Student(5, "Diana", "Oleksandriv");
		
		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(firstStudent);
		studentsList.add(secondStudent);
		studentsList.add(thirldStudent);
		studentsList.add(forthStudent);
		studentsList.add(fifthStudent);
		
		MyFactory theFactory = new MyFactory(studentsList);
		theFactory.createDocument();
		theFactory.readFromDocument();
	}
}
