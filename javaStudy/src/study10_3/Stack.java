package study10_3;

public interface Stack{ //스택 인터페이스
	 int length();
	 int capacity();
	 String pop();
	 boolean push(String value);
	 	//LIFO 방식의 선형 자료구조이다.(Last In First Out)(후입선출)
		//PUSH POP 메소드로 데이터를 넣고 뺄 수 있다.(PUSH가 데이터를 저장, POP이 데이터를 리턴하면서 제거)
		// 스택, 큐, 덱(스택+큐)
	 
	 //큐는 FIFO방식이다 즉 선입선출
	 
	 //한줄로 쫘락 이루어져있다
	 
	 //이 둘을 합친게 덱이다.(DEQUE)
	 
}
