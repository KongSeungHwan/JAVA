package sutdy09;

public interface Calc{
	//상수
	final double PI = 3.14;
	final int ERROR = -9999;
	//추상메서드
	int add(int num1,int num2);
	int sub(int num1,int num2);
	int times(int num1,int num2);
	double div(int num1,int num2);//몫 만 계산한다 치고 인터페이스 생성
	//디폴트 메서드: 공통적으로 구현해야하는 메소드
	default void desc() {
		privateMethod();
		System.out.println("계산기 구현");
		privateStaticMethod();
	}
	//정적 메서드
	static int total(int[] arr){
		int total = 0;
		for (int i : arr) {
			total+=i;
		}
		return total;
	}
	//private 메서드
	private void privateMethod() { //디폴트 메소드에서만 사용가능
		System.out.println("private Method");
		privateStaticMethod();
	}
	private static void privateStaticMethod() {
		System.out.println("Private static method");
	}
}
