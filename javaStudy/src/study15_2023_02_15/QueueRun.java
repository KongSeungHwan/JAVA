package study15_2023_02_15;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueRun{

	public static void main(String[] args) {
		Queue<Character> q = new LinkedList<>();
		
		for(char i = 97;i<=122;i++) {
			q.add(i);
		}
		System.out.println(q.peek());//제일 왼쪽 원소 리턴
		//제일 먼저 들어간 원소 리턴
		for (Character c : q) {
			System.out.println(c);
		}
		System.out.println(q.element());//제일 먼저 들어간 원소 리턴
		System.out.println(q);
		System.out.println(q.remove());//제일 먼저 들어간 원소 리턴 후 제거
		System.out.println(q.poll()); //제일 먼저 들어간 원소 
		System.out.println(q);
		System.out.println(q.offer('a'));
		//약간 contains?메소드와 기능 같음 이것도 완벽한 값을 입력해야 함(일부x)
		q.clear();
		try {
			q.element();
			q.remove();
		}catch(NoSuchElementException e) {
			System.out.println("원소 없음");
		}
	}



}
