package study15_2023_02_15;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeMap;

public class MapInterfaceRun {

	public static void main(String[] args) {
		HashMap<Integer,String> a1 = new HashMap<>();
		LinkedHashMap<Integer,String> a2 = new LinkedHashMap<>();
		Hashtable<Integer,String> a3 = new Hashtable<>();
		TreeMap<Integer,String> a4 = new TreeMap<>();
		
		a1.put(101,"Lee");
		a1.put(102,"Kim");
		a1.put(103,"Kim");
		a1.put(104,"Hong");
		a2.put(103,"Lee");
		a2.put(102,"Kim");
		a2.put(101,"Kim");
		a2.put(102,"Hong");
		a3.put(103,"Lee");
		a3.put(102,"Kim");
		a3.put(101,"Kim");
		a3.put(102,"Hong");
		a4.put(103,"Lee");
		a4.put(102,"Kim");
		a4.put(101,"Kim");
		a4.put(102,"Hong");
		Set<Entry<Integer, String>> e1 = a1.entrySet();
		Set<Entry<Integer, String>> e2 = a2.entrySet();
		Set<Entry<Integer, String>> e3 = a3.entrySet();
		Set<Entry<Integer, String>> e4 = a4.entrySet();
		
		Iterator<Entry<Integer, String>> i1=e1.iterator();
		Iterator<Entry<Integer, String>> i2=e2.iterator();
		Iterator<Entry<Integer, String>> i3=e3.iterator();
		Iterator<Entry<Integer, String>> i4=e4.iterator();
		System.out.println("hashMap");
		while(i1.hasNext()) {
			Entry<Integer, String> a = i1.next();
			System.out.printf("번호: %d,이름: %s \n",a.getKey(),a.getValue());
		}
		System.out.println("LinkedHashMap");
		while(i2.hasNext()) {
			Entry<Integer, String> b = i2.next();
			System.out.printf("번호: %d,이름: %s \n",b.getKey(),b.getValue());
		}
		System.out.println("HashTable");
		while(i3.hasNext()) {
			Entry<Integer, String> c = i3.next();
			System.out.printf("번호: %d,이름: %s \n",c.getKey(),c.getValue());
		}
		System.out.println("TreeMap");
		while(i4.hasNext()) {
			Entry<Integer, String> d = i4.next();
			System.out.printf("번호: %d,이름: %s \n",d.getKey(),d.getValue());
		}
		//next 자체를 호출하면 포인터가 넘어가는 것 유의!2배로 돌려짐
		
		
		
	}

}
