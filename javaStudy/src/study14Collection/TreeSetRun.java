package study14Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetRun {

	public static void main(String[] args) {
		TreeSet<String> animalTSet = new TreeSet<>(
				Arrays.asList("Dog","Cat","Tiger"
						,"Lion","Elephant","Zebra"));
		SortedSet<String> sset = animalTSet.headSet("Z");
		NavigableSet<String> nset = animalTSet.headSet("Z",true);
		System.out.println(sset);
		System.out.println(nset);
		System.out.println(nset.descendingSet());
		Iterator<String> it = nset.descendingIterator();
		//treeset으로 호출하는 순간 내림차순으로 된다.
		while(it.hasNext()) System.out.printf("동물 이름: %s \n",it.next());
		//저장되면 순서대로 정렬됨 (default: 오름차순)
	}

}
