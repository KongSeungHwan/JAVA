package study03;

public class Book {
	//정보 은닉한 필드의 멤버변수
	private String bookName;
	private String author;
	
	
	
	public Book(){}
	public Book(String bookName,String author ){
		this.bookName= bookName;
		this.author=author;
	}
	//생성자 2개 기본생성자,멤버변수 2개를 매개변수로 생성
	//생성자가 1개라도 있으면 컴파일러가 디폴트 생성자를 만들어 주지 않는다.
	
	public String  getBookName() {
		return this.bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	
	
	
	public void printBookInfo() {
		System.out.printf("book: %s by %s \n",bookName,author);
	}
	

	
	public Book clone() {
		Book res = new Book();
		res.bookName=this.bookName;
		res.author=this.author;
		return res;
	}
	
	//책 정보 복사 메소드
	
	

}
