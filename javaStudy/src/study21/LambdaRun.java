package study21;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@FunctionalInterface
interface A {
	String firstPrint(String a);
}//public abstract는 자동으로 붙는다.
@FunctionalInterface
interface B {
	String print(String a);
}
@FunctionalInterface
interface C {
	int print(String a ,int index);
}
@FunctionalInterface
interface D {
	String print(String a,int stindex,int enindex);
}
interface F {
	void sayHi();
}

public class LambdaRun {
	public static void main(String[] args) {
		//		A aFunc = (x) -> {return x;};
		//		B bFunc = (a) -> {System.out.println(a);};
		//		C cFunc = (x,y) -> {return x+y;};
		//		D dFunc = (x,y,z)->{
		//			return x+y+z;
		//		};
		A a = new A() {
			@Override
			public String firstPrint(String a) {
				return  a.length()+" "+a.charAt(0);
			}//맨 앞글자만 출력!
		};//익명클래스로 이용하여 함수 구현
		//이런 귀찮은 짓 안할라고 람다식 만든것!
		A b = x -> x.length()+" "+x.charAt(0);
		//람다식으로 함수구현
		System.out.println(a.firstPrint("abc"));
		System.out.println(b.firstPrint("bbc"));
		System.out.println();
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++)arr[i]=i;
		Arrays.stream(arr).filter(s->s>0).forEach(d-> System.out.println(d));
		//0보다 큰수들만 출력이라 0을 제외한 1,2가 출력
		System.out.println();
		List<String> list2 = new Vector<>(Arrays.asList("1202020","1010101","1111111","12222221"));
		list2.stream().filter(s->s.contains("2")).forEach(s->System.out.println(s));
		//2를 포함한 원소들을 전부 출력
		System.out.println();
		C c = (x,y)-> x.length();
		//print메소드 구현
		System.out.println(c.print("123", 0));
		//호출
		List<Car> list3 = new Vector<>(Arrays.asList(new Car("1",1),new Car("2",2),new Car("3",3)));
		
		List<String> nameList= list3.stream().map(s-> s.getName()).collect(Collectors.toList());
		System.out.println();
		nameList.stream().forEach(s->System.out.println(s));
		//map메소드를 사용하여 list형식으로 리턴하고 바로 stream 연산해서 출력
		//Car 객체의 이름! 문자열 1,2,3 이 나옴
	}

}
