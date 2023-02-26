package study16_2023_02_16_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary{
	private TreeMap<String,String> tm;
	
	Dictionary(){
		tm=new TreeMap<>();
	}
	
	void addDictionary(String eng,String kor){
		tm.put(eng, kor);
	}
	String findWithKor(String kor) {
		Set<Map.Entry<String,String>> s= tm.entrySet();
		
		Iterator<Entry<String,String>> it = s.iterator();
		
		while(it.hasNext()) {
			Entry<String, String> a = it.next();
			
			if(a.getValue().equals(kor)){
				return "검색한 한국어:"+kor+" 일치하는 영단어:"+a.getKey();
			}
		}
		return "";//해당 영단어가 없을 때 빈 문자열 리턴
		
	}
	ArrayList<String> searchWithKor(String kor) {
		Set<Map.Entry<String,String>> s= tm.entrySet();
		ArrayList<String> list = new ArrayList<>();
		Iterator<Entry<String,String>> it = s.iterator();
		
		while(it.hasNext()) {
			Entry<String, String> a = it.next();
			
			if(a.getValue().contains(kor)){
				list.add("검색한 한국어:"+kor+" 일치하는 영단어:"+a.getKey());
			}
		}
		return list;//해당 영단어가 없을 때 빈 문자열 리턴
	}
	boolean deleteDic(String word) {//한국어 칠때 없애기(영어로 삭제하는 응용버전) 영어로 없애는 건 간단하니! 응용!
		Set<Map.Entry<String,String>> s= tm.entrySet();
		Iterator<Entry<String,String>> it = s.iterator();
		
		while(it.hasNext()) {
			Entry<String, String> a = it.next();
			if(a.getValue().equals(word)) {
				tm.remove(a.getKey(), word);
				return true;
			}
		}
		return false;
	}
//있다가 해보기!
	public TreeMap<String, String> getTm() {
		return tm;
	}

	public void setTm(TreeMap<String, String> tm) {
		this.tm = tm;
	}
	
}
