package study24_2023_02_27;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {
	static class Person{
		String name;
		int age;
		public Person(String n,int a){
			name=n;
			age=a;
		}
		@Override
		public String toString() {
			
			return String.format("Person{name : %s, age : %s}",name,age);
		}//문자열로 리턴
	}

	public static void main(String[] args) {
		List<Person> pList = Arrays.asList(new Person("bob",34),new Person("bob",43),new Person("mary",84),new Person("john",12),new Person("bob",22));
	
		pList.stream().map(s-> s.toString()).forEach(System.out::println);
		//오버라이딩한 toString() 활용해서 모든 정보 출력!(STREAM 연산)
		//스트림 생성
		
		
		pList.stream().collect(Collectors.groupingBy(p->p.name)); //이름으로 n분할하여
		
		
	}
}
