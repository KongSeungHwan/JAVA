package study11_1;

public class ClassMain2 {
	public static void main(String[] args) {
		Calculator c1 = new MyMath();
		double res = c1.oper(3.0, 7.0);	
		System.out.println(res);
		//익명클래스 x*y <----- Calculator
		Calculator c2 = new Calculator(){
			public double oper(double a, double b){

				return a*b;
			}//여기에 public이 붙어야하는 이유는 Calculator가 인터페이스 이기 때문이다(인터페이스는 무조건 public을 붙여줘야한다는 규칙을 가지고 있다.)
		};
		System.out.println(c2.oper(3.0,7.0));
		Calculator c3 = new Calculator(){
			public double oper(double a, double b){

				return Math.pow(a, b);
			}//같은 이유
		};
		System.out.println(c3.oper(3.0,7.0));
		//익명 클래스로 바로 생성후 oper 오버라이딩 해서 바로 사용
	}
}
interface Calculator{
	public double oper(double x,double y);

}
class MyMath implements Calculator{
	public double oper(double x,double y){
		return x+y;
	}
}
//mymath에 인터페이스에서 상속 받아 오버라이딩을 하여 oper를 + 연산하는 메소드로 바꿈