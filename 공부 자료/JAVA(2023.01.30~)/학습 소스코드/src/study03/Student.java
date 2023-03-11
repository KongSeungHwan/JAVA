package study03;

import java.util.ArrayList;

public class Student {
	private static int sequentialNumber = 1000;
	//학번 출력을 위한 공유값
	int studentId;
	String studentName;
	int grade;

	ArrayList<Subject> subjectList;//ArrayList 에 저장될 자료형은 Subject 객체이다.

	public Student() {
		subjectList =new ArrayList<Subject>(/*배열 길이 넣을시*/);
		this.studentId =sequentialNumber;
		sequentialNumber++;

	}//기본 생성자
	public Student(String studentName,int grade){
		this();
		this.studentName=studentName;
		this.grade=grade;
	}
	//과목을 추가하는 메소드
	public void addSubject(String name, int score){
		Subject sub = new Subject();
		sub.setName(name);
		sub.setScore(score);
		subjectList.add(sub);//배열에 해당 객체를 추가
		
	}
	//배열 요소 값 출력
	public void showStudentInfo() {
		int total=0;
		for(Subject a: subjectList) {
			total+=a.getScore();
			System.out.printf("%s 학생 %s의 %s과목성적은 %d입니다. \n", studentId,studentName, a.getName(),a.getScore());
		}
		System.out.printf("%s 학생의 총점은 %d입니다 \n",studentId,total);
		
	}//출력문은 ln으로 쓰고 + 연산자로 써도 무방하나 꼴뵈기 싫어서 그냥 f로 함
	public static void showSequentialNumber() {
		System.out.println(sequentialNumber);
	}
}// 데이터 처리 반환 값을 받고 다른곳에서 출력하냐 메소드 안에서출력하냐 상황에 따라 판단
