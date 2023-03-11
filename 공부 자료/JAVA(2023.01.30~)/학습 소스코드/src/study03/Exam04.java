package study03;


public class Exam04 {
	
	public static void main(String[] args){
		//System.out.println((Math.random()*6)+1);
		// (ran*(최대 범위-1))+1(0부터 시작)
		//Math.random은 보통 0~1사이의 값이 나옴
		//12 가 나오면 감탄사 나오는 값을 출력
		
		
		while(true) {
			int i = (int)(Math.random()*6)+1;
			int j = (int)(Math.random()*6)+1;
			
			System.out.println("DICE GAME");
			
			System.out.printf("rolling.. [%d,%d]\n",i,j);
			
			if(i+j==12)System.out.println("사쿠라여!");
			if(i+j==5)break;
			for (int k = 0; k <=999999999; k++) {
				double sum = 0;
				sum*=k;
			}
			//for문 실행빈도를 늘려서 딜레이 생기게 함.
			
		}
		
	}

}
