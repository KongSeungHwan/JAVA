package study24_2023_02_27;

class SyncBlockResult{
	int i=10;
	public void minusResult() {
		synchronized(this) {
			System.out.println(i);
			try{Thread.sleep(2000);}catch(InterruptedException e){}; //딜레이 2초
			i -=1;
			System.out.println(i);
		}
	}
}

class MinusThread extends Thread{
	SyncBlockResult s;
	public MinusThread(SyncBlockResult s) {
		this.s=s;
	}
	@Override
	public void run() {
		s.minusResult();
		System.out.println(getName()+" "+s.i);
	}
}

public class SyncBlockThreadRun {

	public static void main(String[] args) {
		SyncBlockResult s= new SyncBlockResult();
		Thread t1 = new MinusThread(s);
		t1.setName("쓰레드 1");
		t1.start();
		Thread t2 = new MinusThread(s);
		t2.setName("쓰레드 2");
		t2.start();
	} //synchronized의 다른 사용방법

}
