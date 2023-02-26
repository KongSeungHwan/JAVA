package study10_3;

public class TV {
	private int size;
	public TV(int size){
		this.size=size;
	}
	protected int getSize() {
		return size;
	} 
	//해당 메소드는 같은 패키지 내거나 다른 패키지여도 상속 관계가 있다면 그 클래스에서 접근 가능한 메소드이다.(protected)

}
