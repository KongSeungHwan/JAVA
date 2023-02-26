package Generic;



public class GenericTest {
	
	public static void main(String[] args) {
		GenericMethod<String> fr = new GenericMethod<>();
		fr.set("안녕");
		System.out.println(fr.get());
		
		
		
	}

}
