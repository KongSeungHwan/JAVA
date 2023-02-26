package study05;

class Uper{
	void uper(int c) {
		c++;
	}
	void uper(Counter c) {
		c.count++;
	} //매개변수로 받은 객체의 필드 count를 증가 시킴
}
class Counter{
	int count=0;
}

public class CallByValRun {
	public static void main(String[] args){
		Counter mc= new Counter();
		System.out.println(mc.count);
		Uper up = new Uper();
		up.uper(mc.count); //리터럴 상수 1값만 리턴되고 아무 것도 없음.
		up.uper(mc); //객체를 매개변수로 받고 필드값을 1증가 시킴.
		System.out.println(mc.count);
	}

}
