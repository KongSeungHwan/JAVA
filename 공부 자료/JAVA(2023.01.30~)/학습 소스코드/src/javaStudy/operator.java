package javaStudy;

public class operator {

	public static void main(String[] args) {
		int num1 = 8, num2 = 4;
		System.out.println("+ : "+(num1+num2));//더한 값이 나온다.
		System.out.println("- : "+(num1-num2));// 뺀 값이 나온다.
		System.out.println("* : "+(num1*num2));//곱한 값이 나온다.
		System.out.println("/ : "+(num1/num2));//몫이 나온다.
		System.out.println("% : "+(num1%num2));//나머지가 나온다.

		int num3=7,num4=7,num5 =7;
		num3 -=3;// >> num3 = num3 - 3;
		num4 = num4 -3;
		num5 =- 3;// >> num5 = -3;
		System.out.println(num3+" "+num4+" "+num5);

		int y=0, x=10;
		y=x-- +5+ --x; 
		System.out.println(y+" "+x);//x는 --로 증감이 2번 되어 8이 된다.   (10+5+8) 이므로 23

		System.out.println("num3:"+num3+"/num4:"+num4+"/num5:"+num5);
		System.out.println(num3==num4);
		System.out.println(num3!=num5);
		System.out.println(x>y);
		System.out.println(x<=y);

		char char1 = 'a';
		char char2 = 'b';
		System.out.println(char1>char2);
		//아스키 코드 기반으로 a>b 는 (97 > 98)과 같음
		char1= 'v';
		char2= 'B';
		boolean res1,res2;
		System.out.println((int)char1+" "+(int)char2);
		// 강제 캐스팅을 하면 아스키코드에 맞게 숫자가 나온다.
		res1 = (char1>'c')&&(char2<'z');//true
		res2 = (char1<'A')||(char2>'Z');//false
		System.out.println("&&:"+res1);
		System.out.println("||:"+res2);
		System.out.println("!:"+!res1);
		//보통 아스키코드 값은 대문자 < 소문자이다.
		//65~(대문자) 97~(소문자)

		System.out.println(10&7);//10 >>이진법으로 표현 하면 1010,7을 이진법으로 표기하면 0111
		System.out.println(10|7);
		System.out.println(10^7);
		System.out.println(10<<1);
		System.out.println(10>>1);
		System.out.println(7>>1);

		//조건 연산자, 삼항 연산자
		System.out.println( (9<7)?"T":"F" );
	}

}
