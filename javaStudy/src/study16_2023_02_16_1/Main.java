package study16_2023_02_16_1;

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
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		//사전 프로그램 정확한 검색, 일부검색기능 추가
		Dictionary d = new Dictionary();
		d.addDictionary("kong", "공");
		d.addDictionary("kong1", "공1");
		d.addDictionary("kong2", "공2");
		String a;
		ArrayList<String> list;
		System.out.print("접속중");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			clear();
		while(true) {
			try {
				clear();
				System.out.println("사전 프로그램(한국어로 검색하고 삭제하는 프로그램)");
				System.out.println("기능을 입력하십시오.");
				System.out.println("(1 입력)정확한 값 검색, (2 입력)일부 값 포함 검색 (3 입력) 해당 값(정확한 값) 삭제/  \"종료\" 라고 입력시 종료");
				System.out.println("해당 명령어 입력: ");
				String token= n.readLine();
				switch(token) {
				case "1":
					clear();
					System.out.println("단어(정확한 값) 입력: ");
					a = n.readLine();
					if(d.findWithKor(a)!="") {
					System.out.println(d.findWithKor(a));
					}else {
						System.out.println("찾으시는 내용이 없습니다."); //찾는 단어가 아무것도 없을 때
					}
					Thread.sleep(1000);
					Thread.sleep(1000);
					Thread.sleep(1000);
					break;
				case "2":
					clear();
					System.out.println("단어(일부) 입력: ");
					a = n.readLine();
					list= d.searchWithKor(a);
					System.out.println("검색 결과");
					
					for (String s : list) {
						System.out.println(s);
					}
					if(list.size()==0)System.out.println("찾으시는 내용이 없습니다."); //찾는 단어가 아무것도 없을 때
					Thread.sleep(1000);
					Thread.sleep(1000);
					Thread.sleep(1000);
					break;
				case "3":
					System.out.println("삭제할 단어(일부) 입력(한국어): ");
					a = n.readLine();
					
					if(d.deleteDic(a)) {
						System.out.println("삭제하였습니다.");
						Thread.sleep(1000);
						Thread.sleep(1000);
						Thread.sleep(1000);
					}else {
						System.out.println("삭제하려는 내용이 존재하지 않습니다.");
						Thread.sleep(1000);
						Thread.sleep(1000);
						Thread.sleep(1000);
					}
					break;
					
				case "종료":
					clear();
					System.out.println("프로그램을 종료합니다.");
					Thread.sleep(1000);
					Thread.sleep(1000);
					Thread.sleep(1000);
					return; //프로그램 종료
					
				default:System.out.println("유효하지 않은 값입니다. 다시 시도해주십시오.");
				}
			} catch (IOException e) {
				System.out.println("잘못된 값을 입력하셨습니다."); //이상한 값으로 입력시 예외 처리
			}
		}

	}
}
