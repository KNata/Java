package SQLPractice;


import java.sql.*;


public class University {
    private Connection con;
        
    public void studentInitialization(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + name);
            PreparedStatement st = con.prepareStatement("create table if not exists 'Students' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'course' INTEGER);");
            int result = st.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println(" JDBC");
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }     
    }
    
    public void teacherInitialization(String name){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + name);
            PreparedStatement st = con.prepareStatement("create table if not exists 'Teachers' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'subject' text, 'yearOfTeaching' INTEGER);");
            int result = st.executeUpdate();
        }catch(ClassNotFoundException e){
            System.out.println(" JDBC");
            e.printStackTrace();
            System.exit(0);
        }catch (SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }     
    }
    
    public void courseInitialization(String name){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + name);
            PreparedStatement st = con.prepareStatement("create table if not exists 'Courses' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'subject' text, 'yearOfStuding' INTEGER);");
            int result = st.executeUpdate();
        }catch(ClassNotFoundException e){
            System.out.println(" JDBC");
            e.printStackTrace();
            System.exit(0);
        }catch (SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }     
    }
    
    public void insertStudentData(Student aStudent){
        try{
        	String name = aStudent.getName();
        	int course = aStudent.getCourse();
            PreparedStatement statement = con.prepareStatement("INSERT INTO Students(name, course) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, course);

            int result = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
    
    public void insertTeacherData(Teacher aTeacher){
        try{
        	String name = aTeacher.getName();
        	String subject = aTeacher.getSubject();
        	int yearOfTeaching = aTeacher.getYearOfTeaching();
            PreparedStatement statement = con.prepareStatement("INSERT INTO Teachers(name, subject, yearOfTeaching) VALUES (?,?,?)");
            //statement.setInt(1, 1);
            statement.setString(1, name);
            statement.setString(2, subject);
            statement.setInt(3, yearOfTeaching);

            int result = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
    
    public void insertCourseData(Course aCourse){
        try{
        	String subject = aCourse.getSubject();
        	int yearOfStudy = aCourse.getYearOfTeaching();
            PreparedStatement statement = con.prepareStatement("INSERT INTO Courses(subject, yearOfStuding) VALUES (?,?)");
            statement.setString(1, subject);
            statement.setInt(2, yearOfStudy);

            int result = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
    
    public void removeFromStudents(int id) {
    	PreparedStatement statement = null;
    	try {
    		statement = con.prepareStatement("DELETE FROM Students WHERE id = ?");
    		statement.setInt(1, id);
    		statement.executeUpdate();
    		System.out.println("The student with id " + id + " was deleted");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		if (statement != null) {
    			try {
    				statement.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    public void selectSudentsFrom() {
    	Statement statement = null;
    	try {
    		statement = con.createStatement();
    		ResultSet resSet = statement.executeQuery("SELECT * FROM Students;");
    		while (resSet.next()) {
    			int id = resSet.getInt("id");
    			String name = resSet.getString("name");
    			System.out.println("Id: " + id);
    			System.out.println("Name: " + name);
    			System.out.println("");
    		}
    		resSet.close();
    		statement.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("Operation done successfully");
    }
    
    public void selectTeachersFrom() {
    	Statement statement = null;
    	try {
    		statement = con.createStatement();
    		ResultSet resSet = statement.executeQuery("SELECT * FROM Teachers;");
    		while (resSet.next()) {
    			int id = resSet.getInt("id");
    			String name = resSet.getString("name");
    			System.out.println("Id: " + id);
    			System.out.println("Name: " + name);
    			System.out.println("");
    		}
    		resSet.close();
    		statement.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("Operation done successfully");
    }
    
    public void selectCoursesFrom() {
    	Statement statement = null;
    	try {
    		statement = con.createStatement();
    		ResultSet resSet = statement.executeQuery("SELECT * FROM Courses;");
    		while (resSet.next()) {
    			int id = resSet.getInt("id");
    			String name = resSet.getString("subject");
    			System.out.println("Id: " + id);
    			System.out.println("Name: " + name);
    			System.out.println("");
    		}
    		resSet.close();
    		statement.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("Operation done successfully");
    }
    
    public void removeFromTeachers(int id) {
    	PreparedStatement statement = null;
    	try {
    		statement = con.prepareStatement("DELETE FROM Teachers WHERE id = ?");
    		statement.setInt(1, id);
    		statement.executeUpdate();
    		System.out.println("The teacher with id " + id + " was deleted");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		if (statement != null) {
    			try {
    				statement.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    public void removeFromCourses(int id) {
    	PreparedStatement statement = null;
    	try {
    		statement = con.prepareStatement("DELETE FROM Courses WHERE id = ?");
    		statement.setInt(1, id);
    		statement.executeUpdate();
    		System.out.println("The subject with id " + id + " was deleted");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		if (statement != null) {
    			try {
    				statement.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    public void showAllStudents(){
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Students");
            while (res.next()) {
                String name = res.getString("name");
                System.out.println (res.getShort("id")+" "+name);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
    
    public void showAllTeachers(){
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Teachers");
            while (res.next()) {
                String name = res.getString("name");
                System.out.println (res.getShort("id")+" "+name);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
    
    public void showAllCourses(){
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Courses");
            while (res.next()) {
                String name = res.getString("subject");
                System.out.println (res.getShort("id")+" "+name);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Wrong SQL");
            e.printStackTrace();
        }
    }
}
