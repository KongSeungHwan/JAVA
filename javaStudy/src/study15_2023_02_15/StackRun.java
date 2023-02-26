package study15_2023_02_15;

import java.util.Iterator;
import java.util.Stack;

public class StackRun {
	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		for (char j = 90; j >= 65; j--) {
			s.add(j);	
		}//대문자 character 다 불러오기

		System.out.println(s.size());//우리가 아는 배열의 길이와는 다르다. 실제로 해보니 훨씬 더 적게 나옴
		System.out.println(s.search('a'));//0이 나옴 역순으로 하면 26


		for (int i = 0; i < s.capacity()-1; i++){
			System.out.println(s.pop());//오름차순대로 나올듯?
		}		System.out.println(s.isEmpty());//true로 나옴









	}

}
