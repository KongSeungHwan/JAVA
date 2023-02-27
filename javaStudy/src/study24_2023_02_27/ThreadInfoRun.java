package study24_2023_02_27;

class DelayThread extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(" "+getName()+"우선순위"+getPriority()); //디폴트 값 Thread-0,우선순위 5
	}
}

public class ThreadInfoRun {
	public static void main(String[] args) {
		/*Thread cut =Thread.currentThread();
		System.out.println(cut.getName());
		System.out.println(Thread.activeCount());
		System.out.println(cut.getState());
		
		for (int i = 0; i < 5; i++) {
			Thread th = new Thread();
			System.out.println(th.getName());
			System.out.println(Thread.activeCount());
			th.start();
			System.out.println(Thread.activeCount());
		}
		Thread thread = new Thread();
		thread.setName("직접 만든 이름 쓰레드");
		thread.*/
		
		for (int i = 0; i < 5; i++) {
			Thread dth = new DelayThread();
			dth.start();
		}
		for (int i = 0; i < 5; i++) {
			Thread dth= new DelayThread();
			dth.setName("직접지정10"+i+"thread");
			dth.setPriority(10);
			dth.start();
		}
		for (int i = 0; i < 5; i++) {
			Thread dth= new DelayThread();
			dth.setName("직접지정1"+i+"thread");
			dth.setPriority(1);
			dth.start();
		}
	}
}
