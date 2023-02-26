package study23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamTerminalOperation {
	public static void main(String[] args) {
		//forEach, count , sum average , reduce, collect등
		int[] arr = {1,1,0,1,1};
		System.out.println(Arrays.stream(arr).count()); //원소 개수 세는 stream연산 즉 6
		System.out.println(Arrays.stream(arr).max().getAsInt()); // 4556 나옴 OptionalInt >> int로 변환
		System.out.println(Arrays.stream(arr).min().getAsInt()); // 1
		System.out.println();
		Arrays.stream(arr).parallel().reduce((x,y)->x-y).ifPresent(System.out::println);//앞 원소 - 뒤 원소 - 다음원소.... -203 나옴
		System.out.println();
		List<String> e = Arrays.asList("A","AB","C","D","CD","E","F");
		System.out.println(e.stream().parallel().filter(s->s.startsWith("C")).findFirst().get());
		System.out.println(e.stream().parallel().filter(s->s.startsWith("C")).findAny().get());
		System.out.println(e.stream().collect(Collectors.joining()));//문자열 원소를 전부 이어붙인 문자열로 나온다.
		List<Integer> ns = Arrays.asList(1,2,3,4,5,6,7);
		Double aver = ns.stream().collect(Collectors.averagingDouble(s->s));
		System.out.println(aver);
		Integer s =ns.stream().collect(Collectors.summingInt(l->l));
		 System.out.println(ns.stream().collect(Collectors.partitioningBy(a->a>3)));//단 2개로 나눌때 partitionby함수를 쓴다.
		 System.out.println(ns.stream().collect(Collectors.groupingBy(a->a>3)));//여러 파티션으로 나눌때 groupingby함수를 쓴다.
		 
	}
}
