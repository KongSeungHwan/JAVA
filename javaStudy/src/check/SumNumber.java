package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//자릿수의 합
		//세자리수를 입력받아 각 자릿 수를 더하여 결과를 출력

		// /10 %10  /,%연산자 사용

		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(n.readLine());
		int b=0;
		int c=0;
		if(((a/10)==0)){
			System.out.printf("각 자릿수의 합은 %d입니다",a);
		}
		else if((a/10)<10){
			b=a/10;
			a%=10;
			System.out.printf("각 자릿수의 합은 %d입니다",a+b);

		}
		else if((a/100)<10){
			b=a/10;
			c=a/100;//100
			a%=10;//1
			b%=10;//10
			System.out.printf("각 자릿수의 합은 %d입니다",a+b+c);
		}
		else {
			System.out.println("세자리 정수가 아닙니다.");
		}
		
		//문자열으로 형변환 해서 잘라서 구하기 (형변환 2번)

	}

}
