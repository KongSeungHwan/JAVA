package javaStudy2;

public class CarTest {

	public static void main(String args[]) { 
		//configuration에서 먼저 값을 전달 받고 메인메소드에서 다룸
		Car c =new Car();
		c.getSpeed();//protected 같은 패키지 내이므로 접근 가능
		c.getCarNum(); //public은 모든 영역에서 접근 가능이므로 접근 가능
		System.out.println(c.speed2);
		//speed2는 protected로 선언 되어있고,
		//protected는 같은 패키지 내부나 자식 클래스범위이다.
		//고로 접근 가능 메인 클래스와 Car 클래스는 같은 패키지 내에 있움.
	}
}
