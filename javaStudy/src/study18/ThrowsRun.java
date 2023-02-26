package study18;

public class ThrowsRun {
static void handleException() throws Exception {
	try {
		Exception e = new Exception();
		throw e;
	}catch(Exception e) {
		System.out.println("호출된 메소드에서 예외처리");
	}
}
	public static void main(String[] args) {
		try {
		handleException();
		}catch(Exception e) {
			System.out.println("메소드에서 발생한 예외회피를");
			System.out.println("main에서 예외처리함");
		}
	}

}
