package SQLPractice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author natalia
 *
 */

public class StudentTest {
	
	private static final String NAME = "Natalia Kiselyk";
	private static final int COURSE = 2;
	
	private Student student;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		student = new Student(NAME, COURSE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetters() {
		assertEquals(NAME, student.getName());
		assertEquals(COURSE, student.getCourse());
	}

}
