package study24_2023_02_27;

class SharedClass{
	private int sum=0;
	public synchronized void add(int x) {
		//Thread.yield();
		System.out.println(Thread.currentThread().getName()+"시작");
		sum+=x;
		System.out.println(Thread.currentThread().getName()+"끝");
	}
	public void getSum() {
		System.out.println(sum);
	}
}
public class YieldThreadRun {
	public static void main(String[] args){
		SharedClass sc = new SharedClass();
		Thread t1= new Thread(){
			public void run() {
				sc.add(1);
				sc.getSum();
			};
		};
		Thread t2= new Thread(){
			public void run() {
				sc.add(1);
				sc.getSum();
			};
		};
		t1.start();
		t2.start();
		sc.getSum();
		//메인쓰레드를 제외한 두 쓰레드가 모두 yield 메소드를 호출하게 된다면 메인쓰레드가 먼저 실행되고, 그다음 쓰레드 2개가 동시에 실행되게 된다(충돌, 즉 synchronized를 꼭해줘야 충돌 안남)
	}
}
