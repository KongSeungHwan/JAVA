package study24_2023_02_27;

class CommonUse{
	synchronized void commonMethod1() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i+"★");
			try{Thread.sleep(1000);}catch(InterruptedException e){};
		}
	}
	synchronized void commonMethod2() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i+"◆");
			try{Thread.sleep(1000);}catch(InterruptedException e){};
		}
	} // 동일한 형태로 임계영역으로 자리 잡는다면 코드 상 위쪽에 정의된 메소드부터 호출되며 다른 메소드는 실행이 안된다. 즉 ★㈜ 먼저 나옴
	//근데 이후에 두 쓰레드는 우선순위가 동일하게 5이므로 임의의 순서로 나옴
	
	Object obj = new Object(); //각자 Object 객체는 자료형만 같고 다른 주소에 저장되는 객체이니까 키값으로 충분하다.
	void commonMethod3() {
		synchronized(obj) {
			for (int i = 0; i < 4; i++) {
				System.out.println(i+"㈜");
				try{Thread.sleep(1000);}catch(InterruptedException e){};
			}
		}
	}
	void commonMethod4() {
		synchronized(obj) {
			for (int i = 0; i < 4; i++) {
				System.out.println(i+"◎");
				try{Thread.sleep(1000);}catch(InterruptedException e){};
			}
		}
	}
}
public class KeyThreadRun{
	public static void main(String[] args) {
		CommonUse c1= new CommonUse();
		new Thread() {
			public void run() {
				c1.commonMethod1();
			};
		}.start();
		new Thread() {
			public void run() {
				c1.commonMethod2();
			};
		}.start();
		new Thread() {
			public void run() {
				c1.commonMethod3();
			};
		}.start();
		new Thread() {
			public void run() {
				c1.commonMethod3();
			};
		}.start();
		
	} //synchronized를 여럿 쓰게 된다면 우선순위 또한 꼬인다 전부 우선순위가 5이므로 순서는 뒤죽박죽
}
