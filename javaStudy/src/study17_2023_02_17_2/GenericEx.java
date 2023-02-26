package study17_2023_02_17_2;

public class GenericEx {
	public static void main(String[] args) {
		Integer[] intArr = {1,2,3};
		String[] strArr = {"Hello","World"};
		printArray(intArr);
		printArray(strArr);
	}
	private static <T> void printArray(T[] a) {
		for(T t : a)System.out.println(t);
	}//시간 복잡도 O(n) 공간 복잡도 20byte
}
