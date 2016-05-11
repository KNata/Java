package SQLPractice;

public class Program {
	
	public static void main(String[] args){
        University sqlTest = new University();
        // students
        System.out.println("********Students********");
        Student firstStudent = new Student("Natalia Kiselyk", 2);
        Student secondStudent = new Student("Denys Frosty", 3);
        System.out.println("Before:");
        sqlTest.studentInitialization("Students.db");
        //sqlTest.insertStudentData(firstStudent);
        //sqlTest.insertStudentData(secondStudent);
        sqlTest.selectSudentsFrom();
        //sqlTest.showAllStudents();
        //sqlTest.removeFromStudents(1);
        System.out.println("After:");
       // sqlTest.showAllStudents();
        
        // teachers        
        System.out.println(" ");
        System.out.println("********Teachers********");
        Teacher firstTeacher = new Teacher("Anton Makatov", "computer science", 1);
        Teacher secondTeacher = new Teacher("Larysa Babchenko", "Multimedia", 4);
        sqlTest.teacherInitialization("Teachers.db");
        sqlTest.insertTeacherData(firstTeacher);
        sqlTest.insertTeacherData(secondTeacher);
        sqlTest.selectTeachersFrom();
        System.out.println("Before:");
        sqlTest.showAllTeachers();
        sqlTest.removeFromTeachers(2);
        System.out.println("After:");
        sqlTest.showAllTeachers();
        
        // courses
        System.out.println(" ");
        System.out.println("********Courses********");
        Course algebra = new Course("Algebra", 1);
        Course programming = new Course("programming", 2);
        Course informationSearch = new Course("informationSearch", 3);
        sqlTest.courseInitialization("Courses.db");
        sqlTest.insertCourseData(algebra);
        sqlTest.insertCourseData(programming);
        sqlTest.insertCourseData(informationSearch);
        sqlTest.selectCoursesFrom();
        System.out.println("Before:");
        sqlTest.showAllCourses();
        sqlTest.removeFromCourses(3);
        System.out.println("After:");
        sqlTest.showAllCourses();
    }

}
