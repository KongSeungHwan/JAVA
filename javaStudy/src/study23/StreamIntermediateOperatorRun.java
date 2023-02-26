package study23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class StreamIntermediateOperatorRun {

	public static void main(String[] args) {
		IntStream is1 = IntStream.of(7,5,5,2);
		IntStream is2 = IntStream.of(7,1,4,2);
		
		System.out.println(is1.filter(s-> (s%2!=0)&&(s%3==0)).count());//짝수중 3의 배수 카운트 맨 끝 원소만 2이고 0개다
		Stream<String> s1 =Stream.of("html","css","java","ajax");
		List<Integer> ss= s1.map(s->s.length()).sorted().collect(Collectors.toList()); //각 문자열의 길이를 출력 즉 4,3,4,4
		//map은 각자 객체의 메소드를 호출하면서 해당 리턴 값을 출력 또는 다른 Collection으로 리턴해준다.
		//ss.forEach(System.out::println);//중복 제거 되므로 3,4 만 나옴
		//set으로 리턴했을때의 차이는 set으로 반환 후 다시 stream 연산을 하게 되면 정렬되어 출력됨.
		ss.stream().forEach(System.out::println);
		String[] ar = {"a b c d e f","a b c","a b"};
		Stream<String> a = Stream.of("html2","css2","java2","ajax2");
		List<String> list = new ArrayList<>(List.of("css2","html2","java2","ajax2"));
		list.stream().sorted().sorted().forEach(System.out::println);
		System.out.println();
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);//역순 출력
		System.out.println();
		list.stream().peek(System.out::print).limit(5).sorted(Comparator.reverseOrder()).peek(System.out::print).sorted().forEach(System.out::println);
		//그냥 출력 >> 역순 정렬 후 출력 >>오름차순 정렬 후 출력 >> 다시 출력
		//그냥 중간 연산 중 여러번 foreach 연산 필요시에 쓰는 함수 같음
		//skip()
	}

}
