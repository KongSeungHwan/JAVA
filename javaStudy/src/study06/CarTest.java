package study06;

public class CarTest {

	public static void main(String[] args) {
		//접근 제한자에 대하여
		Car c = new Car();
		int speed = c.speed;//default
		c.getSpeed();//protected
		c.getCarNum();//public
		
	}

}
