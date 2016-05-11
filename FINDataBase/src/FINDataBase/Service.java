package FINDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SQLiteTest.Course;
import SQLiteTest.Student;
import SQLiteTest.Teacher;

public class Service {

	private Connection connection;
	Statement statement;
	private Student student;
	
	
	Service() {
		
	}
	
	public void initialization(String name) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection("jdbc:sqlite:" + name);
			System.out.println("Creating database...");
			statement = connection.createStatement();
			String sql = "CREATE UNIVERSITY";
			statement.executeUpdate(sql);
			System.out.println("Database created cuccessfully...");
		 } catch(SQLException se) {
		      se.printStackTrace();
		   } catch (Exception e) {
		      e.printStackTrace();
		   } finally {
		      try {
		         if (statement != null)
		        	 statement.close();
		      } catch (SQLException se2) {
		    }
		      try {
		         if (connection != null)
		        	 connection.close();
		      } catch(SQLException se) {
		         se.printStackTrace();
		      }
		   }
		   System.out.println("Goodbye!");
	}	
	
	
	
	
	
	public void addStudents(Student aStudent) throws SQLException {
		PreparedStatement preparedStatementFN = connection.prepareStatement("INSERT INTO STUDENT_FIRST_NAME (aStudent) VALUES(?)");
		PreparedStatement preparedStatementLN = connection.prepareStatement("INSERT INTO STUDENT_LAST_NAME (aStudent) VALUES(?)");
		PreparedStatement preparedStatementCR = connection.prepareStatement("INSERT INTO COUSE (aStudent) VALUES(?)");
		
		preparedStatementFN.setString(1, aStudent.getFirstName());
		preparedStatementLN.setString(2, aStudent.getLastName());
		preparedStatementCR.setInt(3, aStudent.getCourse());
		
		int resultFN = preparedStatementFN.executeUpdate();
		int resultLN = preparedStatementLN.executeUpdate();
		int resultCS = preparedStatementCR.executeUpdate();   
		
		preparedStatementFN.close();
		preparedStatementLN.close();
		preparedStatementCR.close();
		
		System.out.println("Data added succssesfully");
	}
	
	public void addTeachers(Teacher aTeacher) throws SQLException {
		PreparedStatement preparedStatementFN = connection.prepareStatement("INSERT INTO techerFirstName (aTeacher.getFirstName()) VALUES(?)");
		PreparedStatement preparedStatementLN = connection.prepareStatement("INSERT INTO teacherLastName (aTeacher.getLastName()) VALUES(?)");
		//PreparedStatement preparedStatementSJ = connection.prepareStatement("INSERT INTO subject (aTeacher.getSubject()) VALUES(?)");
		PreparedStatement preparedStatementCR = connection.prepareStatement("INSERT INTO subjectT (aTeacher.getYearOfTeaching()) VALUES(?)");
		
		preparedStatementFN.setString(1, aTeacher.getFirstName());
		preparedStatementLN.setString(2, aTeacher.getLastName());
		//preparedStatementSJ.setString(3, aTeacher.getSubject());
		preparedStatementCR.setInt(4, aTeacher.getYearOfTeaching());
		
		int resultFN = preparedStatementFN.executeUpdate();
		int resultLN = preparedStatementLN.executeUpdate();
		//int resultSJ = preparedStatementSJ.executeUpdate();
		int resultCS = preparedStatementCR.executeUpdate();   
		
		preparedStatementFN.close();
		preparedStatementLN.close();
		//preparedStatementSJ.close();
		preparedStatementCR.close();
		
		System.out.println("Data added succssesfully");
	}
	
	public void addCourses(Course aCourse) throws SQLException {
		PreparedStatement preparedStatementCR = connection.prepareStatement("INSERT INTO subject (aCourse.getSubject()) VALUES(?)");
		PreparedStatement preparedStatementYS = connection.prepareStatement("INSERT INTO yearOfStudyS (aCourse.getYearOfStudy()) VALUES(?)");
		
		preparedStatementCR.setString(1, aCourse.getSubject());
		preparedStatementYS.setInt(2, aCourse.getYearOfStudy());
		
		int resultCR = preparedStatementCR.executeUpdate();
		int resultYS = preparedStatementYS.executeUpdate();
		
		preparedStatementCR.close();
		preparedStatementYS.close();
		
		System.out.println("Data added succssesfully");
	}
	
//	public void findInformation(String aString) throws SQLException {
//		Statement statement = connection.createStatement();
//		ResultSet resSet = statement.executeQuery("SELECT * FROM University");
//		while(resSet.next()) {
//			String firstName = resSet.getString(student.getFirstName());
//			if (firstName.equals(aString)) {
//				System.out.println("");
//			}
//		}
//	}
	
	public void removeFromDatabase(int i, String anElement ) throws SQLException {
		Statement statement = connection.createStatement();
		String deleteStringFromSQL = "DELETE from University where " + i + "=" + anElement;
		statement.executeUpdate(deleteStringFromSQL);
		connection.commit();
		ResultSet resSet = statement.executeQuery("SELECT * FROM University");
		while (resSet.next()) {
			String studentFirstName = resSet.getString("firstName");
			String studentLastName = resSet.getString("lastName");
			String studentCourse = resSet.getString("course");
			System.out.println("Student's first name: " + studentFirstName);
			System.out.println("Student's last name: " + studentLastName);
			System.out.println("Student's course: " + studentCourse);
		}
		resSet.close();
		statement.close();
		connection.close();
	    System.out.println("Operation done successfully");
	}
}
