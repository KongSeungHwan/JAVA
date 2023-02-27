package study03;

public class Exam03 {

	public static void main(String[] args) {
		int[] scores = {70,60,55,75,95,80,85,100};
		int sum = 0;
		double avr;
		for (int i = 0; i < scores.length; i++) {
			sum+=scores[i];
		}
		avr=(double)sum/scores.length;
		System.out.printf("평균 %.2f",avr);////소수점 아래 2번째까지
		sum=0;
		for (int i : scores) {
			sum+=i;
		}
		avr=(double)sum/scores.length;
		System.out.printf("평균 %.2f",avr);//소수점 아래 2번째까지
	}

}
