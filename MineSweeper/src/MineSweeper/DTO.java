package MineSweeper;

public class DTO{
	private String name;
	private String id;
	private String pw;
	private double vRounds;
	private double tRounds;
	private double vRate;//예외 발생 수정필요
	DTO(String name,String id,String pw){
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = 0;
		this.tRounds = 0;
		vRate=(tRounds>0)?vRounds/tRounds:0;
	}//가입시 필요한 생성자
	DTO(String name,String id,String pw,int vRounds,int tRounds,double vRate){//DB에서는 받아올시 INT로 받지만 DOUBLE로 형변환 자동으로 되게끔 설계
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = vRounds;
		this.tRounds = tRounds; //int >>double은 가능(캐스팅x)
		this.vRate=vRate;
	}//데이터 받아올 시 사용하는 생성자(오버로딩)
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
	//승률은 조작 불가능하도록 설계(오로지 총 판수랑 승리한 판수로 계산해서 설정되도록 설계)
	//DB에서 처리VS 자바 소스코드에서 처리?
	//setter 제외
	
}
