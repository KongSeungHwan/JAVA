package study23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableRun {

	public static void main(String[] args) {
		List<Character> list = new ArrayList<>(List.of('a','b','c','d','e','f','g','h','i'));
		list=Collections.unmodifiableList(list);//CRUD 불가.. 시도 시 UnsupportedOperationException 걸린다.// constant pool 할당 ㅇ
		List<Character> list2 =new ArrayList<>(list);
		list2.stream().forEach(System.out::println);//이건 가능/ 대신 내부 값을 crud 시도 시 예외 발생
	}

}
