package IOTest;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest1 {

	public static void main(String[] args) {
		Arrays.stream(STRARR).map(s->s.length()).collect(Collectors.summingInt(s->s));
		Random r = new Random();
		System.out.printf("각 문자열 길이 합값: %s\n",String.valueOf(Arrays.stream(STRARR)
				.map(s->s.length()).
				collect(Collectors.summingInt(s->s))));//이건?
		System.out.printf("각 문자열 길이 최대값: %s\n",String.valueOf(Arrays.stream(STRARR)
				.mapToInt(s->s.length())
				.max()
				.getAsInt()));//** valueof로 하면 문자열 출력
		System.out.println("로또번호 출력");
		new ArrayList<>(List.of(r.nextInt(45)+1,r.nextInt(45)+1,r.nextInt(45)+1,r.nextInt(45)+1,r.nextInt(45)+1,r.nextInt(45)+1))
		.stream()
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.println("주사위 2번 굴릴 시 6일 경우 모두 출력");
		new ArrayList<>(List.of(1,2,3,4,5))
		.stream()
		.forEach(s->System.out.printf("%s + %s = 6\n",String.valueOf(s)
				,String.valueOf(6-s)));
		//그냥 6뺸 숫자 출력하면 끝아닌가
		//IntStream.rangeClosed(1,6).boxed.flatMap(s-> IntStream.rangeClosed(1,6).boxed.map(j->new Integer[]{i,j})).filter(ar -> ar[0]+ar[1]==6).collect(Collectors.toList())
		//내께 더 간단한 것 같기도 하고? 그냥 6에서 뺀 숫자 출력 끝아니여(1~5까지)
		//boxed,IntStream 공부
		//로또 번호 늘어뜨리기!
		//주사위는 솔직히 6뺀수 출력하면 끝인데
		//줄 수는 적은데 가독성 떨어짐.. ㅋㅋ 왜냐 스트림 쓰랬잖어!
	}
	public static final String[] STRARR= {"Pie","pi","P","Cake"};
}
