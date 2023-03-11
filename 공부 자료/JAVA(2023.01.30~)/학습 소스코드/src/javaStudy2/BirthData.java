package javaStudy2;


class Birthday{
	//멤버변수
	private int date;
	private int month;
	private int year;

	//생성자
	//생성자 정의 생성자를 호출할때 3가지 매개변수 필요
	Birthday(int year,int month,int date){
		this.year=year;//this.date<< 멤버변수를 의미
		this.month=month;
		this.date=date;
	}
	public Birthday(){
		this.year=1980;
		this.month=3;
		this.date=8;
		//this(1980,3,8);위의 3줄 지우고 써도됨. 위의 메소드를 호출하므로 괜춘함
	}
	//변수 관련 메소드 getter setter

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public String a() {
		return year +"년"+month+"월"+date+"일";	
	}
	//getter,setter 메소드를 임의로 만들어도 무방하다.

}


public class BirthData {
	public static void main(String[] args) {
		Birthday a = new Birthday();
		//매개변수를 받지 않는 생성자가 호출됨.
		System.out.println(a.a());
		System.out.println(a.getDate());
		System.out.println(a.getMonth());
		System.out.println(a.getYear());
		a. setYear(2000);
		System.out.println(a.getYear());
		System.out.println(a.a());

		Birthday b = new Birthday(1998,4,3);
		//오버로딩으로 인한 매개변수 3개를 받는 생성자가 호출됨.
		System.out.println(b.a());
	}

}
