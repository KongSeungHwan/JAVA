package study14Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class ListToArray {

	public static void main(String[] args) {
		//자료구조의 원소를 배열로 옮기기
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1,2,3,4));
		LinkedList<Integer> l = new LinkedList<>(Arrays.asList(5,6,7,8));
		Vector<Integer> v = new Vector<>(Arrays.asList(9,10,11,12));
		
		Object[] obj=a1.toArray();

		System.out.println(Arrays.toString(obj));
		
		Integer[] i1 =  a1.toArray(new Integer[a1.size()]);
		System.out.println(Arrays.toString(i1));
		Integer[] i2 =  v.toArray(new Integer[v.size()]);
		System.out.println(Arrays.toString(i2));
		Integer[] i3 =  l.toArray(new Integer[l.size()]);
		System.out.println(Arrays.toString(i3));
		//기존 자료구조의 원소개수에서 초과하면 null값으로 뜬다.
		a1.addAll(a2); //깊은 복사
		a1.addAll(v);
		//같은 Collection의 자식 제네릭 클래스니까 벡터던 링크드리스트던 가능, 
		//앞의 자료구조 원소 자료형 한정(담아야할 원소 자료형이 일치해야 함.)
		
	}

}
