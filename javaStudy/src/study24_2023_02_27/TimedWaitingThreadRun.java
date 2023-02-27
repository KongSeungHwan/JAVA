package study24_2023_02_27;

class TimedThread extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(3000);//3초
		}catch(InterruptedException e) {
			System.out.println("예외 발생");
			for (int i = 0; i < 9999999999999L; i++) {};
		}
	}
}

public class TimedWaitingThreadRun {
	public static void main(String[] args) {
		Thread t = new TimedThread();
		t.start();
		try {
			Thread.sleep(300);
		}catch(InterruptedException e) {
			System.out.println(t.getState());
		}
		t.interrupt();//메인 쓰레드는 0.3초 대기중이나 다른 쓰레드가 해당 시간 inturrupt를 시도하였을 때  interruptedException 발생함.
		try {
			Thread.sleep(1);
		}catch(InterruptedException e) {
			System.out.println(t.getState());
		}
	}
}
