package study08;

public class CarTest {
	public static void main(String[] args) {
		CarAbs car = new AICar();
		CarAbs man = new ManualCar();
		car.templateMethod();
		man.templateMethod();
		//상속 받은 클래스의 각각 구현된 메소드들로 호출됨.
	}

}
