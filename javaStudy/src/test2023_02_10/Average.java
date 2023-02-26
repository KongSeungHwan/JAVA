package test2023_02_10;


public class Average {
	public static void main(String[] args) {
		//1번
		int kor = 80;
		int eng = 75;
		int mat = 55;
		
		System.out.printf("평균: %d",(kor+eng+mat)/3/*나눈게 정수인데 굳이 형변환x*/); //나눈 것은 실수니까 서식문자를 %f로 씀 
		
		//문자열이랑 정수형이 합치면 자동 캐스팅됨. 만일 더한다면 무조건 래퍼클래스사용해서 형변환 해줘야 함.
	}

}
