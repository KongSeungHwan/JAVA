package study13;

interface TestInterface{
	void test(); //public abstract 는 자동으로 붙음 어차피
}
class SubClass implements TestInterface{
	@Override
	public void test() {
		System.out.println("SubClass test() run");
	}
}
class NormalClass{
	public static <T extends TestInterface> void genericMethod(T t) {
		t.test();
	}
}

public class LimitedTypeGenericClass2 {
	public static void main(String[] args) {
		SubClass s = new SubClass(); 
		NormalClass.genericMethod(s);
		//SubClass는 TestInterface를 상속 받고 있으니 해당o,
		//NormalClass는 못 들감. 왜냐 TestInterface를 상속 받고 있지 않기 때문
		//중점은 올바른 인터페이스를 상속 받고있냐 안 받고 있냐 차이.
		
			
		NormalClass.genericMethod(new TestInterface() {

			@Override
			public void test() {
				System.out.println("anonymous class test() run..");
				
			}
			
		});
	}
	
}
