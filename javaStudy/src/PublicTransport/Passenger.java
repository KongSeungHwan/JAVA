package PublicTransport;

public class Passenger {
	private String pName;
	private int money;
	private int age;
	
	
	public Passenger(String pName,int money, int age) {
		this.pName = pName;
		this.money=money;
		this.age = age;
	}
	public void takeBus(Bus bus) {
		bus.take(1400);
		ageCheck();
		money-=1400;
	}
	public void takeSubway(Subway subway) {
		subway.take(1400);
		ageCheck();
		money-=1400;
	}
	//잔고 부족일 경우 에러처리 안함 일단
	public void takeTrans(Transport trans,int money) {
		trans.take(money);
	}//이걸 실행 하면 ~~원 입니다 뜸
	public void showInfo() {
		System.out.println("==================");
		System.out.printf("%s \n",pName);
		System.out.printf("소지금: %d \n",money);
		System.out.println("==================");
	}//탔을 경우 
	
	public void ageCheck() {
		if((age>0)&&(age<=5)) {
			System.out.println("유아입니다");
		}else if((age>5)&&(age<=13)) {
			System.out.println("어린이입니다.");
		}else if((age>13)&&(age<=19)) {
			System.out.println("청소년입니다.");
		}else if(age>19) {
			System.out.println("성인 입니다.");
		}else {
			System.out.println("잘못된 나이입니다(음수)"); //나이가 음수일 수는 없으니 예외 처리
		}
	}
	
	
	
	
	public int getmoney() {
		return money;
	}
	public void setmoney(int money) {
		this.money = money;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
