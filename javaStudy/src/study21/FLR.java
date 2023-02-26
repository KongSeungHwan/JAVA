package study21;

public class FLR {

	public static void main(String[] args) {
		FI1 a = () ->System.out.println("i x o x 메소드");
		a.abMethod();
		FI2 b = () -> {
		System.out.println("i x o o 메소드");
			return 100;
		};
		System.out.println(b.abMethod());
		FI3 c = x -> {
			System.out.println("i o o x 메소드");
			System.out.println(x);
		};
		c.abMethod(100);
		FI4 d = (x,y) -> {
			System.out.println("i o o o 메소드");
			return	x*y;
		};
		System.out.println(d.abMethod(9, 3.5));
	}

}
