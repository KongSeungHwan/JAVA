package study18;

public class ArithmaticRun{
	public static void main(String[] args) /*throws ArithmeticException, ArrayIndexOutOfBoundsException*/ {
		
		try {
			System.out.println(5/0);// 산술연산 예외 발생
			byte[] list = {'a','b','c'};
			System.out.println(list[5]);
		}catch(ArithmeticException e) {//산술 연산 예외 발생 시 실행하는 실행문
			System.out.println("산술 연산 예외 발생!");
			e.printStackTrace(); //<<파라미터로 온 예외 클래스를 추적할 시 사용하는 메소드(예외가 어디서 발생했는지 추적 가능)
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}catch(ArrayIndexOutOfBoundsException e) {//인덱스 범위 초과 시 실행되는 실행문
			System.out.println("인덱스 범위 초과!");
			//Exception 클래스에 위의 두 예외 클래스가 상속되어 있으니 다형성으로 활용 가능
		}finally { //예외가 발생해도 실행하는 실행문
			System.out.printf("모두 실행! %d",1+2);
		}
	}
}
