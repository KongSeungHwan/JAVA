package study15_2_2023_02_17;

//패키지에 있는 모든 클래스를 참조할때 쓰는 연산자 *
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		int maxPoint = 0,totalPoint = 0;
		String name = "";
		//값 추가
		//blue , 96
		// hong 86
		// white 92
		
		map.put("blue",96); //4+4 즉 원소당 8byte*3 map은 24byte
		map.put("hong",86);
		map.put("white",92);
		
		//KeySet 방법
		
		Set<String> set1 = map.keySet(); //12byte
		Iterator<String> it1= set1.iterator(); //12byte
		while(it1.hasNext()) {
			 name=it1.next(); //next 함수 꼭 주의하자! 여러 번 사용안하게! 4byte 총 64byte
			totalPoint+=map.get(name);
			if(maxPoint<map.get(name)) {
				maxPoint=map.get(name);
			}
		}
		
		System.out.println("keySet 형태로 받은 결과");
		System.out.printf("평균 점수:%d \n",totalPoint/map.size());
		System.out.printf("최고 점수:%d \n",maxPoint);
		
		 maxPoint= 0;
		 totalPoint= 0;
		 
		 
		//EntrySet 방법
		Set<Entry<String,Integer>> set2 = map.entrySet(); //24
		Iterator<Entry<String,Integer>> it2 = set2.iterator(); //24 총 48+64 byte 112byte
		while(it2.hasNext()) {
			Entry<String,Integer> en = it2.next(); //next문은
			totalPoint+=en.getValue();
			if(maxPoint<en.getValue()){
				maxPoint=en.getValue();
			}//뭐 득점자 추가할라면 따로 변수 초기화해서 저장하면 됨. getKey로
		}
		System.out.println("EntrySet형태로 받은 결과");
		System.out.printf("평균 점수: %d \n",totalPoint/map.size());
		System.out.printf("최고 점수: %d \n",maxPoint);
		
		//성능 정리:시간 복잡도 O(n), 공간복잡도 O(n) 메모리공간 할당량 112byte가 된다
		
		
		//필기 내용:
		//강사님은 if문 대신에 삼항 연산자를 사용.(if문보다 그냥 짧아서 쓴다 성능은 그냥 비슷하다고만 알기)
		//Entry 호출시에 굳이 Map부터 참조할 필요 없음(import 해주면 그만)
		
		//다시 숙지해야 할 것! >> next함수 꼭 1번만 쓰는지 확인! 계속 쓰면 overflow형태로 계속 읽게 된다.
		//만약 원소가 3개면 1,2,3,1,2,3 이런 형태로 계속 읽게된다.(NullPointerException은 없음)
	}

}
