package test2023_02_10;

import java.util.ArrayList;

public class DemicalPoint {
	public static void main(String[] args){
		//소수 구하는 프로그램짜기
		//시간 복잡도 O(N^2) 비효율적 프로그램..무식하긴 한데 
		int[] arr = {2,4,5,6,7,11,13,17,19,23,29,30,37,40};
		ArrayList<Integer> demi = new ArrayList<>();
		boolean token = false;

		for(int i = 0 ;i<arr.length;i++) {
			token = false; //기본으로 token을 false로 놓음
			 if(arr[i]==2) demi.add(arr[i]);
			for(int j = 2;j<arr[i];j++) {
				if(arr[i]%j==0) {
					break; //소수가 아니니까 for문 나가고
				}
				else {
					if(j==(arr[i]-1))token =true; //두 번째 for문을 끝까지 돌렸다면? token을 true로 바꾼다.
				}
			}
			if(token==true)demi.add(arr[i]);//token이 true면 arrayList에 추가!
		}
		System.out.println("찾아낸 소수 출력:");
		for (Integer integer : demi) {
			System.out.printf("%d ",integer);
		}

	}

}
