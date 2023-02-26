package study13;

class Top{}
class Sub extends Top{}
class Cen extends Sub{}
class Bot extends Cen{}

class Team<t>{
	private t a;
	public t getT() {
		return a;
	}
	public void setT(t a) {
		this.a=a;
	}
}
class Member{
	void show1(Team<Top> t) {}; //Team객체 top만 오기 가능
	void show2(Team<?> t) {}; //team<아무타입 다> 오기 가능
	void show3(Team<? extends Sub> t) {}; //<>안에는 Sub 자체와 그 하위 클래스가 올 수 있음(Sub,Cen,Bot오기 가능)
	void show4(Team<? super Sub> t) {}; // <>안에는 Sub 자체와 상위 클래스 모두 올 수 있음(Top만 가능)
	
}

public class WildCardGeneric {
	public static void main(String[] args) {
		Member mem = new Member();
		mem.show1(new Team<Top>());
		//mem.show1(new Team<Sub>());
		//mem.show1(new Team<Cen>());
		//mem.show1(new Team<Bot>());
		
		mem.show2(new Team<Top>());
		mem.show2(new Team<Sub>());
		mem.show2(new Team<Cen>());
		mem.show2(new Team<Bot>());
		
		//mem.show3(new Team<Top>());
		mem.show3(new Team<Sub>());
		mem.show3(new Team<Cen>());
		mem.show3(new Team<Bot>());
		
		mem.show4(new Team<Top>());
		mem.show4(new Team<Sub>());
		//mem.show4(new Team<Cen>());
		//mem.show4(new Team<Bot>());
		
	}

}
