package study25_2023_02_28;

class CoThread extends Thread{
	@Override
	public void run() {
		System.out.println(getName());
		if(isDaemon()) {
			for(int i=0;i<10;i++) {System.out.println("      ■");
			try {Thread.sleep(1000);}catch(InterruptedException e){}
			}
		}else {
			for(int i=0;i<10;i++) {System.out.println("▽");
			try {Thread.sleep(1000);}catch(InterruptedException e){}
			}
		}
			//해당쓰레드가 만일 wait 상태에서 running 상태로 오기 전에 
			//다른 쓰레드에서 wait상태의 해당쓰레드를 임의로 interrupt나 wake-up을 시도하면 발생하는 예외
	}	

}
public class DaemonThreadRun {

	public static void main(String[] args){
		Thread normal = new CoThread();
		normal.setName("normal Thread");
		normal.setDaemon(false);
		normal.start();
		
		Thread daemon = new CoThread();
		daemon.setName("daemon Thread");
		daemon.setDaemon(true);
		daemon.start();
		
		try {Thread.sleep(4000);}catch(InterruptedException e){}
		System.out.println("main thread terminated"); //메인쓰레드 끝나면 데몬쓰레드도 같이 강제로 끝나버린다. 하지만 다른 임의로 만든 쓰레드들은 살아있다.
		//해당 모양들이 메인쓰레드가 dead 상태로 가기전엔 2번씩 이행되다가 메인쓰레드가 dead 상태로 가는 순간 1번씩 이행된다.(normal이라는 사용자 설정 수준 쓰레드)
	}

}
