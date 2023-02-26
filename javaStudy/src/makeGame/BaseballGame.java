package makeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;



public class BaseballGame {
	public static int[] division(String a){
		int size = a.length();
		int[] arr = new int[size];
		for (int i = 0; i < a.length(); i++) {
			arr[i]=Character.getNumericValue(a.charAt(i));//char 값 int자료형으로 변환하는 형변환 메소드
		}
		return arr;
	}
	public static int[] randomComNum(int a){
		Random ran = new Random();
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++){
			arr[i]=ran.nextInt(100)%10;//(1의자리 숫자) 10으로 나눈 나머지니까? 1의 자리 숫자!
		}
		return arr;
	}
	public static boolean check(int[] a){//3자리인지와 중복값이 있는 것이 false, 없는 것이 true.
		if(a.length == 3) {
		for (int i = 0; i < a.length;i++) {
			for(int j = 0;j<a.length;j++) {
				if((i!=j)&&(a[i]==a[j])) { 
					return false;
				} //지난 시간에 배운 선택정렬 방식 처럼 비교함.
				else {

				}
			}
		} 
		return true;
		}else {
			return false;
		}
	}
	public static void clear() {
		for(int i = 0;i<12;i++)
		System.out.println();
	}
	
	//클래스 만들기 애매해서 그냥 static으로 해놓음.
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		//숫자야구게임 made by 공승환 ver.01(2023.02.10 제작 2시간 반 걸림, 갈아엎는 시간 포함)
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		int[] com = null; //컴퓨터가 만든 숫자 형변환해서 대입할 배열
		int gameCount = 9;
		int[] user = null; //사용자 입력 숫자 형변환 해서 대입할 배열
		String use; //사용자가 입력 숫자 대입
		int bCount = 0;
		int sCount = 0;
		String token;
		for(int i= 0; i>=0 ;i++) {//무한 루프 또 생성..
			com = randomComNum(3);
			if(check(com))break;
		}
		//컴퓨터 숫자 중복 체크(무한 루프)
		System.out.printf("접속중.");
		Thread.sleep(1000);
		System.out.printf(".");
		Thread.sleep(1000);
		System.out.printf(". \n");
		Thread.sleep(1000);
		clear();
		System.out.println("숫자 야구 게임(1.시작 2.종료)");
		token = n.readLine();
		//입력받은 String 값을 char로 쪼개서 다시 숫자로 형변환 그리고 배열에 넣음
		clear();
		if(token.equals("1")) {
			while(true) {
				if(gameCount == 0) {
					System.out.println("횟수가 초과되었습니다. 게임을 종료합니다.");
					return;}
				for(int i= 0; i>=0 ;i++) {
					System.out.println("숫자 야구 게임 숫자 입력: (3개만!,중복 없이)");
					use = n.readLine();
					user = division(use);
					if(check(user)) {
						break;
					}else {
						System.out.println("중복 값이 있거나 올바른 값이 아닙니다.");
					}
				}//중복 검사(사용자꺼)
				clear();
				bCount = 0;
				sCount = 0;
				System.out.println("당신의 숫자는?");
				for (int i = 0; i < user.length; i++) {
					System.out.printf(" %d",user[i]);
				}
				System.out.println();
				//배열에 있는 숫자 확인
				System.out.println();
				for (int i = 0; i < user.length;i++) {
					if(user[i]==com[i]) {
						sCount++;
						user[i]= -1; //strike 된 값은 ball로 카운트 안세게 하기 일부러 음수값 줌
						continue;
					}
					for(int j = 0;j<com.length;j++) {
						if((user[i]==com[j])){
							bCount++;
						}
					}
				} 
				/*
					System.out.println("com 숫자: \n");
				 * for (int i = 0; i < com.length; i++) { System.out.printf(" %d",com[i]); }
				 * //디버깅 용 (없애도 된다.)
				 */	
				System.out.println();
				System.out.printf(" %d Strike!! %d Ball!! \n",sCount,bCount);
				System.out.printf("남은 횟수: %s \n", gameCount);
				Thread.sleep(1000);
				Thread.sleep(1000);//이전 수업시간에 배운 딜레이 주는법!
				clear();
				if(sCount == 3) {
					System.out.println("3 Strike!! ");
					System.out.println("Player Win!!! Game Over");
					n.close();
					return;
				}
				gameCount--;
			}
		}else if(token.equals("2")){
			System.out.println("종료합니다.");
			n.close();
		}else {
			System.out.println("잘못된 값을 입력하셨습니다.. 다시 시작해주십시오.");
			n.close();
		}
	}
}