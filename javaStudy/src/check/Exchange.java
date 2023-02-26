package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exchange {
	public static void main(String[] args) throws InterruptedException{ //임의로 프로그램 짜는 거라 인터럽트 처리는 안해도 됨 throw 함.
		//유료 달러 두 번 입력
		//한화로 얼마인지
		//환율 검색
		//달러,유로 한화 1000원기준 0.81 달러 0.75 유로
		//유로
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("계산하실 금액을 입력하십시오.(원)");
			int won = Integer.parseInt(n.readLine());
			System.out.println("유로의 환율을 입력하시오");
			double eur = Double.parseDouble(n.readLine());
			System.out.println("달러의 환율을 입력하시오");
			double dol = Double.parseDouble(n.readLine());
			consoleClear();
			Thread.sleep(1000);
			System.out.print("정산중.");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			consoleClear();
			double totalEur = (eur/1000)*won;
			double totalDol = (dol/1000)*won;
			System.out.printf("입력하신 금액은 %d유로,%d달러 입니다.",(int)totalEur,(int)totalDol);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("잘못된 값을 입력하였습니다. 프로그램을 다시 실행해 주십시오.");
		}
	}
	public static void consoleClear() {
		for (int i = 0; i < 13; i++) {
			System.out.println();
		}//콘솔창 클리어 메소드
	}
}
