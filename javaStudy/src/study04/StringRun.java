package study04;

import java.util.StringTokenizer;

public class StringRun {
	public static void main(String[] args) {
		//참조형 변수(주소값만 저장되는 변수) 기본적으로 객체는 주소값이 저장된다.
		//String class  wrapper 클래스
		//equals ,contains
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1==str2);//객체 str1,str2가 저장된 주소값이 달라서 false
		String str3 = "abc";
		String str4 = "abcd";
		System.out.println(str1==str2); //주소에 저장된 리터럴 값을 비교하여 true로 뜸
		System.out.println(str3==str4);
		
		
		
		System.out.println(str1==str3); 
		//예외상황 출력 저장된 값은 같으나 다른 객체기에 다르다고 뜸
		System.out.println(str1.equals(str3)); 
		//그래서 equals 함수를 써서 저장된 리터럴 값을 비교하여 true라고 뜬다.
		System.out.println(str4.contains(str1));
		//contains함수를 써서 문자열을 비교(str1의 문자열이 str4문자열에 포함되는지 여부 boolean값으로 리턴)
		//equals는 값 자체를 비교하는데 ==은 객체가 같은지 비교하기에 차라리 정확하게 하기위해 equals 함수를 쓰는 것이 좋다.
		
		String e = "Hello Java";
		
		
		//indexOf 문자열에도 적용 가능 왜냐하면 문자열도 배열이기 때문이다.
		//charAt() 함수 문자열의 특정위치의 글자 반환 a.charAt(b) 즉 리턴값은 char 이다.
		//replaceAll() 함수 앞의 것과 동작 원리는 똑같다. a.replaceAll(b) 
		//String subString(int index1,int index2); 대강 인터페이스는 이렇다. index1은 시작 인덱스 index2는 끝 인덱스
		//String toUppercase(), String toLowercase(); 호출한 String 객체를 전부 대소문자로 바꿔줌
		//compareTo >> 객체가 서로 같은지 비교해주는 메소드(주소값이 같냐 여부가 x) 주소값으로 비교하는 것은 ==연산자로 함
		//String contact(String str); 호출한 객체와 str객체를 합치는 메소드
		//문자열을 contact로 합치는 것과, +연산자로 합치는 것과의 차이 
		int num1 = 3,num2= 4;
		char ch1='4',ch2='5';
		String str5 = "5",str6 = "6";
		System.out.println(num1+str6);//int+String
		System.out.println(ch1+str5);//char+String
		System.out.println(ch1+num1);//char+int
		// String과 int, char 모두 자바에서 알아서 캐스팅 해주는 것인가?
		// 다 따로 만나면 문자열 취급된다 ex) System.out.println(3+""+5);int값  3,5는 공백이라는 문자열을 만나 캐스팅 된 예시이다.
		//System.out.println(""+3+5+""); <<이래도 int형인 3,5 값은 문자열 취급된다. 
		
		String g= "        Java     Java            ";
		System.out.print("|||");
		System.out.print(g.trim());//trim()은 문자열을 자르는 메소드이다.그냥 사용시에는 앞뒤 공백만 잘린다.
		//보통 인자 값을 받고 그 인자만 자르는 메소드 로그인이나 회원가입 메뉴에서 유용하다. 회원가입메뉴 특수문자 포함 조건,숫자 포함 조건, 영문자 포함조건
		//포함시킬수 있음
		System.out.print("|||");
		System.out.println();
		
		//length() isEmpty() 문자열의 길이를 구하는메소드, 문자열이 비어있는지 boolean값으로 출력하는 메소드
		//ex) 공백도 문자로 취급한다 ""!=" "
		String test = "이 문장은 문자열-입니다./This is the String.";
		String[] token = test.split(" ");
		for (String t : token) {
			System.out.println(t);
		}
		
		//split 인자값을 받고 그 인자값 기준으로 문자열을 자르는 메소드
		//"a안녕하세요a a힘듭니다a" split으로 자르면 배열 길이가 2개인 배열이 리턴 해당 예시로 든 배열은 {{안녕하세요},{힘듭니다}} 로 쪼개진다.
		//출력은 리턴 받은 값을 향상된 for문하등가~
		System.out.println();
		StringTokenizer stk = new StringTokenizer("-");
		
		System.out.println(stk.countTokens());//밑의 while문은 문자열을 돌면서 문자열의 요소가 있을 때까지 도는 반복문
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		
		String a = "a";
		String b = "b";
		String c = "c";
		System.out.printf("%s %s %s %s",a,c); //서식문자 초과
		
		System.out.printf("%s",a,c);
		
	}
}
