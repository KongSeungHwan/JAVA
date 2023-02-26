package study07;

import java.util.ArrayList;

public class PriceRun {
	public static void main(String[] args) {
		 Customer lee = new Customer("이순신");
		ArrayList<Customer> cusList = new ArrayList<>();
		cusList.add(lee);
		cusList.add(new GoldCustomer("성시경"));
		cusList.add(new GoldCustomer("홍길동"));
		cusList.add(new VipCustomer("김정호","대동아"));
		cusList.add(new VipCustomer("공유","와이파이"));
		System.out.println("고객 리스트:");
		showCustomer(cusList);
		calcPriceAll(cusList,100000);
	}
	static void showCustomer(ArrayList<Customer> list) {
		System.out.println("고객 리스트:");
		for (Customer customer : list) {
			System.out.printf("고객이름: %s \n",customer.customerName);
		}
		//향상 for문으로 list에 저장된 객체 모두 꺼내면서 이름 출력
	}
	static void calcPriceAll(ArrayList<Customer> list,int price) {//calculate구먼..(calc)
		System.out.println("----가격계산----");
		System.out.printf("가격 %d \n",price);
		for (Customer customer : list) {
			System.out.printf("고객 %s의 구매금액: %d \n",customer.getCustomerName(),customer.calcPrice(price));
			System.out.println(customer.getCustomerInfo());
		}	
	}
}
