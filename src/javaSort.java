import static org.junit.Assert.*;				
import org.junit.Test;	
import java.util.*;


public class javaSort {
	
	//Method to read the students from console. Taken from the java sort webpage
	public static List<Student> readStudents(){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		for(int i=0;i<testCases;i++){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
		}
		return studentList;
	}
	
	//Sorting method
	public static List<Student> sortStudents(List<Student> list){
		
		int n = list.size();  
		Student temp;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(!list.get(j-1).isHigherThan(list.get(j))){  
					temp = list.get(j-1);  
					list.set(j-1, list.get(j));  
                    list.set(j, temp);  
				}                     
			}  
		}  
		return list;
	}
	

	//First test, checks if the CGPA is in order

	//Given a list of students
	//When they are sorted by CGPA
	//Then the students with the best CGPA should be first on the list
	@Test
	public void testSort1() {
		List<Student> list = readStudents();
		List<Student> sortedList = sortStudents(list);
		for(int i=0; i<sortedList.size()-1;i++) {
			assertTrue(sortedList.get(i).getCgpa()>=sortedList.get(i+1).getCgpa());
		}
	}

	//Second test, checks if the names are in order when there is a duplicate CGPA

	//Given a list of students
	//When they are sorted by CGPA and their first name
	//Then the students with the best CGPA should be first on the list, and students with the same CGPA should be sorted by their first name
	@Test
	public void testSort2() {
		List<Student> list = readStudents();
		List<Student> sortedList = sortStudents(list);
		for(int i=0; i<sortedList.size()-1;i++) {
			if(sortedList.get(i).getCgpa()==sortedList.get(i+1).getCgpa()) {
				int compare = sortedList.get(i).getFname().compareTo(sortedList.get(i+1).getFname());
				assertTrue(compare <= 0);
			}			
		}
	}
	//Third test, checks if the ID are in order given the students have the same CGPA and First name

	//Given a list of students
	//When they are sorted by CGPA, their first name and their ID
	//Then the students with the best CGPA should be first on the list, students with the same CGPA should be sorted by their first name, and students with same CGPA and first name should be sorted by ID
	@Test
	public void testSort3() {
		List<Student> list = readStudents();
		List<Student> sortedList = sortStudents(list);
		for(int i=0; i<sortedList.size()-1;i++) {
			if(sortedList.get(i).getCgpa()==sortedList.get(i+1).getCgpa()) {
				if(sortedList.get(i).getFname().equals(sortedList.get(i+1).getFname())) {
					assertTrue(sortedList.get(i).getId()>sortedList.get(i+1).getId());			
				}
			}			
		}
	}
	
	public static void main(String[] args){		
		List<Student> list = readStudents();
		List<Student> sortedList = sortStudents(list);
		for(Student st: sortedList){
			System.out.println(st.getFname());
		}
	}
}

//Class student taken from the Java Sort webpage
class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	//Check if a student is "Higher" from other according to the problem's rules
	public boolean isHigherThan(Student st) {
		if(this.cgpa>st.getCgpa()) {
			return true;			
		}else{ 
			if(this.cgpa==st.getCgpa()) {
				if(this.getFname().compareTo(st.getFname()) < 0) {
					return true;
				}else{
					if(this.getFname().compareTo(st.getFname()) == 0) {
						if(this.getId()>st.getId()) {
							return true;
						}
					}
				}
			}
		}	
		return false;
	}
}