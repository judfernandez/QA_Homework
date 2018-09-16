import java.util.*;

public class Solution
{
	public static List<Student> readStudents(){
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.ENGLISH);
		
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
		
		return studentList;
		
	}
	
	public static List<Student> sortStudents(List<Student> list){
		
		Student tempStudent;  
		
		for(int i = 0; i < list.size(); i++){  
			for(int j = 1; j < (list.size() - i); j++){  
				if(!list.get(j-1).compareIfHigherThan(list.get(j))){  
					tempStudent = list.get(j-1);  
					list.set(j-1, list.get(j));  
                    list.set(j, tempStudent);  
				}                     
			}  
		}  
		return list;
	}
	
	public static void printStudents(List<Student> list) {
		for(Student st: list){
			System.out.println(st.getFname());
		}
	}
	
	public static void main(String[] args){
		List<Student> students = readStudents();
		List<Student> studentsSorted = sortStudents(students);
		printStudents(studentsSorted);

	}
}