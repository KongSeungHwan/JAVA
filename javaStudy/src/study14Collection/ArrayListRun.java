package study14Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListRun {

	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<>();
		//List<String> list = new ArrayList<>(); o
		//요소 추가
		
		
		//list인터페이스의 기본적인 메소드 정리
		a.add("태종");
		a.add("태종");
		a.add("태종");
		a.add("태종");
		a.add("승진");
		a.add("주환");
		a.add(1,"소정"); //0 다음 수의 인덱스인 1자리에 넣고 뒤로 밀리게 한다. 태종 소정 승진 주환 순으로
		System.out.println(a);
		
		System.out.println(a.get(01));
		
		System.out.println(a.remove(02));//해당 인덱스의 원소 없애기
		System.out.println(a);
		System.out.println(a.remove("태종"));//값이 문자열 태종인 원소 없애기(오버로딩)
		System.out.println(a);
		
		a.set(0,"태일");//update 기능
		System.out.println(a);
		
		System.out.println(a.size());
		
		System.out.println(a.contains("승진")); //검색하는 메소드
		
		System.out.println(a.indexOf("승진"));//인덱스를 리턴하는 메소드
		
		for (String str : a) {
			System.out.printf("이름: %s \n",str);
		}
		System.out.println();
		Iterator<String> b=a.iterator();
		while(b.hasNext()) {
			System.out.printf("이름: %s \n",b.next());
		}
		for (int i = 1; i < 8; i++) {
			a.add("사람"+i);
		}
		Collections.sort(a);
		System.out.println(a);
		Collections.sort(a,Collections.reverseOrder());
		System.out.println(a);
		ArrayList<String> a2 = new ArrayList<>(Arrays.asList("사람1","사람2","사람3","사람4"));
		System.out.println(a2);
		ArrayList<String> a3 = new ArrayList<>(Arrays.asList("예진","민성","현우","시우","지민","정기"));
		System.out.println(a3);
		
	}

}
