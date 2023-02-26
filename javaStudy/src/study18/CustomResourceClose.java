package study18;

class CustomResources implements AutoCloseable{
	public CustomResources() {
		System.out.println("CustomResources 생성자");
	}
	public void printMessage() {
		System.out.println("CustomResources 메소드 실행");
	}
	@Override
	public void close() throws Exception {
		System.out.println("CustomResources  반환");
	}
}
public class CustomResourceClose {
	public static void main(String[] args) {
		try(CustomResources c = new CustomResources();){
			c.printMessage();
		}catch(Exception e) {
			System.out.println("예외 발생");
		}finally {
			System.out.println("시스템 자원 반환 후 실행");
		}
	}
}
