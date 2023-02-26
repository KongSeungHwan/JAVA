package study03;


public class TwoDimensionArray {

	public static void main(String[] args) {
		int[][] array= new int[2][3];
		System.out.println(array.length);
		System.out.println(array[0].length);
		System.out.println(array[1].length);

		int k=10;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j]=k;
				k+=10;
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.println(arr2[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.printf("[%d], [%d]");
			}
			System.out.println("\n-------------------");
		}

	}

}
