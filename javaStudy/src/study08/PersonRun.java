package study08;

import java.util.ArrayList;

class People{
	String name;
	//디폴트 생성자 그냥 씀
	public void setName(String name) {
		this.name = name;
	}
	public void showInfo() {
		System.out.printf("%s 사람 ",name);
	}
	public void eatFood() {
		System.out.printf("%s 음식을 먹습니다.",name);
	}
}
class Male extends People{
	@Override
	public void showInfo() {
		System.out.printf("%s 남자",name);
	}
}
class Female extends People	{
	@Override
	public void showInfo() {
		System.out.printf("%s 여자",name);
	}
}

public class PersonRun {
	public static void main(String[] args) {
		Male man = new Male();
		Female woman = new Female();
		man.showInfo(); //이름 안정해져서 아마 null로 뜰거임
		
		People pp = new People(); 
		
		//pp라는 변수의 자료형은 People이며 pp라는 변수 안에는 Female,Male타입의 자료형이 들어갈 수 있는 것이다.(업캐스팅)
		
		
		pp.showInfo();
		
		//instance of
		
		pp=woman;
		
		if(pp instanceof Female) {
			System.out.println("Female instance");
		}
		if(pp instanceof Male) {
			System.out.println("Female instance");
		}
		if(pp instanceof People) {
			System.out.println("Female instance");
		}
		if(pp instanceof Object) {
			System.out.println("Female instance");
		} //연산자?
		
		ArrayList<People> ppList = new ArrayList<>();
		ppList.add(new People());
		ppList.add(new Male());
		ppList.add(new Female());
		for (People people : ppList) {
			people.showInfo();
		}
		whoAreYou(man);
		whoAreYou(woman);
		whoAreYou(pp);
		//down casting
		//People p2 = new Male();
		//Male m2 = (Male)p2;
		
	}

	
	
	public static void whoAreYou(People p) {
		p.setName("a");
		p.showInfo();
	} //이 메소드 안에는 People이나 People로 업캐스팅한 Male Female 자료형이 들어와도 된다.
}
