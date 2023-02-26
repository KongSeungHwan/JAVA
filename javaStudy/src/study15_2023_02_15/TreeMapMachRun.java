package study15_2023_02_15;

import java.util.Map.Entry;

import study14Collection.Member;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapMachRun {

	public static void main(String[] args) {
		TreeMap<String,String> tmap1 = new TreeMap<>();
		String intVal1 = new String("1");
		String intVal2 = new String("2"); //중복 값들을 1개로 취급(1개의 원소만 들어간다.)
		tmap1.put(intVal1, "s");
		tmap1.put(intVal2, "t");
		System.out.println(tmap1);//compareTo 메소드 기능 있다

		TreeMap<Integer,Integer> tmap2 = new TreeMap<>();
		Integer intVal3 = new Integer(30);
		Integer intVal4 = new Integer(30); //중복 값을 1개로 취급(1개의 원소만 들어간다.)
		tmap2.put(intVal3, 1);
		tmap2.put(intVal4, 3);
		System.out.println(tmap2);//compareTo 메소드 기능 있다
		CompareMemberTreeMap ctm= new CompareMemberTreeMap();
		Member lee = new Member(101,"이순신",45);
		Point p1 = new Point(1000);
		ctm.addMember(lee,p1);
		Member koo = new Member(102,"구준표",18);
		Point p2 = new Point(1000);
		ctm.addMember(koo,p2);
		Member song = new Member(103,"송시열",32);
		Point p3 = new Point(1000);
		ctm.addMember(song,p3);
		ctm.showAll();
		if(ctm.removeMember(101)) {
			System.out.println("삭제완료");
		}else {
			System.out.println("아이디 없음");
		}
		ctm.showAll();
	}

}
class CompareMemberTreeMap{
	private TreeMap<Member,Point> tmap; //참조형 필드

	CompareMemberTreeMap(){
		tmap = new TreeMap<>();
	}
	public void addMember(Member member,Point point) {
		tmap.put(member, point);
	}
	public void showAll() {
		for (Entry<Member,Point> a: tmap.entrySet()) {
			System.out.printf("이름:%s ,포인트: %s \n",a.getKey().getName(),a.getValue().getPoint());
		}
	}
	public boolean removeMember(Integer memberId) {
		for (Member mem : tmap.keySet()) {
			if(mem.getMemberId()==memberId) {
				tmap.remove(mem);
				return true;
			}
		}
		return false;
		//Iterator
	}
	public boolean removeMemberIt(Integer memberId) {
		Iterator<Member> members = tmap.keySet().iterator();
		while(members.hasNext()) {
			Member a= members.next();
			if(a.getMemberId()==memberId) {
				tmap.remove(a);
				return true;
			}
		}
		//Iterator
		return false;
	}
	public TreeMap<Member,Point> getTmap(){
		return tmap;
	}
	public void setTmap(TreeMap<Member,Point> tm){
		tmap=tm;
	}
}
