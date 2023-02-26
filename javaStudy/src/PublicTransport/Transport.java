package PublicTransport;

public abstract class Transport {
	int passengerCount;//승객 숫자
	int income;//총 수익 초기화 

	
	public void take(int money) {//승객이 해당 교통수단을 이용
		passengerCount++;
		income+=money;
		System.out.printf("%d 원 입니다 \n",money);
	}//구현 코드(일반 메소드)
	
	public abstract void showInfo();
	//추상메소드  이러한 추상 메소드가 1개라도 존재해야 진정으로 해당 클래스가 추상 클래스가 된다.
	
	
	
	
	
}
