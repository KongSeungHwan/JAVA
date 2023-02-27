package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusCard {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//if문으로 나누기
		BufferedReader l = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("버스카드 찍기 프로그램(나이 입력 만x):");
		int age=Integer.parseInt(l.readLine());
		if(age < 0) {
			System.out.println("올바른 나이가 아닙니다.");
			return;
		}
		
		String t =getRole(age);//또 치기 귀찮아서 만듬 변수(성능 생각x)
		//입력 값 예외처리 x(throw함.)
		if(t.equals("유아")) {
			System.out.printf("당신은 %s입니다 고로 공짜",t);
		}
		else if(t.equals("어린이")) {
			System.out.printf("당신은 %s입니다 고로 요금은 500원",t);
		}
		else if(t.equals("청소년")) {
			System.out.printf("당신은 %s입니다 고로 요금은 1000원",t);
		}
		else if(t=="성인") {System.out.println("1500원입니다.");
		}else {
			System.out.println("잘못 입력하셨습니다."); //위에서 리턴으로 처리해줬지만 만약의 경우를 대비하여
		}
		
		/*
		 * +) equals 함수 >>a.equals(b); a,b 문자열 비교 메소드 리턴값 boolean    같으면 true 다르면 false
		 * 		contains함수 >>a.contains(b); 문자열 비교 메소드(a가 b에 일부로 들어가있는지 여부 확인)<< 검색 메소드에 사용하면 용이
		 * 		return 값은 같음
		 * 	
		 * */
	}
	public static String getRole(int age){
		String role="";
		if((age>0)&&(age<=5)) {
			return "유아";
		}else if((age>5)&&(age<=13)) {
			return "어린이";
		}else if((age>13)&&(age<=18)) {
			return "청소년";
		}
		else if(age>18){
			return "성인";
		}else {
			//해당 값을 음수로 대입했을 때 영역
		}
			return role;
	}

}
