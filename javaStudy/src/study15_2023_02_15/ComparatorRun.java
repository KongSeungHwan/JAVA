package study15_2023_02_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
	int id;
	String name;
	int age;
	public Student(int a,String b,int c) {
		id=a;
		name=b;
		age=c;
	}
	@Override
	public String toString() {
		return String.format("이름:%s 아이디:%s 나이:%s",name,id,age);
	}
}
class AgeComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.age-o2.age;//역순 -1 곱하기
	}
}
public class ComparatorRun {

	public static void main(String[] args) {
		ArrayList<Student> a= new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			a.add(new Student(i,"이름"+i,i+1));	
		}
		System.out.println(a);
		Collections.sort(a,new AgeComparator());
		//세미콜론 몇개를 붙여도 안남
		System.out.println(a);
		Collections.sort(a,new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
			
		});
		AgeComparator cm = new AgeComparator();
		System.out.println(a);
		Student b = a.get(0);
		Student c = a.get(1);
		

	}

}
