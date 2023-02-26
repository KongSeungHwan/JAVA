package study08;

public abstract class Computer { 
	//일부 미구현된 추상 메소드,또 다른 일부는 구현된 메소드
	Computer() {
		System.out.println("computer");
	}
	public void display() {};
	public abstract void typing();
	
	//추상 메서드(미구현된 메서드) 실행문(명령문)부분을 채워 상속받아 구현을 해줘야 함.(필수)
	public void turnOn() {
		System.out.println("전원 킴");
	}
	public void turnOff() {
		System.out.println("전원 끔");
	}
	//추상 클래스를 만드는 이유 같은 종류이지만, 일부 기능이 다를 수 있는 가능성을 열어둬야하기 때문에 존재한다고 보면 된다.
	//ex) 노트북과 일반 데스크탑 컴퓨터 전원 키는 방식이 다름
	// 컴퓨터는 본체의 전원버튼 눌러야만 켜지지만, 노트북은 모니터 부분을 열면 알아서 켜짐.
}
