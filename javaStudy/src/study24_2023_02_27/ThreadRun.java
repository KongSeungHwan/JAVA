package study24_2023_02_27;

public class ThreadRun{
	public static void main(String[] args) {
		new DdukThread().start();
		new Thread(new DdukThread1()).start();//Thread 클래스는 Runnable인터페이스를 상속 받고있음
	 new Thread(new Runnable(){
			@Override
			public void run() {
				String[] lman = {"핫","핫","핫","핫","핫","핫","핫"};
				for (String string : lman) {
					System.out.println(string); 
					try {
						Thread.sleep(300); //0.3초 정도 딜레이
					} catch (InterruptedException e){
						e.printStackTrace();
					}
			}
		}
	}).start();
}
}
class DdukThread extends Thread{
	@Override
	public void run() {
		String[] lman = {"짝","떡","짝","떡","짝","떡","짝"};
		for (String string : lman) {
			System.out.println(string);
			try {
				Thread.sleep(300); //0.3초 정도 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class DdukThread1 implements Runnable{
	@Override
	public void run() {
		String[] lman = {"1","2","1","2","1","2","1"};
		for (String string : lman) {
			System.out.println(string); 
			try {
				Thread.sleep(300); //0.3초 정도 딜레이
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
