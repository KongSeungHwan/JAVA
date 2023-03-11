package study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//초를 입력받아서 시간 분 초로 출력하시오
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\'초\'를 입력하시오: (자연수만 입력)");
		int time = Integer.parseInt(n.readLine());



		int a;
		int b;
		int c;
		int d;
		b= time/60;//분
		c= time%60;//초
		if(time<0){
			System.out.println("잘못된 시간입니다.");//에러처리
		}else if((time>=0)&&(time<60)) {
			System.out.printf("%d초 \n",time);
		}else if((time>=60)&&(time<3600)){
			
			if(c!=0){
				System.out.printf("%d분 %d \n",b,c);
			}else {
				System.out.printf("%d분",b);
			}
		}else {
			a = b/60; //시간
			d = b%60; //분
			if((d!=0)&&(c!=0)){
				System.out.printf("%d시간 %d분 %d초",a,d,c);
			}else if((d!=0)&&(c==0)) {
				System.out.printf("%d시간 %d분",a,d);
			}
			else if((d==0)&&(c!=0)){
				System.out.printf("%d시간 %d초",a,c);
			}
			else {
				System.out.printf("%d시간",a);
			}
			
			//코드 너무길음 로직이 ㅂ신..
			
			
			
			int hour= time/3600;
			int minute=(time%3600)/60;
			int second=time%60;
			if(hour != 0) {
				System.out.printf("%d시간",hour);
			}
			if(minute != 0) {
				System.out.printf("%d분",minute);
			}
			if(second!=0) {
				System.out.printf("%d초",second);
			}
			
			
			
		}
		//?시간?분?초 일경우, ?시간?분 일경우,?시간 ?초,?시간 일 경우 총 4가지 경우 나눔

		n.close();
		//시스템 자원 반환 필수


	}

}
