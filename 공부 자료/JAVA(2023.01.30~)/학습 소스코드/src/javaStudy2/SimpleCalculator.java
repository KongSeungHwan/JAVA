package javaStudy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Calculator{//사칙연산 클래스 Calculator
	//생성자 객체 생성
	//필드 속성
	// 써도 되고 안써도 됨 알아서 만들어줌
	private int f;
	private int s;
	static int sta =3;
	Calculator(int a, int b){
		this.f=a;
		this.s=b;
	}

	//메소드 기능
	void add(){//a,b 파라미터
		System.out.printf("더하기 연산의 결과 값은 %d이다. \n",this.f+this.s);
	}//덧셈 메소드
	
	void subtract() {
		System.out.printf("빼기 연산의 결과 값은 %d이다. \n",this.f-this.s);
	}//뺄셈 메소드
	void multiple() {
		System.out.printf("곱셈 연산의 결과 값은 %d이다. \n",this.f*this.s);
	}//곱셈 메소드
	void division() {
		System.out.printf("나누기 연산의 몫은 %d, 나머지는 %d이다 \n",this.f/this.s,this.f%this.s);
	}//나눗셈 메소드
	public int getFirstNumber() {
		return f;
	}
	public int getSecondNumber() {
		return s;
	}



}

public class SimpleCalculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 수 입력:");
		int num1 = Integer.parseInt(n.readLine());
		System.out.print("두번째 수 입력:");
		int num2 = Integer.parseInt(n.readLine());
		Calculator a = new Calculator(num1,num2);
		a.add();
		a.subtract();
		a.multiple();
		a.division();
		System.out.printf("두 수는 %d, %d \n",a.getFirstNumber(),a.getSecondNumber());

		a.sta=10;
		int num3=3,num4=5;
		Calculator b = new Calculator(num3,num4);
		System.out.println(b.sta);
		//static으로 정의한 변수는 a 객체에서 수정하면 b의 sta 변수도 값이 바뀜
		






	}


}
