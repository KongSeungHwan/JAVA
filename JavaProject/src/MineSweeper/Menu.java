package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	BufferedReader n;
	ClientManagement lo;
	Client session; //서버 컴퓨터가 없으니 일단은 객체로 정의
	Thread dbThread = new Thread(){
		@Override
		public void run() {
			while(true) {
				try {
					lo = new ClientManagement();
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	Menu(){
		n = new BufferedReader(new InputStreamReader(System.in));
		lo = new ClientManagement();//각 필드 초기화 session은 냅둠(로그인 후 초기화)
		try{
			menu();
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException 발생!");
			e.printStackTrace();
		}
		catch(IOException e){
			System.out.println("IOException 발생!");
			e.printStackTrace();
		}
		catch(InterruptedException e){
			System.out.println("InterruptedException 발생!");
			e.printStackTrace();
		} //예외 처리는 메인 메소드에서 처리 안하고 여기서 처리!
	}void clear() throws InterruptedException {
		Thread.sleep(4000);
		for (int i = 0; i < 14; i++)System.out.println();
	}//콘솔창 clear&sleep 함수 딜레이!
	@SuppressWarnings("deprecation")
	void menu() throws NumberFormatException, IOException, InterruptedException{
		int token = 0;
		if(!dbThread.isAlive())dbThread.start();
		while(true) {
			System.out.println("메뉴를 선택하십시오.");
			System.out.println("1 로그인 2 회원 가입 3 종료");
			token = Integer.parseInt(n.readLine());
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
				dbThread.stop();
				System.exit(0);
			default:
				System.out.println("유효하지 않은 값입니다. 다시 시도해주세요.");
			}
			clear();
		}
	}
	@SuppressWarnings("deprecation")
	void loginMenu() throws NumberFormatException, IOException, InterruptedException {
			System.out.printf("★%s★ %s님 환영합니다. \n",session.getGrade(),session.getName());
			System.out.println("메뉴를 선택해주십시오");
			System.out.println("1.개인정보 조회 2.게임 시작! 3.로그아웃 4.종료");
			int token = Integer.parseInt(n.readLine());
			switch(token) {
			case 1:
				lo.showClientInfo(session.getId());
				clear();
				loginMenu();
				break;
			case 2:
				new MineSweeper(session).startGame();
				clear();
				loginMenu();
				break;
			case 3:
				System.out.printf("로그아웃 합니다! %s님 이용해주셔서 감사합니다! \n",session.getName());
				clear();
				menu();
				break;
			case 4:
				clear();
				System.out.printf("프로그램을 종료합니다. %s님 이용해주셔서 감사합니다! \n",session.getName());
				lo.cList.dao.closeResource();
				dbThread.stop();
				System.exit(0);
				break;
			default:
				System.out.println("유효하지 않은 값입니다 다시 시도해주세요");
				clear();
				loginMenu();
			}
			}//메소드를 다시 호출하여 처리하는 법! 바로 종료는 System.exit(0);
			//추가 기능이 있다면? 따로 추가 일단은 switch case 문을 나오게 된다면 loginMenu를 다시 호출하게 함.
			//무한루프 vs 재귀호출 >> 스택영역을 조지냐 힙 영역을 조지냐 이 차이 하지만 재귀호출은 호출하는 횟수가 증가함에 따라 복잡도도 기하급수적으로 높아지며
			//실행속도 또한 느리다. 반면 무한루프는 cpu 사이클을 계속 사용하지만 실행속도가 빠르다.
	}

