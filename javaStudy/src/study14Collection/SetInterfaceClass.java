package study14Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfaceClass {
	public static void main(String[] args) {
		HashSet<String> hset = new HashSet<>();

		hset.add("A");

		Set<String> hset2 = new HashSet<>(Arrays.asList("A","B","C"));

		Set<String> hset3 = new HashSet<>(List.of("A","B","C"));

		System.out.println(hset);

		hset2.addAll(hset3);

		System.out.println(hset2);

		System.out.println(hset3);


		LinkedHashSet<String> lset = new LinkedHashSet<>();

		lset.add("A");

		Set<String> lset2 = new LinkedHashSet<>(Arrays.asList("A","B","C"));


		TreeSet<String> tset = new TreeSet<>();

		tset.add("A");

		Set<String> tset2 = new TreeSet<String>(Arrays.asList("A","B","C"));
		
	} //Arrays.asList, List.of() 라는 함수가 존재함을 확인
	
	
	
	
	
	
	
}
