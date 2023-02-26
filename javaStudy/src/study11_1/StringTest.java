package study11_1;

import java.util.StringTokenizer;

public class StringTest {
	public static void main(String[] args) {
		byte[] bytes = {73,32,108,111,118,101,32,121,111,117};
		String str = new String(bytes); 
		// ASCII X 
		//유니코드 인코딩 문자셋 UTF-8로 적용
		System.out.println(str);
		str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		//"자바" 없으면 "자바 없음"이라고 출력
		
		//있으면 "자바" -> "Java"바꿔서 출력
		//contains 함수 활용, charAt
		if(str.contains("자바")) {
			str=str.replaceAll("자바","Java");
			System.out.println(str);
		}else {
			System.out.println("자바 없음");
		}
		str = "1,2,3,4,5,6,7,8,9,10";
		String[] a = new String[10];
		int sum = 0;
		a = str.split(",");
		for (String str1 : a){
			 sum+=Integer.parseInt(str1);
		}
		System.out.println(sum);
		//1. split() ,  떼내기?
		
		sum=0;
		StringTokenizer token = new StringTokenizer(str,",");
		
		while (token.hasMoreTokens()) {
			sum+= Integer.parseInt(token.nextToken());
        }
		System.out.println(sum);
		
		//2.StringTokenizer 사용 
		
		
		
		
	}
}
