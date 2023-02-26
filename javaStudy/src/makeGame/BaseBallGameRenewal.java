package makeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BaseBallGameRenewal {
	public static int[] division(String a){
		int size = a.length();
		int[] arr = new int[size];
		for (int i = 0; i < a.length(); i++) {
			arr[i]=Character.getNumericValue(a.charAt(i));//char 값 형변환 메소드
		}
		return arr;
	}
	public static int[] random(int a){
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
					}
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
	} //콘솔 창 치워주는 메소드
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		//숫자야구게임 made by 공승환 ver.02
		//전에 만든 숫자야구게임인데 이번엔 컴퓨터가 사용자의 숫자를 맞추는 게임으로 바꿔봄(20분 걸림 ㅋㅋ)
		//**기능 추가 해야할 것:strike된 숫자는 다른 배열에 저장 후 답을 입력할 때 출력(나머지 숫자는 랜덤)
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		int[] com = null; //컴퓨터가 만든 숫자 형변환해서 대입할 배열
		int gameCount = 9;
		int[] user = null; //사용자 입력 숫자 형변환 해서 대입할 배열
		String use; //사용자가 입력 숫자 대입
		int bCount = 0;
		int sCount = 0;//Strike,Ball을 카운트 하는 변수
		String token;
		String userSelect="";
		String comSelect="";
		System.out.printf("접속중.");
		Thread.sleep(1000);
		System.out.printf(".");
		Thread.sleep(1000);
		System.out.printf(". \n");
		Thread.sleep(1000);
		System.out.println("숫자 야구 게임(1.시작 2.종료)");
		token = n.readLine();
		for(int i= 0; i>=0 ;i++) {
			System.out.println("숫자 야구 게임 숫자 입력: (3개만!,중복 없이)\n");
			use = n.readLine();
			user = division(use);
			if(check(user)) {
				break;
			}
			else System.out.println("중복 값이 있습니다. 다시 입력해주세요."); //사용자가 중복 값 입력 시 예외 처리 
		}//중복 검사(사용자꺼)
		//입력받은 String 값을 char로 쪼개서 다시 숫자로 형변환 그리고 배열에 넣음
		for (int i : user) {
			userSelect+=" "+i;
		}
		if(token.equals("1")) {
			while(true) {
				if(gameCount == 0) {
					System.out.println("Player Win!!");
					return;}
				bCount = 0;
				sCount = 0;//strike,ball 초기화
				comSelect = ""; //컴퓨터가 선택한 숫자 문자열 초기화
				for(int i= 0; i>=0 ;i++){
					com = random(3);
					if(check(com))break;
				}//컴퓨터 숫자 중복 체크
				for (int i : com) {
					comSelect+=" "+i;
				}//컴퓨터가 선택한 숫자 문자열에 저장(int값+문자열은 자동 캐스팅!!)
				System.out.println("\n");
				for (int i = 0; i < user.length;i++){
					if(user[i]==com[i]) {
						sCount++;
						com[i]= -1; //strike 된 값은 ball로 카운트 안세게 하기 일부러 음수값 줌
						continue;//strike면 ball 카운트 건너뛰기
					}
					for(int j = 0;j<com.length;j++) {
						if((user[i]==com[j])){
							bCount++;
						}
					}
				}
				clear(); //콘솔 창 정리 메소드
				System.out.printf("사용자가 선택한 숫자: %s \n\n\n",userSelect);
				System.out.printf("컴퓨터가 선택한 숫자: %s \n",comSelect);
				System.out.printf(" %d Strike!! %d Ball!! \n\n",sCount,bCount);
				System.out.printf("남은 횟수: %s \n", gameCount);
				Thread.sleep(1000);
				Thread.sleep(1000);//이전 수업시간에 배운 딜레이 주는법!
				if(sCount == 3) {
					System.out.println("3 Strike");
					System.out.println("Computer Win.. Game Over");
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
