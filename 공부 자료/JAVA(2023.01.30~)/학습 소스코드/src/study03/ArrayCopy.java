package study03;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = a;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			System.out.println(b[i]);
		}
		a[1]=10;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			System.out.println(b[i]);
		}
		//object.clone()
		int[] scores = new int[] {1,2,3,4,5};
		int[] newScores = scores;
		//얕은 복사 원본과 복사본의 주소값이 같음
		int[] newScores2 = scores.clone();
		//깊은 복사 원본과 복사본의 주소값이 달라지게 함
		
		System.out.println(scores);
		System.out.println(newScores);
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(newScores));
		System.out.println(Arrays.toString(newScores2));
		scores[1]=11;
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(newScores));
		System.out.println(Arrays.toString(newScores2));
		scores[1]=11;
		System.out.println(scores);
		System.out.println(newScores);
		System.out.println(newScores2);
		
		//Arrays.copyOF() ,Arrays.copyOfRange()
		int[] cal = {1,2,3,4,5,6,7};
		int[] newCal = Arrays.copyOf(cal, cal.length);//>> (배열명, 길이); 길이만큼의 배열의 부분 복사
		int[] newCal2 = Arrays.copyOf(cal, 3);
		int[] newCal3 = Arrays.copyOf(cal, 10);
		System.out.println(Arrays.toString(cal));
		System.out.println(Arrays.toString(newCal));
		System.out.println(Arrays.toString(newCal2));
		System.out.println(Arrays.toString(newCal3));
		int[] newCal4 = Arrays.copyOfRange(cal, 0, 0);//(배열면, 시작 인덱스, 끝 인덱스) 범위로 일부분을 복사
		System.out.println(Arrays.toString(newCal4));
		
		//System.arraycopy
		int[] arc = {1,2,3,4,5,6};
		int[] newArc = new int[8];
		System.arraycopy(arc, 0, newArc, 0, 6);
		System.out.println(Arrays.toString(newArc));
		
		int[] newArc2 = new int[3];
		System.arraycopy(arc, 2, newArc2, 0, 3);
		System.out.println(Arrays.toString(newArc2));
		
		int[] inds = {1,2,3,4,5};
		int[] newInds = new int[5];
		
		for (int i = 0; i < newInds.length; i++) {
			newInds[i]= inds[i];
		}
		System.out.println(Arrays.toString(newInds));
		
		
		
		
	}

}
