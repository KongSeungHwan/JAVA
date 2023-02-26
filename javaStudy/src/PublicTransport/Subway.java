package PublicTransport;

public class Subway extends Transport {
	private int lineNumber;
	
	public Subway(int lineNumber) {
		this.lineNumber=lineNumber;
	}
	//오버라이딩해서 가상메소드 기능 사용(subwaY, bus 기능 달리함)
	public void take(int money){
		this.income+=money;
		passengerCount++;
		System.out.println("지하철 탐.");
		
	}
	
	public	void showInfo() { 
			//추상클래스에서 상속을 받아 추상메소드를 구현해야함 필수.
			System.out.println("==================");
			System.out.printf("%d번 호선 \n",lineNumber);
			System.out.printf("탑승자 수: %d \n",passengerCount);
			System.out.printf("총 수익: %d \n",income);
			System.out.println("==================");
		
	}
	
	
}
