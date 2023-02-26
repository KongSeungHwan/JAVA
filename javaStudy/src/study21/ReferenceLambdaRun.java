package study21;

class NormalClass {
	void normalMethod() {
		System.out.println("일반메소드");
	}
	static void staticMethod() {
		System.out.println("정적메소드");
	}
}
interface IFforObj{
	void objm(NCObj t,String k);
}
class NCObj{
	void printString(String s) {
		System.out.println(s+"객체메소드");
	}
}
public class ReferenceLambdaRun{
	public static void main(String[] args) {
		FI1 a = () -> {
			NormalClass nc= new NormalClass();
			nc.normalMethod(); //객체를 통해 일반메소드 호출
			NormalClass.staticMethod(); //static으로 선언된 메소드 호출
		};
		FI3 c = (x)->System.out.println(x);
		a.abMethod(); //1번 람다식
		c.abMethod(1);
		FI2 b = () -> 1;
		FI4 d = (x,y)-> x/y;
		System.out.println(b.abMethod());
		System.out.println(d.abMethod(10, 3));
		//각 인터페이스를 람다식으로 생성
		FI1 a2 = () ->{
			NormalClass nc= new NormalClass();
			nc.normalMethod();
		};
		a2.abMethod();
		FI1 a3 = () -> NormalClass.staticMethod();
		a3.abMethod();
		
		FI3 c1 = x-> System.out.println(x);//파라미터로 받은 숫자 출력하도록 구현
		c1.abMethod(33);//33을 출력
		
		IFforObj idb = new IFforObj() {
			@Override
			public void objm(NCObj t, String k) {
				t.printString(k);
			}
		};
		idb.objm(new NCObj(),"1");
		IFforObj a11 = (x,y) -> x.printString(y);
		a11.objm(new NCObj(),"1");
		IFforObj a12 = NCObj::printString;
		a12.objm(new NCObj(),"1");
	}
}
