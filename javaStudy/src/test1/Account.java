package test1;

public class Account{
	private int id;
	private String password;
	private String ownerName;
	private int balance;

	Account(int id,String password,String name){
		this.id = id;
		this.password = password;
		this.ownerName = name;
	}
	// 전역변수는 그냥 기본값이 있음 초기화 안해도 0임(지역변수일때는 꼭 초기화 해주자!)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	void deposit(int price) {
		balance+=price;
		System.out.printf("현재 잔고: %d \n",balance);
		System.out.println("입금완료"); 
	}
	int withdraw(int price,String password) {


		if(password.equals(this.password)) {

			if(balance>=price){
			System.out.println("출금되었습니다!");
			return balance-=price;
			}else {
				System.out.println("잔액이 부족합니다.");
				return -2;
			}
		}
		else {
			System.out.println("비밀번호가 틀립니다.");
			return -1;
		}
	}

	int checkBalance(String password) {
		if(password.equals(this.password)) {
			return balance;
		}
		else {
			System.out.println("비밀번호가 틀립니다.");
			return -1;
		}
	}
	//아니 isCorrectPassword는 요구사항 x
	boolean isCorrectPassword(String password) {

		if(password.equals(this.password)) {
			return true;
		}else {
			return false;
		}


	}
}
