package study17_2023_02_17_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) throws IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		String a = n.readLine();
		String b = n.readLine();
		boolean re = isAnagram(a,b);
		System.out.print("두 단어는");
		System.out.println( re ?"Anagram이다.":"Anagram이 아니다.");
		//알고리즘 영역
				
		//각자 char로 쪼개서 비교 char형인 배열 생성
		
		//Collection.sort(자료구조이름); Arrays.equals(배열이름1,배열이름2)로 비교 Arrays.sort(배열이름); 여러 방법이 있으나 그냥 char[]로 함
		
		
	}
	static boolean isAnagram(String a,String b){//문자열 정렬 메소드 그리고 비교 O(nlogn)
		if(a.length()==b.length()) {
			char[] st1 =a.toCharArray();
			char[] st2 = b.toCharArray(); //대소 비교 용이 아스키 코드
			Arrays.sort(st1);
			Arrays.sort(st2);//O(nlogn) 시간 복잡도
			return (new String(st1)).equals(new String(st2));
		}else return false;
		//ArrayList는 선언 생성할게 많아 나는 그냥 char[]로 함(공간 복잡도)
		//String객체 만드는 부분만 찾아봄
	}

}
