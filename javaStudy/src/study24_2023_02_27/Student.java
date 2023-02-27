package study24_2023_02_27;

public class Student {
	private final boolean isMale;
	private final String name;
	private final int grade;
	private final int ban;
	private final int score; //constant pool에 할당하여 값 수정 불가
	//constructor
	public Student(String name,boolean isMale, int grade, int ban, int score) {
		this.isMale = isMale;
		this.name = name;
		this.grade = grade;
		this.ban = ban;
		this.score = score;
	}
	//getter
	public boolean isMale() {
		return isMale;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public int getBan() {
		return ban;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return String.format("%s, %s, %s %d반 %3d점",name,isMale? "남":"여",grade,ban,score);
	}
}
