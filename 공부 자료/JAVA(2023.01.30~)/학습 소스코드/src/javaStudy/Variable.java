package javaStudy;

import java.util.Iterator;

public class Variable {

	public static void main(String args[]) {
		int num = 10;
		//변수 선언
		System.out.println(num);
		//진수 표현
		int binNum= 0B1010;//이진수
		System.out.println(binNum);
		int octNum = 013;//8진수
		System.out.println(octNum);
		int hexNum = 0x1A;//16진수 0 1 2 3 4 5 6 7 8 9 A(10) B(11) C(12) D(13) E(14) F(15) 
		System.out.println(hexNum);
		String binary = Integer.toBinaryString(num);
		System.out.printf("2진수: %s",binary);
		System.out.println();
		int mp; 
		//멤버쉽 포인트 
		//<< 이렇게 개발자 이외의 사람이 볼때 알아 볼 수 있도록 표기해야한다.
		byte byteData = -128;
		System.out.println(byteData);
		byteData = (byte)128;
		int integerNum = 1234567;
		long longNum = 22324123412L;
		//기본적으로 자바에서는 숫자를 입력하면 int값으로 선언이 되기 때문에 long 타입을 선언 시에는 숫자 뒤에 L을 붙여야한다. 
		char ch ='A';
		System.out.println(ch);
		ch = 66; 
		System.out.println(ch);
		//아스키 코드 A 65 B 66
		int chin = 'A';
		System.out.println(chin);

		double doubleNum = 3.14 ;
		//int로 강제 캐스팅을 하면 3이 된다. 소수점 이하 버림
		float floatNum = 3.14f;
		//실수도 정수의 long의 경우와 비슷하게 기본적으로 double 값으로 저장되고 float값으로 저장하려면 뒤에 f를 붙여야한다.
		System.out.println(doubleNum+"  "+floatNum);
		final double PI = 3.1419;
		//상수 재정의 불가(불변의 수)
		//PI = 1234.12 (X)
		System.out.println(PI);
		int iNum = binNum;
		System.out.println(iNum);
		iNum =(int)longNum;
		System.out.println(longNum+" "+iNum);
		iNum = (int)floatNum;
		System.out.println(floatNum+" "+iNum);
		doubleNum = floatNum +iNum;
		System.out.println(doubleNum);
		floatNum = 0.9f;
		//int로 강제 캐스팅을 하면 0이 된다.
		int iNum1 = (int)(doubleNum +floatNum);
		int iNum2 = (int)doubleNum + (int)floatNum;
		System.out.println(iNum1+" "+iNum2);

		var num10 = 10; // int num10 = 10;
		var doubNum =13.11 ; // double doubNum = 13.11;
		var str = "우리집" ; // String str = "우리집";
		System.out.println(num10+" "+doubNum);

	}
}
