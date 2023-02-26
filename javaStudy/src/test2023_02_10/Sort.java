package test2023_02_10;



public class Sort {

	public static void main(String[] args) {
		//시간 복잡도 O(N), 상수는 없는 취급함
		//for문 한번돌때 한꺼번에 정렬하는 방법 swap
		int[] arr = {9,12,14,21,16,13};
		int temp = 0;
		for(int i = 0,j=arr.length-1;i<(arr.length/2);i++,j--) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
		System.out.println("역순으로 바꾼 배열!");
		for (int i : arr) {
			System.out.printf("%d ",i);
		}
		
		temp = 0;
		//오름차순/내림차순 시간 복잡도 O(N^2)
		for(int i = 0; i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]<arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j]=temp;
				}
				
			}
		}
		System.out.println();
		System.out.println("내림차순으로 바꾼 배열!");
		for (int i : arr) {
			System.out.printf("%d ",i);
		}
	}
}
