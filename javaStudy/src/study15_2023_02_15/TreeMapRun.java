package study15_2023_02_15;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapRun {

	public static void main(String[] args) {
		TreeMap<Integer,String> tmap = new TreeMap<>();
		for (int i = 2; i <=40; i++) {
			tmap.put(i,(i/2)+"번 아이" );	 //중복x 니까 홀수는 다 안들어가네
		}
		tmap.put(3,"이상한 놈");
		System.out.println(tmap);
		
		System.out.println(tmap.firstKey());
		System.out.println(tmap.lastKey());
		
		Entry<Integer,String> a = tmap.firstEntry();
		System.out.println(a);
		System.out.println(tmap.lastEntry());
		
		System.out.println(tmap.higherKey(20)); //인덱스?
		System.out.println(tmap.lowerKey(20));
		System.out.println(tmap.higherEntry(18));
		System.out.println(tmap.lowerEntry(18)); //파라미터의 원소를 미포함
		System.out.println(tmap.floorKey(17));
		System.out.println(tmap.ceilingKey(17));
		System.out.println(tmap.floorEntry(17));
		System.out.println(tmap.ceilingEntry(17)); //파라마터의 원소를 포함
		
		System.out.println(tmap.pollFirstEntry());
		System.out.println(tmap.pollLastEntry());
		System.out.println(tmap);
		
		SortedMap<Integer,String> st= tmap.headMap(18);
		NavigableMap<Integer,String> st2= tmap.headMap(18,true); //자신 포함 여부 boolean 값
		
		System.out.println(tmap.headMap(18));
		System.out.println(tmap.headMap(18,true));
		System.out.println(tmap.tailMap(32));
		System.out.println(tmap.tailMap(32,true));
		System.out.println(tmap.subMap(18,32));
		System.out.println(tmap.subMap(18,false,32,true)); 
		//18~32 boolean은 경계 값을 포함하는 지 여부를 나타냄
		
		System.out.println(tmap.entrySet());
		System.out.println(tmap.keySet());
		System.out.println(tmap.values());
		System.out.println(tmap.descendingKeySet());
		System.out.println(tmap.descendingMap());
		
		System.out.println(tmap.replace(4,"4번 녀석"));
		System.out.println(tmap.replace(4, "아닌 녀석", "안 나올 녀석"));
		//동일하면 바꾸고 아니면 안 바꿔줌
		System.out.println(tmap);
		
		System.out.println(tmap.remove(4));

		System.out.println(tmap.remove(6,"3번 아이"));
		System.out.println(tmap);
		
	}
	

}
