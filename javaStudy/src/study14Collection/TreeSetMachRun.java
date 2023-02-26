package study14Collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMachRun {
	public static void main(String[] args) {
		TreeSet<Integer> tset1 = new TreeSet<>();
		Integer intVal1=new Integer(30);
		Integer intVal2=new Integer(20);
		tset1.add(intVal1);
		tset1.add(intVal2);
		System.out.println(tset1);
		
		TreeSet<String> tset2 = new TreeSet<>();
		String str1=new String("당신");
		String str2=new String("당신");
		tset2.add(str1);
		tset2.add(str2);
		System.out.println(tset2);
		
		CompareMemberTreeSet cts = new CompareMemberTreeSet();
		Member lee = new Member(101,"이순신",45);
		cts.addMember(lee);
		Member koo = new Member(102,"구준표",18);
		cts.addMember(koo);
		Member song = new Member(103,"송시열",32);
		cts.addMember(song);
		cts.showAll();
		if(cts.removeMember(105)) {
			System.out.println("삭제완료");
		}else {
			System.out.println("해당 아이디가 존재하지 않습니다.");
		}
		cts.showAll();
		
	}
}

class CompareMemberTreeSet{
	private TreeSet<Member> tset;
	CompareMemberTreeSet(){
		tset = new TreeSet<Member>();
	}
	void addMember(Member mem) {
		tset.add(mem);
	}
	boolean removeMember(int memberId) {
		Iterator<Member> itr = tset.iterator();
		while(itr.hasNext()) {
			Member mem=itr.next();
			if(mem.getMemberId()==memberId) {
				tset.remove(mem);
				return true;
			}
		}
		return false;
	}
	
	void showAll() {
		for(Member mem:tset) {
			System.out.print("ID:"+mem.getMemberId());
			System.out.print("/name:"+mem.getName());
			System.out.println("/age:"+mem.getAge());
		}
	}
}