package study20;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ScannerPrac {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src\\study20\\files\\input.txt");
		Scanner sc = new Scanner(f);
		int sum = 0;
		while(sc.hasNext()) sum+=sc.nextInt();
		//hasNext가 더 안정적이다.(어느 자료형이 쓰여 있을지 모르니까)
		//hasNext는  공백단위로 원소를 나눔
		//nextLine은 줄단위로 원소를 나눔
		//줄단위가 아니니까! hasNext를 사용하여 while문을 돌린다.
		//그리고 받아와야 하는 값은 int값!
		//sum에 다 더해준다. 출력한다. 끝
		System.out.println(sum);
		sc.close();

	}

}
