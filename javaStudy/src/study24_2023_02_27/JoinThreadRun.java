package study24_2023_02_27;

import java.time.LocalTime;

class JoinThread extends Thread{
	@Override
	public void run() {
		System.out.println(LocalTime.now()+"Thread start");
		try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println("예외");};
		System.out.println(LocalTime.now()+"Thread End"); //쓰레드가 dead 상태로 바뀜
	}
	
}

public class JoinThreadRun {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new JoinThread();
		System.out.println(LocalTime.now()+"쓰레드 시작");
		t1.start();
		System.out.println(LocalTime.now()+"쓰레드 종료");
		t1.join(3000);//다른 쓰레드가 종료될 때까지 기다렸다가 
		System.out.println(LocalTime.now()+"쓰레드 종료 여부"+t1.isAlive());//쓰레드가 살아있는지를 boolean으로 리턴하는 함수
	}

}
