package study17_2023_02_17_3;

class Bicycle{

	String define() {
		return "패달을 가진 교통수단";
	}
}
class Motorcycle extends Bicycle{
	String define() {
		return "엔진을 가진 자전거";
	}
	Motorcycle(){
		System.out.println("나는 모터 사이클입니다. 나는"+define());
		String temp= super.define(); //부모 클래스는 super 예약어 사용해야한다!
		System.out.println("내 부모는"+temp+"인 자전거입니다.");
	}//생성자는 객체 생성시에 중괄호 안에 있는 실행문이 자동 실행됨.
}

public class InheritanceEx {

	public static void main(String[] args) {
		Motorcycle m = new Motorcycle();
	}

}
