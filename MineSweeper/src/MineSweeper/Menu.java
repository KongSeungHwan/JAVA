package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	BufferedReader n;
	ClientManagement lo;
	DTO session;

	Menu(){
		n = new BufferedReader(new InputStreamReader(System.in));
		lo = new ClientManagement();//각 필드 초기화 session은 냅둠(로그인 후 초기화)
		try{
			menu();
			if(session!=null)loginMenu();
		}catch(Exception e) {
			System.out.println("Exception 발생! 프로그램을 종료합니다!");
			e.printStackTrace();
		}
	}void clear() throws InterruptedException {
		Thread.sleep(1000);
		Thread.sleep(1000);
		for (int i = 0; i < 14; i++)System.out.println();
	}//콘솔창 clear&sleep 함수 딜레이!
	void menu() throws NumberFormatException, IOException, InterruptedException{
		while(true) {
			System.out.println("메뉴를 선택하십시오.");
			System.out.println("1 로그인 2 회원 가입 3 종료");
			int token = Integer.parseInt(n.readLine());
			clear();
			switch(token) {
			case 1:
				if((session=lo.checkInfo())!=null){
					clear();
					loginMenu();
					break;
				}
				else {
					System.out.println("로그인 실패!");
				}
				break;
			case 2:
				lo.signUp();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				lo.cList.dao.closeResource();//종료 루트에 시스템 자원 반환 한꺼번에 되도록 설계
				n.close();//BufferedReader는 menu 클래스에만 있으니 여기서 그냥 반환
				return;
			default:
				System.out.println("유효하지 않은 값입니다. 다시 시도해주세요.");
			}
			clear();
		}
	}
	void loginMenu() throws NumberFormatException, IOException, InterruptedException {
		for(;true;){ //while무한루프도 되긴하는데 for도 가능하다는 것을 보여주려 쓴 것!
			System.out.printf("%s님 환영합니다. \n",session.getName());
			System.out.println("메뉴를 선택해주십시오");
			System.out.println("1.개인정보 조회 2.로그아웃 3.종료");
			int token = Integer.parseInt(n.readLine());
			switch(token) {
			case 1:
				lo.cList.showClientInfo(session.getId());
				break;
			case 2:
				System.out.printf("로그아웃 합니다! %s님 이용해주셔서 감사합니다! \n",session.getName());
				break;
			case 3:
				System.out.printf("프로그램을 종료합니다. %s님 이용해주셔서 감사합니다! \n",session.getName());
				lo.cList.dao.closeResource();//종료 루트에 시스템 자원 반환 한꺼번에 되도록 설계
				n.close(); //BufferedReader는 menu 클래스에만 있으니 여기서 그냥 반환
				return;
			default:
				System.out.println("유효하지 않은 값입니다 다시 시도해주세요");
			}
			clear();
			if(token == 2)break;
		}
	}
}
