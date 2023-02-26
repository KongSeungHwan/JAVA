package study18;

class FoolException extends Exception{
}//임의의 예외 발생 시키기!(Exception을 상속 받으면 임의의 예외처리 가능)

class Sample{
	public void sayNickname(String n) throws FoolException{
		//try {
		if(n.equals("바보")) {
			throw new FoolException();
		}
		System.out.printf("당신의 별명은 %s이다.\n",n);
		//		}catch(FoolException e) {
		//			System.err.println("임의의 예외 발생!");
		//		}
	}
}
public class CustomExceptionRun {
	public static void main(String[] args) {
		Sample s = new Sample();
		try {
			s.sayNickname("바보");
			s.sayNickname("머저리");
		} catch (FoolException e) {
			System.err.println("임의의 예외 발생"); 
			//예외 한번 발생 시 한번 발생한 예외 처리 후 try문을 나온다.finally문은 예외 발생해도 실행함.
		}
	}
}

