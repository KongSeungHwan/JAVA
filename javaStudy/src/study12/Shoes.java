package study12;

class Type1{
	static final String WALKING="워킹"; //constant pool에도 할당,static에도 할당? 이짓을 왜하지?
	static final String TRACKING="워킹";
	static final String HIKING="워킹";
	static final String RUNNING="워킹";
	
}

enum Type{
	WALKING("워킹") , TRACKING("트래킹"), HIKING("하이킹"), RUNNING("러닝"); //상수들이네
	
	final String name;
	
	private Type(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
//인터페이스에도 상수 집어넣을 수 있는디.. 이게 왜 필요한거여

public class Shoes {
	public String name;
	public int size;
	public Type type;

	//	public enum Type{ WALKING , TRACKING, HIKING, RUNNING }

	public static void main(String[] args) {
		Shoes shoes = new Shoes();
		shoes.name = "아디다스";
		shoes.size = 280;
		shoes.type=Type.WALKING;
		System.out.println(shoes.name);
		System.out.println(shoes.size);
		System.out.println(shoes.type);
		for (Type type: Type.values()) {
			System.out.println(type);
		}
		//ordinal
		System.out.println(shoes.type.ordinal());
		Type tp = Type.RUNNING;
		System.out.println(tp.ordinal()); //열거체의 인덱스 값 리턴 (0,1,2,3)
		
		//valueOf
		Type tpa = Type.TRACKING; //<<다형성?
		Type tpb = Type.valueOf("WALKING");
		System.out.println(tpa);
		System.out.println(tpb);
		System.out.println();
		for (Type t : Type.values()) {
			System.out.println(t);
		}
		String str=Type1.HIKING;
		System.out.println(str);
	}
}
