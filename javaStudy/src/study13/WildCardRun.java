package study13;

class WildClass<T extends Comparable<T>>{}//인터페이스도 extends 쓰나?
class WildClass2<T extends Comparable<? super T>>{}

class Person{}
class Student extends Person implements Comparable<Person>{
	public int compareTo(Person o) {return 0;}
}
class Student2 implements Comparable<Student2>{
	public int compareTo(Student2 o) {return 0;}
}
public class WildCardRun {

	public static void main(String[] args) {
		//WildClass<Student> a = new WildClass<>();
		//위의 클래스 정의를 고쳐야함. 오류 안뜰라면 Comparable<? super T> 때문에 오류나는거
		//들어 갈수 있는게 없음
		//Person을 집어 넣을라고 해도 person클래스는 해당 인터페이스를 상속 받는 것도 아니니까
		//해당 사항이 없음
		//WildClass<Student2> b = new WildClass<>();
		//WildClass2<Student> c = new WildClass2<>();
	}

}
