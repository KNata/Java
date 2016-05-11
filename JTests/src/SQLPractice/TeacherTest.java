package SQLPractice;

import static org.junit.Assert.*;

import javax.security.auth.Subject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author natalia
 *
 */
public class TeacherTest {
	
	private static final String NAME = "Anton Makatov";
	private static final String SUBJECT = "computer science";
	private static final int YEAR_OF_TEACHING = 1;
	
	private Teacher teacher;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		teacher = new Teacher(NAME, SUBJECT, YEAR_OF_TEACHING);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(NAME, teacher.getName());
		assertEquals(YEAR_OF_TEACHING, teacher.getYearOfTeaching());
		assertEquals(SUBJECT, teacher.getSubject());
	}
	
	

}
