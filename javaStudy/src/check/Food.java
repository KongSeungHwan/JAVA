package check;

public class Food {
	//치킨 34인분, 왕만두 10인분, 쌀국수 12인분
	//음식 가격 치킨 가격:25000,왕만두:5000 쌀국수:8500 int 값
	public static void main(String[] args) {
		int chicken = 25000;
		int kingDumpling = 5000;
		int riceNoodle = 8500;
		
		String chicken1 = "치킨";
		String kingDumpling1 = "왕만두";
		String riceNoodle1 = "쌀국수";
		
		System.out.printf("%s 34마리  가격:%d",chicken1,chicken*34);
		System.out.printf("%s 10개  가격:%d",kingDumpling1,kingDumpling*10);
		System.out.printf("%s 12그릇  가격:%d",riceNoodle1,riceNoodle*12);
		
		//서식문자 포함 출력 메소드 사용하는 메인 클래스
	}

}
