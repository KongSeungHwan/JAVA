package study15_2023_02_15;

import java.util.HashMap;

class Food1{
	String foodName;
	Food1(String name){
		foodName=name;
	}
	@Override
	public String toString() {
		return foodName;
	}//toString 오버라이딩 시 주소@해시코드 대신 toString이 호출 됨.

}
class Food2{
	String foodName;
	Food2(String name){
		foodName=name;
	}
	@Override
	public String toString() {
		return foodName;
	}//toString 오버라이딩 시 주소@해시코드 대신 toString이 호출 됨.
	@Override
	public boolean equals(Object obj) {//오버라이딩
		if(obj instanceof Food2) {
			return foodName.equals(((Food2) obj).getFoodName());
			//getter메소드와 강제 캐스팅 해야 비교 가능..
		}else {
			return false;	
		}
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String name) {
		foodName = name;
	}
}


public class HashMapMachRun {

	public static void main(String[] args) {
		HashMap<Integer,String> h = new HashMap<>();
		h.put(3,"H");
		h.put(4,"H");
		h.put(3,"H");
		System.out.println(h.size());
		System.out.println(h);
		System.out.println();
		
		
		HashMap<Food1,String> hm = new HashMap<>();
		Food1 f1 = new Food1("ㄸㅂㅇ");
		System.out.println(f1); 
		Food1 f2 = new Food1("떡볶이");
		hm.put(f1,"분식");
		hm.put(f2,"분식");
		System.out.println(f1.equals(f2));
		System.out.printf("f1의 해시코드 :%d\n",f1.hashCode());
		System.out.printf("f2의 해시코드 :%d",f2.hashCode());
		System.out.println(hm.size());
		System.out.println(hm);
		System.out.println();
		
		h.put(3,"H");
		h.put(4,"H");
		h.put(3,"H");
		System.out.println(h.size());
		System.out.println(h);
		System.out.println();
		
		
		HashMap<Food2,String> hm2 = new HashMap<>();
		Food2 f3 = new Food2("ㄸㅂㅇ");
		System.out.println(f1); 
		Food2 f4 = new Food2("떡볶이");
		hm2.put(f3,"분식");
		hm2.put(f4,"양식");
		System.out.println(f3.equals(f4));
		System.out.printf("f3의 해시코드 :%d\n",f3.hashCode());
		System.out.printf("f4의 해시코드 :%d",f4.hashCode());
		System.out.println(hm2.size());
		System.out.println(hm2);
		System.out.println();
		
	}

}
