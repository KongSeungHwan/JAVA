package study15_1_2023_02_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

enum CoffeeType{Americano,IcedAmericano,CafeLatte;
	private int price;
	
	void price(int p) {
		this.price = p;
	}
	int showPrice() {
		 return this.price;
	}	

}



public class EnumPrac {
	static void printCoffeePrice(String a) {
		HashMap<String,CoffeeType> priceMap = new HashMap<>();
		CoffeeType.Americano.price(3000);
		CoffeeType.IcedAmericano.price(4000);
		CoffeeType.CafeLatte.price(5000);
		priceMap.put("아메리카노",CoffeeType.Americano);
		priceMap.put("아이스아메리카노",CoffeeType.IcedAmericano);
		priceMap.put("카페라떼",CoffeeType.CafeLatte);
			int price = priceMap.get(a).showPrice();
			System.out.printf("%s: %d",a,price);
		
		
	}
	
	public static void main(String[] args) {
		BufferedReader n =new BufferedReader(new InputStreamReader(System.in));
		System.out.print("커피 이름 입력: ");
		String st;
		try {
			st = n.readLine();
			printCoffeePrice(st);
		} catch (IOException e) {
			System.out.println("없는 커피거나 잘못된 입력입니다.");
		}
	}
	

}
