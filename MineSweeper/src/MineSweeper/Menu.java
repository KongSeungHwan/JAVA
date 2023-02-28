package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	BufferedReader n;
	ClientManagement lo;
	Client session; //서버 컴퓨터가 없으니 일단은 객체로 정의

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
		int token = 0;
		while(true) {
			System.out.println("메뉴를 선택하십시오.");
			System.out.println("1 로그인 2 회원 가입 3 종료");
			token = Integer.parseInt(n.readLine());
			clear();
			switch(token) {
			case 1:
				if((session=lo.checkInfo())!=null)loginMenu();
				else System.out.println("로그인 실패!");
				break;
			case 2:
				System.out.println(lo.signUp());
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				lo.cList.dao.closeResource();//종료 루트에 시스템 자원 반환 한꺼번에 되도록 설계
				//n.close();//BufferedReader는 menu 클래스에만 있으니 여기서 그냥 반환
				return;
			default:
				System.out.println("유효하지 않은 값입니다. 다시 시도해주세요.");
			}
			clear();
		}
	}
	void loginMenu() throws NumberFormatException, IOException, InterruptedException {
			System.out.printf("%s님 환영합니다. \n",session.getName());
			System.out.println("메뉴를 선택해주십시오");
			System.out.println("1.개인정보 조회 2.로그아웃 3.종료");
			int token = Integer.parseInt(n.readLine());
			switch(token) {
			case 1:
				lo.cList.showClientInfo(session.getId());
				loginMenu();
				break;
			case 2:
				System.out.printf("로그아웃 합니다! %s님 이용해주셔서 감사합니다! \n",session.getName());
				menu();
				break;
			case 3:
				clear();
				System.out.printf("프로그램을 종료합니다. %s님 이용해주셔서 감사합니다! \n",session.getName());
				lo.cList.dao.closeResource();//종료 루트에 시스템 자원 반환 한꺼번에 되도록 설계
				//n.close();//BufferedReader는 menu 클래스에만 있으니 여기서 그냥 반환
				System.exit(0);
			default:
				System.out.println("유효하지 않은 값입니다 다시 시도해주세요");
				loginMenu();
			}
			clear();
			}
			//추가 기능이 있다면? 따로 추가 일단은 switch case 문을 나오게 된다면 loginMenu를 다시 호출하게 함.
			//무한루프 vs 재귀호출 >> 스택영역을 조지냐 힙 영역을 조지냐 이 차이 하지만 재귀호출은 호출하는 횟수가 증가함에 따라 복잡도도 기하급수적으로 높아지며
			//실행속도 또한 느리다. 반면 무한루프는 cpu 사이클을 계속 사용하지만 실행속도가 빠르다.
	}

