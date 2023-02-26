package test1;

public class Main {

	public static void main(String[] args) {
		//계좌 생성
				Account account = new Account(1,"password!@","park");
				//10만원 입금
				account.deposit(100000);
				//잔액 확인
				System.out.println(account.checkBalance("password!@"));
				//2만원 출급
				account.withdraw(2000000,"password!@");
				System.out.println(account.checkBalance("password!@"));
	}//난 예외처리 다함 int리턴이면 -1 리턴하게끔 하고 boolean값은 false리턴하게 함
}
