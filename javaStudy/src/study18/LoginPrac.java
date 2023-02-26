package study18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

//연습이니까 그냥 static으로 함
class NoExistIDException extends Exception{
	public NoExistIDException() {}
	public NoExistIDException(String m) {
		super(m);
	}
}
class WrongPasswordException extends Exception{
	public WrongPasswordException() {}
	public WrongPasswordException(String m) {
		super(m);
	}
}

public class LoginPrac{
	static void login(String id, String pw)throws Exception {//map이나 다른 자료구조 필요 또는 비교할 참조형 변수의 필드 필요
		//난 map으로 구현
		TreeMap<String,String> m = new TreeMap<>();
		m.put("ajax","1234");
		m.put("java","1231");
		m.put("script","1235");
		m.put("css","1233");
		Set<Entry<String,String>> s =m.entrySet();
		Iterator<Entry<String,String>> it = s.iterator();
		
		while(it.hasNext()) {
			Entry<String,String> cli= it.next();
			if(cli.getKey().equals(id)) {
				if(cli.getValue().equals(pw)) {
					System.out.println("로그인 완료");
					System.out.printf("환영합니다 %s님 \n",cli.getKey());
					return;//원래 이구간에서 다시 로그인 메뉴 메소드가 들어가야 한다.
				}
				else {
					throw new WrongPasswordException();
				}
			}
		}
		throw new NoExistIDException();
	}
	public static void main(String[] args){
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("로그인");
		System.out.println("아이디 입력:");
		String id= n.readLine();
		System.out.println("비밀번호 입력:");
		String pw = n.readLine();
		login(id,pw);
		n.close();
		}catch(IOException e) {
			System.out.println("입출력 예외 발생");
		}catch(Exception e) {
			System.out.println("다른 예외 상황 발생 다시 시도해주십시오.");
		}finally {
		}
	}

}
