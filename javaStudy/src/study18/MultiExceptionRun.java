package study18;

public class MultiExceptionRun {
	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.exceptionProc(1, 2);
		cal.exceptionProc(2, 0);
		cal.exceptionProc(4, 2);
	}
}
class CalTest{
	private int[] arr = new int[3];
	
	CalTest() {
		arr[0]=0;
		arr[1]=100;
		arr[2]= 10;
	}
	public void exceptionProc(int f,int s) {
		try {
			System.out.println(arr[f]/arr[s]);
		}catch(ArithmeticException e) {
			System.out.println("산술 연산 예외 발생");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 초과 예외 발생");
		}catch(Exception e) { //이전에 catch문으로 작성한 예외 이외의 예외 클래스 처리 시 실행 NumberFormatException 등
			System.out.println("모든 예외 발생 시 실행");
		}finally {
			System.out.println("모든 예외 처리 완료");
		}
	}
}