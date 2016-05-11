package SQLPractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseTest {
	
	private static final String SUBJECT = "Alghebra";
	private static final int YEAR_OF_STUDING = 1;
	
	private Course course;
	
	@Before
	public void setUp() throws Exception {
		course = new Course(SUBJECT, YEAR_OF_STUDING);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(SUBJECT, course.getSubject());
		assertEquals(YEAR_OF_STUDING, course.getYearOfTeaching());
	}
}
