package codingTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {
	public static void main(String[] args) {
		Integer[] num_list = {1,2,3,4,5,6,7,8,9,10,11};
		int a = (int)Arrays.stream(num_list).reduce((x,y)->(num_list.length>=11)?x+y:x*y).get();
		System.out.println(a);
		
		System.out.println(Arrays.stream(num_list).anyMatch(x->x==2));
		Integer[] answer = Arrays.copyOfRange(num_list, 1, 3);
		Arrays.stream(answer).forEach(System.out::println);
		int[] arr1=IntStream.rangeClosed(3, 10).boxed().sorted(Collections.reverseOrder()).mapToInt(e->(int)e).toArray();
		String a4= "message";
		System.out.println("message".length());
		
		int[] sides ={3, 6, 2};
		int[] sides2=Arrays.stream(sides).sorted().toArray();
		for(int i:sides2) System.out.print(i);
		
		
		
		System.out.println(sides2[0]+sides2[1] > sides2[2]);
		
        int answer1 = (sides2[0]+sides2[1] > sides[2]) ? 1 : 2;
		System.out.println(answer1);
		String my_string="hello";
		
		Arrays.stream(my_string.split("")).map(e-> e.repeat(3)).collect(Collectors.joining());
		
		
	}
}
12312