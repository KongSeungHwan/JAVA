package sutdy09;

public class CustomerRun {

	public static void main(String[] args) {
		Customer customer  = new Customer();
		customer.buy();
		customer.sell();
		customer.order();
		customer.complain();
		//이건 그냥 customer 객체 메소드만 호출한 형태인데
		
		Buy buyer = customer; //인터페이스도 약간 부모 클래스 개념
		buyer.buy();
		buyer.order();
		//buyer.sell();
		//buyer.complain();
		
		Sell seller = customer;
		seller.sell();
		seller.order();
		//seller.buy();
		//seller.complain();
		
	}

}
