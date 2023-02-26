package javaStudy2;

public class Student {
	String studentName;
	String address;
	String gender;
	int studentID;

	Subject korean;
	Subject math;
	Subject english;
	//선언만 되어있음 new 키워드로 만들지 않음. 힙, 스택메모리에 안올라옴.
	public Student(){
		System.out.println("Student 객체 생성 시에 보임");
		korean= new Subject();
		math= new Subject();
		english= new Subject();//new 키워드로 객체 생성하나
	}
	public Student(int studentID,String studentName,String gender){
		this();
		System.out.println("Student 객체 생성 시에 보임");
		this.studentID=studentID;
		this.studentName=studentName;
		this.gender=gender;//여기에는 new 키워드로 객체 생성을 안함. 이 생성자로 객체를 만들고 Subject 객체를 호출하면 nullPointerException이 뜬다.
	}
	public void showStudentInfo() {
		System.out.printf("%d,%s,%s,%s \n", studentID,studentName,address,gender);
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public Subject getKorea() {
		return korean;
	}
	public void setKorea(Subject korea) {
		this.korean = korea;
	}
	public Subject getMath() {
		return math;
	}
	public void setMath(Subject math) {
		this.math = math;
	}
	public Subject getEnglish() {
		return english;
	}
	public void setEnglish(Subject english) {
		this.english = english;
	};
	
	
	
}
