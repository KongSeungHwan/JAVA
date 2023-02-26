package sutdy09;

public class Customer implements Buy,Sell{ //implements라고하면 상속의 개념이 아닌가?
	
	public void sell() {
		System.out.println("고객 판매");
	}
	public void buy() {
		System.out.println("고객 구매");
	}
	//중복된 메서드의 재정의
	public void order() {
		System.out.println("고객 주문");
	}
	public void complain() {
		System.out.println("고객 불만");
	}
	
}
