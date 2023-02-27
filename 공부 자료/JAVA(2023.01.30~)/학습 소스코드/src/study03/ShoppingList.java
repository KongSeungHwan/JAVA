package study03;

public class ShoppingList {

	public static void main(String[] args) {
		String item1= "한우 꽃등심";
		int price1 = 112500;
		String item2 = "참치 선물팩";
		int price2 = 25500;
		String item3= "맥스봉 한팩";
		int price3 = 10000;
		
		System.out.printf("품명:%s, 가격:%d \n",item1,price1);
		System.out.printf("품명:%s, 가격:%d \n",item2,price2);
		System.out.printf("품명:%s, 가격:%d \n",item3,price3);
		//서식문자 %s <<s앞에 숫자가 붙는경우 줄맞춤 기능을 쓰겠다는 것이다.
		//System.out.printf(format,arguments)
		//서식 문자를 사용하여 출력하겠다는 말임
		// format(어떤 것을 출력할지?(서식문자 포함)),argument(해당 서식문자 타입에 맞는 변수 또는 리터럴)
		//argument는 ','를 사용하여 복수로 사용 가능하다. 
		//%(xy)(서식자) << x는 정수 또는 실수 y 는 서식문자
		

	}

}
