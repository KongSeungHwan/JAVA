package study17_2023_02_17;

import java.util.TreeSet;

public class SetEx {

	public static void main(String[] args) {
		TreeSet<Student> tset = new TreeSet<>();
		tset.add(new Student("lee",96));
		tset.add(new Student("hong",86));
		tset.add(new Student("hong",85));
		tset.add(new Student("hong",84));
		tset.add(new Student("hong",83));
		Student st = tset.last();
		System.out.println(st.score);
		System.out.println(st.name);




	}

} //역순으로 출력하는 거 한번 해보기!

class Student implements Comparable<Student>{
	String name;
	int score;
	Student(String n,int s){
		name=n;
		score=s;
	}
	@Override
	public int compareTo(Student o) {
		//score로 대소 비교하는 메소드
		//3가지.. +,-,0 리턴해줘야하는데
		return this.score-o.score; //역순이면 -1 곱하기
		//그럼 이름순으로 할때는 필드자체의 자료형을 바꿔야해서 
	}
}
