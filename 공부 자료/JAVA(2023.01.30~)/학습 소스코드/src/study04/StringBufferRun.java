package study04;

public class StringBufferRun {

	public static void main(String[] args) {
		//문자열 클래스 StringBuffer
		//buffer의 개념  컴퓨터가 데이터를 처리시 처리할 프로세스가 많아서 프로세스를 나누어 처리하려 임시로 넣는 저장공간** 정처기 내용
		//scanner와 처리속도 차이랑 자원 반환도 차이가 심함. bufferedReader가 훠얼씬 나음
		//HDD vs SSD Hard Disk Drive  Solid State Drive hdd는 인덱스가 처음부터 시작하여 데이터를 찾는데 ssd는 인덱스를 랜덤으로 찍어서
		//찾기에 ssd가 처리속도가 빠르다. ssd와 ram과 비슷한 원리로 작동(작업을 hdd로 안하는 이유)
		//단일로 생성하는 것이 나으면 그냥 String 선언하면 되고 만일 계속해서 String 객체를 덧붙여야하는 경우 StringBuffer로 사용하는 것이 낫다.
		StringBuffer sb1 = new StringBuffer("가나다");
		StringBuffer sb2 = new StringBuffer("가나다");
		StringBuffer sb3 = new StringBuffer("abc");
		
		//a.append(b)함수 a문자열에 b문자열을 뒤에 덧붙이는 메소드 (a,b와는 다른 String 객체를 만드는 메소드, 주소값이 아예 다름)
		
		
		System.out.println(sb1);
		System.out.println(sb1.toString());
		System.out.println(sb2);
		System.out.println(sb3);
		System.out.println(sb1.equals(sb3));
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(sb3));
		//주소 안에 있는 값을 비교하고 싶다면? toString()으로 형변환을 해준 다음에 equals로 비교해야한다.
		//insert
		sb1.insert(3, "라마바사");//어떤 인덱스에 무엇을 집어넣을 것인가? 할때 사용하는 메소드
		System.out.println(sb1.toString());
		//delete
		sb1.delete(0, 0); //(시작 인덱스 값~끝 인덱스 값) 인덱스 값 해당 범위의 값을 삭제하는 메소드0,0이면 0만 삭제하는 메소드
		//subString()함수 시작인덱스와 끝 인덱스를 가지고 문자열을 쪼개는 메소드
		//replace()함수 문자열을 대체하는 메소드
		//reverse()함수 문자열을 역순으로 바꾸는 메소드
		
		//StringBuffer vs StringBuilder 같은 기능을 하지만 상황에 따라 성능차이가 난다
		//전자는 단일 작업만이 존재할때 유리, 후자는 다중 작업이 많이 존재시에 유리하다.
		//쓰레드 작업을 하는 주체
		//프로세스 vs 쓰레드 프로세스는 작업의 단위이고 쓰레드는 프로세스의 흐름(주체도 맞음, 쓰레드는 프로세스의 일종)
		//cpu가 처리하는 작업의 단위를 프로세스, 작업의 흐름단위를 쓰레드라고 함
		//명절 교통체증을 예시로 들기가능
		
		
	}

}
