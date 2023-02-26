package study10_3;

import java.util.Scanner;

public class StackRun {
	//LIFO 방식의 선형 자료구조이다.(Last In First Out)(후입선출)
	//PUSH POP 메소드로 데이터를 넣고 뺄 수 있다.(PUSH가 데이터를 저장, POP이 데이터를 리턴하면서 제거)
	// 스택, 큐, 덱(스택+큐)
	public static void main(String[] args) {
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int max = inputInt.nextInt();
		StringStack s1 = new StringStack(max);
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str = inputString.nextLine();
			if(str.equals("그만"))
				break;
			boolean choice = s1.push(str);
			if(!choice) 
				System.out.println("스택이 가득 참");
			
		}
		System.out.print("스택이 저장된 모든 문자열 팝 : ");
		int len = s1.length();
		for(int i = 0; i < len; i++)
			System.out.print(s1.pop() + " ");
		inputInt.close();
		inputString.close();
		
	}//스택 구현
	
	
}
