package test2023_02_10;

import java.util.ArrayList;

public class OddEven {
	public static void main(String[] args) {
		
		int[] arr = {9,12,14,21,16,13};
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		
		//if로 2,3,5...이렇게 나누고 나누어 떨어지는지 확인해야 함
		//if문으로 홀수 짝수로 구분
		
		for (int i : arr) {
			if(i%2==1) {
				odd.add(i);
			}else {
				even.add(i);
			}
		}
		
		
		
		
		
		System.out.println("홀수:");
		for (Integer i : odd) {
			System.out.printf("%d ",i);
		}
		
		
		System.out.println();
		
		System.out.println("짝수:");
		for (Integer i : even) {
			System.out.printf("%d ",i);
		}

}
}
