package study08;

public class ManualCar extends CarAbs{
	public void drive(){
		System.out.println("사람이 운전");
	}
	public void stop() {
		System.out.println("사람이 브레이크");
	}
	public void turnOn() {
		System.out.println("키로 시동켜기");
	}
	public void turnOff() {
		System.out.println("키로 시동끄기");
	}
	

}
