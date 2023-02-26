package study16_2023_02_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PersonList {
	HashMap<String,PersonInfo> m;
	
	PersonList(){
		m=new HashMap<>();
	}
	void addPerson(String name,String address,String num){
		m.put(num,new PersonInfo(name,address));
		
	}//개인정보 추가 메소드(이름으로)
	ArrayList<String> showPersonByName(String name){
		//personInfo의 이름가지고 찾고
		//객체를 map에 집어 넣었을때 조회하는 기능
		//이 두 과정을 한다
		ArrayList<String> list = new ArrayList<>();

		Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
		
		Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
		PersonInfo info;
		while(b.hasNext()) {
			Entry<String,PersonInfo> c = b.next();
			info = c.getValue();
			if(info.getName().equals(name)) {
				list.add("이름:"+info.getName()+" 전화번호:"+c.getKey()+" 주소:"+info.getAddress());
			}
		}
		return list;
	}//개인정보 추가 메소드(전화번호로)
	ArrayList<String> showPersonByNum(String n){
			ArrayList<String> list = new ArrayList<>();
			Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
			Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
			String info;
			while(b.hasNext()) {
				Entry<String,PersonInfo> c = b.next();
				if(n.equals(c.getKey())) {
				info = c.getKey();
				if(c.getValue().equals(m.get(info))){
					list.add("이름:"+m.get(info).getName()+" 전화번호:"+info+"주소:"+m.get(info).getAddress());
				}
				}
			}
			return list;
	}
	ArrayList<String> searchByName(String n){
		ArrayList<String> list = new ArrayList<>();
		Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
		Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
		PersonInfo per;
		
		while(b.hasNext()) {
			Entry<String,PersonInfo> c = b.next();
			per = c.getValue();
			if(per.getName().contains(n)) {
			String info = c.getKey();
				list.add("이름:"+m.get(info).getName()+" 전화번호:"+info+"주소:"+m.get(info).getAddress());
			}
		}
		return list;
}
	ArrayList<String> searchByNum(String n){
		ArrayList<String> list = new ArrayList<>();
		Set<Map.Entry<String,PersonInfo>> a = m.entrySet();
		Iterator<Map.Entry<String,PersonInfo>> b = a.iterator();
		String info;
		while(b.hasNext()) {
			Entry<String,PersonInfo> c = b.next();
			if(c.getKey().contains(n)) {
			info = c.getKey();
				list.add("이름:"+m.get(info).getName()+" 전화번호:"+info+"주소:"+m.get(info).getAddress());
			}
		}
		return list;
}
	
}
