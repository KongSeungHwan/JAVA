package study24_2023_02_27;

class SyncResult{
	int result = 100;
	public synchronized void calResult() {
		System.out.println(result);
		try {Thread.sleep(2500);}catch(InterruptedException e) {};
		result/=2;
		System.out.println("결과:"+result);
	}
}
class SyncCalThread extends Thread{
	SyncResult result;
	public SyncCalThread(SyncResult s) {
		result = s;
	}
	@Override
	public void run() {
		result.calResult();
	}
}
public class SyncThreadRun {
	public static void main(String[] args){
		SyncResult re = new SyncResult();
		Thread s1 = new SyncCalThread(re);
		s1.setName("no.1 Thread");
		s1.start();
		try {Thread.sleep(1000);}catch(InterruptedException e){};
		Thread s2 = new SyncCalThread(re);
		s2.setName("no.2 Thread");
		s2.start(); //임계영역을 지정하여 첫번째 쓰레드가 연산을 완료한 이후에 두번째 쓰레드가 다시 접근하여 연산을 하는 방식 
		//synchronized는 메소드 한정 사용가능
	}
}
