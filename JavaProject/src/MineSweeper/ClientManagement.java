package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//해당 클래스는 외부(DB)에서 가져온 정보와 회원 정보를 대조하여 데이터를 처리하는 클래스
public class ClientManagement{
	TransferData cList;
	BufferedReader n;

	ClientManagement(){
		n = new BufferedReader(new InputStreamReader(System.in));
		cList = new TransferData();
	}
	Client checkInfo() throws IOException{
		System.out.println("아이디 입력!");
		String id = n.readLine();
		System.out.println("비밀번호 입력!");
		String pw = n.readLine();
		if(cList.dbList.isEmpty()) {
			System.out.println("존재하지 않는 계정입니다.");
			return null;
		}
		else{
			if(cList.dbList.get(id)!=null){
				if(cList.dbList.get(id).getPw().equals(pw)) {
					System.out.println("로그인 성공!");
					return cList.dbList.get(id);
				}else {
					System.out.println("비밀번호가 틀립니다.");
					return null;
				}
			}else return null;	
		}
	}
	boolean signUp() throws IOException{
		System.out.println("이름 입력!");
		String name = n.readLine();
		System.out.println("아이디 입력! 영문자+숫자 조합으로만 입력해주십시오!");
		String id = n.readLine();
		System.out.println("비밀번호 입력! 영문자+숫자+특수문자 조합으로만 입력해주십시오!");
		String pw = n.readLine();
		if(cList.dbList.get(id)!=null) return false; //중복 제거
		if(checkIdCondition(id)!=true) {
			System.out.println("아이디 조건을 다시 확인하고 시도해주십시오!");
			return false;
		}
		if(checkPwCondition(pw)!=true){
			System.out.println("비밀번호 조건을 다시 확인하고 시도해주십시오!");
			return false;
		}
		return cList.addClientByDB(name, id, pw);
	}
	boolean checkPwCondition(String id){ //정규 표현식으로 적용하여 id가 영어/숫자/특수문자 조합인지 확인하며 총 글자 수는 몇인지 확인하는 메소드
		//최소 8자 부터 24자 까지 허용 시간 복잡도는 O(n) 적당? 굳이 메소드 구현할 필요없이
		//짧음
		return id.matches("^[a-zA-Z\\d`~!@#$%^&*()-_=+]{8,24}$") ? true:false; //삼항 연산자로 처리
	}
	boolean checkIdCondition(String pw) {
		//얘는 아스키 코드로 해본다! 규칙 최소 숫자 한개를 포함하며  아스키코드 33-64 즉 허용 특수문자+숫자 조합 확인
		char[] check = pw.toCharArray(); //String 배열을 쓰면 메모리 공간 효율이 많이 떨어지므로 char 배열을 활용 char 크기 1byte String 크기 4byte
		int charCount=0;
		int numCount=0; //최소 몇글자인지 판별하는 변수
		int spaceCount =0;
		for (char c : check) {
			if((c>=48)&&(c<=57)) ++numCount; 
			if((c>=65)&&(c<=90)||((c>=97)&&(c<=122))) ++charCount;
			if(c==' ')++spaceCount;
		}
		return ((numCount>=1) && (charCount>=1) && ((pw.length()>=8)&&(pw.length()<=24)) && (spaceCount==0))? true : false;
		//최소 8글자 이상 최대 24글자 숫자 영문자 조합이어야하는 알고리즘+(공백 제거) 시간 복잡도 O(n) 
	}
	void showClientInfo(String id){ //회원 id를 파라미터로 정보를 조회하는 메소드
		System.out.printf("%s님의 정보! \n",cList.dbList.get(id).getName());
		System.out.printf("id: %s \n",cList.dbList.get(id).getId());
		System.out.printf("승리 판수: %d 판 \n",(int)(cList.dbList.get(id).getvRounds()));
		System.out.printf("총 판수: %d 판 \n",(int)(cList.dbList.get(id).gettRounds()));
		//강제 캐스팅 int >> double %.0f서식자로도 충분히 가능하나 int >> double도 소수점 아래 버림처리 된다는 것도 보이려고 일부러 쓴 것.
		
		System.out.printf("승률: %.2f %c\n",cList.dbList.get(id).getvRate()*100,37);//소수점 아래 2번째까지 반올림 처리
	}//숫자 야구게임 (볼 카운트 수) = (총 일치수)-(스트라이크 카운트 수) 응용
}
