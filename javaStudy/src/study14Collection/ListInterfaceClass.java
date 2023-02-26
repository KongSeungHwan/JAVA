package study14Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class ListInterfaceClass {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		LinkedList<Integer> l = new LinkedList<>(Arrays.asList(1,2,3));
		Vector<Integer> v = new Vector<>(Arrays.asList(1,2,3));
		//각각 Arrays 클래스의 static형 제네릭 메소드 asList 호출!
		long start=0, end=0;
		start=System.nanoTime();
		for(int i=0; i<=99999;i++) {
			a.remove(0);
		}
		end =System.nanoTime(); //차이를 리턴하면 초를 셀 수 있다.
		System.out.printf("ArrayList : %11d\n",end-start);//어레이리스트 자료구조
		
		
		start=System.nanoTime();
		for(int i=0; i<=99999;i++) {
			l.remove(0);
		}
		end =System.nanoTime(); //차이를 리턴하면 초를 셀 수 있다.
		
		System.out.printf("LinkedList: %11d\n",end-start);//링크드리스트 자료구조
		
		start=System.nanoTime();
		for(int i=0; i<=99999;i++) {
			v.remove(0);
		}
		end =System.nanoTime(); //차이를 리턴하면 초를 셀 수 있다.
		System.out.printf("Vector: %11d\n",end-start);//벡터 자료구조
		//링크트 리스트가 추가할때 처리속도가 더 빠르다는 것을 확인 할 수 있다
		//어레이 리스트가 임의의 원소에 접근 할때 처리속도가 더 빠름
		//링크드 리스트가 삭제 관련 메소드 처리속도가 더 빠르다
		//db는 sql문으로 주고 받고 하지, 자바 소스 안에서는 안함
		//(시간 복잡도 측면)
		//왜 오류 나는 지 복습 필요(포인터가 범위 바깥으로 가서 오류나는듯?)
		
		
		
		
		
	}

}
