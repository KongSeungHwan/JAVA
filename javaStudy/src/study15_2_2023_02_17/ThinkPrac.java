package study15_2_2023_02_17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class ThinkPrac {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(List.of(3,6,2,2,2,7));//결과 값이 뭐가 나올지 예측 문제!
		
		HashSet<Integer> set = new HashSet<>(list);//set형태로 저장중복 값 없앰. 3,6,2,7 이 되겠고(순서 없음 그냥 원소 있는거 나열한것임.)
		
		TreeSet<Integer> tset = new TreeSet<>(set);
		//정렬 된다. 2,3,6,7 왜냐 트리셋 형태로 저장되면 디폴트형태인 오름차순으로 정렬될 테니까(역순으로 하는 메소드 공부해놓자! 까먹었으니까 Collection.sort(자료구조,comparable 인터페이스 오는데 뭔지 알아보기))
		
		Stack<Integer> stack = new Stack<>();// 7,6,3,2 LIFO(Last In First Out) 형태니까
		stack.addAll(tset);//깊은 복사
		while(!stack.empty()) System.out.println(stack.pop());
		//7,6,3,2
		
		
		
		
		

	}

}
