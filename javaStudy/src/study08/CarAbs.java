package study08;

public abstract class CarAbs { //abstract class
	public abstract void drive();//abstract method
	public abstract void stop();
	public abstract void turnOn();
	public abstract void turnOff();
	
	//추상 메서드들
	
	//템플릿 메소드(상속받을 클래스들의 공통된 시나리오 대로 메소드를 호출하는 메소드)
	public void templateMethod() {
		turnOn();//시동 키고
		drive(); // 주행하고
		stop(); //멈추고
		turnOff(); //시동 끄고
	}// 자동차의 시나리오 대로 템플릿 메소드 구성
}
