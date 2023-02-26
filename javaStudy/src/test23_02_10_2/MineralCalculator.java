package test23_02_10_2;
class Gold implements Mineral{
	@Override
	public int getValue(){
		return 100;
	}
}
class Silver implements Mineral{
	@Override
	public int getValue(){
		return 90;
	}

}
class Bronze implements Mineral{
	@Override
	public int getValue(){
		return 80;
	} 
	//리턴 값만 달리 놓음(필드) 추상메서드로 갖고오게 함 난
}
interface Mineral{
	public int getValue(); //추상메소드 만들고 값만 내보내면 끝인디..
}
public class MineralCalculator {
	int value = 0;
	
	
	public void add(Mineral mi) { //다형성 활용 문제
		this.value+=mi.getValue();
	}//add 파라미터를 Mineral로 바꿈
	
	
	public int getValue() {
		return value;
	}
	public static void main(String[] args) {
		MineralCalculator cal = new MineralCalculator();
		cal.add(new Gold());//+100
		cal.add(new Silver());//+90
		cal.add(new Bronze());//+80
		System.out.println(cal.getValue());
	}

}
