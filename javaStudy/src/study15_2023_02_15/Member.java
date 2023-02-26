package study15_2023_02_15;

public class Member implements Comparable<Member>{
	private Integer memberId;
	private String memberName;
	private Integer memberAge;
	
	public Member(int id,String name,int age) {
		memberId=id;
		memberName=name;
		memberAge=age;
	}
	
	@Override
	public int hashCode() {
		return memberId.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			
			return (((Member)obj).memberId==memberId);
			//어차피 같은 클래스 내라 getter메소드 안써줘도 된다.
		}else {
			return false;
		}
	}
	@Override
	public int compareTo(Member o) {
		return 0;
	}
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}
	@Override
	public String toString() {
		return "id:"+memberId+",이름:%s"+memberName+"나이:%s"+memberAge;
		//다 문자열로 형변환 해줘서 편함 String.formatㅇㅇ 소켓 통신시 이런식으로 함
	}
	
}
class Point{
	private int point;
	public Point(int point) {
		this.point=point;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
