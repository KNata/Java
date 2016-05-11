package FINDataBase;

import java.sql.SQLException;

import SQLiteTest.Course;
import SQLiteTest.Student;
import SQLiteTest.Teacher;

public class Program {
	
	public static void main(String[] args) throws SQLException {
		
		Student firstStudent = new Student("Natalia", "Kiselyk", 2);
		Student secondStudent = new Student("Andrii", "Ivanov", 1);
		Student thirldStudent = new Student("Stasia", "Bajko", 3);
		Student forthStudent = new Student("Vasul", "Sinitsa", 4);
		
		Teacher firstTeacher = new Teacher("Oleh", "Pokalchuck", "Software Testing", 4);
		Teacher secondTeacher = new Teacher("Ivan", "Babchenko", "Programming languages", 2);
		
		Course firstCourse = new Course("Cloud computing", 2);
		Course secondCourse = new Course("Cryptography", 4);
		Course thirldCourse = new Course("Web technology", 1);
		
		Service theService = new Service();
		theService.initialization("HelloDB");
		theService.addStudents(firstStudent);
		//theService.addTeachers(firstTeacher);
		theService.removeFromDatabase(3, "firstStudent");
	}

}
