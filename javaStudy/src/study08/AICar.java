package study08;


public class AICar extends CarAbs {
	
	public void drive(){
		System.out.println("자율주행");
	}
	public void stop() {
		System.out.println("자동멈춤");
	}
	public void turnOn() {
		System.out.println("시동 켜고 목적지 입력");
	}
	public void turnOff() {
		System.out.println("목적지 도착 후 시동 끄기");
	}
	//부모 클래스인 추상 클래스에서 상속 받은 추상 메서드를 반드시 전부 구현해야한다. 안하면 구현 하라고 뜬다.
}
