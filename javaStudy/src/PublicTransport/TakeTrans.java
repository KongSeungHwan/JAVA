package PublicTransport;

public class TakeTrans {

	public static void main(String[] args) {
		Passenger lee = new Passenger("이순신",10000,25);
		Passenger hong = new Passenger("홍길동",12000,15);
		
		Bus bus122 = new Bus(122);
		Subway subway2 = new Subway(2);
		Transport bus233 = new Bus(233);
		
		lee.takeBus(bus122);
		hong.takeSubway(subway2);
		lee.takeTrans(bus233, 1200);
		hong.takeTrans(subway2, 1500);
		lee.showInfo();
		hong.showInfo();
		bus122.showInfo();
		subway2.showInfo();
		bus233.showInfo();
		

	}

}
