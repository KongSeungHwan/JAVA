package study22;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

class Student {
	private String name;
	private String city;
	private Integer age;
	
	Student(String n){
		name=n;
	}
	Student(String n,String c){
		name=n;
		city=c;
	}
	Student(String n,String c,Integer a){
		name=n;
		city=c;
		age =a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("이름:%s, 거주지:%s, 나이:%s",name,city,age);
	}
}
public class StudentInfoRun {

	public static void main(String[] args) throws IOException {
//		BufferedReader n= new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("이름 입력");
//		String a = n.readLine();
//		System.out.println("거주지 입력");
//		String b = n.readLine();
//		System.out.println("나이 입력");
//		int c = Integer.parseInt(n.readLine());
//		clear();
//		Student s= new Student(a,b,new Integer(c));
//		System.out.println(s);//toString을 오버라이딩해서 주소값 안나오고 바로 정의해둔 문자열이 나온다.
		Function<String,Student> f1= new Function<>() {

			@Override
			public Student apply(String t) {
				return new Student(t);
			}
		};
		Function<String,Student> f2 = x -> new Student(x);
		Function<String,Student> f3 = Student::new;//람다 형식
		BiFunction<String,String,Student> b = (x,y) -> new Student(x,y);
		IntBinaryOperator ageAft = (x,y)-> staticSum(x,y);
		IntBinaryOperator ageAft2 = StudentInfoRun::staticSum;
		System.out.println(ageAft.applyAsInt(1, 2));
		System.out.println(ageAft2.applyAsInt(1, 2));
		 System.out.println(new StudentInfoRun().instanceSum(1,2));
		 //그냥 생성 동시에 메소드 호출도 가능
		 //셋다 동일한 값 나옴
		 ToIntBiFunction<String, String> f11 = (x,y)->x.compareTo(y);
	}
	static void clear() {
		for (int i = 0; i < 14; i++)System.out.println();
	}
	public int instanceSum(int a, int b) {
		return a+b;
	}
	public static int staticSum(int a,int b) {
		return a+b;
	}
	public static void cR(int r) {
		if(r==0)System.out.println("동일 문자열");
		else System.out.println("동일x");
	}
}
