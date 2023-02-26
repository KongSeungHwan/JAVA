package MemberManagementSystemMadeByJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws InterruptedException, NumberFormatException, IOException{
		DbConnecter d = new DbConnecter();
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		Client cookie;
		System.out.print("접속중.");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.println();
		while(true) {
			System.out.println("메뉴를 입력하시오");
			System.out.println("1:로그인,2:회원가입,3:종료 \n");
			int t = Integer.parseInt(n.readLine());
			switch(t) {
			case 1:
				clear();
				System.out.println("아이디를 입력해주십시오:");
				String loginId = n.readLine();
				System.out.println("비밀번호를 입력해주십시오:");
				String loginPw = n.readLine();
				if(d.checkLoginId(loginId)){
					if(d.checkPassword(loginPw)){
						while(true) {
							cookie = d.cookie(loginId);
							System.out.printf("%s님 메뉴를 입력하시오 \n",cookie.getName());
							System.out.println("1:개인정보 조회,2:로그아웃\n");
							t = Integer.parseInt(n.readLine());
							switch(t) {
							case 1:
								d.selectSQL(loginId);
								clear();
							case 2:
								break;
							}
							if(t==2) {
								cookie = null;
								break;
							}
						}
					}else {
						System.out.println("비밀번호가 틀립니다.\n");
						Thread.sleep(1000);
					}
				}else {
					System.out.println("존재하지 않는 아이디입니다.\n");
					Thread.sleep(1000);
				}
				break;
			case 2:
				clear();
				System.out.print("이름을 입력하시오:");
				String name = n.readLine();
				System.out.print("아이디를 입력하시오:");
				String id = n.readLine();
				System.out.print("비밀번호를 입력하시오:");
				String pw = n.readLine();
				d.insertSQL(name,id,pw);
			case 3:
				break;
			}

			if(t==3) {
				n.close();
				break;
			}
		}
	}
	static void clear() {
		for (int i = 0; i < 12; i++) {
			System.out.println();
		}
	}
}
