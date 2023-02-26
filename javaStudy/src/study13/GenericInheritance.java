package study13;

class Parents<t>{
	private t a;
	public t getT() {
		return a;
	}
	public void setT(t a) {
		this.a=a;
	}
}
class FirstChild<T> extends Parents<T>{
	
	
	
	
}
class SecondChild<T,V> extends Parents<T>{
	//상속받으면 T라는 제네릭과 필드, 메소드 같이 상속 받게 된다.
	private V v;
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v=v;
	}
}
public class GenericInheritance{
	public static void main(String[] args) {
		Parents<String> parents = new Parents<>();
		parents.setT("parents generic class");
		System.out.println(parents.getT());
		FirstChild<String> fChild = new FirstChild<>();
		fChild.setT("First child 제너릭 상속 받은 제너릭 클래스");
		System.out.println(fChild.getT());
		SecondChild<String,Double> sChild = new SecondChild<>();
		sChild.setT("Second child 제너릭 상속 받은 제너릭 클래스");
		sChild.setV(3.14);
		System.out.printf("%s : %.2f \n",sChild.getT(),sChild.getV());
		
		Sup s = new Sup();
		s.testMethod(10);
		s.<Integer>testMethod(10);
		s.<Double>testMethod(34.12);
		
		
		Under un = new Under();
		un.<Double>testMethod(11.4);
	}
}
class Sup{
	 <T extends Number> void testMethod(T t) {
		System.out.println(t);
	}
}
class Under extends Sup{
	
}