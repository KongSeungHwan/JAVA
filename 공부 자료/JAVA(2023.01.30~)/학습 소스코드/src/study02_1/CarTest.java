package study02_1;

import javaStudy2.Car;

public class CarTest {
	public static void main(String[] args) {
		Car c =new Car();
		/*int speed= c.speed;//default
		c.getSpeed();//protected 같은 패키지 내이므로 접근 가능
		System.out.println(c.speed2);
		*/
		c.getCarNum(); //public은 모든 영역에서 접근 가능이므로 접근 가능
		
	}

}
