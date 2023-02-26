package study05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MathRun {

	public static void main(String[] args) {
		System.out.println(Math.PI); //Math 클래스에 선언된 PI 상수 3.14.... +)다른 상수 E 오일러의 수를 상수로 선언해놓음(자연로그)
		System.out.println(Math.abs(-6.8)); //절대값을 리턴하는 함수 
		System.out.println(Math.floor(32.123/10)*10);//올림으로 변형(1의 자리 까지)
		System.out.println(Math.ceil(32.123));//올림 메소드
		System.out.println(Math.round(32.523)); // 반올림 메소드
		//최대값, 최소값
		//Math 클래스는 기본적으로 java.lang 패키지에 포함되는 클래스이기때문에 따로 import 안해줘도 된다.
		System.out.println(Math.max(71,89));
		System.out.println(Math.min(1102,325));//따로 if문으로 안나눠도 되는 편리함이 있는 메소드들이다.(최대,최소값)
		int[] arr = {1,4,25,34,-2};
		int maxi = 0;
		
		for (int a = 0; a < arr.length; a++) {
			if(a==0) {
				maxi=arr[a];
			}else {
				maxi=Math.max(maxi,arr[a]);
			}
		}
		System.out.println(maxi);// 배열안의 제일 큰 값을 출력하는 구조, maxi라는 변수를 이용하여 각 구문을 실행할때마다 비교하여 
								// 두 값을 비교하여 큰 값을 maxi에 초기화 시키는 for문
		System.out.println(Math.pow(3,3));//3의 3제곱 제곱을 한 결과 값을 리턴하는 메소드
		System.out.println(Math.sqrt(9)); //제곱근(루트 분야)
		System.out.println(Math.cbrt(27)); // 세제곱근을 리턴하는 메소드
		System.out.println(Math.random());// 0~1사이의 실수를 리턴하는 함수
		System.out.println((Math.random()*6)+1);//0~1 범위에만 곱하여 응용 즉 1~7범위에 있는 난수를 리턴 근데 형변환 안했으니 실수값이 리턴
		
		for (int i = 0; i < 10; i++) {
			System.out.println((int)(Math.random()*(12-2+1)+2)); //2~13? 범위의 자연수인 난수 생성 
			//굉장히 낮은 확률임(13)
		}
		
		//고득점자 찾기
		HashMap<Integer, String> ha = new HashMap<>();//int값을 인덱스로 하고 String 값을 요소로 갖는 해시맵
		ha.put(65,"Elena");
		ha.put(74,"Sam");
		ha.put(23,"Tom");
		ha.put(75,"John");
		ha.put(68,"Emily");
		ha.put(96,"Alex");
		ha.put(88,"Kate");
		
		System.out.printf("가장 높은 점수를 가진 사람은 %s이다. \n",topScorer(ha));
		//해시맵을 활용한 가장 높은 점수의 사람을 뽑아내는 메소드
	}
	public static String topScorer(HashMap<Integer,String> a) {
		int max = 0; 
		int temp = 0; //여기에 Integer 객체로 넣으면 언박싱이 이루어짐.
		Set<Integer> k = a.keySet();  //키 값을 set에 저장
		Iterator<Integer> it = k.iterator(); 
		while(it.hasNext()) { //iterator로 쭉 출력!
			temp = it.next(); 
			if(max<temp) {
				max = temp; //비교하여 max에다 넣음
			}
		}
		return a.get(max); //max안의 키에 해당하는 값을 리턴(사람이름(문자열)) 
	}

}
