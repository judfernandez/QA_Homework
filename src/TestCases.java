import java.util.*;

import junit.framework.TestCase;


//This class are 3 test cases from the Quality Assurance homework
public class TestCases extends TestCase {
	
	/*The first test case, Checks if the student type objects can create
	 * 
	 *Given I have to student parameters 
	 *When I pass the parameters
	 *Then the student should be created
	 * */
	public void testCaseCreateStudent() throws Exception{
		Student testObject = new Student(33, "Rumpa", 3.68);
		assertNotNull(testObject);	
	}
	
	/*The second test case, Checks if a student goes higher on the list than another
	 * 
	 *Given I have two students object
	 *When I pass two students
	 *Then I know which student are higher on the list
	 * */
	public void testCaseCompareStudents() throws Exception{
		Student testObject = new Student(33, "Jose", 3.68);
		Student testObject2 = new Student(30, "Juan", 3.21);
		
		assertTrue(testObject.compareIfHigherThan(testObject2));
	}
	
	/*The third test case, Checks if the function ordered the students in descending order
	 * 
	 *Given I have a students list
	 *When I pass a student list
	 *Then I have the list in descending order
	 * */
	public void testCaseVerifyOrder() throws Exception{
		Student testObject = new Student(33, "Runpa", 3.68);
		Student testObject2 = new Student(85, "Ashir", 3.85);
		Student testObject3 = new Student(56, "Samija", 3.75);
		Student testObject4 = new Student(19, "Samara", 3.75);
		Student testObject5 = new Student(22, "Fahim", 3.76);
		
		List<Student> list = new ArrayList<Student>();
		list.add(testObject);
		list.add(testObject2);
		list.add(testObject3);
		list.add(testObject4);
		list.add(testObject5);
		
		List<Student> orderlist = new ArrayList<Student>();
		orderlist.add(testObject2);
		orderlist.add(testObject5);
		orderlist.add(testObject4);
		orderlist.add(testObject3);
		orderlist.add(testObject);
		
		assertEquals(Solution.sortStudents(list), orderlist);	
	}
	

}
