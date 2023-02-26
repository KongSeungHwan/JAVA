package study07;

public class GoldCustomer extends Customer{
	private double saleRatio;
	public GoldCustomer(String customerName) {
		super(customerName);
		// 오버로딩은 매개변수 개수 , 자료형, 순서로 구분(생성자도 마찬가지 왜냐 생성자도 메소드니까)
		customerGrade = "Gold";
		bonusRatio = 0.03;
		saleRatio =0.05;
		System.out.println("Customer 생성자");
	}
	
@Override
public int calcPrice(int price) {
	bonusPoint+=price*bonusRatio;
	return price-(int)(price*saleRatio);
	//괄호안의 값은 실수범위의 값이 나오게 되고 price(매개변수)*0.05가 된다.
	//그냥 정수형은 실수형과 계산을 하면 보통은 실수형이 되더라..
	//소수점 아래 숫자가 연산해서 0이 되어도 double임 몇.0으로 될건디
	//강제 캐스팅 당연한것.
}




}
