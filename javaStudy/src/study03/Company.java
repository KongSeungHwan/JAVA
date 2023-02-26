package study03;

public  class Company{
	
	private static Company instance = new Company();//*1
	//디폴트 생성자로 인해 저렇게 사용 가능
	private Company() {
		System.out.println("company 생성자 객체 생성");
	}
	public static Company getInstance() {
		if(instance ==  null)instance = new Company();
		return instance;
	}
	//static 메모리에 올라간  *1 객체에 접근하기 위한 메소드
}
