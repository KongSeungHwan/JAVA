package study05;

public class MethodRun {
	String sayHi() {
		return "Hi!";
	}
	void sum(int a,int b) {
		System.out.println(a+b);
	}
	void sum(int a,int b,int c) {
		System.out.println(a+b+c);
	}//오버로딩
	void sayNickname(String nick) {
		if("nerdy".equals(nick)){
			return;//메소드 종료
		}else {
			System.out.printf("My nickname is %s \n",nick);
		}
	}
	public static void main(String[] args){
		//jsp는 Built-in-Object 즉 내부객체가 있어 메소드 홀로 사용가능
		MethodRun n = new MethodRun();
		//디폴트 생성자로 생성!
		System.out.printf("Say %s \n",n.sayHi());
		//바로 생성뒤에 그 객체에서 메소드를 호출
		//출력문에서 Say+공백까지 출력후 n객체의 sayHi메소드를 호출
		n.sum(1,2); //1,2의 합 3이 출력됨.
		n.sum(1,2,3);//1,2,3의 합 6이 출력!(메소드 오버로딩 활용)
		n.sayNickname("nerdy");
		return;//그냥 프로그램 종료됨(메인 메소드기 때문이다.)
	}
}
