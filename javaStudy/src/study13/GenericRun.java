package study13;


//Generic 다뤄보기
//클래스를 여러 개 만들 필요가 없어짐
//ArrayListString , ArrayListInteger....이것들을 한꺼번에 ArrayList<자료형> 하나로 통합가능
//재사용성 증가
//솔직히 <>안에 의미만 있음. 글자 아무거나 와도 상관 없음

class Generic<y>
{
	private y dataType; 
	
	public Generic(y type){
		dataType = type;
	}
	
	Generic(){}
	public y getDataType() {
		return dataType;
	}

	public void setDataType(y dataType) {
		this.dataType = dataType;
	}
	
	static <x> x genericMethod1(x value){
		 return value;	
	}
	static <y> y genericMethod2(y value) {  //오버로딩이 안된다. 제네릭 타입(미지정 타입)은 하나로 판단
		 return value;
	 }
}//y에 기입한 자료형에 따라 나머지 필드나 메소드, 메소드안의 매개변수 타입이 결정되는 방식

class Generic2<a,b>{
	private a first;
	private b second;
	
	void set(a first, b second){
		this.first = first;
		this.second = second;
	}
	a getFirst() {
		return first;
	}
	b getSecond() {
		return second;
	}
	
}//기본형 리턴 값이 2개 이상일때 참조형으로 추가 시켜 리턴해야 함.

public class GenericRun{
	public static void main(String[] args) {
		Generic<String> a = new Generic<>(); //안써도 되긴 한데 경고창 뜸(타입이 1개 일때만 가능)
		Generic<Integer> b = new Generic<>();
		a.setDataType("10");
		b.setDataType(10);
		System.out.println(a.getDataType());
		System.out.println(a.getDataType().getClass().getName()); //라이브러리이름.패키지이름.클래스이름
		System.out.println(b.getDataType());
		System.out.println(b.getDataType().getClass().getName());
		Generic2<String,Integer> c = new Generic2<>(); //2개 이상 부터는 타입 지정 무조건 해야한다.(안하면 값이 안나옴)
		c.set("11",12);
		System.out.println(c.getFirst());
		System.out.println(c.getSecond());
		//generic method
		
		System.out.println(Generic.genericMethod1(3));
		System.out.println(Generic.genericMethod1("문자열"));
		System.out.println(Generic.genericMethod1(b));
		System.out.println(Generic.genericMethod2(3));
		System.out.println(Generic.genericMethod2("문자열"));
		System.out.println(Generic.genericMethod2(b));
		
		System.out.println(Generic.genericMethod1("정적"));
	}
	
	
}
