package study_02;

public class Single {
	public static void main(String[] args) {
		Student s1=Student.getStudent();
		s1.setName("aa");
		Student s2=Student.getStudent();
		System.out.println(s2.getName());
	}
	
}
class Student {
	private String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
		
	}
	/**
	 * ����������֤Student����Ψһ
	 *
	 */
	 Student(){}
	private static Student s=new Student();
	public static Student getStudent() {	
		return s;
		
	}
}
