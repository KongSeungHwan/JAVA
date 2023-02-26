package study_2023_02_16_2;

import java.util.ArrayList;
import java.util.Arrays;

public class SetCalPrac {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6));
		ArrayList<Integer> i = new ArrayList(); //교집합
		ArrayList<Integer> u = new ArrayList(); //합집합(list1+list2)
		ArrayList<Integer> s1 = new ArrayList(); 	//차집합(list1-list2)
		ArrayList<Integer> s2 = new ArrayList();	//,(list2-list1)
									//차집합은 2가지 가능성이 존재 s1, s2
		for(int j = 0; j<4; j++) {
			for(int k=0;k<4;k++) {
				if(list1.get(j).equals(list2.get(k)))i.add(list1.get(j)); //교집합** 합집합, 차집합시 반드시 필요
			}
		}//교집합! 시간복잡도 O(n^2) contains 활용하면 시간 복잡도 O(n)으로 된다..(코딩 짬찌라)

		u.addAll(list1);
		u.addAll(list2);//깊은 복사
		for (Integer num : i){
			u.remove(num);
		}//합집합 u 연산 시간복잡도 O(n)

		s1.addAll(u);
		s2.addAll(u);//깊은 복사
		for(Integer num: list2) {
			s1.remove(num);
		}
		for(Integer num: list1) {
			s2.remove(num);
		}
		//차집합 둘 다 시간복잡도 O(n)
		System.out.println("교집합!");
		System.out.println(i); //교집합
		System.out.println("합집합!");
		System.out.println(u); //합집합
		System.out.println("차집합!(list1-list2)");
		System.out.println(s1); //list1-list2
		System.out.println("차집합!(list2-list1)");
		System.out.println(s2); //list2-list1
		//일단 기억에 의존해서 만듬(안 찾아봄)
		
		//공간 복잡도를 최소한으로 하기 위해 기존에 있는 변수로만 활용!(대신 이번에는 시간 복잡도 고려를 못했다..)

	}

}
