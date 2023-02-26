package study11_1;

class Member{
	private String id;
	private String name;
	
	public Member(String id,String name) {
		this.id =id;
		this.name =name;
	}
	
	//Object toString()메소드 재정의
	
	public String toString() {
		return id+" : "+name;//단 1줄
	} //메소드 오버라이딩
}
public class MemberTest {
	public static void main(String[] args) {
		Member mem = new Member("sulsul","이기광");
		System.out.println(mem.toString());
	}

}
