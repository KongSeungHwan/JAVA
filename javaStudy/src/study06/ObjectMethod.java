package study06;

class Value{
	int value;
	Value(int value){
		this.value=value;
	}	
}
class Cost{
	int cost;
	Cost(int cost){
		this.cost=cost;
	}
	public String toString(){
		//Object에서 toString메소드가 public으로 정의 되어있기때문에 더 좁은 범위인 나머지 접근제어자는 사용 불가능하다.(Object클래스의 하위 클래스이기때문에)
		return "Cost toString() override";
	}
}
public class ObjectMethod {

	public static void main(String[] args) {
		// 최상위 클래스 Object 클래스에 대하여
		//구현/미구현메소드는 중괄호 안의(명령어모임)내용이 있냐 없냐 차이
		Value v1 = new Value(12);
		Value v2 = new Value(13);
		if(v1.value != v2.value) System.out.println("둘의 value 필드 값이 다릅니다.");
		//v1=v2면 같은 주소 v1에 저장된 주소 값이 v2에 저장된 주소값이 변경라는 의미
		//그말은 즉, v1,v2는 같은 주소의 객체를 불러오게 된다.
		//v1.equals(v2) 이 의미는 v1에 저장된 객체 주소와 v2에 저장된 객체 주소가 같은지 
		//boolean값으로 리턴하는 함수라는 것.(primitive type은 저장된 리터럴 값)
		Value v3 = new Value(12);
		Value v4 = new Value(12);
		System.out.println(v3.hashCode());
		System.out.println(v4.hashCode());
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		//주소값을 key값 취급하여 주소를 불러오는 함수
		//hashTable 개념(key를 index로 취급하며 value를 저장하는 방식) key라는 것은 아무 값이나 해도된다.(순서x)1:1대응 자료구조이다.
		//즉, 주소값을 key값으로 취급 그리고 주소에 저장되어있는 값을 value로 놓는 것이다.
		//toString()
		Cost c1 = new Cost(20);
		System.out.println(v4.hashCode());
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(c1.toString());
		Class c1c = c1.getClass();
		System.out.println(c1c.getName()); //
		Class c1c2 = Cost.class;
		//clone함수는 본래 같은 똑같은 복사본을 만들어서 리턴하는 메소드인데
		//여러경우 clone이라는 함수는 알고리즘이 완전히 뒤바뀌게 된다
		//즉 clone이라는 함수는 상황에 따라 오버라이딩해줘야 한다.
		//배열이면 배열 전용 clone 오버라이딩한 메소드를, 
		//객체면 그 해당 객체 전용의 오버라이딩한 메소드를 만들어줘야 한다.
	}

}
