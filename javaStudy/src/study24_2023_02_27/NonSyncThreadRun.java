package study24_2023_02_27;

class Result{
	int result=100;
	public void calResult() {
		System.out.println(result);
		//try{Thread.sleep(2500);}catch(InterruptedException e){};
		result/=2; //실행마다 50 25 12 6 3 1 0 0 ...리턴 된다.
		System.out.println(result);
	}
}
class CalThread extends Thread{
	Result result;
	public CalThread(Result r) {
		result=r;
	}
	@Override
	public void run() {
		result.calResult();
		System.out.println(getName()+" "+result.result); //100
	}
}

public class NonSyncThreadRun {
	public static void main(String[] args) {
		Result re = new Result();
		Thread cal1 = new CalThread(re);//Result 객체
		cal1.setName("no.1 thread");
		cal1.start();
		System.out.println("메인쓰레드");
		//try{Thread.sleep(1000);}catch(InterruptedException e){};
		Thread cal2 = new CalThread(re); //같이 줄어들음 result 필드
		cal2.setName("no.2 thread");
		cal2.start(); 
		 System.out.println(cal1.isDaemon());
		//어차피 자바 소스는 이렇게 순차적으로 작성하면 순서는 start 호출한 순서대로 실행될 텐데 굳이 lock을 해줄 필요가 있나?
		System.out.println("메인쓰레드");
		
	}//충돌일러나서 result가 처음에 둘 다 100으로 뜬다.

}
