package study24_2023_02_27;

import java.util.List;

public class StreamTest5 {
	public static void main(String[] args) {
		List.of("mango","banana","apple")
		.stream()
		.sorted() //동일하면 입력 순서에 따라 바뀐다.
		.forEach(System.out::println);
	}
}
