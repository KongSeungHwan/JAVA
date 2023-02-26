package study21;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

interface Arr{
	int[] sArr(int l);
}

public class ArrayLambda {


	public static void main(String[] args) {
		Arr arr = x -> new int[x];
		int[] arr1 = arr.sArr(10);
		System.out.println(arr1.length);//10
		Clambda a = () -> new TwoConst();
		Clamp b = x -> new TwoConst(x);
		a = TwoConst::new;
		b=TwoConst::new;
		TwoConst n = a.gI();
		
		TwoConst m = b.gI1("두번째 생성자로 만든 객체");
		
		Set<TwoConst> s = new TreeSet<>(Arrays.asList(b.gI1("100"),b.gI1("101"),b.gI1("102")));
		
		
		List<TwoConst>list= s.stream().collect(Collectors.toList());
		//중복제거, List 형식으로 바꿔서 List 변수에 저장
		list.stream().forEach(p->System.out.println(p.getName()));
	}
}
class TwoConst implements Comparable<TwoConst>{
	private String name;
	TwoConst(){
		System.out.println("abc");
	}
	TwoConst(String s){
		System.out.println("abc2"+s.toString());
		name = s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(TwoConst o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
}
interface Clambda{
	TwoConst gI();
}
interface Clamp{
	TwoConst gI1(String s);
}