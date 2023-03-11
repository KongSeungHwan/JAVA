package study03;

public class CompanyRun {
	public static void main(String[] args) {
		
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
		// static 메모리의 안에 있는 객체의 주소값이 나옴
		// static 메모리에 만들어진 객체는 1개이기에 주소가 
		// 1가지만 나오게 된다.(*1 객체)
		
		
	}
}
