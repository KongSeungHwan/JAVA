package study03;

public class Exam01 {

	public static void main(String[] args) {
		//요구 사항: 1_100 합?
		
		int sum = 0;
		
		for (int i = 1; i <=100; i++){
			if(i%3==0) {
				sum+=i;
			}//3으로 나눴을 때 나머지가 0인것 즉 3의 배수!
		}
		System.out.printf("3의 배수의 총합: %d \n",sum);
		
	}

}
