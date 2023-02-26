package study14Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SetRun {

	public static void main(String[] args) {
		HashSet<String> ha = new HashSet<String>();
		for (char i = 65; i < 73; i++) {
			ha.add("사람"+i);//사람 A to H
		}
		System.out.println(ha);
		System.out.println(ha.size());
		ha.add(null);
		//null값은 없는 값이 아니라 컴퓨터가 인식할 수 없는 값을 의미
		System.out.println();
		System.out.println(ha);
		System.out.println(ha.size());
		System.out.println(ha.contains("사람A")); //값 자체로만 검색 가능
		Iterator<String> h = ha.iterator();
		
		while(h.hasNext()) {
			System.out.printf("사람: %s \n",h.next());
		}
		 String[] har=ha.toArray(new String[ha.size()]);
		 System.out.println();
		 for (String string : har) {
			System.out.printf("사람: %s \n",string);
		}
		 System.out.println();
		 System.out.println(Arrays.toString(har));
	}

}
