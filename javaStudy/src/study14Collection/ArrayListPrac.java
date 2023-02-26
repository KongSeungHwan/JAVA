package study14Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListPrac {

	public static void main(String[] args) {
		//객체
		ArrayList<String> arr = new ArrayList<>();
		//내용 추가 일식이 칠식이?
		for (int i = 1; i <=7; i++) {
			arr.add(i+"식이");
		}
		arr.addAll(Arrays.asList("삼식이","사식이","오식이"));
		System.out.println("향상된 for문");
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("iterator");
		Iterator<String> it = arr.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("일반 for문");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			
		}
		//삼식이 있으면 확인 있으면 구식이 추가 없으면 오식이 삭제
		if(arr.contains("삼식이"))arr.add("구식이");else arr.remove("오식이");
		
			
			
		//toArray 배열 변환 후 출력
		String[] str = arr.toArray(new String[0]);
		System.out.println("결과 값 출력:");
		for (String s : str) {
			System.out.println(s);
		}
	}

}
