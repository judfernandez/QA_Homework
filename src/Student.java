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
	public boolean compareIfHigherThan(Student student) {
		
		if ( this.getCgpa() > student.getCgpa() ) {
			return true;
		}
		else if( this.getCgpa() == student.getCgpa() ) {
			
			if ( this.getFname().compareTo(student.getFname()) < 0 ) {
				return true;
			}
			else if ( this.getFname().compareTo(student.getFname()) == 0 ) {
				if (this.getId() > student.getId()) {
					return true;
				}
			}		
		}
		
		return false;
	}
}