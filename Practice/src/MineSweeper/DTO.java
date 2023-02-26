package MineSweeper;

public class DTO{
	private String name;
	private String id;
	private String pw;
	private int vRounds;
	private int tRounds;
	DTO(String name,String id,String pw){
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = 0;
		this.tRounds = 0;
	}
	DTO(String name,String id,String pw,int vRounds,int tRounds){
		this.name =name;
		this.id=id;
		this.pw=pw;
		this.vRounds = vRounds;
		this.tRounds = tRounds;
	}
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
	public int getvRounds() {
		return vRounds;
	}
	public void setvRounds(int vRounds) {
		this.vRounds = vRounds;
	}
	public int gettRounds() {
		return tRounds;
	}
	public void settRounds(int tRounds) {
		this.tRounds = tRounds;
	}
}
