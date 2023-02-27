package study24_2023_02_27;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class StreamTest4 {

	public static void main(String[] args) {
		Student[] students = new Student[] {
				new Student("강민정", true, 1, 1, 300),
                new Student("장아름", false, 1, 1, 250),
                new Student("공승환", true, 1, 1, 200),
                new Student("권비", false, 1, 2, 150),
                new Student("김민석", true, 1, 2, 100),
                new Student("박호진", false, 1, 2, 50),
                new Student("배민국", false, 1, 3, 100),
                new Student("성우석", false, 1, 3, 150),
                new Student("송현동", true, 1, 3, 200),
                new Student("강민정", true, 2, 1, 300),
                new Student("장아름", false, 2, 1, 250),
                new Student("공승환", true, 2, 1, 200),
                new Student("권비", false, 2, 2, 150),
                new Student("김민석", true, 2, 2, 100),
                new Student("박호진", false, 2, 2, 50),
                new Student("배민국", false, 2, 3, 100),
                new Student("성우석", false, 2, 3, 150),
                new Student("송현동", true, 2, 3, 200)
		};
		//150점 미만 학생 수를 남자와 여자로 구별하여 표시
		
		System.out.println(question1(students));
		System.out.println(question2(students));
		
		

	}
	//150점 미만 학생 수를 남자와 여자로 구별하여 표시 boolean 타입 그냥 String으로 바꿈(남,여)
	public static Map<String,List<Student>> question1(Student[] stuArr){
		return Arrays.stream(stuArr)
				.filter(s->s.getScore()<150)
				.collect(Collectors
				.groupingBy(p->p.isMale() ? "남" : "여" ));
	}
	//각 반별 총점을 학년별로 나누기!
	//학년 나눈채로 반을 또 나누고 score 필드 총합을 구함
	public static Map<String,Map<String,Integer>> question2(Student[] stuArr){
		return Arrays.stream(stuArr)
				.collect(Collectors
				.groupingBy(s->s.getGrade()+"학년",
				Collectors
				.groupingBy(s->s.getBan()+"반",
				Collectors.summingInt(s->s.getScore()))));
	}
}
