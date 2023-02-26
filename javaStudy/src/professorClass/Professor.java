package professorClass;



public class Professor {
	private String name; //이름
	private String affiliation; //소속
	private int difficulty; //난이도
	
	
	
	//생성자 따로 요구사항 없음(디폴트로 냅둠)
	
	
	
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	//getter/setter
	
	void callAttendance() {
		System.out.println("다왔나 출석 부르겠다");
	}
	void giveAssignment() {
		System.out.println("과제 내겠다");
	}
	void grantGrade(String grade){
		System.out.printf("넌 %s 다.",grade);
		switch(grade){
			case "A+":
				System.out.println("열심히 했구나!");
				break;
			case "A":
				System.out.println("잘 했다!");
				break;
			case "B":
				System.out.println("무난하게 했구나!");
				break;
			case "C":
				System.out.println("좀 더 노력해라!");
				break;
			case "D":
				System.out.println("수업 안듣고 놀았구나..");
				break;
			case "F":
				System.out.println("수업 다시 듣거라 ^^");
				break;
			default:
				System.out.println("학점으로 줄 수 있는 값이 아닌데?");
		}
	}

}
