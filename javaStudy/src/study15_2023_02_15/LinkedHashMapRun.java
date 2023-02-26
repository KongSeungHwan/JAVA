package study15_2023_02_15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapRun {
	public static void main(String[] args) {
		LinkedHashMap<Integer,String> lmap = new LinkedHashMap<>();
		lmap.put(2,"홍길동");
		lmap.put(4,"김유신");
		lmap.put(3,"유관순");
		lmap.put(1,"이순신");
		System.out.println(lmap);
		//print메소드 안쪽에서 valueOf 메소드를 첫줄부터 호출하게되면 toString을 호출하게 된다.

		HashMap<Integer,String> lmap2 = new HashMap<>();
		lmap2.putAll(lmap);
		System.out.println(lmap2);
		lmap2.put(1, "이방원"); //동일한 key값에 해당하는 값이 자동으로 변경된다.
		System.out.println(lmap2);
		lmap2.putAll(lmap);
		System.out.println(lmap2); //다시 싹다 초기화
		lmap.putIfAbsent(5,"무지개");//적은 인덱스에 해당하는 값이 없으면 기입 
		System.out.println(lmap2);
		//그러면 있으면? 안 바꿔버린다.
		lmap.replace(3,"김구");
		lmap.replace(9,"김구");
		//있으면 대체 없으면 
		//대체기능 소실
		System.out.println(lmap);

		System.out.println(lmap.get(3));
		System.out.println(lmap.getOrDefault(100, "기본값"));

		Set<Map.Entry<Integer,String>> e=lmap.entrySet(); //entry 자료형 형태로 set안에 담는 형태
		System.out.println(e);

		System.out.println(lmap.keySet()); //key 값들만 리턴
		System.out.println(lmap.values()); //value 값들만 리턴

		System.out.println(lmap.size());//자료구조의 길이
		System.out.println(lmap.containsKey(1));
		System.out.println(lmap.containsValue("이순신"));//값을 완벽히 쳐야 찾아진다.
		System.out.println(lmap.remove(4)); //value 값을 리턴하는 함수
		System.out.println(lmap.remove(1,"이순신")); //boolean 값을 리턴
		System.out.println(lmap);
		lmap.clear();
		System.out.println(lmap.isEmpty());

		Set<Integer> s = lmap2.keySet();
		for (Integer key : s) {
			System.out.printf("키: %d, 값: %s \n",key,lmap2.get(key));
		}
		System.out.println();
		Iterator<Integer> it = s.iterator();

		while(it.hasNext()) {
			Integer i = it.next();
			System.out.printf("키: %d, 값: %s \n",i,lmap2.get(i));
		}

	}
}
