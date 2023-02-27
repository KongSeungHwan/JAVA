package javaStudy2;

public class Subject {
	private String subjectName;
	private int score;
	
	Subject(){
		System.out.println("Subject 객체 생성 시에 보임");
	}//생성자
	
	public int getScore() {
		return score;
	};
	public String getSubjectName(){
		return subjectName;
	};
	public void setScore(int score){
		this.score=score;
	};
	public void setSubjectName(String subjectName) {
		this.subjectName=subjectName;
	};
//getter setter 만들기

}
