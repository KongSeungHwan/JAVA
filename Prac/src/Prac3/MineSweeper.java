package Prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MineSweeper {
	 Map<Integer, List<Integer>> mineList;
	public static void main(String[] args) {
		MineSweeper m;
		try(BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
				) {
				panView(mineSelect(5/*변동숫자 임의로 15지정*/));
				System.out.println();
				panView2(hideMine(mineSelect(5)));
				

		} catch (NumberFormatException | IOException e) {
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
		

	}
	MineSweeper(int num){
		mineList=mineSelect(num);
	}

	static Map<Integer, List<Integer>> mineSelect(int num){
		return IntStream.rangeClosed(1, num)
		.boxed()
		.collect(Collectors.toMap(s->s,s->new Random().ints(1,3).boxed().limit(num).collect(Collectors.toList())));
	} //Map의 키값은 row로 구현, 또한 안의 원소는 list며 원소는 1(폭탄),0(일반 땅)을 의미
	static <t> void panView(Map<Integer, List<t>> l) {
		Iterator<Entry<Integer, List<t>>> it= l.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, List<t>> token= it.next();
			token.getValue().stream().forEach(s->System.out.printf(String.format("%s ",s)));
			System.out.println();
		}
	}//지뢰찾기 판을 줄에 맞도록 출력하는 메소드
	static void panView2(Map<Integer, List<String>> l) {
		Iterator<Entry<Integer, List<String>>> it= l.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, List<String>> token= it.next();
			token.getValue().stream().forEach(s->System.out.printf("%s ",s));
			System.out.println();
		}
	}
	
	static Map<Integer, List<String>> hideMine(Map<Integer, List<Integer>> l){
		return IntStream.rangeClosed(1, l.size())
				.boxed()
				.collect(Collectors.toMap(s->s,s-> Stream.generate(()-> "*").limit(l.size()).collect(Collectors.toList())));
	}//맨땅을 0으로 표현하고 이제 1인지 2인지 맞추는 게임

}
