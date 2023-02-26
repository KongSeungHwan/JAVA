package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alba {
	public static void main(String[] args) throws InterruptedException {
		//급여 계산
		//시급, 일한 시간을 입력
		/*
		 입출력 bufferedreader 쓸겨

		 */
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("총 급여 계산 프로그램");
			System.out.println("일한 날짜를 입력하시오.");
			int days = Integer.parseInt(n.readLine());
			System.out.println("시급을 입력하시오.(한화)");
			int timeWages = Integer.parseInt(n.readLine());
			System.out.println("하루 근무시간을 입력해주십시오.(시간단위,24이하)");
			System.out.println("분단위는 소수점아래로 입력!)");
			double hoursDuty = Double.parseDouble(n.readLine());
			double monthlyPayCheck = timeWages*hoursDuty*days;
			if(hoursDuty >24) {
				System.out.println("유효하지 않은 값입니다.");
				return;
			}
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
			System.out.printf("당신의 총 급여는 %d원입니다 \n",(int)monthlyPayCheck);
			n.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("잘못된 값을 입력했습니다 프로그램을 다시 실행하십시오.");
			return;
		}//윤달 적용x
		//시스템 자원 반납

	}
	public static void consoleClear() {
		for (int i = 0; i < 13; i++) {
			System.out.println();
		}//콘솔창 클리어 메소드
	}
}
