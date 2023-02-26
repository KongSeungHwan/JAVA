package PublicTransport;

public class Bus extends Transport{
	private int busNumber; //버스번호
	
	public Bus(int busNumber) {
		this.busNumber=busNumber;
	}
	//가상 메소드 기능으로 처리 take 메소드
	public void take(int money){
		this.income+=money;
		passengerCount++;
		System.out.println("버스 탐.");
	}
	
	public void showInfo() {
		//추상클래스에서 상속을 받아 추상메소드를 구현해야함 필수.
		System.out.println("==================");
		System.out.printf("%d번 버스 \n",busNumber);
		System.out.printf("탑승자 수: %d \n",passengerCount);
		System.out.printf("총 수익: %d \n",income);
		System.out.println("==================");
	}

}
