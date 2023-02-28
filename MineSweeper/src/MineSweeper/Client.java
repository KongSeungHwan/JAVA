package MineSweeper;

public class Client{//Data Tranfer Object 원래 DTO라고 해야하나 파일입출력으로도 정보로 가지고 오고 싶어서 임의로 Client로 잡음
	private String name;
	private String id;
	private String pw;
	private double vRounds;
	private double tRounds; //출력시 서식문자 %f로 쓰되 .0f로 표기 소수점 아래 표기 안하는 서식문자
	private double vRate;//예외 발생 수정필요
	private String grade;
	Client(String name,String id,String pw){
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = 0;
		this.tRounds = 0;
		vRate=(tRounds>0)?vRounds/tRounds:0;
		grade = "Beginner";
	}//가입시 필요한 생성자
	Client(String name,String id,String pw,int vRounds,int tRounds,double vRate){
		//DB에서는 받아올시 INT로 받지만 DOUBLE로 형변환 자동으로 되게끔 설계
		//설계의도 int끼리는 이항연산자 /를 쓰면 정확하게 소수점 밑자리까지 나오지 않지만 double로 연산을 하면 소수점 밑까지 출력 가능! 
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = vRounds;
		this.tRounds = tRounds; //int >>double은 가능(캐스팅x)
		this.vRate=vRate;
//		if(((tRounds>=0)&&(tRounds<=20))||((vRate>=0)&&(vRate<=50))) grade = "Beginner"; //20판 이하거나 승률 50%미만이면 
//		else if((vRate>50)&&(vRate<=75))grade = "AdvancedPlayer";
//		grade = "Master";
		if((tRounds>=0)&&(tRounds<=20)){
			grade = "Beginner";
		}else if(tRounds>20) {
			if((vRate>=0)&&(vRate<=50)) grade ="AdvancedPlayer";
				
		}else {
			grade = "정지사유 유저";
		}
	}
			
		
	//데이터 받아올 시 사용하는 생성자(오버로딩)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public double getvRounds() {
		return vRounds;
	}
	public void setvRounds(int vRounds) {
		this.vRounds = vRounds;
	}
	public double gettRounds() {
		return tRounds;
	}
	public void settRounds(int tRounds) {
		this.tRounds = tRounds;
	}
	public double getvRate() {
		return vRate;
	}
	public String getGrade() {
		return grade;
	} //승률과 등급은 총 판수와 승리 판수에 따라 종속적으로 연산되는 값이기에 getter만 만들어줬다.
	
	//승률은 조작 불가능하도록 설계(오로지 총 판수랑 승리한 판수로 계산해서 설정되도록 설계)
	//DB에서 처리VS 자바 소스코드에서 처리?
	//setter 제외
	
}
