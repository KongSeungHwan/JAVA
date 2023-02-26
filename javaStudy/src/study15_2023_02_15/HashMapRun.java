package study15_2023_02_15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapRun {

	public static void main(String[] args) {
		HashMap<Integer,String> h  =new HashMap<>();
		//다수의 데이터를 효율적으로 처리하는 프레임워크 >> Collection Framework (DB의 데이터 또한 담을 수 있다고만 알자)

		h.put(2,"홍길동");
		h.put(4,"김유신");
		h.put(3,"유관순");
		h.put(1,"이순신");
		System.out.println(h);
		//print메소드 안쪽에서 valueOf 메소드를 첫줄부터 호출하게되면 toString을 호출하게 된다.

		HashMap<Integer,String> h2 = new HashMap<>();
		h2.putAll(h);
		h2.put(1, "이방원"); //동일한 key값에 해당하는 값이 자동으로 변경된다.
		System.out.println(h2);
		h2.putAll(h);
		System.out.println(h2); //다시 싹다 초기화
		h.putIfAbsent(5,"무지개");//적은 인덱스에 해당하는 값이 없으면 기입 
		System.out.println(h2);
		//그러면 있으면? 안 바꿔버린다.
		h.replace(3,"김구");
		h.replace(9,"김구");
		//있으면 대체 없으면 
		//대체기능 소실
		System.out.println(h);
		
		System.out.println(h.get(3));
		System.out.println(h.getOrDefault(100, "기본값"));
		
		Set<Map.Entry<Integer,String>> e=h.entrySet(); //entry 자료형 형태로 set안에 담는 형태
		System.out.println(e);
		
		System.out.println(h.keySet()); //key 값들만 리턴
		System.out.println(h.values()); //value 값들만 리턴
		
		System.out.println(h.size());//자료구조의 길이
		System.out.println(h.containsKey(1));
		System.out.println(h.containsValue("이순신"));//값을 완벽히 쳐야 찾아진다.
		System.out.println(h.remove(4)); //value 값을 리턴하는 함수
		System.out.println(h.remove(1,"이순신")); //boolean 값을 리턴
		System.out.println(h);
		h.clear();
		System.out.println(h.isEmpty());
		
		Set<Integer> s = h2.keySet();
		for (Integer key : s) {
			System.out.printf("키: %d, 값: %s \n",key,h2.get(key));
		}
		System.out.println();
		Iterator<Integer> it = s.iterator();
		
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.printf("키: %d, 값: %s \n",i,h2.get(i));
		}
	}

}
