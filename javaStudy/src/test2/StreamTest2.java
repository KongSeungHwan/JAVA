package test2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest2 {

	public static void main(String[] args) {
		
		System.out.println(question1());
		System.out.println(question2());

	}
	public final static List<String> SPELLS = Arrays.asList("aOMAS","a","hELLO","B","korea","X","Nutella"); 
	//상수 뿐만아니라 constant pool에 할당되는 데이터들은 모두 대문자
	//list에 저장된 단어에 첫번째 문자가 각각 몇개있는지 
	//Map<String,Integer>로 변환 (반환예 "X",1)
	static Map<String, Integer> question1(){
		return SPELLS.stream().map(s->s.substring(0,1)).collect(Collectors.toMap(h -> h,h->1,(o,n)->o+=n));
	}
	static String question2(){//upperCase
		return SPELLS.stream().filter(s-> s.length()>=2).reduce((x,y)->x+" "+y).get().toUpperCase();
	}
}
