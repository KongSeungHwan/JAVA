package MineSweeper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
public static void main(String[] args) {
	List<List<Integer>> list= IntStream.rangeClosed(0, 4).boxed().map(s->IntStream.rangeClosed(0, 4).boxed().collect(Collectors.toList())).collect(Collectors.toList());
	list.stream().forEach(System.out::println);
}
}
