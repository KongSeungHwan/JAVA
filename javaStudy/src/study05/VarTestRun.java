package study05;

public class VarTestRun {
	int fNumber; //초기화 x, 0이 아닌데?
	 int localVal(int a) {
		 fNumber++; //초기화 안한 값을 증가 시키고..
		return ++a;
	}
	public static void main(String[] args) {
		VarTestRun n = new VarTestRun();
		int b = 1;
		System.out.printf("1을 1증가 시킨 값 \n%d \n",n.localVal(b));
		System.out.printf("필드 값 출력 %d",n.fNumber);
	}
}
