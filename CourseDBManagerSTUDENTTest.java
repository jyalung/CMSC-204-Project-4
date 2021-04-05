package project4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerSTUDENTTest {
	private CourseDBManagerInterface data = new CourseDBManager();
	
	@Before
	public void setUp() throws Exception {
		data = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	public void testAdd() {
		try {
			data.add("ENGL101",20401,3,"HB325","Rebecca Portis");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testReadFile() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("ENGL102 33230 3 SCI204 A Deadrick");
			inFile.print("MATH165 30838 4 SC363 M. Aronne");
			
			inFile.close();
			data.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	public void testShowAll() {
		
		data.add("CMSC104",20553,3,"WEB","G. Thai");
		data.add("MATH165",20899,4,"WEB","S. Kolluru");
		data.add("PHOT161",21115,3,"TC145","R. Beverly");
		ArrayList<String> list = data.showAll();
		
		assertEquals(list.get(2),"\nCourse:MATH165 CRN:20899 Credits:4 Instructor:S. Kolluru Room:WEB");
		assertEquals(list.get(0),"\nCourse:CMSC104 CRN:20553 Credits:3 Instructor:G. Thai Room:WEB");
		assertEquals(list.get(1),"\nCourse:PHOT161 CRN:21115 Credits:3 Instructor:R. Beverly Room:TC145");
	}

}
