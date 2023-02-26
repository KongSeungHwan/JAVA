package study11;

public class OuterClass {
	//inner Class
	class Inner{
		int a = 100;
		static int con = 100;
		final static int CON  = 100;
	}
	//static inner class 정적 내부 클래스
	static class StaticInner{
		int a =200;
		static int con = 200;
	}
	void method() {
		class LocalInner{
			int a = 300;
			static int con = 300;
			final static int CON = 300;
			public void displayNum() {
				System.out.println("a:"+a);
				System.out.println("con:"+con);
				System.out.println("CON:"+CON);
			}
		}
		LocalInner loc = new LocalInner(); 
		loc.displayNum();
		//메소드 안에 있는 내부 클래스의 경우 메소드내에서밖에 생성 불가
	}
	public static void main(String[] args){
			System.out.println(Inner.CON); //static 메모리에 올라간 상수(int형) 호출 100
			System.out.println(Inner.con); //static 메모리에 올라간 int형 변수 호출 100
			//System.out.println(Inner.a);
			//Inner in = new Inner();//내부클래스는 직접 객체 생성불가
			OuterClass out =  new OuterClass();
			OuterClass.Inner inn = out.new Inner();
			System.out.println(inn.a); //100이 나오겄고
			
			//참조연산자 . 를 사용하여 자료형의 포함 관계를 정확히 표기
			System.out.println(StaticInner.con);
			 OuterClass.StaticInner outin=new OuterClass.StaticInner();
			 System.out.println(outin.a);//200나오겄네
			 out.method();
			 
	}
}
