package study22;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongToDoubleFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ComsumerRun {

	public static void main(String[] args) {
	Consumer<String> c = new Consumer<>() {//입력o 출력x
			@Override
			public void accept(String t) { //아 파라미터 허용?
				System.out.println(t);
			}
		};
		c.accept("111");
		Consumer<String> a = System.out::println; 
		//구현할 함수 파라미터와 안쪽에 있는 메소드 파라미터와 한개로 일치 시 사용 가능
		//파라미터가 단 한 개일 경우만 사용가능(2개이상 불가)
		//스트림 연산 시에 유용. 일부러 파라미터 적을 필요 없어짐.
		
	Supplier<String> s = new Supplier<>() { //입력 X 출력 O
		@Override
		public String get() {
			return "111";
		}
		
	};
	System.out.println(s.get());
	Function<String,Integer> f = new Function<>() { //입력o 출력o 
		@Override
		public Integer apply(String t) {
			return new Integer(t);
		}
	};
	System.out.println(f.apply("111"));
	
	LongToDoubleFunction ltd = num ->num;
	System.out.println(ltd.applyAsDouble(12L));
	//우리가 치는 숫자들은 디폴트가 int 자료형이기 때문에 뒤에 L을 붙여야함
	//int < long < double < float 작은 범위에서 큰 범위로 형변환시 자동으로 형변환이 이루어진다.
	//반대 방향으로 갈 시 강제 캐스팅을 해줘야 가능하다.
	//(버림 처리 단 int >>long 갈시 overflow 가 일어난다.)
	
	ToIntFunction<String> tis = st -> new Integer(st);
	tis = Integer::new;
	System.out.println(tis.applyAsInt("111"));
	
	//장점: 본래 람다식은 interface를 정의해서 반환값 타입 지정,파라미터 타입 개수 지정
	//후 가능했지만 이 코드들은 라이브러리에 구현되어있는 코드들을 가지고 와서 사용하기에 가독성은 좋을듯 싶다.
	//import 후 그냥 함수를 참조변수에 초기화 하면 사용가능하니까
	}
}

