package study03;

public class Recursive {

	public static void main(String[] args) {
		//피보나치 수열 ex)  a(n-2) + a(n-1) = a(n) 인 수열
		//팩토리얼 ex)  x! x는 자연수  1*...x-2*x-1*x=y 여기서 y 값
		System.out.println(fibonacci(7));
		System.out.println(factorial(5));
	}
	public static long fibonacci(long n) {
		if(n<=2) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static long factorial(long n) {
		if(n == 1) return 1;
		return n*factorial(n-1);
	}
	//long 선언시 만일 리터럴이 
	//int 범위를 초과하게 되는 경우 리터럴 뒤에 L을 붙인다.
}
