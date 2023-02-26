package study11_1;

class Student extends Object{
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	//object equals() 학번이 같으면 같은 삭생
			//hashcode() 학생의 학번의 해쉬 코드 반환
	
	public boolean equals(Object a) //Object 클래스의 equals 함수 오버라이딩
		{ //String 클래스의 equals함수를 쓴것 헷갈리면 안됌.
		if(a instanceof Student) {
		return studentNum.equals(((Student)a).studentNum);
		//호출한 객체의 학번과 매개변수로 들어온 object 객체 a를 Student자료형으로 다운 캐스팅 시켜서 학번을 비교.
		//boolean값을 리턴
		}else {
			return false; //애초에 같은 자료형이 아닐때 그냥 false 리턴 함.
		}
	}
	public int Hashcode(){
		return studentNum.hashCode();
	}
	
}

public class StudentExam {
	public static void main(String[] args){
		Student s1 = new Student("100");
		Student s2 = new Student("200");
		Student s3 = new Student("100");
		sameStudent(s1, s2);
		sameStudent(s1, s3);
		System.out.println(s1.hashCode());
		s1.equals(s2);
		s1.equals(s3);
		s2.equals(s3); //Object 클래스의 equals 함수 오버라이딩해서 사용
		//셋을 비교해서 true/false 값이 나오게끔 설계
		
	}
	public static void sameStudent(Student a,Student b) {
		if(a.equals(b)){
			System.out.println("둘은 같은 학생이다.");
			//두 객체의 주소값을 비교하는 메소드?
			System.out.printf("%d ,%d \n",a.hashCode(),b.hashCode());
		}else {
			System.out.println("둘은 다른 학생이다.");
		}
	}
	//해쉬 코드는 리터럴 값의 해쉬 코드가 나오는 것이다.(객체의 주소 x)
}
