package study14Collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListRun {

	public static void main(String[] args) {
		 LinkedList<String> l = new LinkedList<>();
		//노드(컴퓨터가 있는 엔드포인트)와 노드가 link라는 필드로 연결되어있음
		 for (char i = 65; i<73;i++) {//ASCII Code 응용 65~91 즉27개의 원소 저장
			 l.add("사람"+i);
		}
		 System.out.println(l);
		 System.out.println(l.get(2));//사람3 이 리턴될 것..
		 System.out.println(l.getFirst());//시작 원소 리턴
		 System.out.println(l.getLast());//끝 원소 리턴
		 //나머지는 list 인터페이스를 상속 받고 있기에 메소드는 같음. 단지 동작 방식의 차이가 있을뿐이다.
		 System.out.println(l.lastIndexOf("ddd"));
		 System.out.println(l);
		 for(int i =0;i< l.size()-1;i++) {
			 System.out.printf("원소%d: %s \n",i+1,l.get(i));
		 }//for문
		 
		 System.out.println();
		 for (String string : l) {
			System.out.printf("원소 값: %s \n",string);
		}//향상된 for문 활용
		 
		 System.out.println();
		Iterator<String> it = l.iterator();//이터레이터 활용
		while(it.hasNext()) {
			System.out.printf("원소 값: %s \n",it.next());
		}//while문 활용
		
		Iterator<String> it2 = l.iterator();
		System.out.println();
		do{
			if(it2.hasNext()!=true) {
				break;
			}
			System.out.printf("원소 값: %s \n",it2.next());
		}while(it2.hasNext());
		//do while문 활용
		
	}

}
