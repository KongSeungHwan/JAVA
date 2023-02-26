package study15_2023_02_15;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableRun {

	public static void main(String[] args) {
		Hashtable<Integer,String> h = new Hashtable<>();
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
