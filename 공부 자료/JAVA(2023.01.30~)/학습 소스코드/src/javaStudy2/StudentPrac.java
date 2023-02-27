package javaStudy2;

public class StudentPrac {

	public static void main(String[] args) {
		Student stuA = new Student();
		stuA.korean.setSubjectName("국어");
		System.out.println(stuA.korean.getSubjectName());
		Student stuB= new Student(100,"이순신","남성");
		stuB.english= new Subject(); 
		stuB.english.setSubjectName("영어");
		System.out.println(stuB.english.getSubjectName());
		stuA.studentID=200;
		stuA.studentName="홍길동";
		stuA.address="서울 어딘가";
		stuA.gender="남성";
		stuA.showStudentInfo();
		

	}

}
