package study16_2023_02_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static void clear() {
		for (int i = 0; i < 14; i++) {
			System.out.println();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		//이름 혹은 전화번호로 개인정보 찾기 프로그램(시간,공간 복잡도 생각x,급하게 와가지고..)
		//완성시간 1시간 30분..(흡연시간 포함)
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		PersonList l = new PersonList();
		ArrayList<String> k;
		l.addPerson("공", "가리봉", "1234");
		l.addPerson("공2", "가리봉2", "1235");
		l.addPerson("공3", "가리봉3", "1236");
		l.addPerson("사1", "가리봉", "12345");
		l.addPerson("사2", "가리봉2", "12355");
		l.addPerson("사3", "가리봉3", "12365");
		while(true) {
			try {
				clear();
				System.out.println("개인정보 조회 메뉴");
				System.out.println("1:이름으로 찾기(정확한 값), 2.전화번호로 찾기(정확한 값) 3.검색(이름) 4.검색(전화번호) 5.종료");
				int token = Integer.parseInt(n.readLine());
				switch(token) {
				case 1:
					System.out.println("이름을 입력하십시오");
					String name = n.readLine();
					//찾는 메소드란
					k=l.showPersonByName(name);
					if(k.size()==0)System.out.println("찾는 이름의 사람이 없습니다.");else{
						for (String s : k) {
							System.out.println(s);
						}//결과 값 출력
						Thread.sleep(1000);
						Thread.sleep(1000);
					}

					break;
				case 2:
					System.out.println("전화번호를 입력하십시오");
					String phoneNum = n.readLine();
					//전화번호로 개인정보 찾는 란
					clear();
					k=l.showPersonByNum(phoneNum);
					if(k.size()==0) {System.out.println("찾는 전화번호가 없습니다.");}else {
						for (String s : k) {
							System.out.println(s);
						}//결과 값 출력
						Thread.sleep(1000);
						Thread.sleep(1000);
					}
					break;
				case 3:
					System.out.println("검색할 이름을 입력하십시오");
					String name2 = n.readLine();
					//찾는 메소드란
					k=l.searchByName(name2);
					if(k.size()==0)System.out.println("찾는 이름의 사람이 없습니다.");else {
						for (String s : k) {
							System.out.println(s);
						}//결과 값 출력
						Thread.sleep(1000);
						Thread.sleep(1000);
					}
					break;
				case 4:
					System.out.println("검색할 전화번호를 입력하십시오");
					String phoneNum2 = n.readLine();
					//전화번호로 개인정보 찾는 란
					clear();
					k=l.searchByNum(phoneNum2);
					if(k.size()==0) System.out.println("찾는 전화번호가 없습니다.");else {
						for (String s : k) {
							System.out.println(s);
						}//결과 값 출력
						Thread.sleep(1000);
						Thread.sleep(1000);
					}
					break;
				case 5: 
					System.out.println("정말 프로그램을 종료하시겠습니까? (y/n)");
					String exit = n.readLine();
					if((exit.equals("y"))||(exit.equals("Y"))) {
						return;//종료
					}else if((exit.equals("n"))||(exit.equals("N"))) {
						System.out.println("프로그램을 계속합니다.");
						Thread.sleep(1000);
						Thread.sleep(1000);
					}else {
						System.out.println("y,n외의 값으로 잘못 입력하셨습니다.");
						Thread.sleep(1000);
						Thread.sleep(1000);
					} break;
				default:System.out.println("1,2외에 잘못된 값을 입력하셨습니다.");
				}
			} catch (IOException e) {
				System.out.println("잘못된 값을 입력하셨습니다");
			}

		}
	}

}
