package study03;

public class Subject {
	private String name;//과목이름
	private int score;//과목점수
	
	// 생성자가 따로 없어도 컴파일러에서 자동으로 디폴트 생성자를 만들어줌
	
	
	//getter/setter
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score){
		this.score=score;
	}
}
