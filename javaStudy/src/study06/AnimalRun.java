package study06;


class Animal{
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	void sleep() {
		System.out.println(" 1 %s zzz ");
	}
}
class Dog extends Animal{
	void sleep(){
		System.out.printf(" 2 %s zzz \n",this.getName()); 
		//super.getName(); == this.getName(); Animal에서 getName을 상속을 받았으니 사용가능
	}
}
class Cat extends Animal{
	void sleep(){
		System.out.printf(" 2 %s zzzzzzzzz \n",this.getName()); 
		//super.getName(); == this.getName(); Animal에서 getName을 상속을 받았으니 사용가능
	}
}
class Human extends Animal{
	void sleep() {
		System.out.printf(" 2 %s 쿨쿨 \n",this.getName());
	}
}
class PetDog extends Dog{

	@Override
	void sleep() {
		// TODO Auto-generated method stub
		super.sleep();
	} 
	//상속 관계가 Animal 상속>> Dog 상속>> PetDog 인데  sleep메소드는 멍멍이 zzz 로 나옴(그래서 오버라이딩은 상속 관계를 잘 봐야함.)
	void sleep(int hours) {
		System.out.printf(" %s는 %d 시간 동안 잘 잡니다. \n",this.getName(),hours);
	}
	
	//오버라이딩, 오버로딩 둘 다 PetDog에서 이루어짐 sleep
	
}
public class AnimalRun{
	public static void main(String[] args) {
		Animal dog = new Dog(); //선언만 부모클래스로 하고 생성은 자식클래스로 해도 된다.
		dog.setName("멍멍이");
		dog.sleep();
		//오버라이딩이 dog에서 이루어진 메소드의 결과 값이 나옴 콘솔창: 멍멍이 zzz
		Animal cat = new Cat();
		cat.setName("야옹이");
		cat.sleep(); 
		//오버라이딩이 cat에서 이루어진 메소드의 결과 값이 나옴  콘솔창: 야옹이 zzzzzzzz   로 나옴
		Animal h = new Human();
		PetDog pDog = new PetDog();
		pDog.setName("멍멍이2");
		h.setName("사람"); //h의 필드인 name이 사람으로 바뀜
		h.sleep(); //  콘솔창: 사람 쿨쿨         로 나옴
		pDog.sleep(); //콘솔창: 멍멍이2 zzz               로 나올것이다.
		pDog.sleep(12); 
		//Animal으로 선언한 경우에는 
		//Animal로 선언 후 다른 자식 클래스로 생성 가능한데
		//메소드의 사용 가능범위가 Animal이 정의한 메소드 범위 내밖에 사용이 안된다.
		//(즉,그냥 Animal의 필드, 메소드까지만 접근가능 (+오버라이딩한 메소드만 접근 가능))
		//나머지는 syntax error남.
		
		
	}
}
