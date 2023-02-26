package study06;

import java.util.HashMap;
import java.util.Vector;

class Parent{
	int age;
	String name;
	
	public Parent(){
		name="parent";//객체를 생성하면 그냥 name필드가 "parent"라는 값을 가지게 된다
		System.out.println("Parnet() run");
	}//이 생성자로 객체를 생성하게 된다면 name 값은 null이다.(필드 한정 기본값이 존재(초기화 안해도))
	public Parent(int age,String name) {
		this.age = age;
		this.name= name;
		System.out.println("aprent(param) run");
		//여기의 this는 무조건 써줘야 함 매개변수의 age,name과 구분하기 위해서 
	}
	//위의 생성자 메소드를 오버로딩하여 또 다른 생성자를 만들어 냄(매개변수 기준).
	public void showInfo() {
		System.out.printf("부모 이름 %s/ 나이: %d",name,age);
		//this 써줘도 되고 안써도 된다.
	}
	
}
class Child extends Parent{
	public Child() {
		//super(); 자동으로 부모클래스의 객체를 생성
		System.out.println("Child() run");
	}
	//객체 생성과 동시에 위의 출력문을 출력하는 생성자 메소드
	public Child(int age,String name){
		//super();
		this.age = age;
		this.name = name;
		System.out.println("Child(parameter) run");
	}
	//생성자 메소드 오버로딩
	//매개변수를 바로 해당 객체의 필드로 지정하며 위의 출력문을 출력하는 생성자 메소드
	public void showInfo() {
		System.out.printf("%s( %d ) \n",name,age);
	}
}

public class Inheritance{

	
	
	public static void main(String[] args) {
		Child chi = new Child(10,"마리");
		chi.showInfo();
		//chi가 제약 먹는 것
		//Parent로 선언 되었으니
		//Parent에서 상속 받은 메소드만 사용 가능하다. (오버라이딩한 메소드 포함)
		Vector<Child> vec = new Vector<>(); //자료구조 벡터 이용
		vec.add(new Child(11,"톰"));
		vec.add(new Child(12,"제리"));
		vec.add(new Child(13,"마리"));
		vec.add(new Child(14,"존"));
		//요소 추가
		for (Child child : vec) {
			child.showInfo();
		}
		//각각 출력
		
	}

}
