package MemberManagementSystemMadeByJava;

public class Client {
	private String name;
	private String id;
	private String password;
	private int balance;
	private int accountNumber;
	
	Client(){
		System.out.println("로그아웃 되었습니다.");
	}
	Client(String name,String id,String password,int balance,int accountNumber){
		this.name =name;
		this.id =id;
		this.password = password;
		this.balance = balance;
		this.accountNumber=accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
