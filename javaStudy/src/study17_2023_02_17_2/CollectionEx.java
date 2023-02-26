package study17_2023_02_17_2;

import java.util.HashSet;
import java.util.Set;
interface Arr{
	void addArr(Set<Integer> a,int b);
}

public class CollectionEx {

	public static void main(String[] args) {

		int[] arr = {10,20,30,40,50,60,70,40,30,20};//40byte
		Set<Integer> s = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		
		Arr ar = (x,y) -> {
			if(x.add(y))System.out.println("성공");
			else System.out.println("중복");
		};//추상메소드 메인메소드에서 구현
		
		System.out.println();
		System.out.println("일반 메소드를 이용한 데이터 중복 처리");
		for (Integer i : arr){
			if(s.add(i))System.out.println("성공");
			else System.out.println("중복");
			
			//add가 리턴 값이 boolean이라 if문으로 하거나 삼항연산자로 나눠서 해도 된다.
			//이거 대신 삼항 연산자로 하기
			//System.out.println(s.add(arr[i]) ? "성공": "중복"); 꼭 줄이는 노력을 하자!
		}
		//시간 복잡도 O(n),공간 복잡도 O(n)
		System.out.println(s);
		
		
		System.out.println();
		System.out.println("람다식을 이용한 데이터 중복 처리");
		for (int i = 0; i < arr.length; i++) {
			ar.addArr(s2,arr[i]);		
			}
		System.out.println(s2); 
		//람다식 이용하기 얘도 시간,공간 복잡도 동일

	}
}