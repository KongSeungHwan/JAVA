package study23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Student implements Comparable<Student>{
	int st;
	String name;
	Student(String n){
		name=n;
	}
	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}
	
}
public class StreamMakeRun {
	public static void main(String[] args) {
		//Collection 측 
		ArrayList<String> list = new ArrayList<>(Arrays.asList("1","12","123","1234","12345","123456"));
		System.out.println("ArrayList 원소 줄바꿈하면서 출력");
		list.stream().forEach(System.out::println); //1 이 쫙 나옴 줄바꿈하면서 최종연산만 진행
		//배열 측
		String[] str = {"1","1","1","1","1","1"};
		System.out.println("배열 원소 줄바꿈하면서 출력");
		Arrays.stream(str).forEach(System.out::println);
		System.out.printf("배열 원소 개수: %d",Arrays.stream(str).count());
		System.out.println();
		System.out.println("2를 포함한 원소 전부 출력");
		list.stream().filter(s->s.contains("2")).forEach(System.out::println);
		//첫번째 원소 말고 전부 출력됨.(2가 포함된 원소니까!)
		//코드 수는 확실히 줄지만 for문이 컴파일 작업에 훨씬 더 잘 최적화 되어있다는 것을 알아야한다. 
		//stream은 2015년에 도입된 메소드이기 때문에 최적화 잘 안되어있음
		ArrayList<Student> sList = new ArrayList<>(List.of(new Student("1"),new Student("1"),new Student("1"),new Student("1"),new Student("1"),new Student("1")));
		 List<String> a = sList.stream().map(s-> s.name).collect(Collectors.toList());
		 //map 중간연산을 이용한  collection 형식 바꾸기
		 System.out.println("Student 객체들의 이름 값만 List형식으로 받아 stream연산으로 출력하기");
		 a.stream().forEach(System.out::println);
		 //중간 연산 포함 stream 연산
		 //Stream 객체로 천천히 만들어도 무방 한줄로 쓰는법임 
	}

}
